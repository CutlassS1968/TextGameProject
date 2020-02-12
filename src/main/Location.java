package main;

import java.util.Vector;

/**
 *
 * +description of room
 * +title for room IE Hallway Room Field etc
 * +items in room
 * +Vector array that allows for adding and subtracting exits due to actions
 *
 *
 */
public class Location {
  private String title;
  private String description;
  private Vector vectorExits;

  public Location() {
    // Blank title + description
    title = new String();
    description = new String();
    vectorExits = new Vector();
  }

  public Location(String title) {
    this.title = title;
    description = new String();
    vectorExits = new Vector();
  }

  public Location(String title, String description) {
    this.title = title;
    this.description = description;

    vectorExits = new Vector();

  }

  public void addExit(Exit exit) {
    vectorExits.addElement(exit);
  }

  public void removeExit(Exit exit) {
    if (vectorExits.contains(exit)) {
      vectorExits.removeElement(exit);
    }
  }

  public Vector getExits() {
    // we want to return a clone because we
    // don't want to modify our original vector
    return (Vector) vectorExits.clone();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


}
