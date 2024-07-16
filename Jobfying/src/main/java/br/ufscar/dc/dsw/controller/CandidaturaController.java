package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.CandidaturaDAO;
import br.ufscar.dc.dsw.dao.VagaDAO;
import br.ufscar.dc.dsw.domain.Candidatura;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.domain.Vaga;
import br.ufscar.dc.dsw.domain.Usuario;

import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns= "/candidaturas/*")

public class CandidaturaController extends HttpServlet{
	
    private static final long serialVersionUID = 1L;	
    
    private CandidaturaDAO dao;
    
    @Override
    public void init() {
    	dao = new CandidaturaDAO();
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
    	}else if(!usuario.getPapel().equals("PROFISSIONAL")) {
    		erros.add("Acesso não autorizado");
    		erros.add("Apenas papel [PROFISSIONAL] tem acesso a essa página");
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
    		switch(action){
    			case "/cadastro":
    				apresentaFormCadastro(request, response);
    				break;
    			case "/insercao":
    				insere(request, response);
    				break;
    			default:
    				lista(request, response);
    				break;
    		}
    	} catch(RuntimeException | IOException | ServletException e) {
    		throw new ServletException(e);
    	}
    }
    
    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Profissional profissional = (Profissional) request.getSession().getAttribute("profissionalLogado");
    	List<Candidatura> listaCandidaturas = dao.getAllByProfissional(profissional);
    	request.setAttribute("listaCandidaturas", listaCandidaturas);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/candidatura/lista.jsp");
    	dispatcher.forward(request, response);
    }
    
    private Map<Long, Vaga> getVagas(){
    	Map<Long, Vaga> vagas = new HashMap<>();
    	for(Vaga vaga: new VagaDAO().getAll()) {
    		vagas.put(vaga.getId(), vaga);
    	}
    	return vagas;
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	request.setAttribute("vagas", getVagas());
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/candidatura/formulario.jsp");
    	dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	request.setCharacterEncoding("UTF-8");
    	
    	Long id = Long.parseLong(request.getParameter("vaga"));
    	
    	Vaga vaga = new VagaDAO().get(id);
    	
    	String status = "ABERTO";
    	
    	Profissional profissional = (Profissional) request.getSession().getAttribute("profissionalLogado");
    	
    	String data = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
    	Candidatura candidatura = new Candidatura(data, status, vaga, profissional);
    	dao.insert(candidatura);
    	
    	response.sendRedirect("lista");
    	
    	
    }
       
}
