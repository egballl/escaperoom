# EscapeRoom Game

![Recording2025-11-14112609-ezgif com-video-to-gif-converter](https://github.com/user-attachments/assets/dc53ed34-3c5c-400b-b6d0-eb1009bf928f)

## Overview
Navigate to the other side of the screen in the fewest steps while avoiding obstacles and collecting prizes.

## Game Commands
- `help` or `?` - Display list of commands

## Files Required
- `EscapeRoom.java` - Main game logic
- `GameGUI.java` - Game board and graphics
- `UserInput.java` - Input validation
- `grid.png` - Background grid image
- `coin.png` - Prize image
- `player.png` - Player character image

## Technical Requirements Met
- Static and non-static method calls
- Methods with return values
- `.equals()` String method for input validation
- `if/else/else if` conditional statements
- Compound Boolean expressions
- Increment operators
- User input validation
- Score and step tracking

## Game Board Layout
- **Grid Size**: 8 columns x 5 rows
- **Default Obstacles**: 20 walls, 5 traps, 3 prizes
- **Starting Position**: Top-left corner (15, 15)
- **Goal**: Right side of the board

## Scoring System

### Points Gained
- **+10 points** - Pick up a prize
- **+5 points** - Spring a trap
- **+10 points** - Reach the far right wall
- **+1 point** - Each movement action

### Penalties (Points Lost)
- **-10 points** - Try to pick up prize when none exists
- **-5 points** - Try to spring trap when none exists
- **-5 points** - Hit a wall
- **-5 points** - Move off the grid
- **-10 points** - Quit before reaching the end
