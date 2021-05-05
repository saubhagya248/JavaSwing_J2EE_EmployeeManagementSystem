/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemgt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import javax.swing.JTextField;
/**
 *
 * @author saubhagya
 */
public class db_ser {
    
    /**
     *
     * @param ser
     
     */
    public void ser(String ser1, DefaultTableModel t){
        Connection conn=null;
        PreparedStatement pst=null;
        Long ser = Long.parseLong(ser1);
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/employeemgt", "root", "");
            String query = "SELECT * FROM employee WHERE ano= '"+ser+"' ";
            pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String mobile = rs.getString("mobile");
                String ano1 = rs.getString("ano");
                String email = rs.getString("email");
                String design = rs.getString("designation");
                double sal = rs.getDouble("Salary");
                
                Long ano = Long.parseLong(ano1);
                
                if(ser.equals(ano)){
                    
                    t.addRow(new Object[]{id,fname,lname,mobile,ano,email,design,sal});
                   
                }
                
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public ArrayList ser_upd(String ser1){
        Connection conn=null;
        PreparedStatement pst=null;
        Long ser = Long.parseLong(ser1);
        ArrayList<String > Array = new ArrayList<String>(8);
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/employeemgt", "root", "");
            String query = "SELECT * FROM employee WHERE ano= '"+ser+"' ";
            pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String mobile = rs.getString("mobile");
                String ano1 = rs.getString("ano");
                String email = rs.getString("email");
                String design = rs.getString("designation");
                String sal = rs.getString("Salary");
                
                Long ano = Long.parseLong(ano1);
                
                if(ser.equals(ano)){
                    
                    
                    Array.add(id);
                    Array.add(fname);
                    Array.add(lname);
                    Array.add(mobile);
                    Array.add(ano1);
                    Array.add(email);
                    Array.add(design);
                    Array.add(sal);
                    
                    
                }
                
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return Array;
    }
    
}
