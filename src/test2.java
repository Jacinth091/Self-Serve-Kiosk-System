import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class test2 extends JPanel {
    private JPanel itemPanel; // Panel to hold the items in the cart

    public test2() {
        setLayout(new BorderLayout());

        // Create a scroll pane with a fixed preferred size
        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setPreferredSize(new Dimension(300, 100))
        scrollPane.setSize(100,100);

        itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        itemPanel.setSize(300,100);
        scrollPane.setViewportView(itemPanel); // Set itemPanel as the view of the scroll pane
        add(scrollPane, BorderLayout.CENTER);

        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JPanel cont = new JPanel();
//
//                cont.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//                cont.setLayout(new FlowLayout());
////                cont.setSize(300,200);
//                cont.add(new ItemCartCard(212.00, "Item", "Assets/item_pictures/BS/BS-item-1.png"));
                addItemToCart(new ItemCartCard(212.00, "Item", "Assets/item_pictures/BS/BS-item-1.png"));
//                addItemToCart(cont);

            }
        });

        JButton removeButton = new JButton("remove Item");

        add(addButton, BorderLayout.SOUTH);
//        add(removeButton, BorderLayout.SOUTH);
    }

    // Method to add a new item to the cart
    private void addItemToCart(JPanel panel) {
//        JLabel newItemLabel = new JLabel(itemName);
        Border emptyBorder = BorderFactory.createEmptyBorder(5, 0, 0, 0);

        // Set the empty border to the itemPanel to create vertical spacing between items
        itemPanel.setBorder(emptyBorder);
        itemPanel.add(panel);

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
            frame.setSize(600, 600);
            frame.getContentPane().add(new test2());
            frame.setVisible(true);
        });
    }
}
