/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitybillingsystem;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Dell
 */
public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
            Class.forName("conn.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            s = c.createStatement();
            JOptionPane.showMessageDialog(null,"Connection Succcessful","Connection", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception e){
             System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Connection UnSuccessful"+ e.getMessage(),"Connection", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
