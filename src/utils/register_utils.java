/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Clase usada para procesos de registro tanto de Personas como de nuevos Usuarios.
 * @author bruno
 */
public class register_utils {
    
    public static boolean new_registration(String[] data) throws SQLException, ParseException {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.56.102:5432/tests", "postgres", "bruno123")){  
            System.out.println("Successful connection");
            
//            String query = "SELECT ci FROM persona";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setInt(1,Integer.parseInt(data[0]));
//            
//            ResultSet rs = statement.executeQuery();           
//            while(rs.next()){
//                //if(rs.getInt(1) == Integer.parseInt(data[0])){
//                    System.out.println("Ya existe una Persona registrada con ese documento.");               
//                //}
//                //return false; // a Person with that ID / C.I already exists.
//            }     
            
            String register_query = "INSERT INTO PERSONA(ci,nombre,apellido,direccion,telefono,sexo,fecha_nac) VALUES(?,?,?,?,?,?,?);";
            PreparedStatement register_statement = connection.prepareStatement(register_query);
            register_statement.setInt(1, Integer.parseInt(data[0]));
            register_statement.setString(2, data[1]);
            register_statement.setString(3, data[2]);
            register_statement.setString(4, data[3]);
            register_statement.setInt(5, Integer.parseInt(data[4]));
            register_statement.setString(6, data[5]);            
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = null;
            try {
                date = (Date) dateFormat.parse(data[6]);
            }catch(ParseException e){
            }           
            register_statement.setDate(7,date); 
            
            int resultado = register_statement.executeUpdate();
            
                   
            String user_query = "INSERT INTO usuario(alias,ci,quienlocreo,estado,password) VALUES(?,?,?,?,?);";
            PreparedStatement user_statement = connection.prepareStatement(user_query);
            user_statement.setString(1,data[7]);
            user_statement.setInt(2,Integer.parseInt(data[0]));
            user_statement.setString(3,"none");
            user_statement.setString(4,"En Espera");
            user_statement.setString(5,BCrypt.hashpw(data[8],BCrypt.gensalt()));
            
            int user_query_result = user_statement.executeUpdate();
        }         
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Connection failure.");
            return false;
        }        
        return false;
        
    }
    

}
