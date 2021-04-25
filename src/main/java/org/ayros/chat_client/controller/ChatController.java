package org.ayros.chat_client.controller;

import org.ayros.chat_client.model.Message;

public interface ChatController {

    public void sendMessage(Message msg);
}
