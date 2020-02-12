package test.example;

import java.util.*;
import java.applet.*;
import java.awt.*;

public class LocationDemo extends Applet {
  Location currentLocation;
  String command;

  TextField commandInput;
  TextArea displayOutput;
  Button buttonInput;

  // Constructor - Calling Applet constructor (super();)
  public LocationDemo() {
    super();
  }

  // Initialisation method - This must be overriding a method in Applet
  public void init() {
    super.init();

    // Define colors
    setBackground(Color.white);
    setForeground(Color.black);

    Panel appletPanel = new Panel();

    // Use a border layout
    BorderLayout b = new BorderLayout();
    appletPanel.setLayout(b);
    add(appletPanel);

    // Define UI items
    commandInput = new TextField(20);
    displayOutput = new TextArea(10,60);
    buttonInput = new Button("Go");
    Panel inputPanel = new Panel();

    // Add components to our layout / panels
    inputPanel.add(commandInput);
    inputPanel.add(buttonInput);
    appletPanel.add("North", displayOutput);
    appletPanel.add("South", inputPanel);

    // Create two locations
    Location loc11 = new Location("Entrance to hall", "You stand at the entrance of a long " +
        "hallway. " +
      "The hallway gets darker\nand darker, and you cannot see what lies beyond. To the east \nis" +
      " an old oaken door, unlocked and beckoning");
    Location loc12 = new Location("End of hall", "You have reached the end of a long dark hallway" +
        ". You can \nsee nowhere ot go but back");
    Location loc13 = new Location("Small study", "This is a small and cluttered study, containing" +
        " a desk covered with \npapers. Though they no doubt are of some importance, \nyou cannot" +
        " read their writing");

    // Create an exit for loc11
    loc11.addExit(new Exit(Exit.NORTH, loc12));
    loc11.addExit(new Exit(Exit.EAST, loc13));

    // Create an exit for loc12
    loc12.addExit(new Exit(Exit.SOUTH, loc11));

    // Create an exit for loc13
    loc13.addExit(new Exit(Exit.WEST, loc11));

    // Set up room locations
    currentLocation = loc11;

    // Show first locations
    showLocation();
    repaint();

  }

  private void showLocation() {

    // Show room title
    displayOutput.appendText("\n" + currentLocation.getTitle() + "\n");
    displayOutput.appendText("\n");

    // Show room description
    displayOutput.appendText(currentLocation.getDescription() + "\n");

    // Show available exits
    displayOutput.appendText("\nAvailable exits : \n");
    for (Enumeration e = currentLocation.getExits().elements(); e.hasMoreElements();) {
      Exit an_exit = (Exit) e.nextElement();
      displayOutput.appendText(an_exit + "\n");
    }
  }

  public boolean action(Event evt, Object focus) {
    String command;

    // Was a button pressed?
    if (evt.target instanceof Button) {
      // Obtain string
      command = commandInput.getText();

      // Don't parse blank commands
      if (command.length() == 0) {
        return true;
      }

      // Convert to uppercase for comparison
      command = command.toUpperCase();

      // Search for an exit match
      for (Enumeration e = currentLocation.getExits().elements(); e.hasMoreElements();) {
        Exit an_exit = (Exit) e. nextElement();

        if ((an_exit.getDirectionName().compareTo(command) == 0) || (an_exit.getShortDirectionName().compareTo(command) == 0)) {

          // Set location to the location pointed to by exit
          currentLocation = an_exit.getLeadsTo();

          // Show new location
          showLocation();

          // Clear text area
          commandInput.setText(new String());

          // Event handled
          return true;
        }
      }

      // If code reaches here, direction is invalid
      displayOutput.appendText("\nHuh? Invalid direction!\n");

      // Clear text area
      commandInput.setText(new String());

      // Event handled
      return true;
    }
    // Event not handled
    return true;
  }
}
