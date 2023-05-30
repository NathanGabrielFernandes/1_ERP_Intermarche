package br.com.erp_intermarche.dal;

import java.sql.*;

public class ModuloConexao {
	
	// Método responsavel por estabelecer a conexão com o banco
	
	public static Connection conector() {
		
		java.sql.Connection conexao = null;
		
		// A linha de baixo chama o driver
		String driver = "org.postgresql.Driver";
		
		// Armazenando informções referente ao banco
		String url = "jdbc:postgresql://localhost:5432/acesso_usuarios";
        String usuario = "postgres";
        String senha = "1234!";
			
		// Estabelecendo a conexão com o banco
        try {
			Class.forName(driver);
			
			// A linha abaixo vai receber a "String da conexão do banco de dados"
			conexao = DriverManager.getConnection(url,usuario,senha);
						
			return conexao;
			
		} catch (Exception e) {
			// A linha abaixo serve de apoio para esclarecer o erro da conexão
			
			System.out.println(e);
			
			return null;
			
		}
        
	}
	
	
	
}
