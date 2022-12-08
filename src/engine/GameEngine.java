package engine;
import java.net.MalformedURLException;
import java.net.URL;


public class GameEngine {
	String thePlayer = null;

	
	public GameEngine(String player) {
		thePlayer = player;
	}

	int counter = 0;
	int score = 0; 
	GameServer theGames = new GameServer(); 
	Game current = null; 

	public URL nextGame() {		
			try {
				current = theGames.getRandomGame();
				return current.getLocation(); 
			} catch (MalformedURLException e) {
				System.out.println("Something went wrong when trying to retrieve game "+counter+"!"); 
				e.printStackTrace();
				return null; 
			} 
		
	}

	
	public boolean checkSolution(URL game, int i) {
		if (i == current.getSolution()) {
			score++; 
			return true;
		} else {
			return false;
		}
	}


	
	public int getScore() {
		return score;
	}

}
