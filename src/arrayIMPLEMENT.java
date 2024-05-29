import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

class arrayIMPLEMENT extends JFrame implements ActionListener {
    JFrame frame;
    JPanel panel;
    JButton[] itemButtons;
    JButton addToCartButton;
    JLabel cartLabel, quantityLabel;
    JButton increaseQuantityButton, decreaseQuantityButton;
    int quantity = 1;
    double totalPrice = 0.0;
    StringBuilder cartContents = new StringBuilder("<html>Cart:<br>");
    String[] items = {"Food Item 1 - $10.00", "Food Item 2 - $15.00"};
    double[] prices = {10.00, 15.00};
    int selectedIndex = -1;
    Border defaultBorder;

    arrayIMPLEMENT() {
        frame = new JFrame("Display Test");

        // Create a panel to hold content
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 0, 625, 700);

        // Create item buttons
        itemButtons = new JButton[items.length];
        for (int i = 0; i < items.length; i++) {
            itemButtons[i] = new JButton(items[i]);
            itemButtons[i].setBounds(100, 100 + i * 60, 200, 40);
            itemButtons[i].setFocusable(false);
            itemButtons[i].addActionListener(this);
            itemButtons[i].setActionCommand("item" + i);
            panel.add(itemButtons[i]);
        }

        // Create quantity label
        quantityLabel = new JLabel("Quantity: 1");
        quantityLabel.setForeground(Color.WHITE);
        quantityLabel.setBounds(320, 100, 100, 40);
        panel.add(quantityLabel);

        // Create buttons to increase/decrease quantity
        increaseQuantityButton = new JButton("+");
        increaseQuantityButton.setBounds(430, 100, 50, 40);
        increaseQuantityButton.addActionListener(this);
        increaseQuantityButton.setActionCommand("increaseQuantity");
        panel.add(increaseQuantityButton);

        decreaseQuantityButton = new JButton("-");
        decreaseQuantityButton.setBounds(490, 100, 50, 40);
        decreaseQuantityButton.addActionListener(this);
        decreaseQuantityButton.setActionCommand("decreaseQuantity");
        panel.add(decreaseQuantityButton);

        // Create "Add to Cart" button
        addToCartButton = new JButton("Add to Cart");
        addToCartButton.setBounds(100, 100 + items.length * 60, 200, 40);
        addToCartButton.setFocusable(false);
        addToCartButton.addActionListener(this);
        addToCartButton.setActionCommand("addToCart");

        // Create cart label to display added items
        cartLabel = new JLabel(cartContents.toString());
        cartLabel.setForeground(Color.WHITE);
        cartLabel.setBounds(350, 100, 250, 200);

        // Add components to the panel
        panel.add(addToCartButton);
        panel.add(cartLabel);

        // Add the panel to the frame
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(625, 700);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new arrayIMPLEMENT();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.startsWith("item")) {
            int index = Integer.parseInt(command.substring(4));
            selectItem(index);
        } else if (command.equals("addToCart")) {
            if (selectedIndex != -1) {
                cartContents.append(quantity).append(" x ").append(items[selectedIndex]).append("<br>");
                totalPrice += prices[selectedIndex] * quantity;
                itemButtons[selectedIndex].setBorder(defaultBorder); // Reset button border
                selectedIndex = -1;
                quantity = 1; // Reset quantity
                quantityLabel.setText("Quantity: 1"); // Reset quantity label
                updateCartDisplay();
            }
        } else if (command.equals("increaseQuantity")) {
            quantity++;
            quantityLabel.setText("Quantity: " + quantity);
        } else if (command.equals("decreaseQuantity")) {
            if (quantity > 1) {
                quantity--;
                quantityLabel.setText("Quantity: " + quantity);
            }
        }
    }

    private void selectItem(int index) {
        if (selectedIndex != -1) {
            itemButtons[selectedIndex].setBorder(defaultBorder); // Reset previously selected button border
        }
        selectedIndex = index;
        defaultBorder = itemButtons[index].getBorder(); // Store the default border
        itemButtons[index].setBorder(BorderFactory.createLineBorder(Color.BLUE, 3)); // Highlight selected button
    }

    private void updateCartDisplay() {
        cartLabel.setText(cartContents.toString() + "Total Price: $" + totalPrice + "</html>");
    }
}
