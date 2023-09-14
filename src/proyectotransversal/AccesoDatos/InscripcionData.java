
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
            System.out.println("Extraccion exitosa!!");
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
            System.out.println("Extraccion Exitosa");
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"InscripcionData: Error al obtener materia "+e.getMessage());
        }
        return lmd;
    }
    
    public List<Materia> obtenerMateriasNoCursadas(int id){
        List<Materia> lisM= new ArrayList();
        Materia m;
        PreparedStatement ps;
        String sql="SELECT * FROM materia m JOIN inscripcion i ON(m.idMateria=i.idMateria) WHERE i.idAlumno=? AND m.idMateria != i.idMateria";
        try
        {
            ps=con.prepareStatement(sql);
        } catch (SQLException ex)
        {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lisM;
    }
    
}
