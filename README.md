## Thirteen Card Game

### Description
Thirteen Card Game is a simple card game where the objective is to score the most points by forming sets of cards. The game is played between a player and a bot, each receiving a deck of 13 cards. The player and bot take turns playing cards, trying to form sets of three or more cards of the same rank.

### How to Play
1. The game starts by dealing 13 cards to the player and 13 cards to the bot.
2. The player goes first and plays a card from their hand.
3. The bot then plays a card from its hand, trying to form a set with the player's card.
4. If a set is formed (three or more cards of the same rank), the player or bot who played the last card in the set scores points based on the rank of the cards.
5. The game continues with the player and bot taking turns playing cards until all cards have been played.
6. The player or bot with the highest score at the end of the game wins.

### Scoring
- Three of a kind: 3 points
- Four of a kind: 4 points
- Five of a kind: 5 points
- ... and so on

### Installation
1. Clone the repository: `git clone https://github.com/yourusername/thirteen-card-game.git`
2. Navigate to the project directory: `cd thirteen-card-game`
3. Compile the Java files: `javac *.java`

### Usage
1. Run the main class: `java Thirteen_main`
2. Follow the menu prompts to start a new game or exit.

### Code Structure
- `Thirteen_main.java`: The main class that handles the game flow, creates decks for the player and bot, and tracks points.
- `Card.java`: Represents a playing card with value, name, and suit.
- `Message.java`: Handles displaying messages and menus to the user.

### License
This code is the property of Howard Tran. Unauthorized copying of this file, via any medium, is strictly prohibited. Proprietary and confidential.

© 2024 Howard Tran. All rights reserved.

Citations:
[1] https://ppl-ai-file-upload.s3.amazonaws.com/web/direct-files/928172/a853d4a4-3aed-471b-a7a4-9ab656b16ac4/asd.pdf
