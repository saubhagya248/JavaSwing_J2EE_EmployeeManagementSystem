/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemgt;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author saubhagya
 */
public class db_del {
    
    public boolean del(String ser){
        boolean b = false ;
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employeemgt", "root", "");
            String query = "DELETE FROM `employee` WHERE `employee`.`ano` = '"+ser+"'";
            Statement st = con.createStatement();
            st.executeUpdate(query);
            con.close();
            b=true;
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return b;
    }
}
