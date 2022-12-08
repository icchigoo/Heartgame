package engine;

import java.net.URL;

public class Game {
	URL location = null; 
	int solution = -1;
	
	public Game(URL location, int solution) {
		super();
		this.location = location;
		this.solution = solution;
	}
	
	public URL getLocation() {
		return location;
	}

	
	public int getSolution() {
		return solution;
	}
	
	
	
	

}
