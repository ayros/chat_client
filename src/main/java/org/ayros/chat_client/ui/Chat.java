package org.ayros.chat_client.ui;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import lombok.Getter;
import lombok.Setter;
import org.ayros.chat_client.controller.ChatController;
import org.ayros.chat_client.model.Message;

import java.net.URL;
import java.util.ResourceBundle;

public class Chat implements ChatListener, Initializable {

    @FXML private Button send;
    @FXML private TextArea input;
    @FXML private ListView chatList;

    @Getter
    @Setter
    private ChatController controller;

    private ObservableList<Message> messages;

    public Chat() {
        messages = FXCollections.observableArrayList();
    }

    @Override
    public void received(Message msg) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                messages.add(msg);
            }
        });
    }

    @FXML
    public void send(ActionEvent event) {
        controller.sendMessage(new Message("Anonymous", input.getText()));
        input.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chatList.setItems(messages);
        chatList.setCellFactory(messageView -> new MessageView());
    }
}
