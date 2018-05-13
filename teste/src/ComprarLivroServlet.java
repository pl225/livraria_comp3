

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd_connection.ConexaoBanco;
import catalogos.CatalogoEstoque;
import efetuar_venda.FormaPagamento;
import efetuar_venda.LivroIndisponivelException;
import efetuar_venda.RegistroCompraLivro;
import meu_pacote.Cliente.ClienteNaoEncontradoException;
import meu_pacote.Livro.LivroNaoEncontradoException;
import validation.Validador;
import validation.ValidarCompraLivros;

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
		
		Validador validador = new ValidarCompraLivros();
		validador.make(request.getParameterMap());
		
		if (validador.fails()) {
			request.setAttribute("erros", validador.erros());
			doGet(request, response);
		} else {
		
			int formaPagamento = Integer.parseInt(request.getParameter("forma_pagamento"));
			
			try {
			
				RegistroCompraLivro registroCompra = null;
				
				if (formaPagamento == FormaPagamento.ModoPagamento.DINHEIRO.ordinal()) {
					registroCompra = new RegistroCompraLivro(request.getParameter("qtdExemplar"), 
							request.getParameter("quantiaPaga"), request.getParameter("isbn"));
				} else if (formaPagamento == FormaPagamento.ModoPagamento.CREDITO.ordinal()) {
					registroCompra = new RegistroCompraLivro(request.getParameter("qtdExemplar"),
							request.getParameter("isbn"),  request.getParameter("bandeira"), request.getParameter("numCartao"), 
							request.getParameter("numParcelasCd"), request.getParameter("codSeguranca"));
				} else if (formaPagamento == FormaPagamento.ModoPagamento.CHEQUE.ordinal())  {
					registroCompra = new RegistroCompraLivro(request.getParameter("qtdExemplar"),
							request.getParameter("isbn"),  request.getParameter("codigoBanco"), request.getParameter("numeroAgencia"), 
							request.getParameter("digitoAgencia"), request.getParameter("numConta"), request.getParameter("numeroCheque"),
							request.getParameter("numParcelasCheque"), request.getParameter("dataDebito"), request.getParameter("cpf"));
				}
				
				CatalogoEstoque.getInstance().registrarCompra(registroCompra);
				
				request.setAttribute("sucesso", "Compra realizada com sucesso.");
				request.getRequestDispatcher("/consultar_livro.jsp").forward(request, response);
			
			} catch (LivroIndisponivelException e) {
				request.setAttribute("erro", "Infelizmente esse livro se encontra indisponível.");
				request.getRequestDispatcher("/consultar_livro.jsp").forward(request, response);
			} catch (SQLException | ParseException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				response.sendError(500, e.getMessage());
			} catch (LivroNaoEncontradoException | ClienteNaoEncontradoException e) {
				response.sendError(404, e.getMessage());
			}
			
		}
	}
}