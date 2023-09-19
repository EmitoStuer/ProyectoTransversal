
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
import proyectotransversal.Entidades.Alumno;
import proyectotransversal.Entidades.Inscripcion;
import proyectotransversal.Entidades.Materia;

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
            }else{
                 JOptionPane.showMessageDialog(null,"InscripcionData: Error al obtener el ID");
            }
           ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"InscripcionData: Error al guardar Inscripcion"+ ex.getMessage());
        }
    }
    
    public List<Inscripcion> obtenerInscripciones(){
        List<Inscripcion> lista= new ArrayList();
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
            lista.add(ins);  
        }
        ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"InscripcionData: Error al obtener inscripciones"+ex.getMessage());
        }
        return lista;
    }
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int Id){
        List<Inscripcion> lista=new ArrayList();
        Inscripcion insc;
        ad=new AlumnoData();
        md=new MateriaData();
        PreparedStatement ps;
        try
        {
            String sql="select * from inscripcion insc join alumno al on(insc.idAlumno=al.idAlumno) where al.idAlumno=?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,Id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                insc=new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                insc.setNota(rs.getInt("nota"));
                insc.setAlumno(ad.buscarAlumno(rs.getInt("idAlumno")));
                insc.setMateria(md.buscarMateria(rs.getInt("idMateria")));
                lista.add(insc);
            }
            ps.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"InscripcionData: Error al obtener inscripcion "+e.getMessage());
        }
        
        return lista;
    }
    
    public List<Materia> obtenerMateriasCursada(int id){
        List<Materia> lmd=new ArrayList();
        Materia m;
        
        PreparedStatement ps;
        
        try
        {
            String sql="SELECT * FROM materia m JOIN inscripcion insc on(m.idMateria=insc.idMateria) WHERE insc.idAlumno=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                m=new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAño(rs.getInt("año"));
                m.setEstado(rs.getBoolean("estado"));
                lmd.add(m);
            }
            ps.close();
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"InscripcionData: Error al obtener materia "+e.getMessage());
        }
        return lmd;
    }
    
    public List<Materia> obtenerMateriasNoCursadas(int id){
        List<Materia> lista= new ArrayList();
        Materia m;
        PreparedStatement ps;
        String sql = "SELECT * FROM Materia m WHERE m.idMateria NOT IN (SELECT i.idMateria FROM Inscripcion i WHERE i.idAlumno = ?)";
        try
        {
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                    
                    
                        m = new Materia();
                        m.setIdMateria(rs.getInt("idMateria"));
                        m.setNombre(rs.getString("nombre"));
                        m.setAño(rs.getInt("año"));
                        m.setEstado(rs.getBoolean("estado"));
                        
                        lista.add(m);
                    
                        }
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"InscripcionData: Error al obtener materias no cursadas "+ex.getMessage());
        }
        
        return lista;
    }
    
    public void borrarInscripcion(int idAlumno, int idMateria){
    String sql= "DELETE FROM inscripcion WHERE idAlumno=? AND idMateria=?";
    PreparedStatement ps;
        try {
            ps= con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int rs = ps.executeUpdate();
           if(rs==1){
                JOptionPane.showMessageDialog(null,"InscripcionData: Inscripción eliminada");
           }else{
                JOptionPane.showMessageDialog(null,"InscripcionData: No se encontró Inscripción");
           }
           ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"InscripcionData: Error al borrar inscripción"+ex.getMessage());
        }
    }
    
    public void actualizarNota(int idAlumno, int idMateria, double nota){
    String sql="UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?";
    
    PreparedStatement ps;
        try {
            ps= con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int rs= ps.executeUpdate();
            if(rs==1){
               JOptionPane.showMessageDialog(null,"InscripcionData: Nota actualizada");
            }else{
               JOptionPane.showMessageDialog(null,"InscripcionData: No se encontró inscripción para modificar");
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"InscripcionData: Error al actualizar nota"+ex.getMessage());
        }
    }
    
    public List<Alumno> obtenerAlumnosPorMateria(int idMateria){
    List <Alumno> lista = new ArrayList();
    PreparedStatement ps;
    Alumno a=null;
    String sql="SELECT * FROM alumno a JOIN inscripcion ins ON(a.idAlumno=ins.idAlumno) WHERE idMateria=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                a= new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));
                lista.add(a);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"InscripcionData: Error al obtener alumnos por materia"+ex.getMessage());
        }
    return lista;
    }
}
