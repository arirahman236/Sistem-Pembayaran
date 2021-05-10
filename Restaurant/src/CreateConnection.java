import com.mysql.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Fahri
 */
public class CreateConnection {
    String host;
    String user;
    String pass;
    String dbname;
    
    Connection conn;
    
    public CreateConnection(){
        this.dbname = "kasir_restaurant";
        this.host = "jdbc:mysql://localhost:3306/" +this.dbname;
        this.user = "root";
        this.pass = "";
        
        this.MakeConnection();
    }
    private void MakeConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            this.conn = DriverManager.getConnection(this.host, this.user, this.pass);
            
        }
        catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Connection Not Found!");
            System.exit(0);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Connection Failed!");
            System.exit(0);
        }
        
    }
    public Connection getConnection(){
        return this.conn;
    }
}
