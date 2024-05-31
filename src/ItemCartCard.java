import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class ItemCartCard extends JPanel {
    private JPanel itemCardContainer;
    private JButton itemCardButt;
    private JLabel itemCardLabel;
    private ImageIcon itemCardImage;

    private Double itemPrice;
    private String itemDescription;
    private String image;
    private String pesoSymbol = "\u20B1";

    public ItemCartCard(Double itemPrice, String itemDescription, String image) {
        // Initialize components
        this.setItemPrice(itemPrice);
        this.setItemDescription(itemDescription);
        this.setImage(image);
        itemCardContainer = new JPanel();
//        itemCardButt = new JButton();
        itemCardLabel = new JLabel();
        itemCardImage = new ImageIcon();

        // Configure itemCardContParent
        setOpaque(true);
        setVisible(true);
        setToolTipText("Item Card Parent Cont");
        setPreferredSize(new Dimension(400, 100));
        setLayout(new BorderLayout());

        // Configure itemCardContainer
        itemCardContainer.setOpaque(true);
        itemCardContainer.setVisible(true);
        itemCardContainer.setPreferredSize(new Dimension(400, 200));
        itemCardContainer.setLayout(new BorderLayout());

//        // Configure itemCardButt
//        itemCardButt.setBorder(null);
//        itemCardButt.setOpaque(true);
//        itemCardButt.setVisible(true);
//        itemCardButt.setName("Card");
//        itemCardButt.setLayout(new BorderLayout());

        // Configure itemCardLabel
        itemCardLabel.setOpaque(true);
        itemCardLabel.setVisible(true);
        itemCardLabel.setBackground(Color.WHITE);
        itemCardLabel.setPreferredSize(new Dimension(400,200));
        itemCardLabel.setText("<html><div style='text-align: center; padding: 10px; display:inline;'>"
                + "<p style='display: inline; color: black; font-weight: bold; font-size: 13px; padding:5px; border: 1px solid black; width: 100px; text-align: center;'>"+ getItemDescription()+" </p> " +
                "<p style='padding-right: 10px;display: inline; color: black; font-weight: bold; font-size: 13px; color:red;'> ₱ "
                + getItemPrice() + "</p></div></html>");


//        itemCardLabel.setHorizontalTextPosition(JLabel.WEST);
//        itemCardLabel.setVerticalTextPosition(JLabel.CENTER);
        itemCardLabel.setHorizontalAlignment(JLabel.CENTER);

        // Configure itemCardImage
        itemCardImage = new ImageIcon(getClass().getResource(image));
        itemCardImage = resizeImageIcon(itemCardImage, itemCardImage.getIconWidth()/3, itemCardImage.getIconHeight()/3);
        itemCardLabel.setIcon(itemCardImage);

        // Add components to the panel
//        itemCard.add(itemCardLabel, BorderLayout.CENTER);
        itemCardContainer.add(itemCardLabel, BorderLayout.CENTER);
        add(itemCardContainer, BorderLayout.CENTER);
    }

         private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    // Setter and getter methods for itemPrice, itemDescription, and image

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // Overridden methods for button properties

    @Override
    public void setBorder(Border border) {
        if (itemCardButt != null) {
            itemCardButt.setBorder(border);
        }
    }

    public void setActionCommand(String command) {
        itemCardButt.setActionCommand(command);
    }

    public void addActionListener(ActionListener listener) {
        itemCardButt.addActionListener(listener);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600,600);
        frame.setLayout(new FlowLayout());


        frame.add(new ItemCartCard(212.00, "Item", "Assets/item_pictures/BS/BS-item-1.png"));
        frame.add(new ItemCartCard(212.00, "Item", "Assets/item_pictures/BS/BS-item-1.png"));
        frame.add(new ItemCartCard(212.00, "Item", "Assets/item_pictures/BS/BS-item-1.png"));
        frame.add(new ItemCartCard(212.00, "Item", "Assets/item_pictures/BS/BS-item-1.png"));
        frame.repaint();
        frame.revalidate();
    }
}
