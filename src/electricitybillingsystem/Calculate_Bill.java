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
public class Calculate_Bill extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5;
    JTextField t1 ;
    Choice c1,c2;
    JButton b1,b2;
    JPanel p;
    Calculate_Bill(){
        p = new JPanel();
        p.setLayout(new GridLayout(4,2,30,30));
        p.setBackground(Color.WHITE);
        
        l1 = new JLabel("Calculate Electricity Bill");
        l2 = new JLabel("Meter No");
        l3 = new JLabel("Units Consumed");
        l5 = new JLabel("Month");
        
        t1 = new JTextField();
        
        c1 = new Choice();
        c1.add("1001");
        c1.add("1002");

        c1.add("1003");

        c1.add("1004");
        c2 = new Choice();
        c2.add("january");
        c2.add("february");
        c2.add("march");
        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        ImageIcon il1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2 = il1.getImage().getScaledInstance(180, 270, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l4 = new JLabel(i3);
        
        l1.setFont(new Font("Senserif", Font.PLAIN, 26));
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        p.add(l2);
        p.add(c1);
        p.add(l5);
        p.add(c2);
        p.add(l3);
        p.add(t1);
        p.add(b1);
        p.add(b2);
        
        setLayout(new BorderLayout(30,30));
        
        add(l1, "North");
        add(p,"Center");
        add(l4, "West");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.white);
        setSize(650,500);
        setLocation(350,200);
                       
    }
    public void actionPerformed(ActionEvent ae){
        String a = c1.getSelectedItem();
        String b = t1.getText();
         String c = c2.getSelectedItem();
         
         int p1 = Integer.parseInt(b);
         int p2 = p1*7;
         int p3 = p2+50+12+102+20+50;
         String q = "insert into bill values('"+a+"','"+c+"','"+b+"','"+p3+"')";
         
         try{
             conn cc = new conn();
             cc.s.executeQuery(q);
             JOptionPane.showMessageDialog(null, "Bill Updated");
         }catch(Exception e){
             System.out.println("Calculate_BIll");
             e.printStackTrace();
         }
    }
    public static void main(String[] args){
        new Calculate_Bill().setVisible(true);
    }
}
