package engine;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;


public class GameServer {
	
	public Game getRandomGame() throws MalformedURLException {
		int i =  new Random().nextInt(1000); 
		String urlLocation = "https://sanfoh.com/heartgame/sixeqgame_" + i + ".png";
		URL url = new URL(urlLocation);
		int solution  = i % 10; 
		return new Game(url, solution);
	}


}
