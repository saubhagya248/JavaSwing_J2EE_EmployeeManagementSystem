/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemgt;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author saubhagya
 */
public class db_upd {
    public void upd(ArrayList<String> Array, String ser){
        Connection con= null;
        boolean b=false;
        Statement st  = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/employeemgt", "root", "");
            st = con.createStatement();
            String query = "UPDATE `employee` SET `id`='"+Array.get(0)+"',`fname`='"+Array.get(1)+"',`lname`='"+Array.get(2)+"',`mobile`='"+Array.get(3)+"',`ano`='"+Array.get(4)+"',`email`='"+Array.get(5)+"',`designation`='"+Array.get(6)+"',`salary`='"+Array.get(7)+"' WHERE ano="+ser+"";
            
            st.executeUpdate(query);
            b=true;
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        if(b){
            JOptionPane.showMessageDialog(null, "record updated succesfully");
        } else{
            JOptionPane.showMessageDialog(null, "error");
        }
    }
}
