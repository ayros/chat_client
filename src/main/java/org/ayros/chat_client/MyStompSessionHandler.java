package org.ayros.chat_client;

import lombok.AllArgsConstructor;
import org.ayros.chat_client.model.Message;
import org.ayros.chat_client.ui.ChatListener;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;

import java.lang.reflect.Type;

@AllArgsConstructor
public class MyStompSessionHandler implements StompSessionHandler {

    private ChatListener listener;

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        session.subscribe("/topic/greetings", this);
        //session.send("/app/hello", new HelloMessage("hi"));
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {

    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {

    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return Message.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        Message msg = (Message) payload;
        listener.received(msg);
    }
}
