

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import catalogos.CatalogoExemplar;

/**
 * Servlet implementation class ConsultaExemplarServlet
 */
@WebServlet("/consulta_exemplar")
public class ConsultaExemplarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaExemplarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			boolean b = CatalogoExemplar.getInstance().verificaDisponibilidade(request.getParameter("isbn"), Integer.parseInt(request.getParameter("qtd")));
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println("{ \"disponibilidade\": " + b + "}");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			response.sendError(500, e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
