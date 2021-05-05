/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemgt;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;


/**
 *
 * @author saubhagya
 */
public class db_add{
    
    public void add(String fn_add,String ln_add,String mob_add,String ano_add,String email_add,String des_add,String sal_add){
        
        
        
        long mob = Long.parseLong(mob_add);
        long a = Long.parseLong(ano_add);
        double sal = Double.parseDouble(sal_add);
        int randomCode ; 
        Random rand = new Random();
        randomCode = rand.nextInt(9999);
        
        
        
        
      
        try{
            
            Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgt", "root", "");
           
            Statement pst2 = conn2.createStatement();
            String query2 = "INSERT INTO `employeemgt`.`employee`(`id`,`fname`,`lname`,`mobile`,`ano`,`email`,`designation`,`salary`)"
                    + "VALUES('"+randomCode+"','"+fn_add+"','"+ln_add+"','"+mob+"','"+a+"','"+email_add+"','"+des_add+"','"+sal+"')" ;
            pst2.executeUpdate(query2);
            
            conn2.close();
            JOptionPane.showMessageDialog(null, "Data inserted employee id is "+randomCode);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
}
