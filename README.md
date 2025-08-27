🎲 Java Dice Betting Game

A simple Java Swing betting game created as coursework in Year 1.
The player bets whether the dice roll will be Under 7, Exactly 7, or Over 7.
The game runs for 5 rounds, starting with £3 credit, and includes the option to double bets.

At the end of the game, a summary report is displayed with all bets placed, results, credits, and dice rolls.

🚀 Features

Graphical interface using JOptionPane

Age validation (players under 18 cannot play)

Betting system:

Under Seven → win if dice roll < 7

Exactly Seven → win if dice roll = 7 (higher payout)

Over Seven → win if dice roll > 7

Option to double your bet

Player statistics tracked for each round:

Round number

Option chosen

Credits remaining

Result (Win/Loss)

Computer’s dice roll

Final summary at the end of the game

📦 Requirements

Java 17 (JDK)

No external libraries required (uses javax.swing and java.util)

▶️ Run Without Compiling

Download the latest DiceGame.jar from the Releases page and run:

java -jar DiceGame.jar

▶️ How to Run from Source

From the project root, compile and run:

javac -d bin src/*.java
java -cp bin MainGame

If your files use a package declaration (e.g. package coursework;), then use:

javac -d bin src/coursework/*.java
java -cp bin coursework.MainGame

📜 License

This repository is public for viewing only.
All rights reserved © 2025 Jose.
