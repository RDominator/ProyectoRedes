/*
 * Nombre: Regina Dominique Ríos Ramírez
 * Tema del programa: ~ Cajero de Banco ATM ~
 * Descripción: Cajero hecho en NetBeans junto con una base de datos que guarda los datos de los clientes y accede a ellos
 * para realizar acciones como: depositar a cuenta, retirar fondos de cuenta, transferir de cuenta a cuenta
 * pagar / comprar servicios y consultar respectivamente el saldo, se pretende que el proyecto use SOCKETS o RMI
 * Fecha: ~ 27 de Mayo 2019 ~ 
 */
package Banco;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author NaruHina
 */
public class Iniciar extends javax.swing.JFrame implements Runnable{

    public Iniciar() {
        initComponents();
        URL iconURL = getClass().getResource("/Imagenes/Registro.jpg");
        // iconURL is null when not found
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        this.setSize(310,350);
        this.setTitle("~ Log In ~  ACR");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EtiquetaCorreo = new javax.swing.JLabel();
        Correito = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        BtnIngresar = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();
        Volver = new javax.swing.JButton();
        Icono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        EtiquetaCorreo.setText("Correo Electrónico");
        getContentPane().add(EtiquetaCorreo);
        EtiquetaCorreo.setBounds(80, 50, 110, 30);

        Correito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CorreitoKeyTyped(evt);
            }
        });
        getContentPane().add(Correito);
        Correito.setBounds(50, 90, 180, 30);

        jLabel1.setText("Contraseña");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 160, 80, 20);

        Titulo.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        Titulo.setText("Inicia Sesión");
        getContentPane().add(Titulo);
        Titulo.setBounds(90, 0, 110, 40);

        BtnIngresar.setText("Ingresar");
        BtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnIngresar);
        BtnIngresar.setBounds(160, 230, 80, 30);

        Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PasswordKeyTyped(evt);
            }
        });
        getContentPane().add(Password);
        Password.setBounds(100, 190, 60, 30);

        Volver.setText("Regresar");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Volver);
        Volver.setBounds(30, 230, 80, 30);

        Icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogIn.png"))); // NOI18N
        getContentPane().add(Icono);
        Icono.setBounds(20, 20, 310, 260);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CorreitoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CorreitoKeyTyped
     int limite  = 30;
     if (Correito.getText().length() == limite){
         evt.consume();
         JOptionPane.showMessageDialog(rootPane, "Limite de caracteres excedido");
     }
    }//GEN-LAST:event_CorreitoKeyTyped

    private void PasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyTyped
     int limite  = 8;
     if (Password.getText().length() == limite){
         evt.consume();
         JOptionPane.showMessageDialog(rootPane, "La contraseña tiene un tamaño unicamente de 8 caracteres");
     }
    }//GEN-LAST:event_PasswordKeyTyped

    private void BtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresarActionPerformed
//Aquí ya hace la validación de si existe el correo y contraseña y procede a acceder
    if (BtnIngresar.getText().equals("Ingresar")) {
          String user = Correito.getText(); //Agarrar lo de las cajas de texto de correo y contraseña
          String contra = Password.getText();
        if(Correito.getText().equals("") && Password.getText().equals("")){  
              JOptionPane.showMessageDialog(null,"El correo y/o contraseña son inválidos, inténtalo de nuevo");
              Correito.setText("");
              Password.setText("");
       }else{
             try { 
                RMI rmii;
                Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
                rmii = (RMI) reg.lookup("Objeto remoto");
                rmii.IniciarS(user,contra);   
                  //  JOptionPane.showMessageDialog(null,"El/Los campos se encuentran vacios, favor de rellenarlos"); 
               }
            catch(RemoteException e) {
                e.printStackTrace();
            }
             catch (NotBoundException ex) {
             ex.printStackTrace();
        }  
                 }
    }
    }//GEN-LAST:event_BtnIngresarActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        //Botón pa Volver
        GUIPrincipal gui = new GUIPrincipal();
         gui.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

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
            java.util.logging.Logger.getLogger(Iniciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Iniciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Iniciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Iniciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Iniciar().setVisible(true);
            }
        });
    }
    
    public void run() {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JTextField Correito;
    private javax.swing.JLabel EtiquetaCorreo;
    private javax.swing.JLabel Icono;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
