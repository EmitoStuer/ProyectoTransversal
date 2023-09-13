
package proyectotransversal.AccesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectotransversal.Entidades.Inscripcion;

/**
 *
 * @author ferna
 */
public class InscripcionData {
    private Connection con=null;
    private AlumnoData ad;
    private MateriaData md;
    public InscripcionData(){
        con=Conexion.getConexion();
    }
    
    public void guardarInscripcion(Inscripcion ins){
        String sql="INSERT INTO inscripcion (nota,idAlumno,idMateria) VALUES(?,?,?)";
        
        PreparedStatement ps=null;
        
        try {
            ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1,ins.getNota());
            ps.setInt(2,ins.getAlumno().getIdAlumno());
            ps.setInt(3,ins.getMateria().getIdMateria());
            
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            
            if(rs.next()){
                ins.setIdInscripcion(rs.getInt(1));
                
               JOptionPane.showMessageDialog(null,"InscripcionData: Inscripcion guardada");
            }else {
                 JOptionPane.showMessageDialog(null,"InscripcionData: Error al obtener el ID");
            }
           ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"InscripcionData: Error al guardar Inscripcion"+ ex.getMessage());
        }
    }
    
    public List<Inscripcion> obtenerInscripciones(){
        List<Inscripcion> obtenerInscripciones= new ArrayList();
        Inscripcion ins=null;
        ad=new AlumnoData();
        md=new MateriaData();
        
        String sql="SELECT * FROM inscripcion";
        PreparedStatement ps;
        try {
            ps=con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            
            while (rs.next()){
            ins=new Inscripcion();
            ins.setIdInscripcion(rs.getInt(1));
            ins.setNota(rs.getDouble(2));
            ins.setAlumno(ad.buscarAlumno(rs.getInt(3)));
            ins.setMateria(md.buscarMateria(rs.getInt(4)));
            
          obtenerInscripciones.add(ins);
          ps.close();
        }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"InscripcionData: Error al obtener inscripciones"+ex.getMessage());
        }
        return obtenerInscripciones;
    }
    
}
