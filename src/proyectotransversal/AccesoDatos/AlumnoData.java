/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotransversal.AccesoDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyectotransversal.Entidades.Alumno;

/**
 *
 * @author Emito
 */
public class AlumnoData {
    Connection con=null;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private Alumno a=null;
    
    public AlumnoData() {
        con=Conexion.getConexion();
    }
    //Recibe un alumno sin Id por parametro, lo guarda en la base de datos y una vez creado nos devuelve el Id.
    public void guardarAlumno(Alumno a){
    // >>Signos "?" son propiedades asignadas a traves del preparedStatement.<<
        sql="INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, a.getDni());//Asigna Valores a los comodines.
            ps.setString(2,a.getApellido());
            ps.setString(3,a.getNombre());
            ps.setDate(4,Date.valueOf(a.getFechaNac()));
            ps.setBoolean(5,a.isEstado());
            
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();//Obtiene la Clave generada con AutoIncrement
            
            if (rs.next()){
                a.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"AlumnoData : Alumno cargado con exito.");
            }else{
                JOptionPane.showMessageDialog(null,"AlumnoData : No se pudo obtener el ID");
            }
            ps.close();  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"AlumnoData : Error al guardar Alumno"+ex.getMessage());
        }
        
        
        
    }
    //buscarAlumno recibe el Id del alumno a buscar y si existe lo guarda en un objeto de tipo Alumno para luego hacer el return de Alumno.
    public Alumno buscarAlumno(int id){        
        sql="SELECT * FROM alumno WHERE idAlumno=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()){
                a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));   
            }else{
                JOptionPane.showMessageDialog(null, "AlumnoData : No se encontro ningun Alumno con Id: "+id);      
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "AlumnoData : Error al buscar alumno por id."+ex.getMessage());
        }
    return a;
    }
    //buscarAlumnoPorDni busca Alumnos con ese dni en la base de datos y devuelve el Objeto Alumno si lo encuentra,
    //si no lo encuentra devuelve null
    public Alumno buscarAlumnoPorDni(int dni){
        sql="SELECT * FROM alumno WHERE dni=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,dni);
            rs = ps.executeQuery();
            if (rs.next()){
                a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));   
            }else{
                JOptionPane.showMessageDialog(null, "AlumnoData : No se encontro ningun Alumno con Dni: "+dni);      
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "AlumnoData : Error al buscar alumno por dni."+ex.getMessage());
        }
    return a;
    }
    //ListarAlumnos Guarda en una Variable Alumno los datos de cada fila de nuestra base de datos
    //y una vez llenada esa variable Alumno la va guardando en un Array.
    public List<Alumno> listarAlumnos(){
        List<Alumno> listaAlumnos = new ArrayList();
        sql="SELECT * FROM alumno WHERE estado = ? ORDER BY apellido";
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            rs = ps.executeQuery();
            while(rs.next()){
                a=new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));
                listaAlumnos.add(a);
                
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"AlumnoData : Error al listar alumnos"+ ex.getMessage());
        }
        
        return listaAlumnos;
    }
    //modificarAlumno recibe un Alumno por parametro, lo busca en la base de datos por su ID y modifica con los nuevos Valores
    public void modificarAlumno(Alumno a){
        sql = "UPDATE alumno SET dni=?, apellido=?,nombre=?,fechaNacimiento=?,estado=? WHERE idAlumno=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, a.getDni());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getNombre());
            ps.setDate(4, Date.valueOf(a.getFechaNac()));
            ps.setBoolean(5, a.isEstado());
            ps.setInt(6, a.getIdAlumno());
            int resultSet = ps.executeUpdate();
            if (resultSet==1){
                JOptionPane.showMessageDialog(null, "AlumnoData : Alumno modificado Correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "AlumnoData : No se encontro ningun Alumno a modificar");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"AlumnoData : Error al modificar ALumno"+ex.getMessage());
        }
    }
    //eliminarAlumno recibe el id del Alumno que se desea eliminar y realiza un borrado logico cambiando el estado de true a false
    public void eliminarAlumno(int id){
        sql = "UPDATE alumno SET estado=? WHERE idAlumno=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            int resultSet = ps.executeUpdate();
            if (resultSet==1){
                JOptionPane.showMessageDialog(null, "AlumnoData : Alumno dado de Baja Correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "AlumnoData : No se encontro ningun Alumno a dar de baja");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"AlumnoData : Error al modificar Alumno"+ex.getMessage());
        }
    }
    
}
