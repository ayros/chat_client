package org.ayros.chat_client.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import org.ayros.chat_client.model.Message;

import java.io.IOException;

public class MessageView extends ListCell<Message> {

    @FXML private ImageView icon;
    @FXML private Label author;
    @FXML private Label text;
    @FXML private BorderPane root;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Message item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/ui/MessageListCell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            author.setText(item.getAuthor());
            text.setText(item.getText());

            setText(null);
            setGraphic(root);
        }
    }

}
