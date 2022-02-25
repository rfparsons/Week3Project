package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllItemsServlet
 */
@WebServlet("/viewAllGamesServlet")
public class ViewAllGamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllGamesServlet() {
        super();
        // TODO Auto-generated constructor stub
//        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		int goodNum = 1/0;
//		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
		GameHelper gh = new GameHelper();
		
		request.setAttribute("allGames", gh.showAllGames());
		
		String path = "/game-db.jsp";
		
		if(gh.showAllGames().isEmpty()){
			path = "/index.html";
		}
		
//		path = "/cat.jpg"; // public domain image of a cat for testing
		
		System.out.println(path);
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA");
		doGet(request, response);
	}

}
