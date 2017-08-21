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
import model.entity.Item;
import model.entity.boquet.exception.IncompleteBouquetInitialization;

@WebServlet("/ProductList")
public class ProductListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BouquetDao dao = new BouquetDaoUsingMySqlJdbc();
	List<Item> items = new ArrayList<>();
	try {
	    items.addAll(dao.getAll());
	} catch (StorageSystemException e) {
	    e.printStackTrace();
	} catch (IncompleteBouquetInitialization e) {
	    e.printStackTrace();
	}

	HttpSession session = request.getSession();
	session.setAttribute("items", items);

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
