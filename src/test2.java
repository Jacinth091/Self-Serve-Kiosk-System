import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class test2 extends JFrame implements ActionListener {
    private double[][] foodPrice = {
            // Best Sellers
            {212.00, 137.00, 40.00, 122.00, 103.00, 82.00},
            // Chicken Joy
            {163.00, 132.00, 82.00, 148.00, 128.00, 679.00},
            // Jolly Spaghetti
            {237.00, 679.00, 137.00, 108.00, 60.00, 212.00},
            // Beverages
            {80.00, 64.00, 57.00, 53.00, 53.00, 53.00},
    };

    private JButton[][] buttons;

    // Constructor to initialize the application
    test2(int width, int height, String title, boolean isVisible, boolean isResizable, LayoutManager layout, int defCloseOper) {
        initApp(width, height, title, isVisible, isResizable, layout, defCloseOper);
        initUi();
    }

    // Method to initialize the application window
    private void initApp(int width, int height, String title, boolean isVisible, boolean isResizable, LayoutManager layout, int defCloseOper) {
        setTitle(title);
        setSize(width, height);
        setResizable(isResizable);
        setDefaultCloseOperation(defCloseOper);
        setVisible(isVisible);
    }

    // Method to initialize the user interface
    private void initUi() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(foodPrice.length, foodPrice[0].length));

        buttons = new JButton[foodPrice.length][foodPrice[0].length];


        for (int i = 0; i < foodPrice.length; i++) {
            for (int j = 0; j < foodPrice[i].length; j++) {
                buttons[i][j] = new JButton(String.valueOf(foodPrice[i][j]));
                buttons[i][j].setVisible(true);
                buttons[i][j].setOpaque(true);
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
                buttons[i][j].addActionListener(this);
                buttons[i][j].setActionCommand(i + "-" + j); // Using row-column index as action command
                panel.add(buttons[i][j]);
            }
        }

        add(panel);
    }

    // ActionPerformed method to handle button clicks and other events
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        int row = Integer.parseInt(command.split("-")[0]);
        int col = Integer.parseInt(command.split("-")[1]);
        double price = foodPrice[row][col];
        System.out.println("Price of selected item: " + price);
    }

    // Main method to start the application
    public static void main(String[] args) {
        // Create an instance of MenuApp and set its properties
        new  test2(800, 600, "Menu Application", true, false, null, JFrame.EXIT_ON_CLOSE);
    }
}
