/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clientudp;

import static clientudp.HomePage.listeamis;
import static clientudp.HomePage.port;
import static clientudp.HomePage.removefirstChar;
import static clientudp.HomePage.toSend;
import static clientudp.LoginPageGui.jTextField1;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Timer;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
/**
 *
 * @author totor
 */
public class MessagePage extends javax.swing.JFrame {
    DefaultListModel<String> listedesmessages=new DefaultListModel<String>();
    static final int port = 6010 ;
    DatagramSocket socket;
    DatagramPacket envoye, recu;
    InetAddress address;
    /**
     * Creates new form MessagePage
     *///constructeur
    public MessagePage() throws UnknownHostException, SocketException {
        initComponents();
        address = InetAddress.getByName("127.0.0.1") ;
        socket = new DatagramSocket() ;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Liste = new javax.swing.JList<>();
        Data = new javax.swing.JTextField();
        Button = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });

        jScrollPane1.setViewportView(Liste);

        Button.setText("Envoyer");
        Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(32, 32, 32)
                        .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Button))
                    .addComponent(jButton2))
                .addGap(0, 122, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
        // TODO add your handling code here:


    }//GEN-LAST:event_jPanel1ComponentShown

    private void ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonActionPerformed
        // TODO add your handling code here:
        //pas fini => a faire (utiliser la liste) => code inutilisatble pour le moment
        Liste.setModel(listedesmessages);
            String data=new String(Data.getText());
            try {
                envoi("message@"+LoginPageGui.myName()+"@"+HomePage.toSend()+"@ @"+data);
                
                String s = recu();
                int sizeofs=s.length();
        } catch (SocketException ex) {
            Logger.getLogger(MessagePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MessagePage.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           
    }//GEN-LAST:event_ButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //remet sur la page menu bouton retour
        try {
            HomePage hp;
            hp = new HomePage();
            hp.setVisible(true);
            hp.pack();
            hp.setLocationRelativeTo(null);//center page
            hp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();//delete l'ancienne page
        } catch (UnknownHostException ex) {
            Logger.getLogger(MessagePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(MessagePage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //actualisation des messages, créer nouvelle page (refresh)
        MessagePage mp;
        try {

            mp = new MessagePage();
            mp.setVisible(true);
            mp.pack();
            mp.setLocationRelativeTo(null);//center page
            mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();//delete l'ancienne page
            
            MessagePage.Liste.setModel(listedesmessages);
            String data=new String(MessagePage.Data.getText());
            try {
                envoi("lecture@"+LoginPageGui.myName()+"@"+toSend()); //demande des messages sous forme ...@sender/data@...
                String s = "";
                s = recu();
                String t[]=s.split("@");
                for(int j=1;j<t.length;j++){
                    String k=t[j];
                    String split[]=k.split("/");//récupère les messages et pas le type 0=> nom envoyeur : 1=> data du message
                    if(split[0].equals(LoginPageGui.myName())){
                        listedesmessages.addElement("J'ai envoyé : "+split[1]);
                        listedesmessages.addElement("_____________________________________________________________________________________________________");
                    }else{
                        listedesmessages.addElement("envoie de : "+split[0]+" => message : "+split[1]);
                        listedesmessages.addElement("_____________________________________________________________________________________________________");
                    }
                    
                }

            } catch (SocketException ex) {
                Logger.getLogger(MessagePage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MessagePage.class.getName()).log(Level.SEVERE, null, ex);
            }    
        } catch (UnknownHostException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
    //fonctions envoi et recu des messages
    public void envoi(String msg) throws UnknownHostException, SocketException, IOException {
        int msglen = msg.length() ;
        byte [] message = new byte [1024] ;
        message = msg.getBytes() ;
        envoye = new DatagramPacket(message, msglen, address, port) ;
        socket.send(envoye) ;
        System.out.println("\nLe message envoye => "+msg);
    }
  
    public String recu() throws UnknownHostException, SocketException, IOException {
        byte[] buf = new byte[1024];
        recu = new DatagramPacket(buf, buf.length);
        socket.receive(recu);
        String rcvd = "Message recu du serveur : " + recu.getAddress() + ", au port : " + recu.getPort();
        System.out.println(rcvd);
        return new String(recu.getData(), 0, recu.getLength());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
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
            java.util.logging.Logger.getLogger(MessagePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MessagePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MessagePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MessagePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        //LoginPageGui.myName()    récupérer le nom de l'utilisateur qui envoie un message
        //HomePage.listeamis.getSelectedValue()
        
        //Timer timer = new Time();
        //timer.schedule(new jPanel1ComponentShown(),0,5000);
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MessagePage().setVisible(true); //affiche la page
                } catch (UnknownHostException ex) {
                    Logger.getLogger(MessagePage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SocketException ex) {
                    Logger.getLogger(MessagePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Button;
    public static javax.swing.JTextField Data;
    public static javax.swing.JList<String> Liste;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
