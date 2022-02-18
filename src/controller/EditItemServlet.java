package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Game;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GameHelper gh = new GameHelper();
		
		String title = request.getParameter("title");
		String publisher = request.getParameter("publisher");
		String platform = request.getParameter("platform");
		int year = Integer.parseInt(request.getParameter("year"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Game itemToUpdate = gh.searchForGameById(tempId);
		itemToUpdate.setTitle(title);
		itemToUpdate.setPublisher(publisher);
		itemToUpdate.setPlatform(platform);
		itemToUpdate.setYear(year);
		
		gh.updateGame(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllGamesServlet").forward(request, response);
	}

}
