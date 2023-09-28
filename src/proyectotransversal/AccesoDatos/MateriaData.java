/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotransversal.AccesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyectotransversal.Entidades.Materia;

/**
 *
 * @author Mauri
 */
public class MateriaData {
    private Connection con = null;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private Materia m;
    
    public MateriaData(){
        con = Conexion.getConexion();
    };
    
    //Método que recibe un objeto(materia), para guardar informacion en la base de datos.
    public void guardarMateria(Materia m){
    // >>Signos "?" son propiedades asignadas a traves del preparedStatement.<<
        sql = "INSERT INTO materia(nombre, año, estado) VALUES (?,?,?)";                
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,m.getNombre());
            ps.setInt(2, m.getAño());
            ps.setBoolean(3, m.isEstado());            
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                m.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"MateriaData : Materia cargada con exito.");
            }else{
                JOptionPane.showMessageDialog(null,"MateriaData : Error al cargar ID.");
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"MateriaData: Error al guardar materia"+ex.getMessage());
        }
    };
    
    //Método que realiza la busqueda en la base de datos, a traves de ID.
    public Materia buscarMateria(int id){
        m = null;
        sql = "SELECT * FROM materia WHERE idMateria=?" ;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);            
            rs = ps.executeQuery();            
            if(rs.next()){
                m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAño(rs.getInt("año"));
                m.setEstado(rs.getBoolean("estado"));
            }else{
                JOptionPane.showMessageDialog(null,"MateriaData : No se encontro materia con id : '" + id+"'");
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"MateriaData : Error al buscar" + ex.getMessage());
        }        
        return m;
    }   
    
    //Método que recibe Objeto(materia) para su modificación en la base de datos.
    public void modificarMateria (Materia m){
        sql ="UPDATE materia SET nombre=?,año=?,estado=? WHERE idMateria=?";     
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,m.getNombre());
            ps.setInt(2,m.getAño());
            ps.setBoolean(3,m.isEstado());            
            ps.setInt(4,m.getIdMateria());
            int resultSet = ps.executeUpdate();            
            if(resultSet == 1){
                JOptionPane.showMessageDialog(null,"MateriaData : Materia modificada correctamente.");
            }else{
                JOptionPane.showMessageDialog(null,"MateriaData : No se encontro materia a modificar.");      
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"MateriaData : Error al modificar materia"+ex.getMessage());  
        }
    }    
    
    //Método que recibe ID para la eliminación en la base de datos.
    public void eliminarMateria(int id){
        sql = "UPDATE materia SET estado=? WHERE idMateria=?";   
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2,id);
            int resultSet = ps.executeUpdate();
            
            if(resultSet ==1){
                JOptionPane.showMessageDialog(null, "MateriaData : Materia eliminada con exito.");
            }else{
                JOptionPane.showMessageDialog(null, "MateriaData : No se encontro una materia a eliminar.");
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "MateriaData : Error al eliminar la materia"+ex.getMessage());
        }        
    }
    
    //Método que permite listar las Materias encontradas en la base de datos.
    public List<Materia> listarMaterias(){
        List<Materia> listaMaterias= new ArrayList();
        sql = "SELECT * FROM materia WHERE estado = ? ORDER BY nombre";
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            rs = ps.executeQuery();            
            while(rs.next()){
                m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAño(rs.getInt("año"));
                m.setEstado(rs.getBoolean("estado"));                
                listaMaterias.add(m);
            }    
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "MateriaData : Error al listar las materias"+ex.getMessage());
        }        
        return listaMaterias;
    }
}
