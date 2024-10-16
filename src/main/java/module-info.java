module com.project.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.compiler;

    opens com.project.todolist to javafx.fxml;
    exports com.project.todolist;
    exports com.project.todolist.Controllers;
    opens com.project.todolist.Controllers to javafx.fxml;

    opens com.project.todolist.Classes to javafx.base;
}
