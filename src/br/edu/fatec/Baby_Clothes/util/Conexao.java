/**
 * 
 */
package br.edu.fatec.Baby_Clothes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author marco
 *
 */
public class Conexao {
	
	public static Connection getConnection(){
		
		try {
			String servidor = "localhost:3306";
			String banco = "site_roupa";
			String usuario = "ES3";
			String senha = "YES";
			String drive = "com.mysql.jdbc.Driver";
			String drive2 = "com.mysql.cj.jdbc.Driver";
			
			String url = "jdbc:mysql://"+servidor+"/"+banco+"?serverTimezone=UTC";
			Class.forName(drive2);
					   
			return  DriverManager.getConnection(url,usuario,senha); 

			
		} catch (SQLException erroSQL) {  
            System.out.println("Erro na conexão com o Banco "+erroSQL.getMessage());  
            return null;
        } catch (ClassNotFoundException erroClass){  
            System.out.println("Erro ao carregar o Driver "+erroClass.getMessage());
            return null;
        } catch (Exception e) {
			System.err.println("DRIVE não carregado " + e.getMessage());
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
