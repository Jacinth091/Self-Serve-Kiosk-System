/*
 * NAMES: BARRAL, JACINTH CEDRIC
 *        LAROCO, JAN LORENZ
 *        ABAIS, ALDRIE
 *        SATORRE, LANCE TIMOTHY
 * DATE: 5/31/24
 * DESCRIPTION: FINAL PROJECT IN COMPUTER PROGRAMMING BYE SIR THANKYOU
 *          
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ItemCard extends JPanel{
//    private JPanel itemCardContParent;
    private JPanel itemCardContainer;
    private JButton itemCardButt;
    private JLabel itemCardLabel;
    private ImageIcon itemCardImage;

    private Double item_Price;
    private String item_Desc;
    private ImageIcon image;

    public ItemCard(){

    }

    public ItemCard(Double item_Price, String item_Desc, ImageIcon image) {
        // Initialize components
        this.item_Price = item_Price;
        this.item_Desc = item_Desc;
        this.image = image;
        itemCardContainer = new JPanel();
        itemCardButt = new JButton();
        itemCardLabel = new JLabel();
        itemCardImage = new ImageIcon();

        // Configure itemCardContParent
        setOpaque(true);
        setVisible(true);
        setToolTipText("Item Card Parent Cont");
        setPreferredSize(new Dimension(300, 200));
        setLayout(new OverlayLayout(this));

        // Configure itemCardContainer
        itemCardContainer.setOpaque(true);
        itemCardContainer.setVisible(true);
        itemCardContainer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        itemCardContainer.setPreferredSize(new Dimension(300, 200));
        itemCardContainer.setLayout(new BorderLayout());

        // Configure itemCardButt
        itemCardButt.setBorder(null);
        itemCardButt.setOpaque(true);
        itemCardButt.setVisible(true);
        itemCardButt.setName("Card");
        itemCardButt.setLayout(new BorderLayout());

        // Configure itemCardLabel
        itemCardLabel.setOpaque(true);
        itemCardLabel.setVisible(true);
        itemCardLabel.setBackground(Color.WHITE);
        itemCardLabel.setText("<html><div style='text-align: center;'><p style='color: red; font-weight: bold; text-align: center; font-size: 13px; padding:5px;'> ₱ "+ item_Price+"0"+"</p>" +
                        "<p style='color: Black; font-weight: bold; font-size: 10px;'>"+item_Desc+"</p></div></html>");

        itemCardLabel.setHorizontalTextPosition(JLabel.CENTER);
        itemCardLabel.setVerticalTextPosition(JLabel.BOTTOM);
        itemCardLabel.setHorizontalAlignment(JLabel.CENTER);

        // Configure itemCardImage (Note: You may want to pass image path as a parameter)
        itemCardImage = image;
//        itemCardImage = resizeImageIcon(itemCardImage, (itemCardImage.getIconWidth()/3), (itemCardImage.getIconHeight()/3) );

        itemCardLabel.setIcon(itemCardImage);

        // Add components to the panel
        itemCardButt.add(itemCardLabel, BorderLayout.CENTER);
        itemCardContainer.add(itemCardButt, BorderLayout.CENTER);
        add(itemCardContainer);

    }

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

}
