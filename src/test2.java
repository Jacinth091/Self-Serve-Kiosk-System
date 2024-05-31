import javax.swing.*;
import java.awt.*;

 class test2 {

    private JPanel itemPanel;

    public test2() {
        JFrame frame = new JFrame("Dynamic Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        JPanel mainPanel = new  JPanel();

        mainPanel.setOpaque(true);
        mainPanel.setVisible(true);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//        mainPanel.setPreferredSize();
        mainPanel.setLayout(new BorderLayout());

        // Main panel with BoxLayout (Vertical)
        itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));

        // Scroll pane to contain the item panel
        JScrollPane scrollPane = new JScrollPane(itemPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(mainPanel, BorderLayout.CENTER);
//        frame.add(scrollPane, BorderLayout.CENTER);

        // Add some buttons to add/remove items for demonstration
        JPanel controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(0, 300));
        JButton addButton = new JButton("Add Item");
        JButton removeButton = new JButton("Remove Item");
        controlPanel.add(addButton);
        controlPanel.add(removeButton);

        frame.add(controlPanel, BorderLayout.SOUTH);

        // Add action listeners to buttons
        addButton.addActionListener(e -> addItem());
        removeButton.addActionListener(e -> removeItem());

        frame.setVisible(true);
    }

    private void addItem() {
        // Create a new item panel
        JPanel newItemPanel = new JPanel();
        newItemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        newItemPanel.setPreferredSize(new Dimension(350, 50));
        newItemPanel.add(new JLabel("Item " + (itemPanel.getComponentCount() + 1)));

        // Add the new item panel to the main panel
        itemPanel.add(newItemPanel);
        itemPanel.revalidate(); // Revalidate the panel to update the layout
        itemPanel.repaint(); // Repaint the panel to refresh the display
    }

    private void removeItem() {
        // Remove the last item if it exists
        int count = itemPanel.getComponentCount();
        if (count > 0) {
            itemPanel.remove(count - 1);
            itemPanel.revalidate();
            itemPanel.repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(test2::new);
    }
}
