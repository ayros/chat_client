package org.ayros.chat_client.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import org.ayros.chat_client.model.Message;

public class Chat implements ChatListener{

    @FXML private Button send;
    @FXML private TextArea input;
    @FXML private ListView chatList;

    @Override
    public void received(Message msg) {

    }

    @FXML
    public void send(ActionEvent event) {
        input.deleteText(0, input.getLength());
    }
}
