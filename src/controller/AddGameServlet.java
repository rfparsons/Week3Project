package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Console;
import model.Game;

/**
 * Servlet implementation class AddGameServlet
 */
@WebServlet("/addGameServlet")
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("CCCCCCCCCCCCCCCCCCCCCCC");
		String title = request.getParameter("title");
		String publisher = request.getParameter("publisher");
		String platformName = request.getParameter("platform");
		int year = Integer.parseInt(request.getParameter("year"));
		
		Console platform = new Console(platformName);
		ConsoleHelper ch = new ConsoleHelper();
		
		boolean consoleExists = ch.insertConsole(platform);
		
		if (consoleExists) {
			platform = ch.findConsole(platformName);
		}
		
		Game gm = new Game(title, publisher, platform, year);
		GameHelper gh = new GameHelper();
		gh.insertGame(gm);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
//		getServletContext().getRequestDispatcher("google.com").forward(request, response);
	}

}
