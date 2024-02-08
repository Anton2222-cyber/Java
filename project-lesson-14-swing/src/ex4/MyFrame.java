package ex4;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame extends JFrame {
    public MyFrame(){
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//        this.addWindowListener(new WindowListener() {
//            @Override
//            public void windowOpened(WindowEvent e) {
//                System.out.println("windowOpened");
//            }
//
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.out.println("windowClosing");
//
//            }
//
//            @Override
//            public void windowClosed(WindowEvent e) {
//                System.out.println("windowClosed");
//
//            }
//
//            @Override
//            public void windowIconified(WindowEvent e) {
//                System.out.println("windowIconified");
//
//            }
//
//            @Override
//            public void windowDeiconified(WindowEvent e) {
//                System.out.println("windowDeiconified");
//
//            }
//
//            @Override
//            public void windowActivated(WindowEvent e) {
//                System.out.println("windowActivated");
//
//            }
//
//            @Override
//            public void windowDeactivated(WindowEvent e) {
//                System.out.println("windowDeactivated");
//
//            }
//        });


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("open");
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("close");
            }
        });


        setVisible(true);
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
}
