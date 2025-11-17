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

    
    int score = 0;

    Scanner in = new Scanner(System.in);
    String[] validCommands = { "right", "left", "up", "down", "r", "l", "u", "d",
    "jump", "jr", "jumpleft", "jl", "jumpup", "ju", "jumpdown", "jd",
    "pickup", "p", "quit", "q", "replay", "help", "?", "spring" };
  
    // set up game
    boolean play = true;
    while (play)
    {
      // get user command and validate
      System.out.print("Enter command: ");
      String input = UserInput.getValidInput(validCommands);

      // invalid input check
      if (input.equals("INVALID"))
      {
        System.out.println("Command Invalid!  You lose 3 points.");
        score -= 3;
        System.out.println("Current score: " + score);
      }

      // process user commands
      
      // Movement commands
      else if (input.equals("right") || input.equals("r"))
      {
        score += game.movePlayer(m, 0);
        score--; 
        System.out.println("Current score: " + score);
      }
      else if (input.equals("left") || input.equals("l"))
      {
        score += game.movePlayer(-m, 0);
        score--; 
        System.out.println("Current score: " + score);
      }
      else if (input.equals("pickup") || input.equals("p"))
      {
        score += game.pickupPrize();
        System.out.println("Current score: " + score);
      }
      else if (input.equals("up") || input.equals("u"))
      {
        score += game.movePlayer(0, -m);
        score--; 
        System.out.println("Current score: " + score);
      }
      else if (input.equals("down") || input.equals("d"))
      {
        score += game.movePlayer(0, m);
        score--; 
        System.out.println("Current score: " + score);
      }
      
      // Jump commands
      else if (input.equals("jump") || input.equals("jr"))
      {
        score += game.movePlayer(2*m, 0);
        score--; 
        System.out.println("Current score: " + score);
      }
      else if (input.equals("jumpleft") || input.equals("jl"))
      {
        score += game.movePlayer(-2*m, 0);
        score--; 
        System.out.println("Current score: " + score);
      }
      else if (input.equals("jumpup") || input.equals("ju"))
      {
        score += game.movePlayer(0, -2*m);
        score--; 
        System.out.println("Current score: " + score);
      }
      else if (input.equals("jumpdown") || input.equals("jd"))
      {
        score += game.movePlayer(0, 2*m);
        score--; 
        System.out.println("Current score: " + score);
      }
      
      // Check for trap at current location using .equals() method
      else if (input.equals("spring"))
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
        System.out.println("Current score: " + score);
      }
      
      // Replay
      else if (input.equals("replay"))
      {
        int steps = game.getSteps();
        score += game.replay();
        System.out.println("Board reset! Score: " + score + " Steps: " + steps);
        score = 0; // reset score for new game
      }
      
      // Help
      else if (input.equals("help") || input.equals("?"))
      {
        System.out.println("COMMANDS");
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
        System.out.println("  spring    - Spring a trap");
        System.out.println("  replay    - Reset board");
        System.out.println("  quit, q   - End game");
        System.out.println("  help, ?   - Show this message\n");
      }
      
      // quit
      else if (input.equals("quit") || input.equals("q"))
      {
        play = false;
      }
    }

    score += game.endGame();

    System.out.println("score=" + score);
    System.out.println("steps=" + game.getSteps());
  }
}
