TicTacToeGame/ Game here:
 - consists of board, players

Define board & player
Board
- will have row, column, grid
- can take a grid which will denote all the moves played 
  - i.e. it can be X or O or Empty(if no players has played a move)


Game can be over w/o any player winning

For interview discussion: since we have data attributes within Board entity:
Can keep the logic within the Board class to keep it simple and cohesive for short session.
The board owns its state and the logic directly acts on it. 
However, if we were scaling this to multiple board types, or wanted better testability,
I’d refactor this into a BoardService that operates on a Board object passed in.

Issues encountered while running an application:
Previous version where lombok was added while initialising spring application [start.spring.io]
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <optional>true</optional>
</dependency>

Updated to: Add latest lombok version at both places in pom.xml
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <version>1.18.30</version>
</dependency>



