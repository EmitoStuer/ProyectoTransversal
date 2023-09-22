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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectotransversal.Entidades.Materia;

/**
 *
 * @author Mauri
 */
public class MateriaData {
    private Connection con = null;
    
    public MateriaData(){
        con = Conexion.getConexion();
    };
    
    public void guardarMateria(Materia m){
        String sql = "INSERT INTO materia(nombre, año, estado) VALUES (?,?,?)";
        PreparedStatement ps;        
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,m.getNombre());
            ps.setInt(2, m.getAño());
            ps.setBoolean(3, m.isEstado());            
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            
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
    
    public Materia buscarMateria(int id){
        Materia m = null;
        String sql = "SELECT * FROM materia WHERE idMateria=?" ;
        PreparedStatement ps;        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);            
            ResultSet rs = ps.executeQuery();
            
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
    
    public void modificarMateria (Materia m){
        String sql ="UPDATE materia SET nombre=?,año=?,estado=? WHERE idMateria=?";
        PreparedStatement ps= null;        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,m.getNombre());
            ps.setInt(2,m.getAño());
            ps.setBoolean(3,m.isEstado());            
            ps.setInt(4,m.getIdMateria());
            int rs = ps.executeUpdate();            
            if(rs == 1){
                JOptionPane.showMessageDialog(null,"MateriaData : Materia modificada correctamente.");
            }else{
                JOptionPane.showMessageDialog(null,"MateriaData : No se encontro materia a modificar.");      
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"MateriaData : Error al modificar materia"+ex.getMessage());  
        }
    }    
    
    public void eliminarMateria(int id){
        String sql = "UPDATE materia SET estado=? WHERE idMateria=?";
        PreparedStatement ps = null;        
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2,id);
            int rs = ps.executeUpdate();
            
            if(rs ==1){
                JOptionPane.showMessageDialog(null, "MateriaData : Materia eliminada con exito.");
            }else{
                JOptionPane.showMessageDialog(null, "MateriaData : No se encontro una materia a eliminar.");
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "MateriaData : Error al eliminar la materia"+ex.getMessage());
        }        
    }
    
    public List<Materia> listarMaterias(){
        Materia m = null;
        List<Materia> listaMaterias= new ArrayList();
        String sql = "SELECT * FROM materia WHERE estado = ? ORDER BY nombre";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ResultSet rs = ps.executeQuery();            
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
