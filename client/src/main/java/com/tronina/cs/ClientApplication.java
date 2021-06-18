package com.tronina.cs;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;

public class ClientApplication extends Application {
    private Controller controller = new Controller();
    private ContractTableView<Contract> table = new ContractTableView<Contract>();

    @Override
    public void start(Stage stage) {
        // Display row data
        List<Contract> data = controller.getData();
        if (!data.isEmpty()) {
            table.setItems(FXCollections.observableList(data));
        }

        StackPane root = new StackPane();
        root.getChildren().add(table);

        stage.setTitle("Договора");
        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static class Launcher {
        public static void main(String[] args) {
            Application.launch(ClientApplication.class);
        }
    }
}
