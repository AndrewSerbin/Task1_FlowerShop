package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	List<Bouquet> items = new ArrayList<>();
	try {
	    items = dao.getAll();
	} catch (StorageSystemException e) {
	    e.printStackTrace();
	} catch (IncompleteBouquetInitialization e) {
	    e.printStackTrace();
	}

	PrintWriter out = response.getWriter();
	for (Bouquet bouquet : items) {
	    out.println(bouquet);
	}
	out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
    }

}
