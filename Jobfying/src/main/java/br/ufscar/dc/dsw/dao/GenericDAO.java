package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class GenericDAO {
    
    public GenericDAO() {
        try {
            
        	/* Setup Banco de dados Derby */
        	Class.forName("org.apache.derby.jdbc.ClientDriver");
            
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
    	
    	return DriverManager.getConnection("jdbc:derby://localhost:1527/JobfyingTest", "root", "root");
    }
}