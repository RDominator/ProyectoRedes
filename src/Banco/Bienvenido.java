/*
 * Nombre: Regina Dominique Ríos Ramírez
 * Tema del programa: ~ Cajero de Banco ATM ~
 * Descripción: Cajero hecho en NetBeans junto con una base de datos que guarda los datos de los clientes y accede a ellos
 * para realizar acciones como: depositar a cuenta, retirar fondos de cuenta, transferir de cuenta a cuenta
 * pagar / comprar servicios y consultar respectivamente el saldo, se pretende que el proyecto use SOCKETS o RMI
 * Fecha: ~ 28 de Mayo 2019 ~ 
 */

package Banco;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author NaruHina
 */
public class Bienvenido extends javax.swing.JFrame {

    Connection search;
    public Bienvenido() {
        initComponents();
        URL iconURL = getClass().getResource("/Imagenes/ATM1.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        this.setSize(865,710);
        this.setTitle("~ ACR ~ Proyecto Final ~ Cajero RDRR ~ Depósitos ~ Retiros ~ Transferencias ~ Consultas ~ Pagos / Compras");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloSup = new javax.swing.JLabel();
        Retirar = new javax.swing.JButton();
        Depositar = new javax.swing.JButton();
        Consultar = new javax.swing.JButton();
        Salirse = new javax.swing.JButton();
        TituloSup1 = new javax.swing.JLabel();
        Comprar = new javax.swing.JButton();
        Pagar = new javax.swing.JButton();
        Transferir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        TituloSup.setFont(new java.awt.Font("Vladimir Script", 2, 36)); // NOI18N
        TituloSup.setText("RDRR");
        getContentPane().add(TituloSup);
        TituloSup.setBounds(240, 200, 120, 40);

        Retirar.setText("Retirar");
        Retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetirarActionPerformed(evt);
            }
        });
        getContentPane().add(Retirar);
        Retirar.setBounds(110, 360, 120, 40);

        Depositar.setText("Depositar");
        Depositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepositarActionPerformed(evt);
            }
        });
        getContentPane().add(Depositar);
        Depositar.setBounds(110, 320, 120, 40);

        Consultar.setText("Consultar Saldo");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(Consultar);
        Consultar.setBounds(600, 180, 120, 40);

        Salirse.setText("Salir");
        Salirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirseActionPerformed(evt);
            }
        });
        getContentPane().add(Salirse);
        Salirse.setBounds(730, 610, 100, 50);

        TituloSup1.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        TituloSup1.setText("Cajero a tu servicio , ¿Qué deseas realizar?");
        getContentPane().add(TituloSup1);
        TituloSup1.setBounds(170, 150, 300, 80);

        Comprar.setText("Comprar Servicios");
        Comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprarActionPerformed(evt);
            }
        });
        getContentPane().add(Comprar);
        Comprar.setBounds(110, 400, 130, 40);

        Pagar.setText("Pagar Servicios");
        Pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagarActionPerformed(evt);
            }
        });
        getContentPane().add(Pagar);
        Pagar.setBounds(110, 280, 120, 40);

        Transferir.setText("Transferir");
        Transferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferirActionPerformed(evt);
            }
        });
        getContentPane().add(Transferir);
        Transferir.setBounds(370, 280, 120, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tarjeta.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 320, 330, 220);

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CajeroAtm.png"))); // NOI18N
        getContentPane().add(Fondo);
        Fondo.setBounds(-260, 0, 1110, 670);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirseActionPerformed
          //Salirse del programa
        System.exit(0);
    }//GEN-LAST:event_SalirseActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
     //Intentando RMI
             try { 
                String id= "1";
                RMI rmii;
                Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
                rmii = (RMI) reg.lookup("Objeto remoto");
                rmii.Consultar(id);  //llamar al método retirar, ya que pagar cuenta como un retiro
               }
            catch(RemoteException e) {
                e.printStackTrace();
            }
             catch (NotBoundException ex) {
             ex.printStackTrace();
        }
    }//GEN-LAST:event_ConsultarActionPerformed

    private void TransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransferirActionPerformed
        //Abre nueva pestaña que manda a transferir
        Transferir tf = new Transferir();
        tf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_TransferirActionPerformed

    private void PagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagarActionPerformed
        //Abre nueva pestaña que manda a pagar
        Pagar pg = new Pagar();
        pg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PagarActionPerformed

    private void ComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarActionPerformed
        //Abre nueva pestaña que manda a comprar
        Comprar cp = new Comprar();
        cp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ComprarActionPerformed

    private void DepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepositarActionPerformed
        //Abre nueva pestaña que manda a depositar 
        Depositar dp = new Depositar();
        dp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DepositarActionPerformed

    private void RetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetirarActionPerformed
        //Abre nueva pestaña que manda a retirar
        Retirar rt = new Retirar();
        rt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RetirarActionPerformed

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
            java.util.logging.Logger.getLogger(Bienvenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bienvenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bienvenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bienvenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bienvenido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Comprar;
    private javax.swing.JButton Consultar;
    private javax.swing.JButton Depositar;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton Pagar;
    private javax.swing.JButton Retirar;
    private javax.swing.JButton Salirse;
    private javax.swing.JLabel TituloSup;
    private javax.swing.JLabel TituloSup1;
    private javax.swing.JButton Transferir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
