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
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
            System.out.println("Alumno Guardado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al guardar Alumno"+ex.getMessage());
        }
        
        
        
    }
    
    public Alumno buscarAlumno(int id){
        Alumno alumno = new Alumno();
    return alumno;
    }
    
    public Alumno buscarAlumnoPorDni(int dni){
        Alumno alumno = new Alumno();
        return alumno;
    }
    
    public List<Alumno> listarAlumnos(){
        List<Alumno> listaAlumnos = new ArrayList();
        Alumno alumno = new Alumno();
        return listaAlumnos;
    }
    
    public void modificarAlumno(Alumno alumno){}
    
    public void eliminarAlumno(int id){}
}
