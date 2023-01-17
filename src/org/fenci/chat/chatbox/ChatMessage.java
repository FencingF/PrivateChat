package org.fenci.chat.chatbox;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ChatMessage {

    private String message;
    private final String sender;
    private boolean sent;

    private final StringBuilder messageBuilder = new StringBuilder();

    public ChatMessage(String message, boolean sent) {
        this.message = message;
        com.sun.security.auth.module.NTSystem ntSystem = new com.sun.security.auth.module.NTSystem();
        sender = ntSystem.getName();
        this.sent = sent;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }

    public boolean isSent() {
        return sent;
    }

    public void removeLastChar() {
        if (messageBuilder.length() > 0) {
            messageBuilder.deleteCharAt(messageBuilder.length() - 1);
            message = messageBuilder.toString();
        }
    }

    public void appendMessage(String message) {
        messageBuilder.append(message);
        this.message = messageBuilder.toString();
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void send(String message) {

    }
}
