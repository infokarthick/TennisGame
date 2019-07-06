# TennisGame
 This kata is about implementing a simple tennis game by following TDD approach. In which each set is consider as one game.

# User Story
US0001. The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as “love”, “fifteen”, “thirty”, and “forty” respectively.
US0002. A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
US0003. If at least three points have been scored by each player, and the scores are equal, the score is “deuce”.
US0004. If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is “advantage” for the player in the lead.

#Assumption
* Minimum and Maximum number of player is 2
* Each set is consider as one game
* Player one will always do the service, hence the game score will be always represented with respect to player1 i.e. player1 score - player2 score


# Prerequisite
~~~
Java 1.8 version
Maven 3.5+
Git
~~~

###Set up application
~~~
#### IDE
1. Clone the repository https://github.com/2019-Q2_SOW_DEV_034/Tennis
2. Add as Maven project
3. Select Project SDK as JDK 1.8

#### Command prompt
1. Clone repository from GIT 'git clone https://github.com/2019-Q2_SOW_DEV_034/Tennis'
2. Run `mvn clean install`
~~~

### Run Test Cases
~~~
#### IDE
1. Navigate to Maven Toolbar
2. Select `test` under lifecycle menu and click on play symbol

#### Command Prompt
1. Go to the directory where you have cloned the Tennis program (C:\Study\Workspace\TennisGame)
2. Run `mvn test`
~~~

** Compile and run the application in cmd prompt **
~~~
1. Open the command prompt / terminal and go to the directory where you have cloned the Tennis program (C:\Study\Workspace\TennisGame)
2. Build the application 'mvn clean install'
3. Run the application 'mvn exec:java'.
4. Follow on the instructions on the screen to play the tennis game.
~~~

**Jacoco code coverage Report using JaCoCo Maven plugin**
~~~
1. Open the command prompt / terminal from project directory
2. Run 'mvn clean test' the JaCoCo code coverage report will be generated at target/site/jacoco/*
3. Open the target/site/jacoco/index.html file, review the code coverage report
~~~

**Mutation code coverage Report using PITest Maven plugin**
~~~
1. Open the command prompt / terminal from project directory
2. Run the PITest 'mvn clean test', the Mutation code coverage report will be generated at target/pit-reports/YYYYMMDDHHMI/*
4. Open the target/pit-reports/yyyyMMddHHmm/index.html file, review the mutation coverage report
~~~

