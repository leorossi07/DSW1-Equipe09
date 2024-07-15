package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Empresa;
import br.ufscar.dc.dsw.domain.Vaga;
import br.ufscar.dc.dsw.domain.Usuario;

public class VagaDAO extends GenericDAO {
	
	public void insert(Vaga vaga) {
		
		String sql = "INSERT INTO Vaga (empresa_id, titulo, remuneracao, dataLimiteInscricao) VALUES (?, ?, ?, ?)";
		
		try {
			Connection conn = this.getConnection();
			PreparedStatement sttmt = conn.prepareStatement(sql);
			
			sttmt = conn.prepareStatement(sql);
			
			sttmt.setLong(1, vaga.getEmpresa().getId());
			sttmt.setString(2, vaga.getTitulo());
			sttmt.setFloat(3, vaga.getRemuneracao());
			sttmt.setString(4, vaga.getDataLimiteInscricao());
			sttmt.executeUpdate();
			
			sttmt.close();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Lista todas vagas por empresa
	public List<Vaga> getAll(){
		
		List<Vaga> listaVagas = new ArrayList<>();
		
		// None of these parameters are set at runtime, so it is ok to use createStatement
		String sql = "SELECT * FROM Vaga v, Empresa e where v.EMPRESA_ID = e.ID order by v.id";
		
		try {
			Connection conn = this.getConnection();
			Statement sttmt = conn.createStatement();
			
			ResultSet resultSet = sttmt.executeQuery(sql);
			
			while(resultSet.next()) {
				Long id = resultSet.getLong("id");
				String titulo = resultSet.getString("titulo");
				Float remuneracao = resultSet.getFloat("remuneracao");
				Long empresa_id = resultSet.getLong(4);
				String dataLimiteInscricao = resultSet.getString("dataLimiteInscricao");
				String cnpj = resultSet.getString("cnpj");
				String nome = resultSet.getString("nome");
				String descricao = resultSet.getString("descricao");
				String cidade = resultSet.getString("cidade");
				Long empresa_usuario_id = resultSet.getLong(11);
				Usuario empresa_usuario = new UsuarioDAO().get(empresa_usuario_id);// implementar
				Empresa empresa = new Empresa(empresa_id, cnpj, nome, descricao, cidade, empresa_usuario);
				Vaga vaga = new Vaga(id, titulo, remuneracao, empresa, dataLimiteInscricao);
				listaVagas.add(vaga);
				
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return listaVagas;
	}
	
	public void delete(Vaga vaga) {
		String sql = "DELETE FROM Vaga where id = ?";
		
		try {
			
			Connection conn = this.getConnection();
			PreparedStatement sttmt = conn.prepareStatement(sql);
			
			sttmt.setLong(1, vaga.getId());
			sttmt.executeUpdate();
			
			sttmt.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Vaga vaga) {
		
		String sql = "UPDATE Vaga SET titulo = ?, remuneracao = ?, dataLimiteInscricao = ?";
		sql += ", empresa_id = ?, WHERE id = ?";
		
		try {
			
			Connection conn = this.getConnection();
			PreparedStatement sttmt = conn.prepareStatement(sql);
			
			sttmt.setString(1, vaga.getTitulo());
			sttmt.setFloat(2, vaga.getRemuneracao());
			sttmt.setString(3, vaga.getDataLimiteInscricao());
			sttmt.setLong(4, vaga.getEmpresa().getId());
			sttmt.setLong(5, vaga.getId());
			sttmt.executeUpdate();
			
			sttmt.close();
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	
	public Vaga get(Long id) {
		Vaga vaga = null;
		
		String sql = "SELECT * FROM Vaga v, Empresa e where v.id = ? and v.EMPRESA_ID = e.ID";
		
		try {
			
			Connection conn = this.getConnection();
			PreparedStatement sttmt = conn.prepareStatement(sql);
			
			sttmt.setLong(1, id);
			ResultSet resultSet = sttmt.executeQuery();
			
			if(resultSet.next()) {
				String titulo = resultSet.getString("titulo");
				Float remuneracao = resultSet.getFloat("remuneracao");
				Long empresa_id = resultSet.getLong("empresa_id");
				String dataLimiteInscricao = resultSet.getString("dataLimiteInscricao");
				
				
				Empresa empresa = new EmpresaDAO().get(empresa_id);
				
				vaga = new Vaga(id, titulo, remuneracao, empresa, dataLimiteInscricao);
				
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return vaga;
	}
	
	
    public int countByEmpresa(Long id) {
        int contador = 0;
        
        String sql = "SELECT count(*) from Vaga v where v.EMPRESA_ID = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                contador = resultSet.getInt(1);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contador;
    }
	
}