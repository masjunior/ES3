/**
 * 
 */
package br.edu.fatec.Baby_Clothes.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author marco
 *
 */
public class Conexao {
public static Connection getConnection(){
		
		try {
			String servidor = "localhost";
			String banco = "site_roupa";
			String usuario = "ES3";
			String senha = "root";
			
			Class.forName("com.mysql.jdbc.Driver");
			String path ="jdbc:mysql://"+servidor+ ":3306/"+banco;
			
			return 
				DriverManager.getConnection(path,
						usuario,senha);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		
	}
	
	
	public static void fechar(Connection conn){
		if(conn !=null){
			try {
				conn.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				
			}
		}
	}

}
