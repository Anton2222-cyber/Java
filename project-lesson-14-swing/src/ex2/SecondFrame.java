package ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondFrame extends JFrame {
    private JPanel jPanel;
    private JButton jButton;
    public SecondFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);

        init();
        addListeners();
        addComponents();

        setVisible(true);
    }

    private void init() {
        jPanel = new JPanel();
        jButton = new JButton();

    }

    private void addListeners() {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                jPanel.setBackground(new Color(65,227,20));
                if (jPanel.getBackground() == Color.GREEN) {
                    jPanel.setBackground(Color.RED);
                }else{
                    jPanel.setBackground(Color.GREEN);
                }
                System.out.println("clicked");
            }
        });
    }

    private void addComponents() {
        jPanel.add(jButton);
        this.add(jPanel);
    }
}
