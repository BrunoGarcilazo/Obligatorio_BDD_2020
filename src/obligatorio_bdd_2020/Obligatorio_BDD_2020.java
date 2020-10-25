/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio_bdd_2020;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author bruno
 */
public class Obligatorio_BDD_2020{
    
    public static login_utils login = new login_utils();
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException{
        
        new main_screen().setVisible(true);
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.56.102:5432/tests", "postgres", "bruno123")){
            System.out.println("Successful connection");
        }catch (SQLException e){
            System.out.println("Connection failure.");           
        }                 
    }

    
}
