package org.ayros.chat_client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.ayros.chat_client.controller.StompController;
import org.ayros.chat_client.ui.Chat;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.concurrent.ExecutionException;

public class Main extends Application {

    private static final String URL = "ws://localhost:8080/gs-guide-websocket";

    private FXMLLoader mLLoader;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        mLLoader = new FXMLLoader(getClass().getResource("/ui/Chat.fxml"));
        mLLoader.load();
        Parent root = mLLoader.getRoot();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setMaximized(true);

        stage.setTitle("Chat");
        initStomp();

        stage.show();
    }
    
    private void initStomp() {
        WebSocketClient client = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(client);

        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        Chat chat = mLLoader.getController();
        StompSessionHandler sessionHandler = new MyStompSessionHandler(chat);
        try {
            chat.setController(new StompController(stompClient.connect(URL, sessionHandler).get()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
