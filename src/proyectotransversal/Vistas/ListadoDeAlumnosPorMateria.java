/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotransversal.Vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import proyectotransversal.AccesoDatos.InscripcionData;
import proyectotransversal.AccesoDatos.MateriaData;
import proyectotransversal.Entidades.Alumno;
import proyectotransversal.Entidades.Materia;

/**
 *
 * @author alumno
 */
public class ListadoDeAlumnosPorMateria extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel(){
        public boolean isCellEditable(int f, int c){
                return false;
        }
    };
    /**
     * Creates new form ListadoDeAlumnosXMateria
     */
    public ListadoDeAlumnosPorMateria() {
        initComponents();
        cargarCombo();
        armarCabecera();
        this.setLocation(100, 30);
        borrarFilas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jcbMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlumnos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 102));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Listado de Alumno por Materias");
        setToolTipText("<strong style=\"text-align:center; \"></strong>");
        setPreferredSize(new java.awt.Dimension(600, 500));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado de Alumno por Materia");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Seleccione una Materia:");

        jcbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMateriaActionPerformed(evt);
            }
        });

        jtAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtAlumnos);

        jButton1.setBackground(new java.awt.Color(0, 153, 102));
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 491, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarCombo(){
        List<Materia> listarMaterias = new ArrayList();
        MateriaData md = new MateriaData();
        listarMaterias = md.listarMaterias();        
        for(Materia mat : listarMaterias){
            jcbMateria.addItem(mat);
        }
    }
    
    private void armarCabecera(){
        modelo.addColumn("Codigo");
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Fecha de nacimiento");
        jtAlumnos.setModel(modelo);
    }
    
    private void borrarFilas(){
        int f = jtAlumnos.getRowCount()-1;
        for(;f >= 0; f--){
            modelo.removeRow(f);
        }
    }
    
    private void jcbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMateriaActionPerformed
        // TODO add your handling code here:
        borrarFilas();
        Materia m = new Materia();
        List<Alumno> listarAlumnos = new ArrayList(); 
        m = (Materia)jcbMateria.getSelectedItem();
        
        InscripcionData id = new InscripcionData();
        
        listarAlumnos = id.obtenerAlumnosPorMateria(m.getIdMateria());
        
        for(Alumno a : listarAlumnos){
            modelo.addRow(new Object[]{
                a.getIdAlumno(),
                a.getDni(),
                a.getNombre(),
                a.getApellido(),
                a.getFechaNac()
            });
        }
    }//GEN-LAST:event_jcbMateriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<Materia> jcbMateria;
    private javax.swing.JTable jtAlumnos;
    // End of variables declaration//GEN-END:variables
}
