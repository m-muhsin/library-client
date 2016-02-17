package com.nsbm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsbm.client.BookClient;
import com.nsbm.model.Book;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookClient bookClient;
	
    /**
     * Default constructor. 
     */
    public Main() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		String action = request.getParameter("action");
		
		if(action == null) {
			//if action is null, send to index page
			page = "index.jsp";
			request.getRequestDispatcher(page).forward(request, response);
			
		} else if(action.equals("allbooks")){
			//if action is allbooks, send to allbooks
			
			bookClient = new BookClient();

			List<Book> res = bookClient.getBooks();
			request.setAttribute("res", res);
			page = "allbooks.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		} else if(action.equals("getbook")){
			page = "getbook.jsp";
			
			String bookId = request.getParameter("bookid");
			if(bookId != null) {
				//when a book object is successfully returned
				
				System.out.println("bookId: " + bookId);
				
				bookClient = new BookClient();
				String book = bookClient.getBook(bookId);
				System.out.println("res: " + book);
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(""+book);
				
			} else {
				//when a null is returned instead of a book
				request.getRequestDispatcher(page).forward(request, response);
			} 
			
		} else if(action.equals("addbook")){
			page = "addbook.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null){
			if(action.equals("addbook")){
				String title = request.getParameter("title");
				String author= request.getParameter("author");
				System.out.println("title : " + title);
				System.out.println("author : " + author);
				
				Book book = new Book();
				book.setTitle(title);
				book.setAuthor(author);
				bookClient = new BookClient();
				bookClient.addBook(book);
				
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}

}
