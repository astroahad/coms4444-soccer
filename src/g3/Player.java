package g3;

import java.util.List;
import java.util.Map;

import sim.Game;
import sim.GameHistory;
import sim.SimPrinter;

public class Player extends sim.Player {

     /**
      * Player constructor
      *
      * @param teamID      team ID
      * @param rounds      number of rounds
      * @param seed        random seed
      * @param simPrinter  simulation printer
      *
      */
     public Player(Integer teamID, Integer rounds, Integer seed, SimPrinter simPrinter) {
          super(teamID, rounds, seed, simPrinter);
     }

     /**
      * Reallocate player goals
      *
      * @param round             current round
      * @param gameHistory       cumulative game history from all previous rounds
      * @param playerGames       state of player games before reallocation
      * @param opponentGamesMap  state of opponent games before reallocation (map of opponent team IDs to their games)
      * @return                  state of player games after reallocation
      *
      */
     public List<Game> reallocate(Integer round, GameHistory gameHistory, List<Game> playerGames, Map<Integer, List<Game>> opponentGamesMap) {
          // TODO add your code here to reallocate player goals
    	  int sum = 0;
          for (Game game: playerGames) {
        	  sum += game.getNumPlayerGoals();
          }
          int numGoalsPerOpponent = sum/playerGames.size(); 
          int overflow = sum % playerGames.size();
          for (Game game: playerGames) {
        	  game.setNumPlayerGoals(numGoalsPerOpponent);
          }
          for (int i=0; i<overflow; i++) {
        	  Game game = playerGames.get(i);
        	  game.setNumPlayerGoals(game.getNumPlayerGoals() + 1);
          }
          return playerGames; // TODO modify the return statement to return your list of reallocated player games
     }
}