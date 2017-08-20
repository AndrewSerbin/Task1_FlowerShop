package servlet;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.util.bundle.BundleFactory;
import servlet.util.bundle.EnBundle;
import servlet.util.bundle.RuBundle;

@WebServlet("/Language")
public class LanguageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BundleFactory bundleFactory = getBundle(request, response);
	ResourceBundle bundle = bundleFactory.makeBundle();

	HttpSession session = request.getSession();
	session.setAttribute("bundle", bundle);
	redirect(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	this.getServletContext().getRequestDispatcher("/ProductList").forward(request, response);
    }

    private BundleFactory getBundle(HttpServletRequest request, HttpServletResponse response) {
	switch (request.getParameter("language")) {
	case "en":
	    return new EnBundle();

	case "ru":
	    return new RuBundle();

	default:
	    throw new RuntimeException("Unsupported language");
	}
    }
}
