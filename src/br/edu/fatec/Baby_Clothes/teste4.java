package br.edu.fatec.Baby_Clothes;
import java.sql.*;

public class teste4
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/site_roupa";
        String usuario = "ES3";
		String senha = "root";

        try
        {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("\nDriver carregado com sucesso!\n");
         try
         {
                 Connection conn = DriverManager.getConnection(url, usuario, senha);
                 try
                 {
                 String sql = "SELECT * FROM usuario";
                 	
                    Statement stm = conn.createStatement();
                    try
                    {
                     ResultSet rs = stm.executeQuery(sql);
                  while (rs.next())
                  {
                     int id = rs.getInt("usu_id");
                	 String nome = rs.getString("usu_nome");
                     String cpf = rs.getString("usu_cpf");
                     String email = rs.getString("usu_email");
                     String tipoUsuario = rs.getString("usu_tipo_usuario");
                     System.out.println("id: " + id + "\nNome: " + nome + "\nCPF: " + cpf + "\nE-mail: " + email + "\nTipo Usuario: " + tipoUsuario);
                     System.out.println("---------------------------------------");
                  }
                  System.out.println("\nConsulta realizada com sucesso!!!\n");                    
                    }
               catch (Exception ex)
               {
                  System.out.println("\nErro no resultset!");
               }
                 }
                  catch (Exception ex)
            {
               System.out.println("\nErro no statement!");
            }
         }
         catch (Exception ex)
         {
            System.out.println("\nErro no connection!");
         }  
        }
        catch (Exception ex)
        {
            System.out.println("\nDriver nao pode ser carregado!");
        }
    }
}