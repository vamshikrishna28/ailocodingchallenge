Run the application
Pre-requisites:
1)Maven 3+
2)Java 1.8+

Build:
1)Run the command "mvn compile" from application root directory
2)A jar file named ZombieGame.jar is created in target folder.
3)Run the following java command to start the game.
    java -jar "path-to-jar/ZombieGame.jar"
4)Enter the input for the game in the following sequence
    1)Size of the grid
    2)Position of Zombie in the grid (x,y) ex : (2,3)
    3)Positions of all the creatures ex : (1,1)(2,2)(3,4)
    4)Sequence of moves that a zombie goes L - left, R - Right, U - Up, D - Down
5)Once the program runs it would display what are the positions of all the zombies(all the infected).
And it would also display the score that suggest how many of the zombies have been infected by the initial zombie

Additional: In order to run the test cases use the command "mvn test", this shall run all the unit tests.

About the game : The game is a standalone java program. The