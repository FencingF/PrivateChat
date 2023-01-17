package org.fenci.chat.chatbox;

import javax.swing.*;

public class Chat {

    private static Chat INSTANCE;

    public Chat() {
        INSTANCE = this;
    }

    public static Chat getInstance() {
        return INSTANCE;
    }

    public void start() {
        SwingUtilities.invokeLater(() -> new ChatBox().setVisible(true));
    }
}
