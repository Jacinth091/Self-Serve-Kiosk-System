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
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.List;

class MenuApp extends JFrame implements ActionListener, userCartItemData{

//    Framess reviewOrder;
    FoodData foodData = new FoodData();
    private String[] localFoodCate  = foodData.getFoodCategory();
    private String[][] localFoodDesc = foodData.getFoodDesc();
    private ImageIcon[] localFoodCateImg = foodData.getCateIcon();
    private ImageIcon[][] localFoodItemImg = foodData.getItemPicIcons();

    private double[][] localFoodPrice = foodData.getFoodPrice();
    private int localNoOfCate = foodData.getNoOfCate();
    private int localNoOfItems = foodData.getNoOfItems();



    private List<ItemDataAtt> userCartItemList = new ArrayList<>();


    // main panel container
    private JPanel panelMain;
    // Wrapper for the top, center, bottom panels
    private JPanel[] childPanelCont;

    // childPanelCont[0] Header - Top PART
    private JLabel[] headLabels; // Array of labels used in the header section
    private JPanel[] h_MenuContParent;
    private JPanel[] h_MenuButtCont;
    private JLabel h_MenuLabel; // Label representing the title in the header
    private JButton[] h_MenuButt; // Array of buttons used as menu items in the header
    private JLabel[] h_MButtLabel;
    private JButton selectButt = null;
    private Border defaultBorder = BorderFactory.createLineBorder(Color.GRAY, 1);
    private Border selectedBorder = BorderFactory.createLineBorder(new Color(200, 0, 0), 3,true);
    private Border border4 = BorderFactory.createLineBorder(new Color(112, 47, 43), 7);
    private Border border3 = BorderFactory.createLineBorder((Color.white), 2);
    private Border border1 = BorderFactory.createLineBorder((Color.BLACK), 2);
    private ImageIcon[] h_MButtImg;
    private ImageIcon jolibeeIcon; // Icon representing the Jollibee logo


    // childPanelCont[1] BODY - CENTER PART

    private CardLayout cardLayout;
    private JPanel cardContParent;
    private JPanel[] cardCont;
    private JPanel[][] itemCardCont;
    private ItemCard[][] itemCard;
    private String[] imgPaths;

    // childPanelCont[2] Footer - BOTTOM PART

    private JPanel[] f_ContParent; // Array of parent panels for the footer section
    private JLabel f_NorthLabel; // Label for the header of the footer section
    private JButton f_NorthButt; // Button for actions related to the footer header
    private JLabel[] f_CenterLabel; // Array of labels for displaying information in the footer body
    private JButton[] f_CenterButt; // Array of buttons for actions related to the footer body
    private JButton[] f_SouthButt; // Array of buttons for actions related to the footer checkout section
    private JLabel f_SouthLabel; // Label for displaying total order price in the footer

    //override
    int quantity = 1;
    private int selectedQuant;
    private int selectedIndexRow = -1;
    private int selectedIndexCol = -1;
    private String totalCartPrice = "₱ 0.0";
    private double totalPrice = 0.0;
    private double selectedTotalPrice =0.0;
    private boolean condition;

    private int lrow;
    private int lcol;

    StringBuilder cartContents = new StringBuilder("<html>Cart:<br>");
    String[] items = {"Food Item 1 - P216.00", "Food Item 2 - P216.00", "Food Item 3 - P216.00", "Food Item 4 - P216.00", "Food Item 5 - P216.00", "Food Item 6 - P216.00"};
    double[] prices = {100.00, 200.00, 300.00, 400.00, 500.00, 600.00};

    private String userItemDesc;
    private String userItemCateg;
    private double userItemPrice;
    private int userItemQuant;
    private double userItemPriceTimesQuant;
    private ImageIcon userItemImage;
    private int userItemLROW;
    private int userItemLCOL;
    private Framess reviewOrder;




    MenuApp(){
    }


    MenuApp(int width, int height, String title,
            boolean isVisible, boolean isResizable, LayoutManager layout, int defCloseOper)
    {
        // Initialize Window
        initApp(width, height, title, isVisible, isResizable, layout, defCloseOper);
        initUi();

    }

    public void initUi(){

        // Main panel configuration
        panelMain = new JPanel();
        panelMain.setBackground(Color.GRAY);
        panelMain.setVisible(true);
        panelMain.setLayout(new BorderLayout());
        panelMain.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        // Initialize header panels
        childPanelCont = new JPanel[3];
        for (int i = 0; i < childPanelCont.length; i++) {
            childPanelCont[i] = new JPanel();
            childPanelCont[i].setOpaque(true);
            childPanelCont[i].setVisible(true);
        }

        // Header panel layouts and sizes
        // Header
        childPanelCont[0].setPreferredSize(new Dimension(100, 200));
        childPanelCont[0].setLayout(new GridLayout(2, 1));

        // Body - Center
        childPanelCont[1].setLayout(new BorderLayout());
        childPanelCont[1].setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        // Footer - Bottom
        childPanelCont[2].setPreferredSize(new Dimension(100, 150));
        childPanelCont[2].setLayout(new BorderLayout());

        // Initialize head labels
        headLabels = new JLabel[2];
        for (int i = 0; i < headLabels.length; i++) {
            headLabels[i] = new JLabel();
            headLabels[i].setOpaque(true);
            headLabels[i].setVisible(true);
        }

        // Specific head label configurations
        headLabels[0].setBackground(new Color(112, 47, 43));
        headLabels[0].setLayout(new BorderLayout());

        headLabels[1].setBackground(new Color(112, 47, 43));
        headLabels[1].setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        headLabels[1].setLayout(new GridLayout(1, 4, 5,5));

        // Title label configuration
        h_MenuLabel = new JLabel();
        h_MenuLabel.setText("<html><p style='color: White; font-weight: bold; " +
                "text-align: center;" + "font-size: 30;" +
                "'>Menu" +
                "</p></html>");;
        h_MenuLabel.setHorizontalAlignment(JLabel.CENTER);

        // Load and resize icon for the title label
        jolibeeIcon = new ImageIcon(getClass().getResource("Assets/Icons/Joli-Logo.png"));
        jolibeeIcon = resizeImageIcon(jolibeeIcon, 120, 90);
        h_MenuLabel.setIcon(jolibeeIcon);

        // Initialize h_MenuContParent
        h_MenuContParent = new JPanel[4];
        // Initialize h_MenuButtCont
        h_MenuButtCont = new JPanel[4];
        // Initialize h_MenuButt
        h_MenuButt = new JButton[4];
        // Initialize h_MButtLabel
        h_MButtLabel = new JLabel[4];
        // Initialize h_MButtImg
        h_MButtImg = new ImageIcon[4];

        for (byte i = 0; i < h_MenuContParent.length; i++) {
            // Configure h_MenuContParent
            h_MenuContParent[i] = new JPanel();
            h_MenuContParent[i].setOpaque(true);
            h_MenuContParent[i].setVisible(true);
            h_MenuContParent[i].setPreferredSize(new Dimension(300, 200));
            h_MenuContParent[i].setLayout(new OverlayLayout(h_MenuContParent[i]));

            // Configure h_MenuButtCont
            h_MenuButtCont[i] = new JPanel();
            h_MenuButtCont[i].setVisible(true);
            h_MenuButtCont[i].setPreferredSize(new Dimension(300, 200));
            h_MenuButtCont[i].setLayout(new BorderLayout());


            // Configure h_MenuButt
            h_MenuButt[i] = new JButton();
            h_MenuButt[i].setBorder(null);
            h_MenuButt[i].setOpaque(true);
            h_MenuButt[i].setVisible(true);
            h_MenuButt[i].setName("Menu " + (i + 1));
            h_MenuButt[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            h_MenuButt[i].setLayout(new BorderLayout());
            h_MenuButt[i].addActionListener(this);
            h_MenuButt[i].setActionCommand("Menu " + i);


            // Configure h_MButtLabel
            h_MButtLabel[i] = new JLabel();
            h_MButtLabel[i].setBorder(null);
            h_MButtLabel[i].setOpaque(true);
            h_MButtLabel[i].setVisible(true);
            h_MButtLabel[i].setBackground(Color.WHITE);
            h_MButtLabel[i].setText("<html><p style='text-align:center; font-weight: bold; font-size:10px; color: black;'>"+localFoodCate[i]+"</p></html>");
            h_MButtLabel[i].setHorizontalTextPosition(JLabel.CENTER);
            h_MButtLabel[i].setVerticalTextPosition(JLabel.BOTTOM);
            h_MButtLabel[i].setHorizontalAlignment(JLabel.CENTER);

            // Configure h_MButtImg
            if(localFoodCateImg[i] != null){
                h_MButtImg[i] = localFoodCateImg[i];

            }
            else{
                System.out.printf("Image File at index %d, can't be found!\n", (i+1) );
            }
        }

        h_MenuButt[0].setBorder(border4);
        selectButt = h_MenuButt[0];


        /*---------------------------- Body PArt ( center) ----------------------------*/

        cardContParent = new JPanel();
        cardContParent.setOpaque(true);
        cardContParent.setVisible(true);
        cardContParent.setToolTipText("Parent Cont");
        cardContParent.setLayout(new CardLayout());


        cardCont = new JPanel[4];
        for(int i = 0; i < cardCont.length; i++){
            cardCont[i] = new JPanel();
            cardCont[i].setOpaque(true);
            cardCont[i].setVisible(true);
            cardCont[i].setBackground(null);
            cardCont[i].setToolTipText("Card Container");
            cardCont[i].setLayout(new GridLayout(2,3, 5,5));

            cardContParent.add(cardCont[i], "card" + (i + 1));

        }

        cardLayout = (CardLayout)cardContParent.getLayout();

        itemCardCont = new JPanel[localNoOfCate][localNoOfItems];

        for(int i =0; i<itemCardCont.length; i++){
            for(int j =0; j < itemCardCont[i].length; j++){
                itemCardCont[i][j]= new JPanel();
                itemCardCont[i][j].setOpaque(true);
                itemCardCont[i][j].setVisible(true);
                itemCardCont[i][j].setToolTipText("Item Card");
                itemCardCont[i][j].setBackground(Color.WHITE);
                itemCardCont[i][j].setLayout(new OverlayLayout(itemCardCont[i][j]));
            }
        }

        for(int i =0; i < itemCardCont[0].length; i++){
            cardCont[0].add(itemCardCont[0][i]);
            cardCont[1].add(itemCardCont[1][i]);
            cardCont[2].add(itemCardCont[2][i]);
            cardCont[3].add(itemCardCont[3][i]);
        }


        itemCard = new ItemCard[localNoOfCate][localNoOfItems];

        for(int i =0; i<itemCard.length; i++){
            for(int j =0; j < itemCard[i].length; j++){

                itemCard[i][j] = new ItemCard(localFoodPrice[i][j], localFoodDesc[i][j], localFoodItemImg[i][j]);

                itemCard[i][j].setActionCommand(i + "item" +j );
                itemCard[i][j].addActionListener(this);
            }
        }
        itemCard[0][1].setActionCommand("sold2");
        itemCard[0][5].setActionCommand("sold2");
        itemCard[1][2].setActionCommand("sold2");
        itemCard[2][4].setActionCommand("sold2");
        itemCard[3][2].setActionCommand("sold2");

        for(int i =0; i < itemCard[0].length; i++){
            itemCardCont[0][i].add(itemCard[0][i], BorderLayout.CENTER);
            itemCardCont[1][i].add(itemCard[1][i], BorderLayout.CENTER);
            itemCardCont[2][i].add(itemCard[2][i], BorderLayout.CENTER);
            itemCardCont[3][i].add(itemCard[3][i], BorderLayout.CENTER);
        }
        

        /*----------------------- Initialize childPanelCont[2] FOOTER - BOTTOM PART -----------------------*/

        // Initialize Footer Containers
        f_ContParent = new JPanel[3];
        for (byte i = 0; i < f_ContParent.length; i++) {
            f_ContParent[i] = new JPanel();
            f_ContParent[i].setOpaque(true);
            f_ContParent[i].setVisible(true);
            f_ContParent[i].setLayout(new BorderLayout(5, 5));
        }

        /*----------------------- Configure Header of Footer -----------------------*/

        // Configure Header
        f_ContParent[0].setToolTipText("Header");
        f_ContParent[0].setBackground(new Color(218, 181, 83));
        f_ContParent[0].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Initialize and Configure Header Label
        f_NorthLabel = new JLabel();
        f_NorthLabel.setBorder(null);
        f_NorthLabel.setOpaque(true);
        f_NorthLabel.setVisible(true);
        f_NorthLabel.setBackground(Color.WHITE);
        f_NorthLabel.setText("<html><p style='color: Black; font-weight: bold; text-align: center; font-size: 14px'>Order Options</p></html>");
        f_NorthLabel.setHorizontalTextPosition(JLabel.CENTER);
        f_NorthLabel.setVerticalTextPosition(JLabel.BOTTOM);
        f_NorthLabel.setHorizontalAlignment(JLabel.CENTER);


        /*----------------------- Configure Body of Footer -----------------------*/

        // Configure Body
        f_ContParent[1].setToolTipText("Center");
        f_ContParent[1].setBackground(new Color(246, 216, 216));
        f_ContParent[1].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Initialize and Configure Body Labels
        f_CenterLabel = new JLabel[2];
        for (byte i = 0; i < f_CenterLabel.length; i++) {
            f_CenterLabel[i] = new JLabel();
            f_CenterLabel[i].setBorder(null);
            f_CenterLabel[i].setOpaque(true);
            f_CenterLabel[i].setVisible(true);
        }


        f_CenterLabel[0].setBackground(new Color(255, 255, 255));
        f_CenterLabel[0].setText("<html><div style='text-align: top;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 12px; padding:3px;'>"+ "</p>" +
        "<p style='color: Black; font-weight: bold; font-size: 10px;'>Quantity</p></div></html>");
        f_CenterLabel[0].setHorizontalTextPosition(JLabel.CENTER);
        f_CenterLabel[0].setVerticalTextPosition(JLabel.TOP);
        f_CenterLabel[0].setHorizontalAlignment(JLabel.CENTER);
        f_CenterLabel[0].setPreferredSize(new Dimension(100, 30));

        f_CenterLabel[1].setPreferredSize(new Dimension(100, 30));
        f_CenterLabel[1].setLayout(new GridLayout(1, 2, 5, 5));

        /*----------------------- Initialize and Configure Body Buttons -----------------------*/

        f_CenterButt = new JButton[3];
        for (byte i = 0; i < f_CenterButt.length; i++) {
            f_CenterButt[i] = new JButton();
            f_CenterButt[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            f_CenterButt[i].setOpaque(true);
            f_CenterButt[i].setVisible(true);
            f_CenterButt[i].setFocusable(false);

        }

        f_CenterButt[0].setText("<html><p style=' font-weight: bold; text-align: center; font-size: 25px;'>+</p></html>");
        f_CenterButt[0].setForeground(Color.WHITE);
        f_CenterButt[0].setBackground(new Color(0, 140, 44));
        f_CenterButt[0].setBorder(border3);
        f_CenterButt[0].addActionListener(this);
        f_CenterButt[0].setActionCommand("increaseQuantity");

        f_CenterButt[1].setText("<html><p style=' font-weight: bold; text-align: center; font-size: 25px;'>-</p></html>");
        f_CenterButt[1].addActionListener(this);
        f_CenterButt[1].setForeground(Color.WHITE);
        f_CenterButt[1].setBackground(new Color(99, 0, 0));
        f_CenterButt[1].setBorder(border3);
        f_CenterButt[1].setActionCommand("decreaseQuantity");

        f_CenterButt[2].setPreferredSize(new Dimension(200, 20));
        f_CenterButt[2].setText("<html><p style='color: Black; font-weight: bold; text-align: center; font-size: 15px;'>Add To Cart</p></html>");
        f_CenterButt[2].addActionListener(this);
        f_CenterButt[2].setActionCommand("addToCart");
        f_CenterButt[2].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        /*----------------------- Configure Footer CheckOut -----------------------*/

        f_ContParent[2].setBackground(new Color(99, 0, 0));
        f_ContParent[2].setToolTipText("Footer - CheckOut");
        f_ContParent[2].setPreferredSize(new Dimension(0, 50));
        f_ContParent[2].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Initialize and Configure CheckOut Buttons
        f_SouthButt = new JButton[2];
        for (byte i = 0; i < f_SouthButt.length; i++) {
            f_SouthButt[i] = new JButton();
            f_SouthButt[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            f_SouthButt[i].setOpaque(true);
            f_SouthButt[i].setVisible(true);
            f_SouthButt[i].setFocusable(false);
        }

        // Configure Back Button
        f_SouthButt[0].setPreferredSize(new Dimension(100, 30));
        f_SouthButt[0].setText("<html><p style='color: white; font-weight: bold; text-align: center; font-size: 15px;'>Back</p></html>");
        f_SouthButt[0].setBackground(null);
        f_SouthButt[0].setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        f_SouthButt[0].addActionListener(this);


        // Configure Review and CheckOut Button
        f_SouthButt[1].setText("<html><p style='color: White; font-weight: bold; text-align: center; font-size: 20;'>Review Order</p></html>");
        f_SouthButt[1].setBackground(new Color(0, 94, 32, 255));
        f_SouthButt[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reviewOrder = new Framess(MenuApp.this);
                int x = 57;
                int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2;
                setLocation(x,y);
                reviewOrder.putItemsToList();
                reviewOrder.addItemToCart();





            }
        });

        // Initialize and Configure CheckOut Label
        totalCartPrice = "₱ " + totalPrice;
        f_SouthLabel = new JLabel();
        f_SouthLabel.setBorder(null);
        f_SouthLabel.setOpaque(true);
        f_SouthLabel.setVisible(true);
        f_SouthLabel.setBackground(Color.white);
        f_SouthLabel.setText("<html><div style='text-align: center;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 15px;'>Order Total: <span style='color: Black; font-weight: bold; font-size: 20;'>" + totalCartPrice +"0"+ " </span> </p></div></html>");
        f_SouthLabel.setHorizontalTextPosition(JLabel.CENTER);
        f_SouthLabel.setVerticalTextPosition(JLabel.TOP);
        f_SouthLabel.setHorizontalAlignment(JLabel.CENTER);
        f_SouthLabel.setPreferredSize(new Dimension(200, 30));
        f_SouthLabel.setBorder(border1);



        /*----------------------- Add Components to Panels -----------------------*/

        // Add Components to Footer Header
        f_ContParent[0].add(f_NorthLabel, BorderLayout.CENTER);


        // Add Components to Footer Body
        f_CenterLabel[1].add(f_CenterButt[0]);
        f_CenterLabel[1].add(f_CenterButt[1]);

        f_ContParent[1].add(f_CenterLabel[0], BorderLayout.WEST);
        f_ContParent[1].add(f_CenterLabel[1], BorderLayout.CENTER);
        f_ContParent[1].add(f_CenterButt[2], BorderLayout.EAST);

        // Add Components to Footer CheckOut
        f_ContParent[2].add(f_SouthButt[0], BorderLayout.WEST);
        f_ContParent[2].add(f_SouthLabel, BorderLayout.CENTER);
        f_ContParent[2].add(f_SouthButt[1], BorderLayout.EAST);

        // Add Footer Containers to childPanelCont[2]
        childPanelCont[2].add(f_ContParent[0], BorderLayout.NORTH);
        childPanelCont[2].add(f_ContParent[1], BorderLayout.CENTER);
        childPanelCont[2].add(f_ContParent[2], BorderLayout.SOUTH);


        childPanelCont[1].add(cardContParent, BorderLayout.CENTER);

        // Configuring header menu buttons and their containers

        for (byte i = 0; i < 4; i++) {
            // Set icon for menu button label
            h_MButtLabel[i].setIcon(h_MButtImg[i]);

            // Add menu button label to menu button
            h_MenuButt[i].add(h_MButtLabel[i], BorderLayout.CENTER);

            // Add menu button to menu button container
            h_MenuButtCont[i].add(h_MenuButt[i], BorderLayout.CENTER);

            // Add menu button container to menu container parent
            h_MenuContParent[i].add(h_MenuButtCont[i]);
        }



// Add menu buttons to the second head label
        for (JPanel MenuLabelParent: h_MenuContParent) {
            headLabels[1].add(MenuLabelParent);
        }


        // Add title label to the first head label
        headLabels[0].add(h_MenuLabel, BorderLayout.CENTER);

        // Add head labels to the first header panel
        for (JLabel headLabel : headLabels) {
            childPanelCont[0].add(headLabel);
        }

        // Add header panels to the main panel
        panelMain.add(childPanelCont[0], BorderLayout.NORTH);
        panelMain.add(childPanelCont[1], BorderLayout.CENTER);
        panelMain.add(childPanelCont[2], BorderLayout.SOUTH);

        // Add main panel to the frame
        add(panelMain, BorderLayout.CENTER);

        revalidate();
        repaint();


    }


    public void initApp(int width, int height, String title,
    boolean isVisible, boolean isResizable, LayoutManager layout, int defCloseOper) {
        this.setSize(width, height);
        this.setTitle(title);
        this.setDefaultCloseOperation(defCloseOper);
        this.setLayout(layout);
        this.setVisible(isVisible);
        this.setLocationRelativeTo(null);
        this.setResizable(isResizable);
    }
    public static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage(); // Get the image from the ImageIcon
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Resize the image
        return new ImageIcon(resizedImage); // Create a new ImageIcon with the resized image
    }


    public static void main(String[] args){

        new MenuApp(625,750,"JOLLIKOD MENU - (L.A.B.S)",true,false, new BorderLayout(), JFrame.EXIT_ON_CLOSE);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.contains("item")) {
            lrow= Integer.parseInt(command.split("item")[0]);
            lcol = Integer.parseInt(command.split("item")[1]);
            selectItem(lrow, lcol);
            System.out.println("lRow: " + lrow + "lCol: " + lcol+ "\n\n" +
                    "ItemPrice : " + localFoodPrice[lrow][lcol]+ "\n" );
            f_CenterLabel[0].setText("<html><div style='text-align: top;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 12px; padding:3px;'>"+ quantity+   "</p>" +
                    "<p style='color: Black; font-weight: bold; font-size: 10px;'>Quantity</p></div></html>");
            condition = true;

        } else if (command.equals("addToCart")) {
            if (selectedIndexRow != -1 && selectedIndexCol != -1) {
                cartContents.append(quantity).append(" x ").append("Product").append("<br>");
                totalPrice += localFoodPrice[lrow][lcol] * quantity;

                selectedQuant = quantity;
                selectedTotalPrice = localFoodPrice[lrow][lcol] *selectedQuant;

                userCartItemList.add(new ItemDataAtt(localFoodDesc[lrow][lcol], localFoodCate[lrow], localFoodPrice[lrow][lcol],
                        selectedQuant, selectedTotalPrice, lrow, lcol));

                displayAllItems();


                // Assuming itemCard is the source for itemCardButt; you need to handle this logic appropriately.
                itemCard[selectedIndexRow][selectedIndexCol].setBorder(defaultBorder); // Reset button border
                selectedIndexRow = -1;
                selectedIndexCol = -1;
                quantity = 1; // Reset quantity
                f_CenterLabel[0].setText("<html><div style='text-align: top;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 12px; padding:3px;'>"+ "</p>" +
                        "<p style='color: Black; font-weight: bold; font-size: 10px;'>Quantity</p></div></html>");
                condition = false;
                updateCartDisplay();
            }
        }

        if (condition) {
            if (command.equals("increaseQuantity")) {
                quantity++;
                f_CenterLabel[0].setText("<html><div style='text-align: top;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 12px; padding:3px;'>"+ quantity+   "</p>" +
                        "<p style='color: Black; font-weight: bold; font-size: 10px;'>Quantity</p></div></html>");
            } else if (command.equals("decreaseQuantity")) {
                if (quantity > 1) {
                    quantity--;
                    f_CenterLabel[0].setText("<html><div style='text-align: top;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 12px; padding:3px;'>" + quantity + "</p>" +
                            "<p style='color: Black; font-weight: bold; font-size: 10px;'>Quantity</p></div></html>");
                }
            }
        }


        if (command.startsWith("Menu")) {
            int index = Integer.parseInt(command.substring(5));
            cardLayout.show(cardContParent, "card" + (index + 1));
            handleSelectButt((JButton) e.getSource());
            System.out.println(command);
        }

        if ( e.getSource() == f_SouthButt[0] ) {
            new FrontPage();
            initApp(625,800,"JOLLIKOD MENU - (L.A.B.S)",false,true, new BorderLayout(), JFrame.EXIT_ON_CLOSE);

            
        }
        if (command.equals("sold2")){
            JOptionPane.showMessageDialog(null, "OUT OF STOCK (SOLD OUT)");}
    }
    

  // 88888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888  
    public void handleSelectButt(JButton button){
        if(selectButt != null){
            selectButt.setBorder(defaultBorder);
        }
        button.setBorder(border4);
        selectButt = button;
    }
    public double getTotalPrice(){
        return totalPrice;
    }
    public void setTotalPrice(double newPrice){
        this.totalPrice = newPrice;
    }

    public void updateTotalPrice(double priceToDeduct) {
        System.out.println("Updating total price by deducting: " + priceToDeduct); // Log price to deduct
        double newPrice = getTotalPrice() - priceToDeduct;
        System.out.printf("New total price: %.2f\n", newPrice); // Log new total price
        setTotalPrice(newPrice);
    }   

    private void selectItem(int lrow, int lcol) {
        if (selectedIndexRow != -1 && selectedIndexCol!=-1) {
            itemCard[selectedIndexRow][selectedIndexCol].setBorder(defaultBorder); // Reset previously selected button border
        }
        selectedIndexRow = lrow;
        selectedIndexCol= lcol;
        itemCard[lrow][lcol].setBorder(selectedBorder); // Highlight selected button
    }

    public void updateCartDisplay() {
        totalCartPrice = "₱ " + getTotalPrice();
        f_SouthLabel.setText("<html><div style='text-align: center;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 15px;'>Order Total: <span style='color: Black; font-weight: bold; font-size: 20;'>" + totalCartPrice + "0" +"</span> </p></div></html>");

    }

    public String getTotalCartPrice() {
        return totalCartPrice;
    }
    public void displayAllItems() {
        for (ItemDataAtt item : userCartItemList) {
            userItemDesc = item.getItemDesc();
            userItemCateg = item.getItemCateg();
            userItemPrice = item.getItemPrice();
            userItemQuant = item.getItemQuant();
            userItemPriceTimesQuant = item.getItemPriceTimesQuant();

            userItemLROW = item.getItem_LROW();
            userItemLCOL = item.getItem_LCOL();

            System.out.println("Item Description: " + userItemDesc);
            System.out.println("Item Category: " + userItemCateg);
            System.out.println("Item Price: " + userItemPrice);
            System.out.println("Item Quantity: " + userItemQuant);
            System.out.println("Item Price Times Quantity: " + userItemPriceTimesQuant);
            System.out.println("Item Image: " + userItemImage);
            System.out.println("Item Last Row: " + userItemLROW);
            System.out.println("Item Last Column: " + userItemLCOL);
            System.out.println();
        }

    }


    @Override
    public String getItemDesc() {
        return userItemDesc;
    }

    @Override
    public String getItemCateg() {
        return userItemCateg;
    }

    @Override
    public double getItemPrice() {
        return userItemPrice;
    }

    @Override
    public int getItemQuant() {
        return userItemQuant;
    }

    @Override
    public double getItemPriceTimesQuantity() {
        return userItemPriceTimesQuant;
    }

    @Override
    public int getItem_LROW() {
        return userItemLROW;
    }    @Override
    public int getItem_LCOL() {
        return userItemLCOL;
    }

    @Override
    public List<ItemDataAtt> getCartData(){
        return userCartItemList;
    }


}