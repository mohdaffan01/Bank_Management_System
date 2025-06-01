package com.affan.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JButton change,back;
    JTextField pinTextField,repinTextField;
    String pinNumber;
    PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/whiteblank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change your pin : ");
        text.setBackground(Color.white);
        text.setForeground(Color.black);
        text.setFont(new Font("Raleway",Font.BOLD,30));
        text.setBounds(350,200,500,40);
        image.add(text);

        JLabel pinText = new JLabel("New Pin:");
        pinText.setBackground(Color.white);
        pinText.setForeground(Color.black);
        pinText.setFont(new Font("Raleway",Font.BOLD,16));
        pinText.setBounds(160,300,200,40);
        image.add(pinText);

        pinTextField = new JTextField();
        pinTextField.setBackground(Color.white);
        pinTextField.setForeground(Color.black);
        pinTextField.setFont(new Font("Raleway",Font.BOLD,16));
        pinTextField.setBounds(380,300,300,40);
        image.add(pinTextField);


        JLabel pinText1 = new JLabel("Re-enter new Pin:");
        pinText1.setBackground(Color.white);
        pinText1.setForeground(Color.black);
        pinText1.setFont(new Font("Raleway",Font.BOLD,16));
        pinText1.setBounds(160,360,500,40);
        image.add(pinText1);

        repinTextField = new JTextField();
        repinTextField.setBackground(Color.white);
        repinTextField.setForeground(Color.black);
        repinTextField.setFont(new Font("Raleway",Font.BOLD,16));
        repinTextField.setBounds(380,360,300,40);
        image.add(repinTextField);

        //button
        change = new JButton("Change");
        change.setBackground(Color.black);
        change.setForeground(Color.white);
        change.setBounds(580,460,100,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(380,460,100,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == change){
            try{
                String newPin = pinTextField.getText();
                String repin = repinTextField.getText();
                if (!newPin.equals(repin)){
                    JOptionPane.showMessageDialog(null,"Enter both pin not same");
                    return;
                }
                if (newPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new pin");
                    return;
                }
                if (repin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter new pin");
                    return;
                }
                Conn conn = new Conn();
                String query1  = "update bank set pin = '"+repin+"' where pin = '"+pinNumber+"'";
                String query2  = "update login set pinNo = '"+repin+"' where pinNo = '"+pinNumber+"'";
                String query3  = "update signupthree set pinNo = '"+repin+"' where pinNo = '"+pinNumber+"'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"Pin change successfully");
                setVisible(false);
                new Transaction(repin).setVisible(true);


            }catch (Exception e){
                System.out.println(e);
            }
        }else {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("");//.setvisible(
    }
}
