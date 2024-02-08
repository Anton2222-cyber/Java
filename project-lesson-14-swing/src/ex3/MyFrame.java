package ex3;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);

        JPanel jPanel = new JPanel();

        JButton jButton = new JButton("Button");
        JTextField jTextField = new JTextField("name", 10);
        JTextArea jTextArea = new JTextArea(5, 10);

        JScrollPane jScrollPane =  new JScrollPane(
                jTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);

        jPanel.add(jButton);
        jPanel.add(jTextField);
        jPanel.add(jScrollPane);

        this.add(jPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
}
