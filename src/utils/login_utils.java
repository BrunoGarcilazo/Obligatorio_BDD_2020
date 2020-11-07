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
import utils.BCrypt;
import java.sql.Statement;
import javax.swing.JFrame;
import obligatorio_bdd_2020.Database;
import obligatorio_bdd_2020.app_select_screen;


/**
 * 
 * @author bruno
 */
public class login_utils {
    /**
     * Esta horriblemente hecho. Es para probar.
     * 
     * @param btn1 user
     * @param btn2 password
     * @return 
     * @throws java.sql.SQLException 
     */
//    public boolean login_attempt(String btn1,String btn2) throws SQLException{
//        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.56.102:5432/tests", "postgres", "bruno123")){ 
//            
//            String query = "SELECT * FROM usuario";
//            PreparedStatement statement = connection.prepareStatement(query);           
//            ResultSet rs = statement.executeQuery(); 
//            
//            
//            while(rs.next()){
//                if(rs.getString("alias").compareTo(btn1)==0 && BCrypt.checkpw(btn2,rs.getString("password"))){
//                    System.out.println("Datos correctos");
//                    app_select_screen after_login = new app_select_screen(btn1);
//                    after_login.setVisible(true);
//                    return true;
//                }
//            }
//        }         
//        catch (SQLException e) {
//            System.out.println("Connection failure.");
//            return false;
//        } 
//        return false;
//    }
    
    public boolean login_attempt(String username,String password,Database db) throws SQLException{
        Connection conn = db.getConnection();
        if(!conn.isClosed()){
            String query = "SELECT * FROM usuario";
            PreparedStatement statement = conn.prepareStatement(query);           
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                if(rs.getString("alias").compareTo(username)==0 && BCrypt.checkpw(password,rs.getString("password"))){
                    System.out.println("Datos correctos");                    
                    return true;
                }
            }
        }
        return false;
        
    }
}
