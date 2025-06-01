package com.affan.bank;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    String pinNumber;
    MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;



        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel mini = new JLabel();
        mini.setBounds(20,120,300,80);
        add(mini);



        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,300,300,20);
        add(balance);

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pinNo = '"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card number :"+rs.getString("cardNo"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin ='"+pinNumber+"' ");
            String text = "<html>";
            while (rs.next()) {
                text += rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs.getString("amount") + "<br>";
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            text += "</html>";
            mini.setText(text);
            balance.setText("Your current balance account is Rs "+bal);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }




        setLayout(null);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
