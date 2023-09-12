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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectotransversal.Entidades.Alumno;

/**
 *
 * @author Emito
 */
public class AlumnoData {
    Connection con=null;

    public AlumnoData() {
        con=Conexion.getConexion();
    }
    public void guardarAlumno(Alumno a){
        String sql="INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, a.getDni());//Asigna Valores a los comodines.
            ps.setString(2,a.getApellido());
            ps.setString(3,a.getNombre());
            ps.setDate(4,Date.valueOf(a.getFechaNac()));
            ps.setBoolean(5,a.isEstado());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();//Obtiene la Clave generada con AutoIncrement
            
            if (rs.next()){
                a.setIdAlumno(rs.getInt(1));
            }else{
                JOptionPane.showMessageDialog(null,"No se pudo obtener el ID");
            }
            ps.close();  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al guardar Alumno"+ex.getMessage());
        }
        
        
        
    }
    
    public Alumno buscarAlumno(int id){
        Alumno a=null;
        String sql="SELECT * FROM alumno WHERE idAlumno=?";
        PreparedStatement ps=null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));   
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro ningun Alumno con Id: "+id);      
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar alumno por id."+ex.getMessage());
        }
    return a;
    }
    
    public Alumno buscarAlumnoPorDni(int dni){
        Alumno a=null;
        String sql="SELECT * FROM alumno WHERE dni=?";
        PreparedStatement ps=null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));   
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro ningun Alumno con Dni: "+dni);      
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar alumno por dni."+ex.getMessage());
        }
    return a;
    }
    
    public List<Alumno> listarAlumnos(){
        Alumno a=null;
        List<Alumno> listaAlumnos = new ArrayList();
        String sql="SELECT * FROM alumno";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
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
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaAlumnos;
    }
    
    public void modificarAlumno(Alumno a){
        String sql = "UPDATE alumno SET dni=?, apellido=?,nombre=?,fechaNacimiento=?,estado=? WHERE idAlumno=?";
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, a.getDni());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getNombre());
            ps.setDate(4, Date.valueOf(a.getFechaNac()));
            ps.setBoolean(5, a.isEstado());
            ps.setInt(6, a.getIdAlumno());
            int rs = ps.executeUpdate();
            if (rs==1){
                JOptionPane.showMessageDialog(null, "Alumno modificado Correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro ningun Alumno a modificar");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al modificar ALumno"+ex.getMessage());
        }
    }
    
    public void eliminarAlumno(int id){
        String sql = "UPDATE alumno SET estado=? WHERE idAlumno=?";
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            int rs = ps.executeUpdate();
            if (rs==1){
                JOptionPane.showMessageDialog(null, "Alumno dado de Baja Correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro ningun Alumno a dar de baja");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al modificar Alumno"+ex.getMessage());
        }
    }
    
}
