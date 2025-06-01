package com.affan.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.SQLException;

public class Login extends Frame implements ActionListener{
    JButton clearButton,signUpButton,signInButton;//if we use this button out of the constructor:- login()
    JTextField cardTextfield,pinTextfield;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);//if we do not use this then the image align in center
        // TO INSERT THE IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/FIRST.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);//set size
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,30,100,100); //why label set because the image in upper on label
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(220,50,400,40);
        add(text);

        //card no
        JLabel cardno = new JLabel("Card no :");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        cardTextfield = new JTextField();
        cardTextfield.setBounds(300,150,190,30);
        cardTextfield.setFont(new Font("Arial",Font.BOLD,15));
        add(cardTextfield);


        //for pin
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,150,30);
        add(pin);
        pinTextfield = new JTextField();
        pinTextfield.setBounds(300,220,190,30);
        pinTextfield.setFont(new Font("Arial",Font.BOLD,15));
        add(pinTextfield);

        //button
        signInButton = new JButton("SIGN IN");
        signInButton.setBackground(Color.black);
        signInButton.setForeground(Color.white);
        signInButton.setBounds(300,290,90,30);
        signInButton.addActionListener(this);
        add(signInButton);

        clearButton = new JButton("CLEAR");
        clearButton.setBackground(Color.black);
        clearButton.setForeground(Color.white);
        clearButton.setBounds(400,290,90,30);
        clearButton.addActionListener(this);
        add(clearButton);

        signUpButton = new JButton("SIGN UP");
        signUpButton.setBackground(Color.black);
        signUpButton.setForeground(Color.white);
        signUpButton.setBounds(300,330,190,30);
        signUpButton.addActionListener(this);
        add(signUpButton);

        //frame
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clearButton){
            cardTextfield.setText("");//these lines is used to empty the textfield
            pinTextfield.setText("");
            
        } else if (ae.getSource() == signInButton) {
            Conn conn = new Conn();
            String cardnumber = cardTextfield.getText();
            String pinNumber = pinTextfield.getText();
            String query = "select * from login where cardNO ='"+cardnumber+"' and pinNO = '"+pinNumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card number or pin");
                }

            } catch (SQLException e) {
                System.out.println(e);
            }

        }else if(ae.getSource() == signUpButton) {
            setVisible(false);
            new SignUpOne().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new Login();
    }


}
