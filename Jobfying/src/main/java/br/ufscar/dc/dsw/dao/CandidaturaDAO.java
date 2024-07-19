package br.ufscar.dc.dsw.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.ufscar.dc.dsw.domain.Candidatura;
import br.ufscar.dc.dsw.domain.Vaga;
import br.ufscar.dc.dsw.domain.Profissional;

public class CandidaturaDAO extends GenericDAO {
	
	// Inserir Candidatura no Banco de Dados
	public void insert(Candidatura candidatura) {
		
		String sql = "INSERT INTO Candidatura (data, status, vaga_id, profissional_id) VALUES (?, ?, ?, ?)";
		
		try {
			
			Connection conn = this.getConnection();
			
			PreparedStatement sttmt = conn.prepareStatement(sql);
			
			sttmt = conn.prepareStatement(sql);
			sttmt.setString(1, candidatura.getData());
			sttmt.setString(2, candidatura.getStatus());
			sttmt.setLong(3, candidatura.getVaga().getId());
			sttmt.setLong(4, candidatura.getProfissional().getId());
			sttmt.executeUpdate();
			
			sttmt.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Listar as Candidaturas de acordo com o profissional
	public List<Candidatura> getAllByProfissional(Profissional profissional){
		
		List<Candidatura> listaCandidaturas = new ArrayList<>();
		
		// warning: this case we are using ? -> so, prepareStatement?? doubts
		String sql = "SELECT * from Candidatura c where c.PROFISSIONAL_ID = ? order by c.ID";
		
		try {
			
			Connection conn = this.getConnection();
			PreparedStatement sttmt = conn.prepareStatement(sql);
			
			sttmt.setLong(1, profissional.getId());
			ResultSet resultSet = sttmt.executeQuery();
			
			while(resultSet.next()) {
				Long id = resultSet.getLong("id");
				String data = resultSet.getString("data");
				String status = resultSet.getString("status");
				Long vagaId = resultSet.getLong("vaga_id");
				
				Vaga vaga = new VagaDAO().get(vagaId);
				Candidatura candidatura = new Candidatura(id, data, status, vaga, profissional);
				listaCandidaturas.add(candidatura);
			}
			
			resultSet.close();
			sttmt.close();
			conn.close();
			
			
			
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
		
		return listaCandidaturas;
	
	
	}		
}
