package test.jpaneltesting;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

public class test extends JPanel {
  private JPanel newPanel;
  private JLabel label;
  private JTextField userName;
  private JFrame frame;


  public test() {
    newPanel = new JPanel(new GridLayout());
    label = new JLabel("Enter Username:");
    userName = new JTextField(20);
    frame = new JFrame("JPanel Demo Program");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    newPanel.add(label);
    newPanel.add(userName);

    newPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
        "Login Panel"));
//    newPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

    frame.add(newPanel);
    frame.setSize(400, 600);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    test main = new test();

  }


}
