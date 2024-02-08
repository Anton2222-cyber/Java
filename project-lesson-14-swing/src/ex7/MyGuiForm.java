package ex7;

import javax.swing.*;

public class MyGuiForm extends JFrame{
    private JPanel jPanelMain;
    private JTextField textField1;
    private JButton button1;
    private JTextArea textArea1;
    private JTextArea textArea2;

    public MyGuiForm(){
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(jPanelMain);
        setVisible(true);
    }

    public static void main(String[] args) {
        MyGuiForm myGuiForm = new MyGuiForm();
    }

}
