# EscapeRoom Game

![Recording2025-11-14112609-ezgif com-video-to-gif-converter](https://github.com/user-attachments/assets/dc53ed34-3c5c-400b-b6d0-eb1009bf928f)

## Overview
Navigate to the other side of the screen (right wall) in the fewest steps while avoiding walls and collecting prizes.

## Game Commands
- `help` or `?` - Display list of commands

## Technical Requirements Met
- Static and non-static method calls
- Methods with return values
- `.equals()` String method for input validation
- `if/else/else if` conditional statements
- Compound Boolean expressions
- Increment operators
- User input validation
- Score and step tracking

## Scoring System

### Points Gained
- **+10 points** - Pick up a prize
- **+5 points** - Spring a trap: `spring`
- **+10 points** - Reach the far right wall


### Penalties (Points Lost)
- **-1 point** - Each movement action
- **-10 points** - Try to pick up prize when none exists
- **-5 points** - Try to spring trap when none exists
- **-5 points** - Hit a wall
- **-5 points** - Try to move off the grid
- **-3 points** - Invalid command
- **-10 points** - Quit before reaching the end
