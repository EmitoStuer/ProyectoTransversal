package proyectotransversal.AccesoDatos;
import java.sql.*;
import javax.swing.JOptionPane;
public class Conexion {
    private static final String URL="jdbc:mariadb://localhost:3306/proyectoTransversal";
    private static final String USER="root";
    private static final String PWD="";
    private static Conexion conexion=null;
    
    private Conexion(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error carga de driver: "+ e.getMessage());
        }
    }
    
    public static Connection getConexion(){
        Connection con=null;
        if(conexion == null){
           conexion= new Conexion();
        }
        try{
            // Setup the connection with the DB
            con=DriverManager.getConnection(URL,USER,PWD);
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion "+ex.getMessage());
        }
        
        return con;
    }
}
