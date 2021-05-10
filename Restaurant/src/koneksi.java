
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fahri
 */
public class koneksi {
    
    public static Connection connect;
    
    public static Connection GetConnection()throws SQLException{
        if(connect==null){
            new Driver();
            
            connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/kasir_restaurant","root","");
        }
        return connect;
    }
    
}
