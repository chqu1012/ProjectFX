package de.dc.projectfx;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import de.dc.projectfx.model.Project;
import de.dc.projectfx.model.ProjectCategory;
import de.dc.projectfx.model.ProjectType;
import de.dc.projectfx.model.User;
import de.dc.projectfx.repository.ProjectCategoryRepository;
import de.dc.projectfx.repository.ProjectRepository;
import de.dc.projectfx.repository.ProjectTypeRepository;
import de.dc.projectfx.repository.UserRepository;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@SpringBootApplication
public class ProjectFXApp extends Application implements CommandLineRunner{

    private ConfigurableApplicationContext springContext;
    private BorderPane root;
	private boolean initialize = true;
	
    @Autowired ProjectRepository projectRepository;
    @Autowired UserRepository userRepository;
    @Autowired ProjectTypeRepository typeRepository;
    @Autowired ProjectCategoryRepository categoryRepository;
    
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

	@Override
	public void run(String... args) throws Exception {
		if (initialize) {
			ProjectCategory category = new ProjectCategory();
			category.setCreatedOn(LocalDateTime.now());
			category.setName("General");
			category = categoryRepository.save(category);
			
			User user = new User();
			user.setCreatedOn(LocalDateTime.now());
			user.setEmail("max.mustermann@mail.com");
			user.setName("Max Mustermann");
			user.setPassword("abc");
			user.setPasswordExpiredIn(LocalDateTime.now());
			user = userRepository.save(user);

			ProjectType type = new ProjectType();
			type.setCreatedOn(LocalDateTime.now());
			type.setName("High Priority");
			type = typeRepository.save(type);
			
			Project project = new Project();
			project.setCreatedOn(LocalDateTime.now());
			project.setCategory(category);
			project.setKey("MTP");
			project.setName("My Test Project");
			project.setProjectLead(user);
			project.setType(type);
			projectRepository.save(project);
		}
	}
}