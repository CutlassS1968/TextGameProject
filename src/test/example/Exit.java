package test.example;

public class Exit {

  // All numerical codes
  public static final int UNDEFINED = 0;
  public static final int NORTH = 1;
  public static final int SOUTH = 2;
  public static final int EAST = 3;
  public static final int WEST = 4;
  public static final int UP = 5;
  public static final int DOWN = 6;
  public static final int NORTHEAST = 7;
  public static final int NORTHWEST = 8;
  public static final int SOUTHEAST = 9;
  public static final int SOUTHWEST = 10;
  public static final int IN = 11;
  public static final int OUT = 12;

  // Directory of all the long direction codes
  public static final String[] dirName = {
      "UNDEFINED",
      "NORTH",
      "SOUTH",
      "EAST",
      "WEST",
      "UP",
      "DOWN",
      "NORTHEAST",
      "NORTHWEST",
      "SOUTHEAST",
      "SOUTHWEST",
      "IN",
      "OUT"
  };

  // Directory of all the short direction codes
  public static final String [] shortDirName = {
      "NULL",
      "N",
      "S",
      "E",
      "W",
      "U",
      "D",
      "NE",
      "NW",
      "SE",
      "SW",
      "I",
      "O"
  };

  // Instance variables
  private Location leadsTo = null;
  private int direction;

  // Full name of direction
  private String directionName;

  // Short name of direction
  private String shortDirectionName;

  // Default Constructor
  public Exit() {
    direction = Exit.UNDEFINED;
    leadsTo = null;
    directionName = dirName[UNDEFINED];
    shortDirectionName = shortDirName[UNDEFINED];
  }
  // Main Constructor
  public Exit(int direction, Location leadsTo) {
    this.direction = direction;

    if (direction <= dirName.length) {
      this.directionName = dirName[this.direction];
    }

    if (direction <= shortDirName.length) {
      this.shortDirectionName = shortDirName[this.direction];
    }

    this.leadsTo = leadsTo;
  }

  public String toString() {
    return  directionName;
  }

  public void setDirectionName(String directionName) {
    this.directionName = directionName;
  }

  public String getDirectionName() {
    return directionName;
  }

  public void setShortDirectionName(String shortDirectionName) {
    this.shortDirectionName = shortDirectionName;
  }

  public String getShortDirectionName() {
    return shortDirectionName;
  }

  public void setLeadsTo(Location leadsTo) {
    this.leadsTo = leadsTo;
  }

  public Location getLeadsTo() {
    return leadsTo;
  }

}
