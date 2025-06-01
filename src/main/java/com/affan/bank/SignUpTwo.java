package com.affan.bank;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {

    JTextField   panTextField,adhaarTextField;
    JButton nextButton2;
    JRadioButton sYesButton1,sNoButton1,exisYesButton,existNoButton;
    JComboBox categoryCombo,incomeCombo,qualificationComboBox,occupationComboBox;
    String formno;

    SignUpTwo(String formno){
        this.formno = formno;
        setLayout(null);

        JLabel additionalDetail = new JLabel("Page 2: Additional Details");
        additionalDetail.setFont(new Font("Raleway",Font.BOLD,30));
        additionalDetail.setBounds(290,80,400,40);
        add(additionalDetail);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,22));
        category.setBounds(100,190,200,30);
        add(category);
        String[] castname = {"General","OBC","SC","ST","other"};
        categoryCombo = new JComboBox(castname);
        categoryCombo.setBounds(300,190,400,30);
        add(categoryCombo);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,22));
        income.setBounds(100,240,200,30);
        add(income);
        String[] incomeOptions = {"Below ₹1,00,000", "₹1,00,000 - ₹2,50,000", "₹2,50,001 - ₹5,00,000", "₹5,00,001 - ₹10,00,000",                                    "Above₹1000,000"  };
        incomeCombo = new JComboBox(incomeOptions);
        incomeCombo.setBounds(300,240,400,30);
        add(incomeCombo);


        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,22));
        qualification.setBounds(100,290,200,30);
        add(qualification);
        String[] qualificationOptions = {"10th Pass", "12th Pass", "Diploma", "Graduate", "Postgraduate", "PhD", "Other"};
        qualificationComboBox = new JComboBox(qualificationOptions);
        qualificationComboBox.setBounds(300,290,400,30);
        add(qualificationComboBox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,22));
        occupation.setBounds(100,340,200,30);
        add(occupation);
        String[] occupationOptions = {"Salaried","Self-Employed","Business","Student","Retired","Unemployed","Government Employee",
                "Private Job","Farmer","Other"};
        occupationComboBox = new JComboBox(occupationOptions);
        occupationComboBox.setBounds(300,340,400,30);
        add(occupationComboBox);



        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,22));
        pan.setBounds(100,390,200,30);
        add(pan);
        panTextField = new JTextField();
        panTextField.setBounds(300,390,400,30);
        panTextField.setFont(new Font("Raleway",Font.BOLD,22));
        add(panTextField);

        JLabel adhaar = new JLabel("Adhaar Number:");
        adhaar.setFont(new Font("Raleway",Font.BOLD,22));
        adhaar.setBounds(100,440,200,30);
        add(adhaar);
        adhaarTextField = new JTextField();
        adhaarTextField.setFont(new Font("Raleway",Font.BOLD,14));
        adhaarTextField.setBounds(300,440,400,30);
        add(adhaarTextField);

        JLabel scitizen = new JLabel("Senior citizen :");
        scitizen.setFont(new Font("Raleway",Font.BOLD,22));
        scitizen.setBounds(100,490,200,30);
        add(scitizen);
        sYesButton1 = new JRadioButton("yes");
        sYesButton1.setBackground(Color.white);
        sYesButton1.setBounds(350,490,60,30);
        add(sYesButton1);
        sNoButton1 = new JRadioButton("No");
        sNoButton1.setBackground(Color.white);
        sNoButton1.setBounds(500,490,60,30);
        add(sNoButton1);
        ButtonGroup sgroupButton= new ButtonGroup();
        sgroupButton.add(sYesButton1);
        sgroupButton.add(sNoButton1);



        JLabel existingacc = new JLabel("Existing Account:");
        existingacc.setFont(new Font("Raleway",Font.BOLD,22));
        existingacc.setBounds(100,540,200,30);
        add(existingacc);
        exisYesButton = new JRadioButton("yes");
        exisYesButton.setBackground(Color.white);
        exisYesButton.setBounds(350,540,60,30);
        add(exisYesButton);
        existNoButton = new JRadioButton("No");
        existNoButton.setBackground(Color.white);
        existNoButton.setBounds(500,540,60,30);
        add(existNoButton);
        ButtonGroup egroupButton = new ButtonGroup();
        egroupButton.add(exisYesButton);
        egroupButton.add(existNoButton);



        //button
        nextButton2 = new JButton("Next");
        nextButton2.setBackground(Color.BLACK);
        nextButton2.setForeground(Color.white);
        nextButton2.setBounds(620,660,80,30);
        nextButton2.addActionListener( this);
        add(nextButton2);


        //frame
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }

    //backend

    public void actionPerformed(ActionEvent e) {

        String category  = (String) categoryCombo.getSelectedItem();//typecasting to string
        String income = (String) incomeCombo.getSelectedItem();
        String qualification = (String) qualificationComboBox.getSelectedItem();
        String occupation = (String) occupationComboBox.getSelectedItem();
        String pan = panTextField.getText().toString();
        String adhaar = adhaarTextField.getText().toString();
        String citizen = null;
        if (sYesButton1.isSelected()){
            citizen = "yes";
        }else {
            citizen ="no";
        }
        String existAcc = null;
        if (exisYesButton.isSelected()){
            existAcc = "yes";
        }else if(existNoButton.isSelected()){
            existAcc = "No";
        }


        try {
             Conn conn = new Conn();
             String query = "insert into signuptwo values('"+formno+"','"+category+"','"+income+"','"+qualification+"','"+occupation+"',                                                '"+pan+"','"+adhaar+"','"+citizen+"','"+existAcc+"')";
             conn.s.executeUpdate(query);
             //obj signupthree
            setVisible(false);
            new SignUpThree(formno).setVisible(true);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }



    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
