package com.affan.bank;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,pinTextField,stateTextField,addressTextField,cityTextField;
    JButton nextButton;
    JRadioButton maleButton,femaleButton,merried,unmerried;
    JDateChooser dateChooser;

    SignUpOne(){
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L)+1000L);
        JLabel formno = new JLabel("Application Form no."+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personlaDetails = new JLabel("Page 1: Personal Details");
        personlaDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personlaDetails.setBounds(290,80,400,30);
        add(personlaDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,200,30);
        dateChooser.setForeground(new Color(122,33,44));
        add(dateChooser);



        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);
        maleButton = new JRadioButton("Male");
        maleButton.setBounds(300,290,60,30);
        maleButton.setBackground(Color.white);
        add(maleButton);
        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(450,290,80,30);
        femaleButton.setBackground(Color.white);
        add(femaleButton);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);


        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,340,200,30);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        JLabel merital = new JLabel("Merital status:");
        merital.setFont(new Font("Raleway",Font.BOLD,22));
        merital.setBounds(100,390,200,30);
        add(merital);
        merried = new JRadioButton("Married");
        merried.setBounds(300,390,100,30);
        merried.setBackground(Color.white);
        add(merried);
        unmerried = new JRadioButton("Unmarried");
        unmerried.setBounds(450,390,100,30);
        unmerried.setBackground(Color.white);
        add(unmerried);
        ButtonGroup meritalGroup = new ButtonGroup();
        meritalGroup.add(merried);
        meritalGroup.add(unmerried);


        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);

        //button
        nextButton = new JButton("Next");
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.white);
        nextButton.setBounds(620,660,80,30);
        nextButton.addActionListener(this);
        add(nextButton);


        //frame
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }

    //backend
    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = ""+ random;
        String name  = nameTextField.getText().toString();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
         if (maleButton.isSelected()){
             gender = "male";
         }else {
             gender ="female";
         }
        String email = emailTextField.getText();
        String merital = null;
        if (merried.isSelected()){
            merital = "merried";
        }else if(unmerried.isSelected()){
            merital = "unmerried";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        if (name.isEmpty()|| fname.isEmpty()||dob.isEmpty()||gender.isEmpty()||email.isEmpty()||merital.isEmpty()||address.isEmpty()||city.isEmpty()||state.isEmpty()||pin.isEmpty()){
            JOptionPane.showMessageDialog(nextButton,"please fill the form", "Alert",0);
        }
        Conn conn = new Conn();
        String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+merital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
        try {
            conn.s.executeUpdate(query);
            setVisible(false);//close the frame visibility
            new SignUpTwo(formno).setVisible(true);//to open the second page signuptwo
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        new SignUpOne();
    }
}
