/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemgt;

/**
 *
 * @author saubhagya
 */

import java.util.Properties;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.mail.Session;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.*;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saubhagya
 */
public class mail {

    /**
     *
     * @param to
     * @param subject
     * @param message
     * @param from
     * @param password
     */
    public void send(String to,String subject,String message,String from,String password){
                Properties pros = new Properties();
                pros.put("mail.smtp.host", "smtp.gmail.com");
                pros.put("mail.smtp.socketFactory.port", "465");
                pros.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                pros.put("mail.smtp.auth", "true");
                pros.put("mail.smtp.port", "465");
                
                Session session = Session.getDefaultInstance(pros, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(from,password);
                    }
                });
                
                
            try{
                MimeMessage messege = new MimeMessage(session);
                messege.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
                messege.setSubject(subject);
                messege.setText(message);
                
                Transport.send(messege);
                JOptionPane.showMessageDialog(null, "email sent");
                
                
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "make sure you are connected to internet"+ex);
        }
        
    }
}
