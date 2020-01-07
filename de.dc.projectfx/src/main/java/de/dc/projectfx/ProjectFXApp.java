package de.dc.projectfx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@SpringBootApplication
public class ProjectFXApp extends Application {

    private ConfigurableApplicationContext springContext;
    private BorderPane root;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(ProjectFXApp.class);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/de/dc/projectfx/Main.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        root = fxmlLoader.load();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("(FA) ProjectFX");
        Scene scene = new Scene(root, 1200, 820);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
    	springContext.stop();
        springContext.close();
    }

    @Bean
    public HostServices getHostService() {
    	return getHostServices();
    }
    

    public static void main(String[] args) {
    	// Used for avoiding screenshot robot exception
    	System.setProperty("java.awt.headless", "false");
    	
        launch(ProjectFXApp.class);
    }
}