package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Empresa;
import br.ufscar.dc.dsw.domain.Usuario;

public class EmpresaDAO extends GenericDAO{
	
	public void insert(Empresa empresa) {
		String sql = "INSERT INTO Empresa (cnpj, nome, descricao, cidade, usuario_id) VALUES (?, ?, ?, ?, ?)";
		
		try {
			Connection conn = this.getConnection();
			PreparedStatement sttmt = conn.prepareStatement(sql);
			
			sttmt = conn.prepareStatement(sql);
			
			sttmt.setString(1, empresa.getCnpj());
			sttmt.setString(2, empresa.getNome());
			sttmt.setString(3, empresa.getDescricao());
			sttmt.setString(4, empresa.getCidade());
			sttmt.setLong(5, empresa.getUsuario().getId());
			sttmt.executeUpdate();
			
			sttmt.close();
			conn.close();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Empresa> getAll(){
		
		List<Empresa> listaEmpresas = new ArrayList<>();
		
		String sql = "SELECT * FROM Empresa";
		
		try {
			
			Connection conn = this.getConnection();
			// Static Statement
			Statement sttmt = conn.createStatement();
			
			ResultSet rs = sttmt.executeQuery(sql);
			
			while(rs.next()) {
				Long id = rs.getLong("id");
				String cnpj = rs.getString("cnpj");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				String cidade = rs.getString("cidade");
				Long usuario_id = rs.getLong(6);
				Usuario usuario = new UsuarioDAO().get(usuario_id);
				Empresa empresa = new Empresa(id, cnpj, nome, descricao, cidade, usuario);
				listaEmpresas.add(empresa);
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return listaEmpresas;
	}
	
	public void delete(Empresa empresa) {
		String sql = "DELETE FROM Empresa WHERE id = ?";
		
		try {
			Connection conn = this.getConnection();
			PreparedStatement sttmt = conn.prepareStatement(sql);
			
			sttmt.setLong(1, empresa.getId());
			sttmt.executeUpdate();
			
			sttmt.close();
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Empresa empresa) {
		
		String sql = "UPDATE Empresa SET cnpj = ?, nome = ?, descricao = ?, cidade = ?";
		sql += ", usuario_id = ? WHERE id = ?";
		
		try {
			
			Connection conn = this.getConnection();
			PreparedStatement sttmt = conn.prepareStatement(sql);
			
			sttmt.setString(1, empresa.getCnpj());
			sttmt.setString(2, empresa.getNome());
			sttmt.setString(3, empresa.getDescricao());
			sttmt.setString(4, empresa.getCidade());
			sttmt.setLong(5, empresa.getUsuario().getId());
			sttmt.setLong(6, empresa.getId());
			
			sttmt.close();
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Empresa get(Long id) {
		Empresa empresa = null;
		
		String sql = "SELECT * FROM Empresa e, Usuario u WHERE e.id = ? and e.usuario_id = u.id";
		
		try {
			
			Connection conn = this.getConnection();
			PreparedStatement sttmt = conn.prepareStatement(sql);
			
			sttmt.setLong(1, id);
			
			ResultSet rs = sttmt.executeQuery();
			
			if(rs.next()) {
				String cnpj = rs.getString("cnpj");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				String cidade = rs.getString("cidade");
				
				Long usuario_id = rs.getLong("usuario_id");
				Usuario usuario = new UsuarioDAO().get(usuario_id); 
				
				empresa = new Empresa(id, cnpj, nome, descricao, cidade, usuario);
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return empresa;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}