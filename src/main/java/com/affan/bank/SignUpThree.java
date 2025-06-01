package com.affan.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {


    JRadioButton savingAccRadio,fixedAccRadio,currentAccRadio,recurringAccRadio;
    JCheckBox atmCardCheckb,netbankCheck,mobbankCheck,emailalertCheck,chequebookCheck,estatementCheck,herebyCheckbox;
    JButton submitButton,cancelButton;
    String formno;

    SignUpThree( String formno){
        this.formno= formno;
        JLabel accDetLebel = new JLabel("Page 3: Account Details");
        accDetLebel.setFont(new Font("Raleway",Font.BOLD,30));
        accDetLebel.setBounds(280,40,400,40);
        add(accDetLebel);

        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("Raleway",Font.BOLD,22));
        accountType.setBounds(100,140,200,30);
        add(accountType);

        savingAccRadio = new JRadioButton("Saving Account");
        savingAccRadio.setBackground(Color.white);
        savingAccRadio.setBounds(100,180,200,30);
        add(savingAccRadio);

        fixedAccRadio = new JRadioButton("Fixed Deposit Account");
        fixedAccRadio.setBackground(Color.white);
        fixedAccRadio.setBounds(400,180,200,30);
        add(fixedAccRadio);

        currentAccRadio = new JRadioButton("Current Account");
        currentAccRadio.setBackground(Color.white);
        currentAccRadio.setBounds(100,220,200,30);
        add(currentAccRadio);

        recurringAccRadio = new JRadioButton("Recurring Deposit Acount");
        recurringAccRadio.setBackground(Color.white);
        recurringAccRadio.setBounds(400,220,200,30);
        add(recurringAccRadio);
        ButtonGroup chooseAccType = new ButtonGroup();
        chooseAccType.add(savingAccRadio);
        chooseAccType.add(fixedAccRadio);
        chooseAccType.add(currentAccRadio);
        chooseAccType.add(recurringAccRadio);

        JLabel cardLabel = new JLabel("Card Number");
        cardLabel.setFont(new Font("Raleway",Font.BOLD,30));
        cardLabel.setBounds(100,300,200,30);
        add(cardLabel);
        JLabel cardNoLabel = new JLabel("XXXX-XXXX-XXXX-1234");
        cardNoLabel.setFont(new Font("Raleway",Font.PLAIN,22));
        cardNoLabel.setBounds(350,300,300,30);
        add(cardNoLabel);

        JLabel pinLabel = new JLabel("PIN");
        pinLabel.setFont(new Font("Raleway",Font.BOLD,30));
        pinLabel.setBounds(100,360,200,30);
        add(pinLabel);
        JLabel pinNOLabel = new JLabel("XXXX");
        pinNOLabel.setFont(new Font("Raleway",Font.PLAIN,22));
        pinNOLabel.setBounds(350,360,200,30);
        add(pinNOLabel);

        JLabel servicelabel = new JLabel("Service Required");
        servicelabel.setFont(new Font("Raleway",Font.BOLD,25));
        servicelabel.setBounds(100,440,300,30);
        add(servicelabel);
        //checkbox
        atmCardCheckb = new JCheckBox("Atm Card");
        atmCardCheckb.setBounds(100,480,200,30);
        atmCardCheckb.setBackground(Color.white);
        add(atmCardCheckb);

        netbankCheck = new JCheckBox("Internet Banking");
        netbankCheck.setBounds(300,480,200,30);
        netbankCheck.setBackground(Color.white);
        add(netbankCheck);

        mobbankCheck = new JCheckBox("Mobile Banking");
        mobbankCheck.setBounds(100,520,200,30);
        mobbankCheck.setBackground(Color.white);
        add(mobbankCheck);

        emailalertCheck = new JCheckBox("Email & sms alert");
        emailalertCheck.setBounds(300,520,200,30);
        emailalertCheck.setBackground(Color.white);
        add(emailalertCheck);

        chequebookCheck = new JCheckBox("Cheque Book");
        chequebookCheck.setBounds(100,560,200,30);
        chequebookCheck.setBackground(Color.white);
        add(chequebookCheck);

        estatementCheck = new JCheckBox("E-Statement");
        estatementCheck.setBounds(300,560,200,30);
        estatementCheck.setBackground(Color.white);
        add(estatementCheck);

        herebyCheckbox = new JCheckBox("I hereby declare that above entered details are correct to the best of my knowledge.");
        herebyCheckbox.setBounds(100,620,500,30);
        herebyCheckbox.setBackground(Color.white);
        add(herebyCheckbox);

        //Button
        submitButton = new JButton("Submit");
        submitButton.setBounds(450,680,100,30);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.white);
        submitButton.addActionListener(this);
        add(submitButton);
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(300,680,100,30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.white);
        cancelButton.addActionListener(this);
        add(cancelButton);






        setSize(850,820);
        getContentPane().setBackground(Color.white);
        setLocation(350,0);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submitButton){
                String accountType = null;
                  if(savingAccRadio.isSelected()){
                      accountType = "Saving account";
                  } else if(fixedAccRadio.isSelected()){
                      accountType = "fixed deposit account";
                   }else if (currentAccRadio.isSelected()){
                      accountType ="Current Account";
                   }else if (recurringAccRadio.isSelected()){
                      accountType = "Recurring Deposit Account";
                   }

                  //card no and pin no. gnerate
                Random random = new Random();
                String cardnumber = ""+Math.abs(random.nextLong() % 90000000L) + 67890000L;
                String pinNumber = "" +Math.abs((random.nextLong() % 9000L)+ 1000);

                String services = "";
                  if (atmCardCheckb.isSelected()){
                      services =services + " atm card";
                  }  if (netbankCheck.isSelected()) {
                      services = services + " internet banking";
                  } if (mobbankCheck.isSelected()) {
                      services = services + " mobile banking";
                  }  if (emailalertCheck.isSelected()) {
                      services = services +" email&sms alert";
                  }  if (chequebookCheck.isSelected()) {
                      services = services+" cheque book";
                  }  if (estatementCheck.isSelected()) {
                      services = services + " e-statement";
                  }
                  try{
                      if (services.isEmpty() && accountType.isEmpty()){
                          JOptionPane.showMessageDialog(null,"please fill the form");
                      } else  {
                          Conn conn = new Conn();
                          String query1 ="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinNumber+"','"+services+"')";
                          String query2 ="insert into login values('"+formno+"','"+cardnumber+"','"+pinNumber+"')";
                          conn.s.executeUpdate(query1);
                          conn.s.executeUpdate(query2);
                          JOptionPane.showMessageDialog(null,"Card Number:"+cardnumber+"\n Pin Number:"+pinNumber);

                          setVisible(false);
                          new Deposit(pinNumber).setVisible(true);

                      }
                  }catch (Exception e1){
                      System.out.println(e1);
                  }

            }else if (e.getSource() == cancelButton) {
                    setVisible(false);
                    new Login().setVisible(true);
            }
    }

    public static void main(String[] args) {
        new SignUpThree("");
    }
}
