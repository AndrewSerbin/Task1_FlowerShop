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
import util.sort.BouquetSort;
import util.sort.FreshnessComparator;

@WebServlet("/SortProductList")
public class SortProductListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();

	List<Bouquet> bouquets = (List<Bouquet>) session.getAttribute("bouquets");
	BouquetSort bouquetSort = new BouquetSort();
	bouquetSort.sort(bouquets, new FreshnessComparator());

	session.setAttribute("bouquets", bouquets);
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
