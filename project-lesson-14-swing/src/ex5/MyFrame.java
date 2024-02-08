package ex5;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel jPanel = new JPanel();
        JButton jButton = new JButton("smile");

        jButton.addActionListener(new SmileAction());

        jPanel.add(jButton);
        add(jPanel);

        KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl shift S");
        InputMap inputMap = jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        String key = "print smile";
        inputMap.put(keyStroke, key);
        ActionMap actionMap = jPanel.getActionMap();
        actionMap.put(key, new SmileAction());

        setVisible(true);
    }

    public static void main(String[] args) {

        MyFrame myFrame = new MyFrame();
    }
}
