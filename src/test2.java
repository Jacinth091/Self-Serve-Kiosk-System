/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class test2 extends JPanel implements ActionListener {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private ItemCard[] itemCards;
    private JButton nextButton;

    public test2() {
        setLayout(new BorderLayout());

        // Initialize CardLayout and JPanel for holding cards
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Initialize array of ItemCards
        itemCards = new ItemCard[6];
        for (int i = 0; i < itemCards.length; i++) {
            itemCards[i] = new ItemCard();
            cardPanel.add(itemCards[i], "Card " + (i + 1));
        }

        // Initialize Next button
        nextButton = new JButton("Next");
        nextButton.addActionListener(this);

        // Add components to main panel
        add(cardPanel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Switch to the next card
        cardLayout.next(cardPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Item Card Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new test2());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}


class ItemCards extends JPanel {
    private JPanel itemCardContParent;
    private JPanel itemCardContainer;
    private JButton itemCardButt;
    private JLabel itemCardLabel;
    private ImageIcon itemCardImage;

    public ItemCards() {
        // Configure itemCardContainer
        setOpaque(true);
        setVisible(true);
        setPreferredSize(new Dimension(300, 200));
        setLayout(new OverlayLayout(this));

        // Configure itemCardContainer
        itemCardContainer = new JPanel();
        itemCardContainer.setOpaque(true);
        itemCardContainer.setVisible(true);
        itemCardContainer.setPreferredSize(new Dimension(300, 200));
        itemCardContainer.setLayout(new BorderLayout());

        // Configure itemCardButt
        itemCardButt = new JButton();
        itemCardButt.setBorder(null);
        itemCardButt.setOpaque(true);
        itemCardButt.setVisible(true);
        itemCardButt.setLayout(new BorderLayout());
//        itemCardButt.addActionListener(this);

        // Configure itemCardLabel
        itemCardLabel = new JLabel();
        itemCardLabel.setBorder(null);
        itemCardLabel.setOpaque(true);
        itemCardLabel.setVisible(true);
        itemCardLabel.setBackground(Color.WHITE);
        itemCardLabel.setHorizontalTextPosition(JLabel.CENTER);
        itemCardLabel.setVerticalTextPosition(JLabel.BOTTOM);
        itemCardLabel.setHorizontalAlignment(JLabel.CENTER);

        // Configure itemCardImage
        itemCardImage = new ImageIcon(getClass().getResource("Assets/item_pictures/BS/BS-item-1.png"));
        itemCardImage = resizeImageIcon(itemCardImage, 100, 70);

        // Add components to itemCardButt
        itemCardButt.add(itemCardLabel, BorderLayout.CENTER);
        itemCardButt.setIcon(itemCardImage);
        itemCardContainer.add(itemCardButt, BorderLayout.CENTER);

        // Add itemCardContainer to this panel
        add(itemCardContainer);
    }

    // Resize ImageIcon method
    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        // Handle button click action
//    }
}

*/
