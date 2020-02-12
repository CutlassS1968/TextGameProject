package main;

public class Map {

  // QUESTION: SHOULD THIS BE STATIC?
  private Location[][] locations = new Location[5][5];

  public Map() {
    for (int x = 0; x < locations.length; ++x) {
      for (int y = 0; y < locations.length; ++y) {
        locations[x][y] = new Location();
      }
    }
    setTitles();
    setDescriptions();
    setExits();
  }

  public Location[][] getLocations() {
    return locations;
  }

  private void setTitles() {
    locations[0][0].setTitle(null);
    locations[0][1].setTitle(null);
    locations[0][2].setTitle(null);
    locations[0][3].setTitle("Master Bedroom");
    locations[0][4].setTitle(null);

    locations[1][0].setTitle("West Kitchen");
    locations[1][1].setTitle("East Kitchen");
    locations[1][2].setTitle("North Hallway");
    locations[1][3].setTitle("Master Bedroom");
    locations[1][4].setTitle("Master Bathroom");

    locations[2][0].setTitle("West Dining Room");
    locations[2][1].setTitle("East Dining Room");
    locations[2][2].setTitle("South Hallway");
    locations[2][3].setTitle("Guest Bedroom");
    locations[2][4].setTitle("Guest Bathroom");

    locations[3][0].setTitle(null);
    locations[3][1].setTitle("Room");
    locations[3][2].setTitle("Foyer");
    locations[3][3].setTitle("Coat Closet");
    locations[3][4].setTitle(null);

    locations[4][0].setTitle(null);
    locations[4][1].setTitle("West Porch");
    locations[4][2].setTitle("Porch");
    locations[4][3].setTitle("East Porch");
    locations[4][4].setTitle(null);
  }

  private void setDescriptions() {
    locations[0][0].setDescription(null);
    locations[0][1].setDescription(null);
    locations[0][2].setDescription(null);
    locations[0][3].setDescription("You're in the Northern end of the Master Bedroom Suite");
    locations[0][4].setDescription(null);

    locations[1][0].setDescription("You're in the Western end of the Kitchen");
    locations[1][1].setDescription("You're in the Eastern end of the Kitchen");
    locations[1][2].setDescription("You're in the Northern end of the Hallway");
    locations[1][3].setDescription("You're in the Southern end of the Master Bedroom Suite");
    locations[1][4].setDescription("You're in the Master Bathroom");

    locations[2][0].setDescription("You're in the Western end of the Dinning room");
    locations[2][1].setDescription("You're in the Eastern end of the Dinning room");
    locations[2][2].setDescription("You're in the Southern end of the Hallway");
    locations[2][3].setDescription("You're in the Guest Bedroom");
    locations[2][4].setDescription("You're in the Guest Bathroom");

    locations[3][0].setDescription(null);
    locations[3][1].setDescription("You're in the waiting room");
    locations[3][2].setDescription("\"You stand at the entrance of a long hallway. The hallway gets darker and darker, and you cannot see what lies beyond. To the east is an old oaken door, unlocked and beckoning");
    locations[3][3].setDescription("You're in the coat closet");
    locations[3][4].setDescription(null);

    locations[4][0].setDescription(null);
    locations[4][1].setDescription("You're on the Western end of the Porch");
    locations[4][2].setDescription("You're on the Porch");
    locations[4][3].setDescription("You're on the Eastern end of the Porch");
    locations[4][4].setDescription(null);
  }

  private void setExits() {
//    locations[0][0].addExit(new Exit());                              // North
//    locations[0][0].addExit(new Exit(Exit.EAST,   locations[0][1]));  // East
//    locations[0][0].addExit(new Exit(Exit.SOUTH,  locations[1][0]));  // South
//    locations[0][0].addExit(new Exit());                              // West
//
//    locations[0][1].addExit(new Exit());
//    locations[0][1].addExit(new Exit(Exit.EAST,   locations[0][2]));
//    locations[0][1].addExit(new Exit(Exit.SOUTH,  locations[1][1]));
//    locations[0][1].addExit(new Exit(Exit.WEST,   locations[0][0]));
//
//    locations[0][2].addExit(new Exit());
//    locations[0][2].addExit(new Exit(Exit.EAST,   locations[0][3]));
//    locations[0][2].addExit(new Exit(Exit.SOUTH,  locations[1][2]));
//    locations[0][2].addExit(new Exit(Exit.WEST,   locations[0][1]));

//    locations[0][3].addExit(new Exit());
//    locations[0][3].addExit(new Exit(Exit.EAST,   locations[0][4]));
    locations[0][3].addExit(new Exit(Exit.SOUTH,  locations[1][3]));
//    locations[0][3].addExit(new Exit(Exit.WEST,   locations[0][2]));

//    locations[0][4].addExit(new Exit());
//    locations[0][4].addExit(new Exit());
//    locations[0][4].addExit(new Exit(Exit.SOUTH,  locations[1][4]));
//    locations[0][4].addExit(new Exit(Exit.WEST,   locations[0][3]));


//    locations[1][0].addExit(new Exit(Exit.NORTH,  locations[0][0]));
    locations[1][0].addExit(new Exit(Exit.EAST,   locations[1][1]));
    locations[1][0].addExit(new Exit(Exit.SOUTH,  locations[2][0]));
//    locations[1][0].addExit(new Exit());

//    locations[1][1].addExit(new Exit(Exit.NORTH,  locations[0][1]));
    locations[1][1].addExit(new Exit(Exit.EAST,   locations[1][2]));
//    locations[1][1].addExit(new Exit(Exit.SOUTH,  locations[2][1]));
    locations[1][1].addExit(new Exit(Exit.WEST,   locations[0][1]));

//    locations[1][2].addExit(new Exit(Exit.NORTH,  locations[0][2]));
    locations[1][2].addExit(new Exit(Exit.EAST,   locations[1][3]));
    locations[1][2].addExit(new Exit(Exit.SOUTH,  locations[2][2]));
    locations[1][2].addExit(new Exit(Exit.WEST,   locations[1][1]));

    locations[1][3].addExit(new Exit(Exit.NORTH,  locations[0][3]));
    locations[1][3].addExit(new Exit(Exit.EAST,   locations[1][4]));
//    locations[1][3].addExit(new Exit(Exit.SOUTH,  locations[2][3]));
    locations[1][3].addExit(new Exit(Exit.WEST,   locations[1][2]));

//    locations[1][4].addExit(new Exit(Exit.NORTH,  locations[0][4]));
//    locations[1][4].addExit(new Exit());
//    locations[1][4].addExit(new Exit(Exit.SOUTH,  locations[2][4]));
    locations[1][4].addExit(new Exit(Exit.WEST,   locations[1][3]));


    locations[2][0].addExit(new Exit(Exit.NORTH, locations[1][0]));
    locations[2][0].addExit(new Exit(Exit.EAST, locations[2][1]));
//    locations[2][0].addExit(new Exit(Exit.SOUTH, locations[3][0]));
//    locations[2][0].addExit(new Exit());

//    locations[2][1].addExit(new Exit(Exit.NORTH, locations[1][1]));
//    locations[2][1].addExit(new Exit(Exit.EAST, locations[2][2]));
    locations[2][1].addExit(new Exit(Exit.SOUTH, locations[3][1]));
    locations[2][1].addExit(new Exit(Exit.WEST, locations[2][0]));

    locations[2][2].addExit(new Exit(Exit.NORTH, locations[1][2]));
    locations[2][2].addExit(new Exit(Exit.EAST, locations[2][3]));
    locations[2][2].addExit(new Exit(Exit.SOUTH, locations[3][2]));
//    locations[2][2].addExit(new Exit(Exit.WEST, locations[2][1]));

//    locations[2][3].addExit(new Exit(Exit.NORTH, locations[1][3]));
    locations[2][3].addExit(new Exit(Exit.EAST, locations[2][4]));
//    locations[2][3].addExit(new Exit(Exit.SOUTH, locations[3][3]));
    locations[2][3].addExit(new Exit(Exit.WEST, locations[2][2]));

//    locations[2][4].addExit(new Exit(Exit.NORTH, locations[1][4]));
//    locations[2][4].addExit(new Exit());
//    locations[2][4].addExit(new Exit(Exit.SOUTH, locations[3][4]));
    locations[2][4].addExit(new Exit(Exit.WEST, locations[2][3]));


//    locations[3][0].addExit(new Exit(Exit.NORTH, locations[2][0]));
//    locations[3][0].addExit(new Exit(Exit.EAST, locations[3][1]));
//    locations[3][0].addExit(new Exit(Exit.SOUTH, locations[4][0]));
//    locations[3][0].addExit(new Exit());

    locations[3][1].addExit(new Exit(Exit.NORTH, locations[2][1]));
    locations[3][1].addExit(new Exit(Exit.EAST, locations[3][2]));
//    locations[3][1].addExit(new Exit(Exit.SOUTH, locations[4][1]));
//    locations[3][1].addExit(new Exit(Exit.WEST, locations[3][0]));

    locations[3][2].addExit(new Exit(Exit.NORTH, locations[2][2]));
    locations[3][2].addExit(new Exit(Exit.EAST, locations[3][3]));
    locations[3][2].addExit(new Exit(Exit.SOUTH, locations[4][2]));
    locations[3][2].addExit(new Exit(Exit.WEST, locations[3][1]));

//    locations[3][3].addExit(new Exit(Exit.NORTH, locations[2][3]));
//    locations[3][3].addExit(new Exit(Exit.EAST, locations[3][4]));
//    locations[3][3].addExit(new Exit(Exit.SOUTH, locations[4][3]));
    locations[3][3].addExit(new Exit(Exit.WEST, locations[3][2]));

//    locations[3][4].addExit(new Exit(Exit.NORTH, locations[2][4]));
//    locations[3][4].addExit(new Exit());
//    locations[3][4].addExit(new Exit(Exit.SOUTH, locations[4][4]));
//    locations[3][4].addExit(new Exit(Exit.WEST, locations[3][3]));


//    locations[4][0].addExit(new Exit(Exit.NORTH, locations[3][0]));
//    locations[4][0].addExit(new Exit(Exit.EAST, locations[4][1]));
//    locations[4][0].addExit(new Exit());
//    locations[4][0].addExit(new Exit());

//    locations[4][1].addExit(new Exit(Exit.NORTH, locations[3][1]));
    locations[4][1].addExit(new Exit(Exit.EAST, locations[4][2]));
//    locations[4][1].addExit(new Exit());
//    locations[4][1].addExit(new Exit(Exit.WEST, locations[4][0]));

    locations[4][2].addExit(new Exit(Exit.NORTH, locations[3][2]));
    locations[4][2].addExit(new Exit(Exit.EAST, locations[4][3]));
//    locations[4][2].addExit(new Exit());
    locations[4][2].addExit(new Exit(Exit.WEST, locations[4][1]));

//    locations[4][3].addExit(new Exit(Exit.NORTH, locations[3][3]));
//    locations[4][3].addExit(new Exit(Exit.EAST, locations[4][4]));
//    locations[4][3].addExit(new Exit());
    locations[4][3].addExit(new Exit(Exit.WEST, locations[4][2]));

//    locations[4][4].addExit(new Exit(Exit.NORTH, locations[3][4]));
//    locations[4][4].addExit(new Exit());
//    locations[4][4].addExit(new Exit());
//    locations[4][4].addExit(new Exit(Exit.WEST, locations[4][3]));
  }
}
