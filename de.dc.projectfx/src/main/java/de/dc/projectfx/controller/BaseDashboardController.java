package de.dc.projectfx.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public abstract class BaseDashboardController {

    @FXML
    protected TextField textSearchField;

    @FXML
    protected Button buttonNewItem;

    @FXML
    protected ComboBox<?> comboDashboard;

    @FXML
    protected Button buttonEditDashboards;

    @FXML
    protected TableView<?> tableViewMyWorkItem;

    @FXML
    protected TableColumn<?, ?> columnWorkItemType;

    @FXML
    protected TableColumn<?, ?> columnWorkItemKey;

    @FXML
    protected TableColumn<?, ?> columnWorkItemName;

    @FXML
    protected TableColumn<?, ?> columnWorkItemProject;

    @FXML
    protected TableColumn<?, ?> columnWorkItemStart;

    @FXML
    protected TableColumn<?, ?> columnWorkItemDue;

    @FXML
    protected TableColumn<?, ?> columnWorkItemPhase;

    @FXML
    protected VBox vboxMyTimers;

    @FXML
    protected PieChart pieChartActiveProjectsByPrio;

    @FXML
    protected PieChart pieChartActiveProjectsByType;

    @FXML
    protected PieChart pieChartActiveProjectsByStatus;

    @FXML
    protected abstract void onButtonAction(ActionEvent event);

}
