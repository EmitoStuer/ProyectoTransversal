/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotransversal.Vistas;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyectotransversal.AccesoDatos.AlumnoData;
import proyectotransversal.Entidades.Alumno;

/**
 *
 * @author alumno
 */
public class AlumnoView extends javax.swing.JInternalFrame {
    AlumnoData ad;
    Alumno a;

    /**
     * Creates new form Alumno
     */
    public AlumnoView() {
        initComponents();
        this.setLocation(130, 30);
        ad = new AlumnoData();
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
        jtDocumento = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jrbEstado = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jbAgregar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jdcFechaNacimiento = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(0, 153, 102));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Alumno");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Documento:");

        jtDocumento.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jBBuscar.setBackground(new java.awt.Color(0, 153, 102));
        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Alumno");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Estado:");

        jrbEstado.setForeground(new java.awt.Color(0, 0, 0));
        jrbEstado.setBorder(null);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha de Nacimiento:");

        jbAgregar.setBackground(new java.awt.Color(0, 153, 102));
        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbEditar.setBackground(new java.awt.Color(0, 153, 102));
        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbEliminar.setBackground(new java.awt.Color(0, 153, 102));
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(0, 153, 102));
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbAgregar)
                        .addGap(61, 61, 61)
                        .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(jtNombre)
                            .addComponent(jrbEstado))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscar)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar)
                    .addComponent(jbEditar)
                    .addComponent(jbEliminar)
                    .addComponent(jbSalir))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        // TODO add your handling code here:
        a= new Alumno();
        try{
            a=ad.buscarAlumnoPorDni(Integer.parseInt(jtDocumento.getText()));
                if (a!=null){
                    jtNombre.setText(a.getNombre());
                    jtApellido.setText(a.getApellido());
                    jrbEstado.setSelected(a.isEstado());
                    jdcFechaNacimiento.setDate(Date.valueOf(a.getFechaNac()));
                    jbAgregar.setEnabled(false);
                    jbEditar.setEnabled(true);
                    jbEliminar.setEnabled(true);
                }else{
                    jtNombre.setText("");
                    jtApellido.setText("");
                    jrbEstado.setSelected(false);
                    jdcFechaNacimiento.setDate(null);
                    JOptionPane.showMessageDialog(null,"Complete los campos para el nuevo alumno");
                    jbAgregar.setEnabled(true);
                    jbEditar.setEnabled(false);
                    jbEliminar.setEnabled(false);
                    jtNombre.requestFocus();
                }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Debe ingresar un Numero para Dni.");
            jtDocumento.setText("");
            jtDocumento.requestFocus();
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        // TODO add your handling code here:
        a=new Alumno();
        try{
            a.setDni(Integer.parseInt(jtDocumento.getText()));
        
                if (jtApellido.getText().isEmpty()){
                        jtApellido.requestFocus();
                }else{
                        if (comprobarCaracteres(jtApellido.getText())){
                        a.setApellido(jtApellido.getText());
                        }else{
                        JOptionPane.showMessageDialog(null, "Debe Ingresar solo letras para Apellido");
                        jtApellido.setText("");
                        jtApellido.requestFocus();
                        return;
                        }
                }
        
                if (jtNombre.getText().isEmpty()){
                       jtNombre.requestFocus();
                }else{
                        if (comprobarCaracteres(jtNombre.getText())){
                        a.setNombre(jtNombre.getText());
                        }else{
                          JOptionPane.showMessageDialog(null, "Debe Ingresar solo letras para Nombre");
                            jtNombre.setText("");
                            jtNombre.requestFocus();
                            return;  
                        }
                }
        
            a.setEstado(jrbEstado.isSelected());
            a.setFechaNac(jdcFechaNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                if(jtNombre.getText().isEmpty() || jtApellido.getText().isEmpty() ){
                    JOptionPane.showMessageDialog(null, "Complete todos los Campos");
                }else{
                    ad.guardarAlumno(a);
                    jtDocumento.setText("");
                    jtNombre.setText("");
                    jtApellido.setText("");
                    jrbEstado.setSelected(false);
                    jdcFechaNacimiento.setDate(null);
                }
            
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Corrobore los datos ingresados");
            jdcFechaNacimiento.setDate(null);
            jdcFechaNacimiento.requestFocus();
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Debe Ingresar un numero valido para dni "+e.getMessage());
            jtDocumento.setText("");
            jtDocumento.requestFocus();
        }
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        // TODO add your handling code here:
        a= new Alumno();
        try{
        a = ad.buscarAlumnoPorDni(Integer.parseInt(jtDocumento.getText()));
        a.setDni(Integer.parseInt(jtDocumento.getText()));
        if (jtApellido.getText().isEmpty()){
                        jtApellido.requestFocus();
                }else{
                        
                        if (comprobarCaracteres(jtApellido.getText())){
                        a.setApellido(jtApellido.getText());
                        }else{
                        JOptionPane.showMessageDialog(null, "Debe Ingresar solo letras para Apellido");
                        jtApellido.setText("");
                        jtApellido.requestFocus();
                        return;
                        }
                }
        
                if (jtNombre.getText().isEmpty()){
                       jtNombre.requestFocus();
                }else{
                        if (comprobarCaracteres(jtNombre.getText())){
                        a.setNombre(jtNombre.getText());
                        }else{
                          JOptionPane.showMessageDialog(null, "Debe Ingresar solo letras para Nombre");
                            jtNombre.setText("");
                            jtNombre.requestFocus();
                            return;  
                        }
                }
        
            a.setEstado(jrbEstado.isSelected());
        
            a.setFechaNac(jdcFechaNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            if(jtNombre.getText().isEmpty() || jtApellido.getText().isEmpty() ){
                    JOptionPane.showMessageDialog(null, "Complete todos los Campos");
                }else{
                    ad.modificarAlumno(a);
            }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Corrobore los datos ingresados");
            jdcFechaNacimiento.setDate(null);
            jdcFechaNacimiento.requestFocus();
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Debe Ingresar un numero valido para dni "+e.getMessage());
            jtDocumento.setText("");
            jtDocumento.requestFocus();
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
        a= new Alumno();
        try{
        a = ad.buscarAlumnoPorDni(Integer.parseInt(jtDocumento.getText()));
        ad.eliminarAlumno(a.getIdAlumno());
        jtDocumento.setText("");
        jtNombre.setText("");
        jtApellido.setText("");
        jrbEstado.setSelected(false);
        jdcFechaNacimiento.setDate(null);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Debe Ingresar un numero valido para dni "+e.getMessage());
            jtDocumento.setText("");
            jtDocumento.requestFocus();
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
            // TODO add your handling code here:
            this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private boolean comprobarCaracteres(String e){
        int longitud = e.length();
        boolean validado=true;
        for (int i =0; i<longitud;i++){
            char c = e.charAt(i);
            if (!Character.isLetter(c) && !Character.isWhitespace(c)){
                validado=  false;
            }
        }
        return validado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbSalir;
    private com.toedter.calendar.JDateChooser jdcFechaNacimiento;
    private javax.swing.JRadioButton jrbEstado;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDocumento;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}
