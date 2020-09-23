package pizzaselectiontest;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Icon;

public class PizzaSelectionFrame extends JFrame implements ActionListener, ItemListener
{
    //string for combo box options then setting combobox to string
    String pizza[] = {"chicken pizza", "pepperoni pizza", "veggie pizza"};
    JComboBox<String> comboMenu = new JComboBox<String>(pizza);
    
    //setting pizza images to icon
    String pizzaNames[] = {"chicken.png", "pepperoni.png", "veggie.png"};
    ImageIcon chickenPic = new ImageIcon("chicken.png");
    ImageIcon pepPic = new ImageIcon("pepperoni.png");
    ImageIcon vegPic = new ImageIcon("veggie.png");
    private final Icon [] pizzaPics = {chickenPic, pepPic, vegPic};
    
    JLabel lblImage = new JLabel();
   
    //buttons for pizza size, setting b1 to true so small is auto picked on open
    JRadioButton size1 = new JRadioButton("Small", true);
    JRadioButton size2 = new JRadioButton("Medium");
    JRadioButton size3 = new JRadioButton("Large");
    ButtonGroup bg = new ButtonGroup();
    
    //checkboxes for toppings
    JCheckBox checkbox1 = new JCheckBox("Mushroom");
    JCheckBox checkbox2 = new JCheckBox("Bacon");
    
    //submit button to submit order
    JButton submitButton = new JButton("Submit Order");
  
    public PizzaSelectionFrame()
    {
        super("Order Pizza");//title
        this.setSize(325, 300);//size of box
        this.setLayout(new FlowLayout());

        lblImage.setIcon(pizzaPics[0]);//sets the image to chicken pic
        //drop down menu 
        add(lblImage);
        add(comboMenu);
        comboMenu.addItemListener(this);
        
        //pizza size
        this.add(new JLabel("Select Size:"));
        bg.add(size1);
        bg.add(size2);
        bg.add(size3);
        this.add(size1);
        this.add(size2);
        this.add(size3);
        
        //pizza toppings
        this.add(new JLabel("Select Topping(s):"));
        this.add(checkbox1);
        this.add(checkbox2);
        
        //submit button
        this.add(submitButton);
        
        //listener for pressing submit button
        submitButton.addActionListener(this);
        
        //listener for changing pizza picture
        comboMenu.addItemListener(this);
        this.setBackground(Color.gray);
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        String pizzaSize;
        int optionDialog;
        
        //setting the size picked to pizzaSize to store it to display in string message
        if(size1.isSelected())
            pizzaSize = "Small";
        else if(size2.isSelected())
            pizzaSize = "Medium";
        else
            pizzaSize = "Large";
        
        //if neither topping is picked then display message
        if((!checkbox1.isSelected()) && (!checkbox2.isSelected()))
        {
            optionDialog = JOptionPane.showOptionDialog(PizzaSelectionFrame.this, 
                    "Order Summary: "+pizzaSize+" "+comboMenu.getSelectedItem().toString(), 
                    "Confirmation", JOptionPane.OK_CANCEL_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
        }
        
        else
        {
            String pizzaTopping;
            
            //if mushroom topping is picked, set to pizzaTopping string to display
            if(checkbox1.isSelected() && !checkbox2.isSelected()){
                pizzaTopping = "Mushroom";
            }
            //if bacon topping picked
            else if(checkbox2.isSelected() && !checkbox1.isSelected()){
                pizzaTopping = "Bacon";
            }
            //if both toppings picked
            else{
                pizzaTopping = "Mushroom and Bacon";
            }
            //setting response to new message that'll display toppings picked
            optionDialog = JOptionPane.showOptionDialog(PizzaSelectionFrame.this, 
                    "Order Summary: "+pizzaSize+" "+comboMenu.getSelectedItem().toString()+" with "+pizzaTopping, 
                    "Confirmation", JOptionPane.OK_CANCEL_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
        }
        
        if(optionDialog == 0)
        {
            new PaymentFrame();//opens payment if OK button clicked
            //hides the pizza selection window
            setVisible(false);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        //if the dropdown menu has been clicked, then change to that new option
        if(e.getStateChange() == ItemEvent.SELECTED){
            //sets the image to what's been clicked on comboMenu
            lblImage.setIcon(pizzaPics[comboMenu.getSelectedIndex()]);
        }
    }
}