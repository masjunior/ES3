package br.edu.fatec.Baby_Clothes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import br.edu.fatec.Baby_Clothes.model.NivelAcesso;

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
                 String sql = "SELECT * FROM site_roupa.usuario";
                    Statement stm = conn.createStatement();
                    try
                    {
                     ResultSet rs = stm.executeQuery(sql);
                  while (rs.next())
                  {
                     int id = rs.getInt("usu_id");
                     String dataCriacao = rs.getString("usu_data_criacao");
                	 String habilitado = rs.getString("usu_habilitado");
                	 String email = rs.getString("usu_email");
                     String cpf = rs.getString("usu_senha");
                     String nivelAcesso = rs.getString("usu_nivel_acesso");
                     System.out.println("id: " + id + "\nCriacao: " + dataCriacao + "\nhabilitado: " + habilitado +   "\nCPF: " + cpf + "\nE-mail: " + email + "\nTipo Usuario: " + nivelAcesso);
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