/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio_bdd_2020;

import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author bruno
 */
public class Obligatorio_BDD_2020{
    
    private Connection connection_db = null;
    
    
    public Obligatorio_BDD_2020(){
        
    }
    

    
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException{       
        Database database = new Database();
    }

    
}
