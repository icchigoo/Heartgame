 package main;

import javax.swing.*;


import peripherals.GameGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class dashboard extends JFrame implements ActionListener {
    
     JMenuBar bar1;
    JMenu m1, m2, m3, m4;
    JMenuItem it1, it2, it3, it4, it5, it6, it7, it8, it9;
    JButton btn1,btn2;
    
    
    
    // first it will show error so we have to overide every buuton
    dashboard(){
        
        
             bar1 = new JMenuBar();
     //   bar1.setBounds(100,200,1000,30);
        add(bar1);
        
          m1 = new JMenu("Hotel");
        m1.setForeground(Color.BLUE);
        bar1.add(m1);
        
         it1 = new JMenuItem("Login Hotel(admin)");
        it1.addActionListener(this);
        m1.add(it1);

        it2 = new JMenuItem("Login Resturant(admin)");
        it2.addActionListener(this);
        m1.add(it2);

        it3 = new JMenuItem("Login Customer");
        it3.addActionListener(this);
        m1.add(it3);
        
        it4 = new JMenuItem("Register Customer");
        it4.addActionListener(this);
        m1.add(it4);
        
        it5 = new JMenuItem("Register CoperateClient");
        it5.addActionListener(this);
        m1.add(it5);
        
        bar1.setBounds(0,0,1920,30);

        setBounds(0,0,1920,1080);
      //  setSize(400,400);

     // setLocation(300,300);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/hotel2.jpg"));
        JLabel lbl1 = new JLabel(i1);
        lbl1.setBounds(0,0,1920,1080);
        add(lbl1);


        JLabel lbl2 = new JLabel("Hotel Pani Puri" );
        lbl2.setBounds(650,30,1000,100);
        lbl2.setForeground(Color.WHITE);
        lbl2.setFont(new Font("serief",Font.ROMAN_BASELINE,70));
        lbl1.add(lbl2);

       btn1 = new JButton("Login Hotel");
        btn1.setBackground(Color.LIGHT_GRAY);
        btn1.setForeground(Color.WHITE);
        btn1.setBounds(1700,50,130,30);
        btn1.addActionListener(this);
        lbl1.add(btn1);
        
       btn2 = new JButton("Login resturant");
        btn2.setBackground(Color.LIGHT_GRAY);
        btn2.setForeground(Color.WHITE);
        btn2.setBounds(1700,90,130,30);
        btn2.addActionListener(this);
        lbl1.add(btn2);
        
    /*     JButton btn3 = new JButton("Register for Customer");
        btn3.setBackground(Color.LIGHT_GRAY);
        btn3.setForeground(Color.WHITE);
        btn3.setBounds(600,600,130,30);
        btn3.addActionListener(this);
        lbl1.add(btn2);


  */      
         JLabel lbl4 = new JLabel("click on hotel to register" );
        lbl4.setBounds(700,70,1000,100);
        lbl4.setForeground(Color.WHITE);
        lbl4.setFont(new Font("serief",Font.ROMAN_BASELINE,25));
        lbl1.add(lbl4);







        setLayout(null);
        setVisible(true);


//        while(true)(
//            lbl2.setVisible(false);
//            try {
//                Thread.sleep(500);
//            }catch (Exception e){
//
//            }
//            lbl2.setVisible(true);
//            try {
//                Thread.sleep(500);
//            }catch (Exception e)()
       // Try again lol

     while(true){
         lbl2.setVisible(false);
         try {
             Thread.sleep(500);
         }catch(Exception e){

         }
         lbl2.setVisible(true);
        try {
           Thread.sleep(3000);
         }catch (Exception e) {
        }
        }

     }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()== btn1){
        new GameGUI().setVisible(true);
        this.setVisible(false);

     }else if(ae.getSource() ==btn2){
          new GameGUI().setVisible(true);
        this.setVisible(false);
          
         
     }else if (ae.getActionCommand().equals("Hotel")){
          
        }else if(ae.getActionCommand().equals("Login Hotel(admin)")){
            new GameGUI().setVisible(true);
        }
            
        // }else if(ae.getActionCommand().equals("Login Resturant(admin)")){
        //     new Login1().setVisible(true);
            
        // }else if(ae.getActionCommand().equals("Login Customer")){
        //     new Login2().setVisible(true);
            
        // }else if(ae.getActionCommand().equals("Register Customer")){
        //     new Register().setVisible(true);
        
        
        // }else if(ae.getActionCommand().equals("Register CoperateClient")){
        //     new Register2().setVisible(true);
        // }




     }

    public static void main(String[]args){
        new dashboard();
    }

}
