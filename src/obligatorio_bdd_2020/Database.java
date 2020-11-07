/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio_bdd_2020;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.login_utils;
import utils.queries;
import utils.register_utils;

/**
 *
 * @author bruno
 */
public class Database {
    
    private Connection connection_db = null;
    private queries querie = new queries();
    private login_utils login = new login_utils();
    private register_utils register = new register_utils();
    
    public Database(){
        if(this.connection_db == null){
            database_login_page db = new database_login_page(connection_db,this);  
            db.setVisible(true);
        }
    }
    
    public Connection getConnection(){
        return this.connection_db;
    }
    
    public boolean conectarse(String url,String user,String password) throws SQLException{
        if(this.connection_db == null){
            if(conectarseDB(url,user,password)){
                return true;
            }else{
                return false;
            }
            
        }else{
            return false;
        }
    }
    
    private boolean conectarseDB(String url, String user, String password) throws SQLException{
        try(Connection con = DriverManager.getConnection(url, user, password)){
            this.connection_db = con;
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean login(String username,String password) throws SQLException{
        boolean intento = this.login.login_attempt(username, password, this);
        return intento;
    }
    
}
