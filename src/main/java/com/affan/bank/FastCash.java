package com.affan.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class FastCash extends JFrame implements ActionListener {

    JButton rs100,rs500,rs1000,rs2000,rs5000,rs10000,backButton;
    String pinNumber;
    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/whiteblank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        //text
        JLabel text = new JLabel("------Please select the Withrawl amount------");
        text.setBounds(280 ,200,600,30);
        text.setFont(new Font("System",Font.BOLD,18));
        image.add(text);

        //button
        rs100 = new JButton("Rs 100");
        rs100.setBounds(200,400,200,30);
        rs100.setBackground(Color.BLACK);
        rs100.setForeground(Color.white);
        rs100.addActionListener(this);
        image.add(rs100);

        rs500 = new JButton("Rs 500");
        rs500.setBounds(500,400,200,30);
        rs500.setBackground(Color.BLACK);
        rs500.setForeground(Color.white);
        rs500.addActionListener(this);
        image.add(rs500);

        rs1000 = new JButton("Rs 1000");
        rs1000.setBounds(200,460,200,30);
        rs1000.setBackground(Color.BLACK);
        rs1000.setForeground(Color.white);
        rs1000.addActionListener(this);
        image.add(rs1000);

        rs2000 = new JButton("Rs 2000");
        rs2000.setBounds(500,460,200,30);
        rs2000.setBackground(Color.BLACK);
        rs2000.setForeground(Color.white);
        rs2000.addActionListener(this);
        image.add(rs2000);

        rs5000 = new JButton("Rs 5000");
        rs5000.setBounds(200,520,200,30);
        rs5000.setBackground(Color.BLACK);
        rs5000.setForeground(Color.white);
        rs5000.addActionListener(this);
        image.add(rs5000);

        rs10000 = new JButton("Rs 10000");
        rs10000.setBounds(500,520,200,30);
        rs10000.setBackground(Color.BLACK);
        rs10000.setForeground(Color.white);
        rs10000.addActionListener(this);
        image.add(rs10000);

        backButton = new JButton("Back");
        backButton.setBounds(350,580,200,30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.white);
        backButton.addActionListener(this);
        image.add(backButton);





        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==backButton) {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != backButton && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient amount ");
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"', '"+date+"' , 'Withdrawl' , '"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null , "Rs "+amount+ " Debited successfully");

                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
