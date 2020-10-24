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
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usuario");
            System.out.println("Comprobando datos ingresados");
            boolean success = false;
            String[] data = new String[4];
            //new user_info_screen().setVisible(true);
            while (resultSet.next()){
                System.out.println("-------");
                System.out.println(resultSet.getString("alias"));
                System.out.println(btn1);
                System.out.println(resultSet.getString("password"));
                System.out.println(btn2);
                
                if(btn1.compareTo(resultSet.getString("alias"))==0 && btn2.compareTo(resultSet.getString("password"))==0){
                    success = true;         
//                    data[0]=resultSet.getString("alias");
//                    data[1]=resultSet.getString("password");
//                    data[2]=resultSet.getString("ci");
//                    data[3]=resultSet.getString("estado");
                    
                    if(success){
                        main_user_screen user = new main_user_screen();
                        user.setVisible(true);
                        return true;
                    }                                   
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
