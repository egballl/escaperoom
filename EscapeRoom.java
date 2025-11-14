/*
* Problem 1: Escape Room
* 
* V1.0
* 10/10/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.util.Scanner;

/**
 * Create an escape room game where the player must navigate
 * to the other side of the screen in the fewest steps, while
 * avoiding obstacles and collecting prizes.
 */
public class EscapeRoom
{
  public static void main(String[] args) 
  {      
    // welcome message
    System.out.println("Welcome to EscapeRoom!");
    System.out.println("Get to the other side of the room, avoiding walls and invisible traps,");
    System.out.println("pick up all the prizes.\n");
    
    GameGUI game = new GameGUI();
    game.createBoard();

    // size of move
    int m = 60; 
    // individual player moves
    int px = 0;
    int py = 0; 
    
    int score = 0;

    Scanner in = new Scanner(System.in);
    String[] validCommands = { "right", "left", "up", "down", "r", "l", "u", "d",
    "jump", "jr", "jumpleft", "jl", "jumpup", "ju", "jumpdown", "jd",
    "pickup", "p", "quit", "q", "replay", "help", "?"};
  
    // set up game
    boolean play = true;
    while (play)
    {
      // get user command and validate
      System.out.print("Enter command: ");
      String input = UserInput.getValidInput(validCommands);

      // process user commands
      
      // Movement commands
      if ("right r".indexOf(input) >= 0)
      {
        score += game.movePlayer(m, 0);
      }
      else if ("left l".indexOf(input) >= 0)
      {
        score += game.movePlayer(-m, 0);
      }
      else if ("up u".indexOf(input) >= 0)
      {
        score += game.movePlayer(0, -m);
      }
      else if ("down d".indexOf(input) >= 0)
      {
        score += game.movePlayer(0, m);
      }
      
      // Jump commands
      else if ("jump jr".indexOf(input) >= 0)
      {
        score += game.movePlayer(2*m, 0);
      }
      else if ("jumpleft jl".indexOf(input) >= 0)
      {
        score += game.movePlayer(-2*m, 0);
      }
      else if ("jumpup ju".indexOf(input) >= 0)
      {
        score += game.movePlayer(0, -2*m);
      }
      else if ("jumpdown jd".indexOf(input) >= 0)
      {
        score += game.movePlayer(0, 2*m);
      }
      
      // Pickup prize
      else if ("pickup p".indexOf(input) >= 0)
      {
        score += game.pickupPrize();
      }
      
      // Spring trap - check if trap exists first
      else if ("spring".indexOf(input) >= 0)
      {
        if (game.isTrap(0, 0))
        {
          score += game.springTrap(0, 0);
        }
        else
        {
          System.out.println("THERE IS NO TRAP HERE TO SPRING");
          score -= 5;
        }
      }
      
      // Replay
      else if ("replay".indexOf(input) >= 0)
      {
        score += game.replay();
        System.out.println("Board reset! Steps: " + game.getSteps());
      }
      
      // Help command
      else if ("help ?".indexOf(input) >= 0)
      {
        System.out.println("\n COMMANDS");
        System.out.println("Movement:");
        System.out.println("  right, r  - Move right");
        System.out.println("  left, l   - Move left");
        System.out.println("  up, u     - Move up");
        System.out.println("  down, d   - Move down");
        System.out.println("Jumping:");
        System.out.println("  jump, jr       - Jump right");
        System.out.println("  jumpleft, jl   - Jump left");
        System.out.println("  jumpup, ju     - Jump up");
        System.out.println("  jumpdown, jd   - Jump down");
        System.out.println("Actions:");
        System.out.println("  pickup, p - Pick up prize");
        System.out.println("  replay    - Reset board");
        System.out.println("  quit, q   - End game");
        System.out.println("  help, ?   - Show this message\n");
      }
      
      // quit
      else if ("quit q".indexOf(input) >= 0)
      {
        play = false;
      }
    }

    score += game.endGame();

    System.out.println("score=" + score);
    System.out.println("steps=" + game.getSteps());
  }
}