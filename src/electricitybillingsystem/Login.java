/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitybillingsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author Dell
 */
public class Login extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2;
    JPanel p1,p2,p3,p4;
    Login(){
        super("Login!!!");
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        tf1 = new JTextField(15);
        pf2 = new JPasswordField(15);
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i1 = ic1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b1 = new JButton("Login", new ImageIcon(i1));
        
        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2 = ic2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b2 = new JButton("Cancel", new ImageIcon(i2));
        
        b1.addActionListener(this);
        b2.addActionListener(this);

        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i3 = ic3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        ImageIcon ic4 = new ImageIcon(i3);
        l3 = new JLabel(ic4);
        
        setLayout(new BorderLayout());
                
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        
        add(l3,BorderLayout.WEST);
        p2.add(l1);
        p2.add(tf1);
        p2.add(l2);
        p2.add(pf2);
        add(p2, BorderLayout.CENTER);
        
        p4.add(b1);
        p4.add(b2);
        add(p4, BorderLayout.SOUTH);
        
        p2.setBackground(Color.white);
        
        setSize(440,250);
        setLocation(600,400);
        setVisible(true);

        
    }
    public void actionPerformed(ActionEvent ae){
        try{
            conn c1 = new conn();
            String a = tf1.getText();
            String b = pf2.getText();
            
            String q = "Select * from login where username = '"+a+"' and password = '"+b+"'";
            ResultSet rs = c1.s.executeQuery(q);
            if(rs.next()){
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalide Login");
            }
        }catch(Exception e){
            System.out.println("Login Error: "+ e);
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Login().setVisible(true);
    }
}
