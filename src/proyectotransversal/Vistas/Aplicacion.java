/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotransversal.Vistas;

/**
 *
 * @author alumno
 */
public class Aplicacion extends javax.swing.JFrame {

    /**
     * Creates new form Aplicacion
     */
    public Aplicacion() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jMMenuPrincipal = new javax.swing.JMenuBar();
        jMAlumno = new javax.swing.JMenu();
        jMFormularioAlumno = new javax.swing.JMenuItem();
        jMMateria = new javax.swing.JMenu();
        jMFormularioMaterias = new javax.swing.JMenuItem();
        jMDescripcion = new javax.swing.JMenu();
        jMManejoInscripciones = new javax.swing.JMenuItem();
        jMManipularNotas = new javax.swing.JMenuItem();
        jMConsultas = new javax.swing.JMenu();
        jMAlumnosPorMaterias = new javax.swing.JMenuItem();
        jMSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplicacion");

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        jMMenuPrincipal.setName(""); // NOI18N

        jMAlumno.setText("Alumno");

        jMFormularioAlumno.setText("Formulario de Alumno");
        jMFormularioAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMFormularioAlumnoActionPerformed(evt);
            }
        });
        jMAlumno.add(jMFormularioAlumno);

        jMMenuPrincipal.add(jMAlumno);

        jMMateria.setText("Materia");

        jMFormularioMaterias.setText("Formulario de Materia");
        jMFormularioMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMFormularioMateriasActionPerformed(evt);
            }
        });
        jMMateria.add(jMFormularioMaterias);

        jMMenuPrincipal.add(jMMateria);

        jMDescripcion.setText("Administracion");

        jMManejoInscripciones.setText("Manejo de Inscripciones");
        jMManejoInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMManejoInscripcionesActionPerformed(evt);
            }
        });
        jMDescripcion.add(jMManejoInscripciones);

        jMManipularNotas.setText("Manipulacion de Notas");
        jMDescripcion.add(jMManipularNotas);

        jMMenuPrincipal.add(jMDescripcion);

        jMConsultas.setText("Consultas");

        jMAlumnosPorMaterias.setText("Alumnos por Materias");
        jMConsultas.add(jMAlumnosPorMaterias);

        jMMenuPrincipal.add(jMConsultas);

        jMSalir.setText("Salir");
        jMMenuPrincipal.add(jMSalir);

        setJMenuBar(jMMenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMFormularioAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMFormularioAlumnoActionPerformed
        // TODO add your handling code here:
        Escritorio.removeAll();
        Escritorio.repaint();
        AlumnoView al =new AlumnoView();
        al.setVisible(true);
        Escritorio.add(al);
        Escritorio.moveToFront(al);
    }//GEN-LAST:event_jMFormularioAlumnoActionPerformed

    private void jMFormularioMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMFormularioMateriasActionPerformed
        // TODO add your handling code here:
        Escritorio.removeAll();
        Escritorio.repaint();
        MateriaView mv=new MateriaView();
        mv.setVisible(true);
        Escritorio.add(mv);
        Escritorio.moveToFront(mv);
    }//GEN-LAST:event_jMFormularioMateriasActionPerformed

    private void jMManejoInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMManejoInscripcionesActionPerformed
        // TODO add your handling code here:
        Escritorio.removeAll();
        Escritorio.repaint();
        FormularioInscripcion fi=new FormularioInscripcion();
        fi.setVisible(true);
        Escritorio.add(fi);
        Escritorio.moveToFront(fi);
    }//GEN-LAST:event_jMManejoInscripcionesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplicacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenu jMAlumno;
    private javax.swing.JMenuItem jMAlumnosPorMaterias;
    private javax.swing.JMenu jMConsultas;
    private javax.swing.JMenu jMDescripcion;
    private javax.swing.JMenuItem jMFormularioAlumno;
    private javax.swing.JMenuItem jMFormularioMaterias;
    private javax.swing.JMenuItem jMManejoInscripciones;
    private javax.swing.JMenuItem jMManipularNotas;
    private javax.swing.JMenu jMMateria;
    private javax.swing.JMenuBar jMMenuPrincipal;
    private javax.swing.JMenu jMSalir;
    // End of variables declaration//GEN-END:variables
}