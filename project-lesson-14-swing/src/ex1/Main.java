package ex1;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        FirstFrame firstFrame = new FirstFrame();
        firstFrame.setVisible(true);
        firstFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        firstFrame.setSize(100, 100);
//        firstFrame.setBounds(500, 100, 300, 300);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
//        System.out.println(dimension.width);
//        System.out.println(dimension.height);
        //firstFrame.setBounds(dimension.width / 2 - 125, 0, 250, 250);
        firstFrame.setSize(300,300);
        firstFrame.setLocationRelativeTo(null);
        firstFrame.setTitle("Calculator");

    }
}
