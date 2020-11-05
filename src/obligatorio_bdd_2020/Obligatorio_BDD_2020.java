/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio_bdd_2020;

import utils.login_utils;
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
    
    private Connection connection_db = null;
    
    
    public Obligatorio_BDD_2020(){
        
    }
    
    public static login_utils login = new login_utils();

    
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException{        
        Database database = new Database();
    }

    
}
