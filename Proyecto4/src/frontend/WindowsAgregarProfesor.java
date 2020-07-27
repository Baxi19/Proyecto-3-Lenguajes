/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;



import backend.SingletonProlog;
import database.SQLite;
import entity.Profesor;
import javax.swing.JOptionPane;
import patterns.Singleton;

/**
 *
 * @author Baxi
 */
public class WindowsAgregarProfesor extends javax.swing.JFrame {
    WindowsMenu wc;
    
    
    public WindowsAgregarProfesor(WindowsMenu wm) {
        initComponents();
        this.setSize(450,250);
        setLocationRelativeTo(null);
        this.wc = wm;
        
       
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButtonClose1 = new javax.swing.JButton();
        jLabelTitle = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldApellidos = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldCedula = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jButtonAgregarProfesor = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(467, 3));
        getContentPane().setLayout(null);

        jButtonClose1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close1.png"))); // NOI18N
        jButtonClose1.setBorder(null);
        jButtonClose1.setBorderPainted(false);
        jButtonClose1.setContentAreaFilled(false);
        jButtonClose1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonClose1.setRequestFocusEnabled(false);
        jButtonClose1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close2.png"))); // NOI18N
        jButtonClose1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close2.png"))); // NOI18N
        jButtonClose1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close2.png"))); // NOI18N
        jButtonClose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonClose1MouseClicked(evt);
            }
        });
        jButtonClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClose1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClose1);
        jButtonClose1.setBounds(370, 10, 70, 60);

        jLabelTitle.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setText("Registrar nuevo profesor");
        getContentPane().add(jLabelTitle);
        jLabelTitle.setBounds(20, 10, 320, 28);

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Nombre");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(20, 50, 80, 30);

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNombre);
        jTextFieldNombre.setBounds(110, 60, 230, 20);

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Apellidos");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(20, 90, 80, 30);

        jTextFieldApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidosActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldApellidos);
        jTextFieldApellidos.setBounds(110, 100, 230, 20);

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Cedula");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(20, 140, 80, 30);

        jTextFieldCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCedulaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCedula);
        jTextFieldCedula.setBounds(110, 140, 230, 20);

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Agregar");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(360, 150, 70, 30);

        jButtonAgregarProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrar.png"))); // NOI18N
        jButtonAgregarProfesor.setBorder(null);
        jButtonAgregarProfesor.setBorderPainted(false);
        jButtonAgregarProfesor.setContentAreaFilled(false);
        jButtonAgregarProfesor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonAgregarProfesor.setRequestFocusEnabled(false);
        jButtonAgregarProfesor.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrar2.png"))); // NOI18N
        jButtonAgregarProfesor.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrar2.png"))); // NOI18N
        jButtonAgregarProfesor.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrar2.png"))); // NOI18N
        jButtonAgregarProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAgregarProfesorMouseClicked(evt);
            }
        });
        jButtonAgregarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarProfesorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregarProfesor);
        jButtonAgregarProfesor.setBounds(350, 180, 80, 70);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hydrogen.jpg"))); // NOI18N
        bg.setMaximumSize(new java.awt.Dimension(450, 250));
        bg.setMinimumSize(new java.awt.Dimension(450, 250));
        bg.setPreferredSize(new java.awt.Dimension(450, 250));
        getContentPane().add(bg);
        bg.setBounds(0, 0, 450, 250);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jTextFieldApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidosActionPerformed

    private void jTextFieldCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCedulaActionPerformed

    private void jButtonAgregarProfesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAgregarProfesorMouseClicked
        
    }//GEN-LAST:event_jButtonAgregarProfesorMouseClicked

    private void jButtonAgregarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarProfesorActionPerformed
        if(!jTextFieldNombre.getText().isEmpty()){
            if(!jTextFieldApellidos.getText().isEmpty()){
                if(!jTextFieldCedula.getText().isEmpty()){
                    try {
                        SQLite.getInstance().agregarProfesor(jTextFieldNombre.getText(), jTextFieldApellidos.getText(), jTextFieldCedula.getText());
                        JOptionPane.showMessageDialog(null, "Profesor agregado correctamente!");
                        
                        Profesor a = new Profesor(jTextFieldNombre.getText(), jTextFieldApellidos.getText(), jTextFieldCedula.getText());
                        SingletonProlog.getInstance().InsertarDatoEnMemoria(a.getHecho());
                        
                        wc.cerrarPaneles();
                        wc.datosProfesor();
                        this.dispose();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Debe ingresar una cedula..!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Debe ingresar un apellido..!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre..!");
        }
    }//GEN-LAST:event_jButtonAgregarProfesorActionPerformed

    private void jButtonClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClose1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButtonClose1MouseClicked

    private void jButtonClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClose1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonClose1ActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAgregarProfesor;
    private javax.swing.JButton jButtonClose1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldCedula;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
