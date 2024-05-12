import javax.swing.*;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ghost Text Example");
        JTextArea textArea = new JTextArea(10, 30);

        // Set the default message as ghost text
        textArea.setText("Type your message here...");
        textArea.setBackground(Color.BLACK);
        textArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textArea.getText().equals("Type your message here...")) {
                    textArea.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textArea.getText().isEmpty()) {
                    textArea.setText("");
                }
            }
        });

        frame.add(textArea);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}