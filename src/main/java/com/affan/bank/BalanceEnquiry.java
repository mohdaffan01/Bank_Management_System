package com.affan.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinNumber;
    JButton back;

    BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/whiteblank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        //button

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(380,460,100,30);
        back.addActionListener(this);
        image.add(back);

        Conn conn = new Conn();
        int balance = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        JLabel text = new JLabel("Your current balance is Rs.  "+balance);
        text.setFont(new Font("System",Font.BOLD,20));
        text.setBounds(200,380,500,30);
        image.add(text);



        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
