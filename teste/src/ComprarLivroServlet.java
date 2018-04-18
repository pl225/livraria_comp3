

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meu_pacote.Livro.LivroNaoEncontradoException;

/**
 * Servlet implementation class ConsultarLivroServlet
 */
@WebServlet("/comprar_livro")
public class ComprarLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprarLivroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setAttribute("livro", ConexaoBanco.consultarLivro(request.getParameter("isbn")));
			request.getRequestDispatcher("/comprar_livro.jsp").forward(request, response);
		} catch (LivroNaoEncontradoException e) {
			// TODO Auto-generated catch block
			response.sendError(404, e.getMessage());;
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
