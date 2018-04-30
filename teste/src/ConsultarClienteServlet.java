

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import catalogos.CatalogoCliente;
import meu_pacote.Cliente;
import meu_pacote.Cliente.ClienteNaoEncontradoException;

/**
 * Servlet implementation class ConsultarClienteServlet
 */
@WebServlet("/consultar_cliente")
public class ConsultarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Cliente c = CatalogoCliente.getInstance().getCliente(request.getParameter("cpf"));
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println(c.toJSON());
		} catch (ClienteNaoEncontradoException e) {
			response.sendError(404, e.getMessage());
		} catch (SQLException e) {
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
