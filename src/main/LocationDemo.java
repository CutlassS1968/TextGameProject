package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.border.Border;

public class LocationDemo extends JFrame {
  private Location currentLocation;
  private String command;

  private JPanel panel;
  private PerformedListener listen;
  private JTextField commandInput;
  private JTextArea displayOutput;
  private JButton buttonInput;
  private JScrollPane scrollPane;

  private Map map;

  // Constructor - Calling Applet constructor (super();)
  public LocationDemo() {
    super("LocationDemo Program");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setMinimumSize(new Dimension(600,400));
    setMaximumSize(new Dimension(600,400));

    listen = new PerformedListener();
    displayOutput = new JTextArea(15, 40);
    commandInput = new JTextField(15);
    buttonInput = new JButton("Go");
    map = new Map();

    // format the output area
    displayOutput.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
    displayOutput.setLineWrap(true);
    displayOutput.setEditable(false);
    displayOutput.setWrapStyleWord(true);

    // add actionlistener to button
    buttonInput.addActionListener(listen);
    commandInput.addActionListener(listen);

    // create a new panel with GridBagLayout manager
    panel = new JPanel(new GridBagLayout());
    JScrollPane sp = new JScrollPane(displayOutput);

    GridBagConstraints constraints = new GridBagConstraints();
    constraints.anchor = GridBagConstraints.CENTER;
    constraints.insets = new Insets(10, 10, 10, 10);

    // add components to the panel
    constraints.gridx = 0;
    constraints.gridy = 0;
    panel.add(sp, constraints);

    constraints.gridy = 2;
    constraints.anchor = GridBagConstraints.WEST;
    panel.add(commandInput, constraints);

    constraints.gridy = 2;
    constraints.gridwidth = 2;
    constraints.anchor = GridBagConstraints.EAST;
    panel.add(buttonInput, constraints);

    // add the panel to this frame
    add(panel);

    pack();
    setLocationRelativeTo(null);

    createMap();
  }

  // Initialisation method - This must be overriding a method in Applet
  public void createMap() {
    map = new Map();
    currentLocation = map.getLocations()[4][2];
     showLocation();
     repaint();

  }

  private class PerformedListener implements ActionListener {

    public void actionPerformed(ActionEvent ae) {
//      if (ae.getSource().equals(KeyEvent.VK_ENTER)) {
//        buttonInput.doClick();
//      }

      if (ae.getSource() == buttonInput) {
        command = commandInput.getText();

        if (command.length() == 0) {
          return;
        }

        command = command.toUpperCase();

        for (Enumeration e = currentLocation.getExits().elements(); e.hasMoreElements(); ) {
          Exit an_exit = (Exit) e.nextElement();

          if ((an_exit.getDirectionName().compareTo(command) == 0) ||
              (an_exit.getShortDirectionName().compareTo(command) == 0)) {

            currentLocation = an_exit.getLeadsTo();

            showLocation();

            commandInput.setText(new String());

            return;
          }
        }

        displayOutput.append("\nHuh? Invalid direction \n");

        commandInput.setText(new String());

        return;
      }
      return;
    }
  }

  private void showLocation() {
    // Clear area
     displayOutput.setText(null);

    // Show room title
    displayOutput.append("\n" + currentLocation.getTitle() + "\n\n");
    displayOutput.append("\n");

    // Show room description
    displayOutput.append(currentLocation.getDescription() + "\n");

    // Show available exits
    displayOutput.append("\n\nAvailable exits : \n");
    for (Enumeration e = currentLocation.getExits().elements(); e.hasMoreElements(); ) {
      Exit an_exit = (Exit) e.nextElement();
      displayOutput.append(an_exit + "\n");
    }
  }

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new LocationDemo().setVisible(true);
      }
    });
  }
}
