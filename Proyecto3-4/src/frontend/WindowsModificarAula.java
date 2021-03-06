/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;



import backend.SingletonProlog;
import database.SQLite;
import entity.Aula;
import javax.swing.JOptionPane;
import patterns.Singleton;

/**
 *
 * @author Baxi
 */
public class WindowsModificarAula extends javax.swing.JFrame {
    WindowsMenu wc;
    Aula aula;
    
    public WindowsModificarAula(WindowsMenu wm, Aula a) {
        initComponents();
        this.setSize(450,250);
        setLocationRelativeTo(null);
        this.wc = wm;
        aula = a;
        jTextFieldNombre.setText(aula.getNombre());
        jTextFieldCapacidad.setText(Integer.toString(aula.getCapacidad()));
        jComboBoxTipo.setSelectedItem(aula.getTipo());
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
        jTextFieldCapacidad = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jButtonAgregarAula = new javax.swing.JButton();
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
        jLabelTitle.setText("Modificar aula");
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
        jLabel24.setText("Capacidad");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(20, 90, 80, 30);

        jTextFieldCapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCapacidadActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCapacidad);
        jTextFieldCapacidad.setBounds(110, 100, 230, 20);

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Tipo");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(20, 140, 80, 30);

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "normal", "laboratorio" }));
        jComboBoxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxTipo);
        jComboBoxTipo.setBounds(110, 140, 230, 20);

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Modificar");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(360, 150, 70, 30);

        jButtonAgregarAula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrar.png"))); // NOI18N
        jButtonAgregarAula.setBorder(null);
        jButtonAgregarAula.setBorderPainted(false);
        jButtonAgregarAula.setContentAreaFilled(false);
        jButtonAgregarAula.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonAgregarAula.setRequestFocusEnabled(false);
        jButtonAgregarAula.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrar2.png"))); // NOI18N
        jButtonAgregarAula.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrar2.png"))); // NOI18N
        jButtonAgregarAula.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/entrar2.png"))); // NOI18N
        jButtonAgregarAula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAgregarAulaMouseClicked(evt);
            }
        });
        jButtonAgregarAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarAulaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregarAula);
        jButtonAgregarAula.setBounds(350, 180, 80, 70);

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

    private void jTextFieldCapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCapacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCapacidadActionPerformed

    private void jButtonAgregarAulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAgregarAulaMouseClicked
        
    }//GEN-LAST:event_jButtonAgregarAulaMouseClicked

    private void jButtonAgregarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarAulaActionPerformed
        if(!jTextFieldNombre.getText().isEmpty()){
            if(!jTextFieldCapacidad.getText().isEmpty()){
                int capacidad ;
                try {
                    capacidad = Integer.parseInt(jTextFieldCapacidad.getText());
                } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, "Debe ingresar la capacidad en numeros"); 
                   return;
                }
                try {
                    String eliminar = "retract(" +Singleton.getInstance().buscarAula(aula.getId()).getDatos()+").";
                    SingletonProlog.getInstance().consultaProlog(eliminar);

                    SQLite.getInstance().modificarAula(
                        aula.getId(), 
                        jTextFieldNombre.getText(),
                        capacidad, 
                        jComboBoxTipo.getSelectedItem().toString());
                    JOptionPane.showMessageDialog(null, "Aula modificada correctamente!");
                 
                    Singleton.getInstance().buscarAula(aula.getId()).setNombre(jTextFieldNombre.getText());
                    Singleton.getInstance().buscarAula(aula.getId()).setCapacidad(capacidad);
                    Singleton.getInstance().buscarAula(aula.getId()).setTipo(jComboBoxTipo.getSelectedItem().toString());
                        
                    
                    SingletonProlog.getInstance().InsertarDatoEnMemoria(Singleton.getInstance().buscarAula(aula.getId()).getHecho());

                    wc.cerrarPaneles();
                    wc.datosAulas();
                    this.dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Debe ingresar una capacidad");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre..!");
        }
    }//GEN-LAST:event_jButtonAgregarAulaActionPerformed

    private void jButtonClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClose1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButtonClose1MouseClicked

    private void jButtonClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClose1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonClose1ActionPerformed

    private void jComboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAgregarAula;
    private javax.swing.JButton jButtonClose1;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JTextField jTextFieldCapacidad;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
