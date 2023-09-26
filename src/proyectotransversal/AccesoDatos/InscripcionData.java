
package proyectotransversal.AccesoDatos;

import java.sql.*;
import java.util.*;
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
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private Inscripcion ins;
    private Inscripcion insc;
    private Materia m;
    private Alumno a;

    
    public InscripcionData(){
        con=Conexion.getConexion();
    }
    public void guardarInscripcion(Inscripcion ins){
        /*
            Este metodo guardarIncripcion recive por parametro una inscripcion de tipo
            Inscripcion sin Id para registra en la base de datos mediante una sentencia
            SQL retornando la clave generada automaticamente para luego asignarle
            asi la clave posteriomente a una instancia de tipo Inscripcion.
        */
        sql="INSERT INTO inscripcion (nota,idAlumno,idMateria) VALUES(?,?,?)";
        
        try {
            ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1,ins.getNota());
            ps.setInt(2,ins.getAlumno().getIdAlumno());
            ps.setInt(3,ins.getMateria().getIdMateria());
            
            ps.executeUpdate();
            rs= ps.getGeneratedKeys();
            
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
        /*
            Este metodo obtenerInscripciones retorna una Lista de tipo Inscripcion mediante
            una sentencia SQL la cual selecciona de la base de datos en la tabla de
            inscripcion todas las filas.
        */
        List<Inscripcion> lista= new ArrayList();        
        ad=new AlumnoData();
        md=new MateriaData();
        
        sql="SELECT * FROM inscripcion";
        try {
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            
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
        /*
            Este metodo obtenerInscripcionesPorAlumno recive un Id de un alumno para retornar
            una Lista de tipo Inscripcion mediante una sentencia SQL la cual selecciona de la
            base de datos en la tabla de inscripcion unida a la tabla alumno todas las
            inscripciones de un alumno en particular.
        */
        List<Inscripcion> lista=new ArrayList();
        ad=new AlumnoData();
        md=new MateriaData();
        try
        {
            sql="select * from inscripcion insc join alumno al on(insc.idAlumno=al.idAlumno) where al.idAlumno=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,Id);
            rs=ps.executeQuery();
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
        /*
            Este metodo obtenerMateriasCursada recive por parametro un id de un alumno para
            retornar una lista de tipo materia mediante una sentencia SQL la cual selecciona de la
            base de datos la tabla de materia unida a la tabla inscripcion todas las materias
            cursadas de un alumno en particular.
        */
        List<Materia> lmd=new ArrayList();
        try
        {
            sql="SELECT * FROM materia m JOIN inscripcion insc on(m.idMateria=insc.idMateria) WHERE insc.idAlumno=? AND m.estado=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setBoolean(2,true);
            rs=ps.executeQuery();
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
        /*
            Este metodo obtenerMateriasCursada recive por parametro un id de un alumno para
            retornar una lista de tipo materia mediante una sentencia SQL la cual selecciona de la
            base de datos la tabla de materia unida a la tabla inscripcion todas las materias no
            cursadas de un alumno en particular.
        */
        List<Materia> lista= new ArrayList();
        sql = "SELECT * FROM Materia m WHERE m.estado= ? AND m.idMateria NOT IN (SELECT i.idMateria FROM Inscripcion i WHERE i.idAlumno = ?)";
        try
        {
            ps=con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            rs = ps.executeQuery();
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
        /*
            Este metodo borrarInscripcion recive por parametro dos argumentos idAlumno e idMateria
            que mediante una sentencia SQL elimina de la tabla inscripcion una fila donde estos
            argumentos coinsidan.
        */
        sql= "DELETE FROM inscripcion WHERE idAlumno=? AND idMateria=?";
        try {
            ps= con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int resultSet = ps.executeUpdate();
           if(resultSet==1){
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
        /*
            Este metodo actualizarNota recive tres argumentos idAlumno, idMateria y una nota
            mediante una sentencia SQL actualiza la tabla inscripcion con la nota de la base de dato
            donde coinsidan los argumentos idAlumno e idMateria.
        */
        sql="UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?";
        try {
            ps= con.prepareStatement(sql);
            ps.setDouble(1,nota);
            ps.setInt(2,idAlumno);
            ps.setInt(3,idMateria);
            int resultSet= ps.executeUpdate();
            if(resultSet==1){
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
        /*
            Este metodo obtenerAlumnosPorMateria recive un argumento idMateria que retorna una
            lista de tipo Alumno mediante una sentencia SQL que selecciona de la base de dato
            la tabla alumno unida con la tabla inscripcion todos los alumno donde coincida con
            el argumento.
        */
        List <Alumno> lista = new ArrayList();
        sql="SELECT * FROM alumno a JOIN inscripcion ins ON(a.idAlumno=ins.idAlumno) WHERE idMateria=? AND a.estado=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ps.setBoolean(2, true);
            rs=ps.executeQuery();
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
