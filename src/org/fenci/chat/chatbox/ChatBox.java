package org.fenci.chat.chatbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatBox extends JFrame {

    public ChatBox() {
        super("SecureChat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        super.setResizable(false);
        super.setVisible(true);
        super.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/org/fenci/chat/icons/lock.png"))).getImage());
    }

    public List<Shape> shapes = new ArrayList<>();

    public void drawLines(Graphics graphics) throws UnknownHostException {
        Graphics2D graphics2D = (Graphics2D) graphics;

//        graphics2D.drawRoundRect(50, 40, 300, 250, 10, 10);
//        graphics2D.drawRoundRect(50, 300, 300, 40, 10, 10);
        RoundRectangle2D displayBox = new RoundRectangle2D.Double(50, 40, 300, 250, 10, 10);
        RoundRectangle2D textBox = new RoundRectangle2D.Double(50, 300, 300, 40, 10, 10);
        //draw a string on the screen that can be modified

        graphics2D.draw(displayBox);
        graphics2D.draw(textBox);
        shapes.add(displayBox);
        shapes.add(textBox);

        //change the font
        graphics2D.setFont(new Font("Arial", Font.PLAIN, 15));

        ChatMessage currentMessage = new ChatMessage("", false);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getX() > 50 && e.getX() < 350 && e.getY() > 300 && e.getY() < 340) {
//                    ChatBox.super.getContentPane().remove(textBox);
                } else {
//                    manageTextBox(graphics2D, Color.black);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Graphics g = getGraphics();
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    currentMessage.send(currentMessage.getMessage());
                    g.setColor(Color.white);
                    g.fillRoundRect(50, 300, 300, 40, 10, 10);
                    g.setColor(Color.black);
                    currentMessage.setMessage("");
                } else {
                    if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                        currentMessage.removeLastChar();
                    } else {
                        currentMessage.appendMessage(String.valueOf(e.getKeyChar()));
                    }
                    g.setColor(Color.white);
                    g.fillRoundRect(50, 300, 300, 40, 10, 10);
                    g.setColor(Color.black);
                    g.drawString(currentMessage.getMessage(), 60, 325);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        try {
            drawLines(graphics);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
