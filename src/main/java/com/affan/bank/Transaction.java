package com.affan.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

    JButton depositbutton,withdrawl,fastCash,ministatement,pinChange,balanceEnq,exitb;
    String pinNumber;
    Transaction(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/whiteblank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        //text
        JLabel text = new JLabel("------Please select your transaction------");
        text.setBounds(280 ,200,600,30);
        text.setFont(new Font("System",Font.BOLD,18));
        image.add(text);

        //button
        depositbutton = new JButton("Deposit");
        depositbutton.setBounds(200,400,200,30);
        depositbutton.setBackground(Color.BLACK);
        depositbutton.setForeground(Color.white);
        depositbutton.addActionListener(this);
        image.add(depositbutton);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(500,400,200,30);
        withdrawl.setBackground(Color.BLACK);
        withdrawl.setForeground(Color.white);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(200,460,200,30);
        fastCash.setBackground(Color.BLACK);
        fastCash.setForeground(Color.white);
        fastCash.addActionListener(this);
        image.add(fastCash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(500,460,200,30);
        ministatement.setBackground(Color.BLACK);
        ministatement.setForeground(Color.white);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(200,520,200,30);
        pinChange.setBackground(Color.BLACK);
        pinChange.setForeground(Color.white);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnq = new JButton("Balance Enquiry");
        balanceEnq.setBounds(500,520,200,30);
        balanceEnq.setBackground(Color.BLACK);
        balanceEnq.setForeground(Color.white);
        balanceEnq.addActionListener(this);
        image.add(balanceEnq);

        exitb = new JButton("Exit");
        exitb.setBounds(350,580,200,30);
        exitb.setBackground(Color.BLACK);
        exitb.setForeground(Color.white);
        exitb.addActionListener(this);
        image.add(exitb);





        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==exitb) {
            System.exit(0);
        }
        else if (ae.getSource() == depositbutton) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if (ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        } else if (ae.getSource() == balanceEnq) {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        } else if (ae.getSource() == ministatement) {
            new MiniStatement(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
