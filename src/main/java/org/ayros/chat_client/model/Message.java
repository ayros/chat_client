package org.ayros.chat_client.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {

    private String author;
    private String text;

}
