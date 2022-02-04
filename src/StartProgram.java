/**
 * @author Bobby - rfparsons
 * CIS175 - Spring 2022
 * Feb 3, 2022
 */


import java.util.List;
import java.util.Scanner;

import controller.GameHelper;
import model.Game;

/**
 * @author Bobby
 *
 */
public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static GameHelper gh = new GameHelper();

	private static void addAnGame() {
		// TODO Auto-generated method stub
		System.out.print("Enter a title: ");
		String title = in.nextLine();
		
		System.out.print("Enter a publisher: ");
		String publisher = in.nextLine();
		
		System.out.print("Enter a platform: ");
		String platform = in.nextLine();
		
		System.out.print("Enter a year: ");
		int year = Integer.parseInt(in.nextLine()); // not using nextInt to avoid input issues
		
		Game toAdd = new Game(title, publisher, platform, year);
		gh.insertGame(toAdd);
	}

	private static void deleteAnGame() {
		// TODO Auto-generated method stub
		System.out.print("Enter the title to delete: ");
		String title = in.nextLine();
		System.out.print("Enter the publisher to delete: ");
		String publisher = in.nextLine();
		System.out.print("Enter the platform to delete: ");
		String platform = in.nextLine();
		System.out.print("Enter the year to delete: ");
		int year = Integer.parseInt(in.nextLine()); // not using nextInt to avoid input issues
		
		Game toDelete = new Game(title, publisher, platform, year);
		gh.deleteGame(toDelete);
	}

	private static void editAnGame() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Title");
		System.out.println("2 : Search by Publisher");
		System.out.println("3 : Search by Platform");
		System.out.println("4 : Search by Year");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Game> foundGames;
		if (searchBy == 1) {
			System.out.print("Enter the game title: ");
			String title = in.nextLine();
			foundGames = gh.searchForGameByTitle(title);
			
		} 
		else if (searchBy == 2) {
			System.out.print("Enter the game publisher: ");
			String publisher = in.nextLine();
			foundGames = gh.searchForGameByPublisher(publisher);
		}
		else if (searchBy == 3) {
			System.out.print("Enter the game platform: ");
			String platform = in.nextLine();
			foundGames = gh.searchForGameByPlatform(platform);
		}
		else {
			System.out.print("Enter the year: ");
			int year = Integer.parseInt(in.nextLine()); // not using nextInt to avoid input issues
			foundGames = gh.searchForGameByYear(year);
		}

		if (!foundGames.isEmpty()) {
			System.out.println("Found Results.");
			for (Game l : foundGames) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Game toEdit = gh.searchForGameById(idToEdit);
			System.out.println("Retrieved " + toEdit.getTitle() + " on " + toEdit.getPlatform());
			System.out.println("1 : Update Title");
			System.out.println("2 : Update Publisher");
			System.out.println("3 : Update Platform");
			System.out.println("4 : Update Year");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Title: ");
				String newTitle = in.nextLine();
				toEdit.setTitle(newTitle);
			} 
			else if (update == 2) {
				System.out.print("New Publisher: ");
				String newPublisher = in.nextLine();
				toEdit.setPublisher(newPublisher);
			}
			else if (update == 3) {
				System.out.print("New Platform: ");
				String newPlatform = in.nextLine();
				toEdit.setPlatform(newPlatform);
			} 
			else if (update == 4) {
				System.out.print("New Year: ");
				int newYear = Integer.parseInt(in.nextLine());
				toEdit.setYear(newYear);
			}

			gh.updateGame(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to the game database! ---");
		while (goAgain) {
			System.out.println("*  Select a game:");
			System.out.println("*  1 -- Add a game");
			System.out.println("*  2 -- Edit a game");
			System.out.println("*  3 -- Delete a game");
			System.out.println("*  4 -- View the collection");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnGame();
			} else if (selection == 2) {
				editAnGame();
			} else if (selection == 3) {
				deleteAnGame();
			} else if (selection == 4) {
				viewTheList();
			} else {
				gh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		List<Game> allGames = gh.showAllGames(); 
		
		for(Game singleGame : allGames){ 
			System.out.println(singleGame.returnGameDetails()); 
		}
	}
}
