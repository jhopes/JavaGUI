/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frontend;

import Controller.ClsTipoPersona;
import Modell.IdTipoPersona;
import Utilitarios.RecursosMetodos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JOEL
 */
public class FormTipoPersona extends javax.swing.JFrame {

    ClsTipoPersona clstp;
    IdTipoPersona idtp = new IdTipoPersona();
    RecursosMetodos rm = new RecursosMetodos();
    DefaultTableModel modelo;
    ArrayList <IdTipoPersona>tbTipoPersona;
    public FormTipoPersona() {
        initComponents();
        cargar_cab();
    }

    public void llenarTabla()
    {
        idtp.setId_tipo_persona(rm.contador());
        idtp.setNom_tip_per(this.TxtTipopersona.getText());            
        clstp = new ClsTipoPersona(idtp);
    }
    public void cargar_cab(){
        modelo = new DefaultTableModel();
        modelo.addColumn("id_tipo_persona");
        modelo.addColumn("Nombre");
        this.TableTipoPersona.setModel(modelo);
    }
    public void limpiar_text()
    {
     this.TxtTipopersona.setText("");
     enabled_text(true);
    }
    public void enabled_text(boolean estado)
    {
     this.TxtTipopersona.enable(estado);
    }
    public void cargar_datos()
    {
        tbTipoPersona = clstp.reporteTipoPersona();
        for(IdTipoPersona idtp1 : tbTipoPersona){
            modelo.addRow(new Object[]{idtp1.getId_tipo_persona(),
                                        idtp1.getNom_tip_per()
                });
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableTipoPersona = new javax.swing.JTable();
        PanelBtnSecond = new javax.swing.JPanel();
        BtnEdit = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        PanelDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtTipopersona = new javax.swing.JTextField();
        PanelBtnMain = new javax.swing.JPanel();
        BtnNuevo = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        TableTipoPersona.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableTipoPersona);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 250, 440, 150);

        PanelBtnSecond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelBtnSecond.setLayout(null);

        BtnEdit.setText("Editar");
        PanelBtnSecond.add(BtnEdit);
        BtnEdit.setBounds(10, 10, 73, 25);

        BtnEliminar.setText("Eliminar");
        PanelBtnSecond.add(BtnEliminar);
        BtnEliminar.setBounds(90, 10, 73, 25);

        getContentPane().add(PanelBtnSecond);
        PanelBtnSecond.setBounds(10, 190, 440, 50);

        PanelDatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelDatos.setToolTipText("");
        PanelDatos.setEnabled(false);
        PanelDatos.setLayout(null);

        jLabel1.setText("Tipo de persona");
        PanelDatos.add(jLabel1);
        jLabel1.setBounds(10, 40, 100, 25);

        TxtTipopersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtTipopersonaKeyPressed(evt);
            }
        });
        PanelDatos.add(TxtTipopersona);
        TxtTipopersona.setBounds(120, 40, 190, 25);

        getContentPane().add(PanelDatos);
        PanelDatos.setBounds(10, 80, 440, 100);

        PanelBtnMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelBtnMain.setLayout(null);

        BtnNuevo.setIcon(new javax.swing.ImageIcon("D:\\Proyectos Programacion\\Desarrollo de Software Amidata\\amipro\\amipro\\src\\resources\\nuevo16.png")); // NOI18N
        BtnNuevo.setText("Nuevo");
        BtnNuevo.setBorderPainted(false);
        BtnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnNuevo.setIconTextGap(6);
        BtnNuevo.setVerifyInputWhenFocusTarget(false);
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });
        PanelBtnMain.add(BtnNuevo);
        BtnNuevo.setBounds(10, 10, 90, 25);

        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });
        PanelBtnMain.add(BtnGuardar);
        BtnGuardar.setBounds(110, 10, 90, 25);

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });
        PanelBtnMain.add(BtnCancelar);
        BtnCancelar.setBounds(220, 10, 90, 25);

        getContentPane().add(PanelBtnMain);
        PanelBtnMain.setBounds(10, 20, 440, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtTipopersonaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTipopersonaKeyPressed

    }//GEN-LAST:event_TxtTipopersonaKeyPressed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        limpiar_text();
        enabled_text(true);
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        // TxtAppNombres.setText(clsp.contador()+"");
        llenarTabla();
        cargar_datos();
        limpiar_text();
        enabled_text(false);
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        limpiar_text();
        enabled_text(false);
    }//GEN-LAST:event_BtnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTipoPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTipoPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTipoPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTipoPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTipoPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JPanel PanelBtnMain;
    private javax.swing.JPanel PanelBtnSecond;
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JTable TableTipoPersona;
    private javax.swing.JTextField TxtTipopersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
