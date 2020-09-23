package pizzaselectiontest;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PaymentFrame extends JFrame implements ActionListener
{
    //labels for card info to pay
    JLabel name = new JLabel("Name and Surname");
    JLabel address = new JLabel("Address");
    JLabel ccn = new JLabel("Credit Card Number");
    JLabel exp = new JLabel("Expiration Date");
    JLabel cvc = new JLabel("CVC");
  
    JTextField field1 = new JTextField(20);
    JTextField field2 = new JTextField(20);
    JTextField field3 = new JTextField(20);
    JTextField field4 = new JTextField(20);
    JTextField field5 = new JTextField(20);
  
    JButton payButton = new JButton("Pay");
  
    public PaymentFrame(){
        super("Payment");//title
        this.setLayout(new GridLayout(6,2,5,5));
       
        //name and surname
        this.add(name);
        this.add(field1);
       
        //address
        this.add(address);
        this.add(field2);
       
        //credit card number
        this.add(ccn);
        this.add(field3);
       
        //expiration date
        this.add(exp);
        this.add(field4);
       
        //cvc
        this.add(cvc);
        this.add(field5);
       
        //button to pay
        this.add(payButton);
        payButton.addActionListener(this);//when button clicked, will display delivery time message
        this.setBackground(Color.gray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        String deliveryMsg = "Your order will be delivered in 30 minutes.";
        JOptionPane.showMessageDialog(this, deliveryMsg);
        System.exit(0);
    }

}
