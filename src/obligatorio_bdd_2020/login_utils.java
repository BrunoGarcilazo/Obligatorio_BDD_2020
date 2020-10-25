/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio_bdd_2020;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.BCrypt;
import java.sql.Statement;
import javax.swing.JFrame;

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
    public boolean login_attempt(String btn1,String btn2) throws SQLException{
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.56.102:5432/tests", "postgres", "bruno123")){ 
            String query = "SELECT * FROM usuario WHERE alias = ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, btn1);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                if(rs.getString("alias").compareTo(btn1)==0 && BCrypt.checkpw(btn2,rs.getString("password"))){
                    return true;
                }
            }
        }         
        catch (SQLException e) {
            System.out.println("Connection failure.");
            return false;
        } 
        return false;
    }   
}
