# tic-tac-toe

A simple tic-tac-toe game with swing UI. The goal was to follow a [TDD](https://en.wikipedia.org/wiki/Test-driven_development) aproach to creating the core components. With regards to the time available I had to make some tradeoffs to make it work and the code isn't as polished as I would normaly like.

# requirements

[Java 8] (https://www.oracle.com/java/technologies/javase-jre8-downloads.html)

# release

[release 0.0.1](https://github.com/xSakix/tic-tac-toe/releases/tag/0.0.1)

# how to run

Release contains an executable jar file. Run it to run the game.

# how to build

Clone the repository. Requires maven to build. Then run:

<pre>
mvn clean package 
</pre>

to build,run the tests and create a jar executable package.

# remarks

It's more like a prototype then a finished/polished product. I'm not realy happy with the code and it would need polishing. 
* The idea with the GridPosition didn't pay out. 
* Also the connection of original-core components with the UI isn't as smooth as I would like. 
* The implementation of 'isFinished' method is horrible and would require some refactoring/rethinking to make it more general
* More generalisation would be needed with the grid size and handling of the grid
* Removal of global vars would be required
* The creation of UIShapes after each click would need to be fixed.
* And many more...

As far as building, running and providing a client package what would be nice to do/nice to have:
* use Wix for a clean/nice  desktop install
* use JNLP for a webstart option

# todo for the future
* Enable bigger/customizeable grids with dynamic number of same symbols to win...lets say you make a game session with grid like 100x100 and to win the game you need 7 symbol aligned
* It would be nice to make this into a service. Then create a js/html frontend for it. Enable multiplayer and game session
* Play the game for score(with bigger grids), where the goal is to make as many points with symbols aligned until the game board is filled and no other reasonable symbol placement can be made
* Generally multiplayer and competitive gameplay would be a nice have...
