package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.ProfissionalDAO;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/profissionais/*")
public class ProfissionalController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private ProfissionalDAO dao;
	
	@Override
	public void init() {
		dao = new ProfissionalDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		Erro erros = new Erro();

		if (usuario == null) {
			response.sendRedirect(request.getContextPath());
			return;
		} else if (!usuario.getPapel().equals("PROFISSIONAL")) {
			erros.add("Acesso não autorizado!");
			erros.add("Apenas Papel [PROFISSIONAL] tem acesso a essa página");
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
			return;
		}
		
		String action = request.getPathInfo();
		if (action == null) {
			action = "";
		}

		try {
			switch (action) {
			case "/cadastro":
				apresentaFormCadastro(request, response);
				break;
			case "/insercao":
				insere(request, response);
				break;
			case "/edicao":
				apresentaFormEdicao(request, response);
				break;
			case "/remocao":
				remove(request, response);
				break;
			case "/atualizacao":
				atualize(request, response);
				break;
			default:
				lista(request, response);
				break;
			}
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}
	
	private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Profissional> listaProfissionais = dao.getAll();
		request.setAttribute("listaProfissionais", listaProfissionais);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/profissional/lista.jsp");
		dispatcher.forward(request, response);
	}
	
	private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/profissional/formulario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");

		Profissional profissional = new Profissional(nome, cpf);

		dao.insert(profissional);
		response.sendRedirect("lista");
	}
	
	private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Profissional profissional = dao.get(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/profissional/formulario.jsp");
		request.setAttribute("profissional", profissional);
		dispatcher.forward(request, response);
	}
	
	private void atualize(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");

		Profissional profissional = new Profissional(id, nome, cpf);

		dao.update(profissional);
		response.sendRedirect("lista");
	}
	
	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));

		Profissional profissional = new Profissional(id);
		dao.delete(profissional);
		response.sendRedirect("lista");
	}
	
	
	
}
