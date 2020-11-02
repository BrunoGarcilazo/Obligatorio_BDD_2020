/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bruno
 */
public class queries {
    
    public static int getIdApp(String nombreApp){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.56.102:5432/tests", "postgres", "bruno123")){
            String query_2 = "SELECT idapp FROM aplicacion WHERE nombreapp=?";
            PreparedStatement statement = connection.prepareStatement(query_2);
            statement.setString(1,nombreApp);
            ResultSet rs = statement.executeQuery();       
            while(rs.next()){
                return rs.getInt("idapp");
            }            
        }catch (SQLException e){
            System.out.println("Connection failure.");           
        } 
        return -1;
    }
    
    public static int getIdMenu(String nombreMenu){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.56.102:5432/tests", "postgres", "bruno123")){
            System.out.println("Se conecto para buscar la ID del Menu");
            String query_2 = "SELECT idmenu FROM menu WHERE descripcionmenu=?";
            PreparedStatement statement = connection.prepareStatement(query_2);
            statement.setString(1,nombreMenu);
            ResultSet rs = statement.executeQuery();       
            while(rs.next()){
                return rs.getInt("idmenu");
            }            
        }catch (SQLException e){
            System.out.println("Connection failure.");           
        } 
        return -1;
    }
    
   public static String getDescMenu(int idMenu){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.56.102:5432/tests", "postgres", "bruno123")){
            System.out.println("Se conecto para buscar la Descripcion del Menu");
            String query_desc = "SELECT descripcionmenu FROM menu WHERE idmenu=?";
            PreparedStatement statement = connection.prepareStatement(query_desc);
            statement.setInt(1,idMenu);
            ResultSet rs = statement.executeQuery();       
            while(rs.next()){
                return rs.getString("descripcionmenu");
            }            
        }catch (SQLException e){
            System.out.println("Connection failure.");           
        } 
        return "N/A";  
   }
   
   public static String getNombreRol(int idrol){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.56.102:5432/tests", "postgres", "bruno123")){
            System.out.println("Se conecto para buscar la Descripcion del Menu");
            String query_desc = "SELECT nombrerol FROM rol WHERE idrol=?";
            PreparedStatement statement = connection.prepareStatement(query_desc);
            statement.setInt(1,idrol);
            ResultSet rs = statement.executeQuery();       
            while(rs.next()){
                return rs.getString("nombrerol");
            }            
        }catch (SQLException e){
            System.out.println("Connection failure.");           
        }
        return "N/A";
   }
    
}
