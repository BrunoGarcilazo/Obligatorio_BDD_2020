/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio_bdd_2020;

import java.sql.Connection;

/**
 *
 * @author bruno
 */
public class Database {
    
    private final Connection connection_db = null;
    
    public Database(){
        if(this.connection_db == null){
            database_login_page db = new database_login_page();
            
        }
    }
    
}
