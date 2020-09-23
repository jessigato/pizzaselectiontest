package pizzaselectiontest;

import javax.swing.JFrame;

public class PizzaSelectionTest
{
    public static void main(String[] args)
    {
        PizzaSelectionFrame frame = new PizzaSelectionFrame();
        frame.setSize(325, 300);//size for pizza selection
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
