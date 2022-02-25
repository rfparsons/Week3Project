import java.util.List;

import controller.ConsoleHelper;
import controller.GameHelper;
import model.Console;
import model.Game;

/**
 * @author Bobby - rfparsons
 * CIS175 - Spring 2022
 * Feb 24, 2022
 */

/**
 * @author Bobby
 *
 */
public class GameConsoleTester {
	public static void main(String[] args) {
		Console wii = new Console("Wii");
	
		ConsoleHelper ch = new ConsoleHelper();
	
		ch.insertConsole(wii);
	
		GameHelper gh = new GameHelper();
		
		Game smg = new Game("Super Mario Galaxy", "Nintendo", wii, 2007);
		
		gh.insertGame(smg);
		
		List<Game> allGames = gh.showAllGames();
		
		for(Game g: allGames) {
			System.out.println(g.toString());
		}
	}
}
