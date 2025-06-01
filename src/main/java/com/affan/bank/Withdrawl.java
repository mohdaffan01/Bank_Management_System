package com.affan.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    JButton withdrawButton, backButton;
    JTextField amount;
    String pinNumber;

    Withdrawl(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/whiteblank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw :");
        text.setBounds(280, 200, 450, 40);
        text.setFont(new Font("System", Font.BOLD, 18));
        image.add(text);

        amount = new JTextField();
        amount.setBounds(250, 400, 450, 40);
        amount.setFont(new Font("System", Font.BOLD, 40));
        image.add(amount);

        //button
        backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.white);
        backButton.setBounds(300, 500, 100, 40);
        backButton.addActionListener(this);
        image.add(backButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBackground(Color.BLACK);
        withdrawButton.setForeground(Color.white);
        withdrawButton.setBounds(550, 500, 100, 40);
        withdrawButton.addActionListener(this);
        image.add(withdrawButton);


        //Frame
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdrawButton) {
            String number = amount.getText();
            Date date = new Date();
            if (number.isEmpty()) {
                JOptionPane.showMessageDialog(null, "please enter the amount!");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pinNumber + "','" + date + "','Withdrawl','" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " withdraw successfully");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == backButton) {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }

    }
    public static void main (String[]args){
        new Withdrawl("");
    }
}

