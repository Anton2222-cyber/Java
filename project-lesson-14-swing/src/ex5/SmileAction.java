package ex5;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SmileAction  extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(":-)");
    }
}
