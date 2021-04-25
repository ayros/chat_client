package org.ayros.chat_client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/ui/Chat.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setMaximized(true);

        stage.setTitle("Chat");

        stage.show();
    }
}
