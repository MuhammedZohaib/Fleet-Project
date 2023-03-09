module com.example.fleet_plan_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fleet_plan_project to javafx.fxml;
    exports com.example.fleet_plan_project;
}