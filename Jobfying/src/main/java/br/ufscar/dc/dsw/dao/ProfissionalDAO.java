package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.domain.Usuario;

public class ProfissionalDAO extends GenericDAO{
	
	public void insert(Profissional profissional) {
		String sql = "INSERT INTO Profissional (nome, cpf, telefone, sexo, dataNascimento, usuario_id) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			Connection conn = this.getConnection();
			PreparedStatement sttmt = conn.prepareStatement(sql);
			
			sttmt = conn.prepareStatement(sql);
			sttmt.setString(1, profissional.getNome());
			sttmt.setString(2, profissional.getCpf());
			sttmt.setString(3, profissional.getTelefone());
			sttmt.setString(4, profissional.getSexo());
			sttmt.setString(5, profissional.getDataNascimento());
			sttmt.setLong(6, profissional.getUsuario().getId());
			
			sttmt.executeUpdate();
			
			sttmt.close();
			conn.close();
			
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Profissional> getAll(){
		List<Profissional> listaProfissionais = new ArrayList<>();
		
		String sql = "SELECT * FROM Profissional";
		
		try {
			Connection conn = this.getConnection();
			Statement sttmt = conn.createStatement();
			
			ResultSet rs = sttmt.executeQuery(sql);
			
			while(rs.next()) {
				Long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String telefone = rs.getString("telefone");
				String sexo = rs.getString("sexo");
				String dataNascimento = rs.getString("dataNascimento");
				Long usuario_id = rs.getLong(7);
				Usuario usuario = new UsuarioDAO().get(usuario_id);
				Profissional profissional = new Profissional(id, nome, cpf, telefone, sexo, dataNascimento, usuario);
				listaProfissionais.add(profissional);
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return listaProfissionais;
	}
	
	public void delete(Profissional profissional) {
		String sql = "DELETE FROM Profissional WHERE id = ?";
		
		try {
			Connection conn = this.getConnection();
			PreparedStatement sttmt = conn.prepareStatement(sql);
			
			sttmt.setLong(1, profissional.getId());
			sttmt.executeUpdate();
			
			sttmt.close();
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Profissional profissional) {
		String sql = "UPDATE Profissional SET nome = ?, cpf = ?, telefone = ?, sexo = ?, dataNascimento = ?";
		sql += ", usuario_id = ? WHERE id = ?";
		
		try {
			
			Connection conn = this.getConnection();
			PreparedStatement sttmt = conn.prepareStatement(sql);
			
			sttmt.setString(1, profissional.getNome());
			sttmt.setString(2, profissional.getCpf());
			sttmt.setString(3, profissional.getTelefone());
			sttmt.setString(4, profissional.getSexo());
			sttmt.setString(5, profissional.getDataNascimento());
			sttmt.setLong(6, profissional.getUsuario().getId());
			sttmt.setLong(7, profissional.getId());
			
			sttmt.close();
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}