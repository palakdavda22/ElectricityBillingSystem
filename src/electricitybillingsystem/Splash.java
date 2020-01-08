/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitybillingsystem;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Dell
 */
public class Splash {
    public static void main(String[] args){
        fframe f1 = new fframe();
        f1.setVisible(true);
        int x = 1;
        for(int i = 2; i<=600; i+=4, x+=1){
            f1.setLocation(800 - ((i+x)/2), 500 - (i/2));
            f1.setSize(i+x,i);
            try{
                Thread.sleep(10);
            }catch(Exception e){
                            System.out.println("Error in splash screen: "+ e);

            }
        }
    }
}
class fframe extends JFrame implements Runnable{
    Thread t1;
    fframe(){
        super("Electricity Billing System");
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image il = c1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(il);
        
        JLabel jl = new JLabel(i2);
        add(jl);
        t1 = new Thread(this);
        t1.start();
    }
    public void run(){
        try{
            Thread.sleep(7000);
            Login l = new Login();
            l.setVisible(true);
            this.setVisible(false);
            
        }catch(Exception e){
            System.out.println("Error in splash screen: "+ e);
            e.printStackTrace();
        }
    }
}
