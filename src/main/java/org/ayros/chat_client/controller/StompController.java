package org.ayros.chat_client.controller;

import lombok.AllArgsConstructor;
import org.ayros.chat_client.model.Message;
import org.springframework.messaging.simp.stomp.StompSession;

@AllArgsConstructor
public class StompController implements ChatController{

    private StompSession session;

    @Override
    public void sendMessage(Message msg) {
        session.send("/app/hello", msg);
    }
}
