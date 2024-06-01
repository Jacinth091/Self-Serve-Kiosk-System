/*
 * NAMES: BARRAL, JACINTH CEDRIC
 *        LAROCO, JAN LORENZ
 *        ABAIS, ALDRIE
 *        SATORRE, LANCE TIMOTHY
 * DATE: 5/31/24
 * DESCRIPTION: FINAL PROJECT IN COMPUTER PROGRAMMING BYE SIR THANKYOU
 *          
 */

 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.kerberos.KerberosCredMessage;
import javax.swing.*;
import javax.swing.border.Border;
class Framess extends JFrame implements ActionListener, MouseListener {

    
    JFrame[] frames = new JFrame[2];
    JPanel[] panels = new JPanel[20];

    private JPanel itemPanel; // Panel to hold the items in the cart


    JLabel[] labels = new JLabel[20];
    JButton[] buttons = new JButton[20];
    ImageIcon[] image = new ImageIcon[10];
    Border border, border1, border2, border3, border4, borderForEdit;
    JButton COD, CARD;
    private userCartItemData userCartItems;
    private String itemDesc;
    private String itemCateg;
    private double itemPrice;
    private int itemQuant;
    private double itemPriceTimesQuant;
    private int itemLROW;
    private int itemLCOL;
    private double totalItemPrice;
    private String tcp;

    private UserCart shoppingCart = new UserCart();


    List<ItemDataAtt> cartDataList = new ArrayList<>();

    MenuApp menuApp = new MenuApp();

    Framess() {
    }
    public Framess(MenuApp menuApp) {
        this.menuApp = menuApp;
        this.userCartItems = menuApp;

        initFrame();
    }



    private void initFrame() {
        menuApp.addMouseListener(this);

        for (int i = 0; i < 2; i++) {
            frames[i] = new JFrame();
        }
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
        }
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
        }
        for (int i = 0; i < image.length; i++) {
            image[i] = new ImageIcon();
        }

        // START OF REVIEW FRAME *************************************************************************************
        // BORDER =====================================================================================
        border = BorderFactory.createLineBorder(Color.white, 2);
        border1 = BorderFactory.createLineBorder(Color.black, 5);
        border2 = BorderFactory.createLineBorder((new Color(222, 187, 6, 255)), 5);
        border3 = BorderFactory.createLineBorder((new Color(0, 94, 32, 255)), 5);
        border4 = BorderFactory.createLineBorder(new Color(222, 187, 6, 255), 5);
        borderForEdit = BorderFactory.createLineBorder(Color.black, 3);
       
        // ICON OR IMAGE ==============================================================================
        image[0] = new ImageIcon("src/Assets/Icons/Joli-Logo.png"); // jollibee picture
        ImageIcon scaledIcon = new ImageIcon(image[0].getImage().getScaledInstance(170, 70, Image.SCALE_SMOOTH));

        image[1] = new ImageIcon("src/Assets/Icons/check-Icon2.png"); // CHECK LOGO sa PROCEED PAYMENT
        ImageIcon scaledCheck = new ImageIcon(image[1].getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));


        // LABEL ======================================================================================
        labels[0] = new JLabel(); // TOP / REVIEW YOUR ORDER
        labels[0].setIcon(scaledIcon);
        labels[0].setText("REVIEW YOUR ORDER");
        labels[0].setForeground(Color.WHITE);
        labels[0].setFont(new Font("ARIAL", Font.BOLD, 30));

        labels[1] = new JLabel(); // ORDER TOTAL
        // labels[1].setText("ORDER TOTAL");
        labels[1].setBounds(45,-10, 150, 50);
        labels[1].setFont(new Font("ARIAL", Font.BOLD, 15));

        labels[2] = new JLabel(); // TOTAL PRICE
        // labels[2].setText("P200.00");
        labels[2].setText("<html><div style='text-align: center;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 12px;'>Order Total: <span style='color: Black; font-weight: bold; font-size: 20;'<br>" + menuApp.getTotalCartPrice() +"0" + " <br></span> </p></div></html>");
        labels[2].setBounds(55,5, 150, 50);
        labels[2].setFont(new Font("ARIAL", Font.BOLD, 16));

        // BUTTON ====================================================================================
        buttons[0] = new JButton("PROCEED TO PAYMENT"); // PROCEED BUTTON
        buttons[0].setForeground(Color.BLACK);
        buttons[0].setFont(new Font("Arial", Font.BOLD, 11));
        buttons[0].setBackground(new Color(4, 136, 43));
        buttons[0].setBounds(428, 12, 171, 50);
        buttons[0].setIcon(scaledCheck);
        buttons[0].setBorder(border3);
        buttons[0].addActionListener(this);
        buttons[0].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttons[0].setFocusable(false);


        buttons[1] = new JButton("CLOSE"); // BACK BUTTON
        buttons[1].setForeground(Color.WHITE);
        buttons[1].setFont(new Font("ARIAL", Font.BOLD, 16));
        buttons[1].setBackground(new Color(99, 0, 0));
        buttons[1].setBounds(10, 10, 150, 50);
        buttons[1].addActionListener(this);
        buttons[1].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttons[1].setFocusable(false);
        buttons[1].setBorder(border);

        
     
        // PANEL =================================================================================

        panels[0] = new JPanel(); // GRAY COLOR
        panels[0].setBackground(Color.DARK_GRAY);
        panels[0].setBounds(0, 0, 610, 90);
        panels[0].setLayout(new BorderLayout());
        panels[0].setBorder(border2);

        panels[1] = new JPanel(); // RED COLOR kanang 2nd COLOR
        panels[1].setBackground(new Color(99, 0, 0));
        panels[1].setBounds(0, 90, 610, 80);
        panels[1].setLayout(null);

        panels[2] = new JPanel(); // DARK RED kanang UBOS
        panels[2].setBackground(new Color(99, 0, 0));
        panels[2].setBounds(0, 590, 610, 80);
        panels[2].setLayout(null);
        panels[2].setBorder(border1);
        panels[2].add(buttons[0]);
        panels[2].add(buttons[1]);

        panels[3] = new JPanel(); // WHITE COLOR, kanang center dako nga white
        panels[3].setBackground(Color.WHITE);
        panels[3].setOpaque(true);
        panels[3].setVisible(true);
        panels[3].setBounds(4, 180, 600, 400);
        panels[3].setLayout(new BorderLayout());

        JPanel test = new JPanel();

        test.setOpaque(true);
        test.setVisible(true);
        test.setLayout(new BorderLayout());

        itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(itemPanel);
        test.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton removeButton = new JButton("REMOVE ITEM");
        removeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        removeButton.setBackground(new Color(99, 0, 0));
        removeButton.setForeground(Color.white);
        removeButton.setFocusable(false);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItemFromCart(0);
            }
        });
        buttonPanel.add(removeButton);

        test.add(buttonPanel, BorderLayout.SOUTH);

        panels[3].add(test, BorderLayout.CENTER);



        panels[4] = new JPanel(); // PANEL SA ORDER TOTAL kanang babaw  sa PROCEED button
        panels[4].setBackground(new Color(222, 187, 6, 255));
        panels[4].setBounds(200, 8, 200, 60);
        panels[4].setLayout(null);
        panels[4].setBorder(border1);
        panels[4].add(labels[1]);
        panels[4].add(labels[2]);

        panels[5] = new JPanel(); // YELLOW LINE kanang babaw sa EDIT ORDER
        panels[5].setBackground(new Color(222, 187, 6, 255));
        panels[5].setBounds(0, 100, 610, 10);


        // FRAME ==========================================================================================

        frames[0].setTitle("REVIEW YOUR ORDER - (L.A.B.S)");
        frames[0].setSize(625, 700);
        frames[0].setLayout(null);
        frames[0].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frames[0].setVisible(true);
        frames[0].setResizable(false);
        frames[0].setLocationRelativeTo(menuApp);
        panels[0].add(labels[0]);
        frames[0].add(panels[5]);
        panels[2].add(panels[4]);
        frames[0].add(panels[0]);
        frames[0].add(panels[2]);
        frames[0].add(panels[3]);
        frames[0].add(panels[1]);
       
        int x = 700;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 16;
        frames[0].setLocation(x,y);
        frames[0].revalidate();
        frames[0].repaint();

        //=============================================================
        ImageIcon  card = new ImageIcon("src/Assets/Icons/credit.png"); // credit picture
        ImageIcon cards = new ImageIcon(card.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH));

        ImageIcon  cash = new ImageIcon("src/Assets/Icons/cash.png"); // CASH LOGO sa PROCEED PAYMENT
        ImageIcon cashs = new ImageIcon(cash.getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH));
        
        JLabel credit = new JLabel();
        credit.setIcon(cards);
        credit.setBounds(405,200, 150, 50);

        JLabel money = new JLabel();
        money.setIcon(cashs);
        money.setBounds(162,147, 150, 150);


        JPanel backgrounds = new JPanel();
        backgrounds.setBackground(new Color(99, 0, 0));
        backgrounds.setBounds(14, 10, 650, 90);
        backgrounds.setBorder(border4);
        backgrounds.setLayout(null);

        JPanel design1 = new JPanel();
        design1.setBackground(Color.RED);
        design1.setBounds(-10, 400, 700, 90);
        design1.setBorder(border4);
        design1.setLayout(null);

        JLabel choose = new JLabel();
        choose.setText("CHOOSE YOUR PAYMENT METHODS");
        choose.setForeground(Color.WHITE);
        choose.setBounds(55, 10, 700, 50);
        choose.setFont(new Font("ARIAL", Font.BOLD, 30));

        COD = new JButton("CASH");
        COD.setForeground(Color.BLACK);
        COD.setFont(new Font("ARIAL", Font.BOLD, 19));
        COD.setBackground(new Color(4, 136, 43));
        COD.addActionListener(this);
        COD.setBounds(150, 250, 150, 70);
        COD.setBorder(border1);
        COD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        COD.setFocusable(false);

        CARD = new JButton("CREDIT CARD");
        CARD.setForeground(Color.BLACK);
        CARD.setFont(new Font("ARIAL", Font.BOLD, 16));
        CARD.setBackground(new Color(4, 136, 43));
        CARD.addActionListener(this);
        CARD.setBorder(border1);
        CARD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        CARD.setBounds(380, 250, 150, 70);
        CARD.setFocusable(false);

        frames[1].setTitle("PAYMENT METHOD (L.A.B.S)");
        frames[1].setSize(700, 500);
        frames[1].setLayout(null);
        frames[1].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frames[1].setVisible(false);
        frames[1].setResizable(false);
        backgrounds.add(choose);
        frames[1].add(design1);
        frames[1].add(backgrounds);
        frames[1].add(credit);
        frames[1].add(money);
        frames[1].add(CARD);
        frames[1].add(COD);
        frames[1].setLocationRelativeTo(null);
    }

    private void removeItemFromCart(int index) {
        System.out.println("Attempting to remove item at index: " + index); // Log index
        if (index >= 0 && index < cartDataList.size()) {
            ItemDataAtt itemToRemove = cartDataList.get(index);
            System.out.println("Removing item: " + itemToRemove.getItemDesc() + " with price: " + itemToRemove.getItemPriceTimesQuant()); // Log item details
    
            cartDataList.remove(index);
            menuApp.updateTotalPrice(itemToRemove.getItemPriceTimesQuant());
            menuApp.updateCartDisplay();
            labels[2].setText("<html><div style='text-align: center;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 12px;'>Order Total: <span style='color: Black; font-weight: bold; font-size: 20;'<br>" + menuApp.getTotalCartPrice() +"0" + " <br></span> </p></div></html>");
    
            displayCartItems(); // Update the displayed items after removal
        } else {
            System.out.println("Invalid index: " + index);
        }
    }
    public void putItemsToList(){

        cartDataList = userCartItems.getCartData();
    }
    public void addItemToCart() {
        displayCartItems();
        System.out.println("---------------------------------------------- List ----------------------------------------------");
        displayAllItems();
    }
    public void displayCartItems(){
        itemPanel.removeAll();

        List<JLabel> itemLabelList = new ArrayList<>();

        for(ItemDataAtt item: cartDataList){

            itemDesc = item.getItemDesc();
            itemCateg = item.getItemCateg();
            itemPrice = item.getItemPrice();
            itemQuant = item.getItemQuant();
            itemPriceTimesQuant = item.getItemPriceTimesQuant();
            itemLROW = item.getItem_LROW();
            itemLCOL = item.getItem_LCOL();
            String labelText = "<html><div style='padding: 5px; margin:20px;'>" +
                    "<p style='font-weight: bold; font-size: 12px;'>" + itemDesc + " x" + itemQuant + "  - ₱ " + itemPrice+"</p>" +
                    "<p style='font-weight: bold; font-size: 12px;'> ₱ " + itemPriceTimesQuant + "</p>" +
                    "</div></html>";

            JLabel itemLabel = new JLabel(labelText);
            itemLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            itemLabel.setPreferredSize(new Dimension(650,80)); // Adjusted size
            itemLabel.setMaximumSize(new Dimension(650, 80)); // To ensure it doesn't resize
            itemLabel.setBackground(Color.yellow);
            itemLabel.setOpaque(true);

            itemLabelList.add(itemLabel);


        }

        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));

        // Add each JLabel to the itemPanel
        for (JLabel label : itemLabelList) {
            itemPanel.add(label);
        }
        int panelHeight = 100 * itemLabelList.size(); // Each item label has a height of 100
        itemPanel.setPreferredSize(new Dimension(300, panelHeight));
        itemPanel.setMaximumSize(new Dimension(300, panelHeight));
        itemPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        // Repaint the panel
        itemPanel.revalidate();
        itemPanel.repaint();
    }

    public void displayAllItems() {
        for (ItemDataAtt item : cartDataList) {
            itemDesc = item.getItemDesc();
            itemCateg = item.getItemCateg();
            itemPrice = item.getItemPrice();
            itemQuant = item.getItemQuant();
            itemPriceTimesQuant = item.getItemPriceTimesQuant();
            itemLROW = item.getItem_LROW();
            itemLCOL = item.getItem_LCOL();

            System.out.println("Item Description: " + itemDesc);
            System.out.println("Item Category: " + itemCateg);
            System.out.println("Item Price: " + itemPrice);
            System.out.println("Item Quantity: " + itemQuant);
            System.out.println("Item Price Times Quantity: " + itemPriceTimesQuant);
            System.out.println("Item Last Row: " + itemLROW);
            System.out.println("Item Last Column: " + itemLCOL);
            System.out.println();
        }
    }


    public static void main(String[] args) {
        new Framess();

    }
    public void setItemCartPrice(double totalPrice){
        this.totalItemPrice = totalPrice;
    }
    public void cartPrice(){
        tcp = "₱ " + totalItemPrice;

    }

    public ItemDataAtt getCartListPrice(int index){
        return cartDataList.get(index);
    }


   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[1]) {
            frames[0].setVisible(false);
            menuApp.setLocationRelativeTo(null);
        }

        if (e.getSource() == buttons[0]) {
            if(cartDataList.size() !=0){
                frames[1].setVisible(true);
                frames[0].setVisible(false);;
                menuApp.setVisible(false);;
            }
            else{
                JOptionPane.showMessageDialog(null, "Your Food Carts is Empty, Please Add Some Items!");

            }

        }

        if(e.getSource() == COD){
            frames[1].setVisible(false);
            JOptionPane.showMessageDialog(null, "THANK YOU FOR CHOOSING JOLLIKOD BY L.A.B.S.");

        }
        
        if(e.getSource() == CARD){
            frames[1].setVisible(false);
            JOptionPane.showMessageDialog(null, "THANK YOU FOR CHOOSING JOLLIKOD BY L.A.B.S.");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        frames[0].setVisible(false);
        menuApp.setLocationRelativeTo(null);
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
    }



}

