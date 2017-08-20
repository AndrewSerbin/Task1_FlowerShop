package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.boquet.Bouquet;
import model.entity.boquet.StemLength;
import util.find.BouquetFind;

@WebServlet("/FindInProductList")
public class FindInProductList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();

	List<Bouquet> bouquets = (List<Bouquet>) session.getAttribute("bouquets");
	BouquetFind bouquetFind = new BouquetFind();
	List<Bouquet> result = bouquetFind.find(bouquets, StemLength.valueOf(request.getParameter("StemLength")));
	session.setAttribute("bouquets", result);

	redirect(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	this.getServletContext().getRequestDispatcher("/WEB-INF/product_list.jsp").forward(request, response);
    }
}
