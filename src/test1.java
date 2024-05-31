import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class test1 extends JPanel {
    private JPanel itemPanel; // Panel to hold the items in the cart

    public test1() {
        setLayout(new BorderLayout());

        itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(itemPanel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                addItemToCart("New Item");
            }
        });
        buttonPanel.add(addButton);

        JButton removeButton = new JButton("Remove Item");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItemFromCart();
            }
        });
        buttonPanel.add(removeButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Method to add a new item to the cart
    private void addItemToCart(String itemDesc, String itemCateg, double itemPrice, int itemQuant, double itemPriceTimesQuant) {
        JPanel newItemLabel = new JPanel();
//        newItemLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        newItemLabel.setPreferredSize(new Dimension(300, 100)); // Adjusted size
        newItemLabel.setMaximumSize(new Dimension(300, 100)); // To ensure it doesn't resize
        newItemLabel.setLayout(new BorderLayout());

        String labelText = "<html><div style='padding: 5px;'>" +
                "<p style='font-weight: bold;'>Item Description: " + itemDesc + "</p>" +
                "<p style='font-weight: bold;'>Item Category: " + itemCateg + "</p>" +
                "<p style='font-weight: bold;'>Item Price: " + itemPrice + "</p>" +
                "<p style='font-weight: bold;'>Item Quantity: " + itemQuant + "</p>" +
                "<p style='font-weight: bold;'>Item Price Times Quantity: " + itemPriceTimesQuant + "</p>" +
                "</div></html>";

        JLabel itemLabel = new JLabel(labelText);
        itemLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        itemLabel.setPreferredSize(new Dimension(300, 100)); // Adjusted size
        itemLabel.setMaximumSize(new Dimension(300, 100)); // To ensure it doesn't resize
        itemLabel.setBackground(Color.yellow);
        itemLabel.setOpaque(true);



        newItemLabel.add(itemLabel, BorderLayout.CENTER);

        itemPanel.add(newItemLabel);
        // Repaint the panel to reflect the addition of the new item
        itemPanel.revalidate();
        itemPanel.repaint();
    }

    // Method to remove an item from the cart
    private void removeItemFromCart() {
        Component[] components = itemPanel.getComponents();
        if (components.length > 0) {
            itemPanel.remove(components[components.length - 1]);
            // Repaint the panel to reflect the removal of the item
            itemPanel.revalidate();
            itemPanel.repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Cart Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400); // Adjusted frame size for better visibility
            frame.getContentPane().add(new test1());
            frame.setVisible(true);
        });
    }
}
