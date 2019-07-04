# TennisGame
 This kata is about implementing a simple tennis game. In which each set is consider as one game.

# User Story
1. A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
2. The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as “love”, “fifteen”, “thirty”, and “forty” respectively.
3. If at least three points have been scored by each player, and the scores are equal, the score is “deuce”.
4. If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is “advantage” for the player in the lead.

#Prerequisite
Java 1.8 version
Maven 3.3+
Git

**Jacoco code coverage Report using JaCoCo Maven plugin**
~~~
1. Open the command prompt / terminal from project directory
2. Run 'mvn clean test', the JaCoCo code coverage report will be generated at target/site/jacoco/*
3. Open the target/site/jacoco/index.html file, review the code coverage report
~~~