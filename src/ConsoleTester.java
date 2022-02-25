import java.util.List;

import controller.ConsoleHelper;
import model.Console;

/**
 * @author Bobby - rfparsons
 * CIS175 - Spring 2022
 * Feb 24, 2022
 */

/**
 * @author Bobby
 *
 */
public class ConsoleTester {
	public static void main(String[] args) {
		Console wii = new Console("Wii");
		Console x360 = new Console("Xbox 360");
		Console ps3 = new Console("PlayStation 3");
		
		ConsoleHelper ch = new ConsoleHelper();
		
		ch.insertConsole(wii);
		ch.insertConsole(x360);
		ch.insertConsole(ps3);
		
		List<Console> allConsoles = ch.showAllConsoles();
		
		for(Console c: allConsoles) {
			System.out.println(c.toString());
		}
	}
}
