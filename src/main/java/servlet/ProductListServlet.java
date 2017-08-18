package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BouquetDao;
import dao.exception.StorageSystemException;
import dao.mysql.BouquetDaoUsingMySqlJdbc;
import model.entity.boquet.Bouquet;
import model.entity.boquet.exception.IncompleteBouquetInitialization;

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BouquetDao dao = new BouquetDaoUsingMySqlJdbc();
	List<Bouquet> bouquets = new ArrayList<>();
	try {
	    bouquets = dao.getAll();
	} catch (StorageSystemException e) {
	    e.printStackTrace();
	} catch (IncompleteBouquetInitialization e) {
	    e.printStackTrace();
	}

	HttpSession session = request.getSession();
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
