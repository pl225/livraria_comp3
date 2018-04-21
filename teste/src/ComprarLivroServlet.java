

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd_connection.ConexaoBanco;
import efetuar_venda.EstoqueLivro;
import efetuar_venda.FormaPagamento;
import efetuar_venda.LivroIndisponivelException;
import efetuar_venda.RegistroCompraLivro;
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
		try {
			request.setAttribute("livro", ConexaoBanco.consultarLivro(request.getParameter("isbn")));
			request.setAttribute("bandeiras", ConexaoBanco.consultarBandeiras());
			request.getRequestDispatcher("/comprar_livro.jsp").forward(request, response);
		} catch (LivroNaoEncontradoException e) {
			response.sendError(404, e.getMessage());;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			response.sendError(500, e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("forma_pagamento") != null) {
			int formaPagamento = Integer.parseInt(request.getParameter("forma_pagamento"));
			
			try {
				RegistroCompraLivro registroCompra = null;
				
				if (formaPagamento == FormaPagamento.ModoPagamento.DINHEIRO.ordinal()) {
					 registroCompra = new RegistroCompraLivro(request.getParameter("qtdExemplar"), 
							request.getParameter("quantiaPaga"), request.getParameter("isbn"));
				}
				
				EstoqueLivro.registrarCompra(registroCompra);
				
				request.setAttribute("sucesso", "Compra realizada com sucesso.");
				request.getRequestDispatcher("/consultar_livro.jsp").forward(request, response);
			} catch (LivroIndisponivelException e) {
				request.setAttribute("erro", "Infelizmente esse livro se encontra indisponível.");
				request.getRequestDispatcher("/consultar_livro.jsp").forward(request, response);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				response.sendError(500, e.getMessage());
			} catch (LivroNaoEncontradoException e) {
				response.sendError(404, e.getMessage());
			}
		}
	}

}
