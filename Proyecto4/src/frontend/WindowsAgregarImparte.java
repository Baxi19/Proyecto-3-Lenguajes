/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;



import database.SQLite;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Baxi
 */
public class WindowsAgregarImparte extends javax.swing.JFrame {
    WindowsMenu wc;
    int profesorId, cursoId;
    int formato = 1;
    
    public WindowsAgregarImparte(WindowsMenu wm) {
        initComponents();
        this.setSize(450,250);
        setLocationRelativeTo(null);
        this.wc = wm;
        datosProfesor(); 
        updateTable();
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
        jLabelMensaje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelSiguiente = new javax.swing.JLabel();
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
        jLabelTitle.setText("Registrar profesor - curso");
        getContentPane().add(jLabelTitle);
        jLabelTitle.setBounds(20, 10, 320, 28);

        jLabelMensaje.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMensaje.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelMensaje.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMensaje.setText("Seleccione el Profesor y digite siguiente");
        getContentPane().add(jLabelMensaje);
        jLabelMensaje.setBounds(20, 50, 270, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 90, 320, 130);

        jLabelSiguiente.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSiguiente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSiguiente.setText("Siguiente");
        getContentPane().add(jLabelSiguiente);
        jLabelSiguiente.setBounds(360, 150, 70, 30);

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

    private void jButtonAgregarProfesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAgregarProfesorMouseClicked
        
    }//GEN-LAST:event_jButtonAgregarProfesorMouseClicked

    private void jButtonAgregarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarProfesorActionPerformed
       if(formato == 1){
            if(!jTable1.getSelectionModel().isSelectionEmpty()){
                profesorId =(int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
                datosCurso();
                jLabelMensaje.setText("Seleccione el Curso y digite siguiente");
                formato = 2;
            }else{
                JOptionPane.showMessageDialog(null, "Por favor seleccione el profesor para continuar..");
            } 
       }else{
           if(!jTable1.getSelectionModel().isSelectionEmpty()){
                cursoId =(int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
                try {
                        SQLite.getInstance().agregarImparte(profesorId, cursoId);
                        JOptionPane.showMessageDialog(null, "Relacion de Profesor - Curso agregada correctamente!");
                        wc.cerrarPaneles();
                        wc.datosImparte();
                        this.dispose();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }               
            }else{
                JOptionPane.showMessageDialog(null, "Por favor seleccione el curso para continuar..");
            }
       }
        
    }//GEN-LAST:event_jButtonAgregarProfesorActionPerformed

    private void jButtonClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClose1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButtonClose1MouseClicked

    private void jButtonClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClose1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonClose1ActionPerformed

    protected String datosProfesor(){
        String sql = "SELECT id, nombre, apellidos FROM Profesor WHERE activo = 'T';";
        jTable1.setModel(SQLite.getInstance().executeSQL(sql));
        return  "";
    }
    
    protected String datosCurso(){
        String sql = "SELECT id, nombre FROM Curso WHERE activo = 'T';";
        jTable1.setModel(SQLite.getInstance().executeSQL(sql));
        return  "";
    }
    
    protected void updateTable(){
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable1.setCellSelectionEnabled(true);
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAgregarProfesor;
    private javax.swing.JButton jButtonClose1;
    private javax.swing.JLabel jLabelMensaje;
    private javax.swing.JLabel jLabelSiguiente;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
