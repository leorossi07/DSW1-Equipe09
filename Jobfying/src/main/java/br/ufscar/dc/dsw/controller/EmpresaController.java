package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.EmpresaDAO;
import br.ufscar.dc.dsw.domain.Empresa;
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

@WebServlet(urlPatterns = "/empresas/*")
public class EmpresaController extends HttpServlet{
	
	private  static final long serialVersionUID = 1L;
	
	private EmpresaDAO dao;
	
	@Override
	public void init() {
		dao = new EmpresaDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		Erro erros = new Erro();
		
		if(usuario == null) {
			response.sendRedirect(request.getContextPath());
			return;
		} else if(!usuario.getPapel().equals("EMPRESA")) {
			erros.add("Acesso não autorizado!");
			erros.add("Apenas Papel [EMPRESA] tem acesso a essa página");
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
			return;
		}
		
		String action = request.getPathInfo();
		if(action == null) {
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
			case "/remocao":
				remove(request, response);
				break;
			case "/edicao":
				apresentaFormEdicao(request, response);
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
	
	private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Empresa> listaEmpresas = dao.getAll();
		request.setAttribute("listaEmpresas", listaEmpresas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/empresa/lista.jsp");
		dispatcher.forward(request, response);
	}
	
	private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/empresa/formulario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Long id = Long.parseLong(request.getParameter("id"));
		Empresa empresa = dao.get(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/empresa/formulario.jsp");
		request.setAttribute("empresa", empresa);
		dispatcher.forward(request, response);
	}
	
	private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String cnpj = request.getParameter("cnpj");
		String nome = request.getParameter("nome");

		Empresa empresa = new Empresa(cnpj, nome);

		dao.insert(empresa);
		response.sendRedirect("lista");
	}
	
	
	private void atualize(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		Long id = Long.parseLong(request.getParameter("id"));
		String cnpj = request.getParameter("cnpj");
		String nome = request.getParameter("nome");

		Empresa empresa = new Empresa(id, cnpj, nome);

		dao.update(empresa);
		response.sendRedirect("lista");
	}
	

	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));

		Empresa empresa = new Empresa(id);
		dao.delete(empresa);
		response.sendRedirect("lista");
	}
	
	
}
