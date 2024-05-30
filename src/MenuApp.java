
//import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
//import javax.swing.BorderLayout;
import javax.swing.border.Border;
import java.util.ArrayList;
class MenuApp extends JFrame implements ActionListener{

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
    private ImageIcon[] h_MButtImg;
    private ImageIcon jolibeeIcon; // Icon representing the Jollibee logo


    // childPanelCont[1] BODY - CENTER PART

    private CardLayout cardLayout;
    private JPanel cardContParent;
    private JPanel[] cardCont;
    private JPanel[][] itemCardCont;
    private ItemCard[][] itemCard;
    private String[] imgPaths;
/*//    private ArrayList<ItemCard[]> itemCardList;
//    private JPanel[] itemCardContParent; // Array of parent panels for items in the center part of the interface
//    private JPanel[] itemCardContainer; // Array of layered panes containing item cards
//    private JLabel[] itemCardLabel; // Array of labels for displaying item images
//    private JButton[] itemCardButt; // Array of buttons associated with item cards
//    private ImageIcon[] itemCardImage; // Array of image icons representing item images*/



    // childPanelCont[2] Footer - BOTTOM PART

    private JPanel[] f_ContParent; // Array of parent panels for the footer section
    private JLabel f_NorthLabel; // Label for the header of the footer section
    private JButton f_NorthButt; // Button for actions related to the footer header
    private JLabel[] f_CenterLabel; // Array of labels for displaying information in the footer body
    private JButton[] f_CenterButt; // Array of buttons for actions related to the footer body
    private JButton[] f_SouthButt; // Array of buttons for actions related to the footer checkout section
    private JLabel f_SouthLabel; // Label for displaying total order price in the footer
    float totalCompPrice = 0.00f; // Total order pri

    //override
    int quantity = 1;
    int selectedIndex = -1;

    StringBuilder cartContents = new StringBuilder("<html>Cart:<br>");
    String[] items = {"Food Item 1 - P216.00", "Food Item 2 - P216.00", "Food Item 3 - P216.00", "Food Item 4 - P216.00", "Food Item 5 - P216.00", "Food Item 6 - P216.00"};
    double totalPrice = 0.0;
    double[] prices = {100.00, 200.00, 300.00, 400.00, 500.00, 600.00};
    Border defaultBorder;
    private String totalCartPrice;



    MenuApp(){
        initApp(625,800,"Jolikod",true,true, new BorderLayout(), JFrame.EXIT_ON_CLOSE);
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
        panelMain.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

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
//        childPanelCont[1].setLayout(new GridLayout(2,6, 10,10));
        childPanelCont[1].setLayout(new BorderLayout());
        childPanelCont[1].setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        // Footer - Bottom
        childPanelCont[2].setPreferredSize(new Dimension(100, 200));
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
                "'>Jolibee Menu" +
                "</p></html>");;
        h_MenuLabel.setHorizontalAlignment(JLabel.CENTER);

        // Load and resize icon for the title label
        jolibeeIcon = new ImageIcon(getClass().getResource("Assets/Item_category/Joli-Logo.png"));
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
            // h_MenuButtCont[i].setOpaque(true);
            h_MenuButtCont[i].setVisible(true);
            h_MenuButtCont[i].setPreferredSize(new Dimension(300, 200));
            h_MenuButtCont[i].setLayout(new BorderLayout());


            // Configure h_MenuButt
            h_MenuButt[i] = new JButton();
            h_MenuButt[i].setBorder(null);
            h_MenuButt[i].setOpaque(true);
            h_MenuButt[i].setVisible(true);
            h_MenuButt[i].setName("Menu " + (i + 1));
            h_MenuButt[i].setLayout(new BorderLayout());
            h_MenuButt[i].addActionListener(this);
            h_MenuButt[i].setActionCommand("Menu " + i);


            // Configure h_MButtLabel
            h_MButtLabel[i] = new JLabel();
            h_MButtLabel[i].setBorder(null);
            h_MButtLabel[i].setOpaque(true);
            h_MButtLabel[i].setVisible(true);
            h_MButtLabel[i].setBackground(Color.WHITE);
            h_MButtLabel[i].setText("<html><p style='text-align:center; font-weight: bold; font-size:10px; color: black;'>Product Category</p></html>");
            h_MButtLabel[i].setHorizontalTextPosition(JLabel.CENTER);
            h_MButtLabel[i].setVerticalTextPosition(JLabel.BOTTOM);
            h_MButtLabel[i].setHorizontalAlignment(JLabel.CENTER);

            // Configure h_MButtImg
            h_MButtImg[i] = new ImageIcon(getClass().getResource("Assets/Item_category/best-sellers-icon.png"));
            h_MButtImg[i] = resizeImageIcon(h_MButtImg[i], (300 / 4), (210 / 4));
        }



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

        itemCardCont = new JPanel[4][6];

        for(int i =0; i<itemCardCont.length; i++){
            for(int j =0; j < itemCardCont[i].length; j++){
                itemCardCont[i][j]= new JPanel();
                itemCardCont[i][j].setOpaque(true);
                itemCardCont[i][j].setVisible(true);
                itemCardCont[i][j].setToolTipText("Item Card");
                itemCardCont[i][j].setBackground(Color.WHITE);
//                itemCardCont[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                itemCardCont[i][j].setLayout(new OverlayLayout(itemCardCont[i][j]));
            }
        }

        for(int i =0; i < itemCardCont[0].length; i++){
            cardCont[0].add(itemCardCont[0][i]);
            cardCont[1].add(itemCardCont[1][i]);
            cardCont[2].add(itemCardCont[2][i]);
            cardCont[3].add(itemCardCont[3][i]);
        }



        itemCard = new ItemCard[4][6];

        imgPaths = new String[]{
                "Assets/item_pictures/BS/BS-item-1.png",
                "Assets/item_pictures/BS/BS-item-2.png",
                "Assets/item_pictures/BS/BS-item-3.png",
                "Assets/item_pictures/BS/BS-item-4.png"
        };
        for(int i =0; i<itemCard.length; i++){
            for(int j =0; j < itemCard[i].length; j++){

                itemCard[i][j] = new ItemCard(223.23, "Product", imgPaths[i]);

                itemCard[i][j].setActionCommand("item" + (i * itemCard[i].length + j));
                itemCard[i][j].addActionListener(this);
            }
        }


        for(int i =0; i < itemCard[0].length; i++){
            itemCardCont[0][i].add(itemCard[0][i], BorderLayout.CENTER);
            itemCardCont[1][i].add(itemCard[1][i], BorderLayout.CENTER);
            itemCardCont[2][i].add(itemCard[2][i], BorderLayout.CENTER);
            itemCardCont[3][i].add(itemCard[3][i], BorderLayout.CENTER);


        }


/*


        // Initialize itemCardContParent
        itemCardContParent = new JPanel[6];
        // Initialize itemCardContiner
        itemCardContainer = new JPanel[6];
        // Initialize itemCardCButton
        itemCardButt = new JButton[6];
        // Initialize itemCardLabel
        itemCardLabel = new JLabel[6];
        // Initialize ImageIcon[]
        itemCardImage = new ImageIcon[6];

        for(byte i =0; i< itemCardContParent.length; i++) {
            // Configure itemCardContainer
            itemCardContParent[i] = new JPanel();
            itemCardContParent[i].setOpaque(true);
            itemCardContParent[i].setVisible(true);
            itemCardContParent[i].setToolTipText("Parent Cont");
            itemCardContParent[i].setPreferredSize(new Dimension(300, 200));
            itemCardContParent[i].setLayout(new OverlayLayout(itemCardContParent[i]));

            // Configure itemCardContainer
            itemCardContainer[i] = new JPanel();
            itemCardContainer[i].setOpaque(true);
            itemCardContainer[i].setVisible(true);
            itemCardContainer[i].setPreferredSize(new Dimension(300,200));
            itemCardContainer[i].setLayout(new BorderLayout());

            // Configure itemCardButt
            itemCardButt[i] = new JButton();
            itemCardButt[i].setBorder(null);
            itemCardButt[i].setOpaque(true);
            itemCardButt[i].setVisible(true);
            itemCardButt[i].setName("Card " + (i+1));
            itemCardButt[i].setLayout(new BorderLayout());
            itemCardButt[i].addActionListener(this);
            itemCardButt[i].setActionCommand("item" + i);

            // Configure itemCardLabel
            itemCardLabel[i] = new JLabel();
            itemCardLabel[i].setBorder(null);
            itemCardLabel[i].setOpaque(true);
            itemCardLabel[i].setVisible(true);
            itemCardLabel[i].setBackground(Color.WHITE);
            itemCardLabel[i].setText("<html><p style='color: red; font-weight: bold; " +
                    "text-align: center;'>P 212.00</p><br><p>Product Description</p></html>");
            itemCardLabel[i].setHorizontalTextPosition(JLabel.CENTER);
            itemCardLabel[i].setVerticalTextPosition(JLabel.BOTTOM);
            itemCardLabel[i].setHorizontalAlignment(JLabel.CENTER);

            // Configure itemCardImage
            itemCardImage[i] = new ImageIcon(getClass().getResource("Assets/item_pictures/BS/BS-item-1.png"));
            itemCardImage[i] = resizeImageIcon(itemCardImage[i], 100, 70);

        }
*/



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

/*        // Initialize and Configure Header Button
//        f_NorthButt = new JButton("View Cart");
//        f_NorthButt.setBorder(null);
//        f_NorthButt.setOpaque(true);
//        f_NorthButt.setVisible(true);
//        f_NorthButt.setFocusable(false);
//        f_NorthButt.setBackground(Color.WHITE);
//        f_NorthButt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//        f_NorthButt.setPreferredSize(new Dimension(200, 30));*/

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
        f_CenterLabel[0].setText("<html><div style='text-align: top;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 15px; padding:5px;'>"+ quantity+   "</p>" +
                "<p style='color: Black; font-weight: bold; font-size: 20;'>Quantity</p></div></html>");
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
            f_CenterButt[i].setOpaque(true);
            f_CenterButt[i].setVisible(true);
            f_CenterButt[i].setFocusable(false);

        }

        f_CenterButt[0].setText("<html><p style='color: Black; font-weight: bold; text-align: center; font-size: 25px;'>+</p></html>");
        f_CenterButt[0].addActionListener(this);
        f_CenterButt[0].setActionCommand("increaseQuantity");

        f_CenterButt[1].setText("<html><p style='color: Black; font-weight: bold; text-align: center; font-size: 25px;'>-</p></html>");
        f_CenterButt[1].addActionListener(this);
        f_CenterButt[1].setActionCommand("decreaseQuantity");

        f_CenterButt[2].setPreferredSize(new Dimension(200, 20));
        f_CenterButt[2].setText("<html><p style='color: Black; font-weight: bold; text-align: center; font-size: 15px;'>Add To Cart</p></html>");
        f_CenterButt[2].addActionListener(this);
        f_CenterButt[2].setActionCommand("addToCart");
        f_CenterButt[2].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        /*----------------------- Configure Footer CheckOut -----------------------*/

        f_ContParent[2].setBackground(Color.RED);
        f_ContParent[2].setToolTipText("Footer - CheckOut");
        f_ContParent[2].setPreferredSize(new Dimension(0, 60));
        f_ContParent[2].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Initialize and Configure CheckOut Buttons
        f_SouthButt = new JButton[2];
        for (byte i = 0; i < f_SouthButt.length; i++) {
            f_SouthButt[i] = new JButton();
            f_SouthButt[i].setOpaque(true);
            f_SouthButt[i].setVisible(true);
            f_SouthButt[i].setFocusable(false);
        }

        // Configure Back Button
        f_SouthButt[0].setPreferredSize(new Dimension(100, 30));
        f_SouthButt[0].setText("<html><p style='color: white; font-weight: bold; text-align: center; font-size: 15px;'>Back</p></html>");
        f_SouthButt[0].setBackground(null);
        f_SouthButt[0].setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));

        // Configure Review and CheckOut Button
        f_SouthButt[1].setText("<html><p style='color: White; font-weight: bold; text-align: center; font-size: 20;'>Review Order</p></html>");
        f_SouthButt[1].setBackground(new Color(51, 220, 88));

        // Initialize and Configure CheckOut Label
        totalCartPrice = "P " + totalPrice;
        f_SouthLabel = new JLabel();
        f_SouthLabel.setBorder(null);
        f_SouthLabel.setOpaque(true);
        f_SouthLabel.setVisible(true);
        f_SouthLabel.setBackground(Color.white);
        f_SouthLabel.setText("<html><div style='text-align: center;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 15px;'>Order Total: <span style='color: Black; font-weight: bold; font-size: 20;'>" + totalCartPrice +" </span> </p></div></html>");
        f_SouthLabel.setHorizontalTextPosition(JLabel.CENTER);
        f_SouthLabel.setVerticalTextPosition(JLabel.TOP);
        f_SouthLabel.setHorizontalAlignment(JLabel.CENTER);
        f_SouthLabel.setPreferredSize(new Dimension(200, 30));




        /*----------------------- Add Components to Panels -----------------------*/

        // Add Components to Footer Header
        f_ContParent[0].add(f_NorthLabel, BorderLayout.CENTER);
//        f_ContParent[0].add(f_NorthButt, BorderLayout.EAST);


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

/*//        // Configuring item card components and their hierarchy
//
//        for (byte i = 0; i < itemCardContainer.length; i++) {
//            // Set item card label's icon
//            itemCardLabel[i].setIcon(itemCardImage[i]);
//
//            // Add item card label to item card button
//            itemCardButt[i].add(itemCardLabel[i], BorderLayout.CENTER);
//
//            // Add item card button to item card container
//            itemCardContainer[i].add(itemCardButt[i], BorderLayout.CENTER);
//
//            // Add item card container to item card parent container
////            itemCardContParent[i].add(itemCardContainer[i]);
//
//            // Add item card parent container to the center panel
//            cardCont[0].add(itemCardContainer[i]);
//        }*/

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

        setLocationRelativeTo(null);
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
        this.setResizable(isResizable);
    }
    public static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage(); // Get the image from the ImageIcon
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Resize the image
        return new ImageIcon(resizedImage); // Create a new ImageIcon with the resized image
    }


    public static void main(String[] args){

        MenuApp menuWindow = new MenuApp(625,800,"Jolikod",true,true, new BorderLayout(), JFrame.EXIT_ON_CLOSE);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.startsWith("item")) {
            int index = Integer.parseInt(command.substring(4));
            selectItem(index);
        } else if (command.equals("addToCart")) {
            if (selectedIndex != -1) {
                cartContents.append(quantity).append(" x ").append("Product").append("<br>");
                totalPrice += prices[selectedIndex] * quantity;
                // Assuming itemCard is the source for itemCardButt; you need to handle this logic appropriately.
                itemCard[selectedIndex / 6][selectedIndex % 6].setBorder(defaultBorder); // Reset button border
                selectedIndex = -1;
                quantity = 1; // Reset quantity
                f_CenterLabel[0].setText("<html><div style='text-align: top;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 15px; padding:5px;'>"+ quantity+"</p>" +
                        "<p style='color: Black; font-weight: bold; font-size: 20;'>Quantity</p></div></html>"); // Reset quantity label
                updateCartDisplay();
            }
        } else if (command.equals("increaseQuantity")) {
            quantity++;
            f_CenterLabel[0].setText("<html><div style='text-align: top;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 15px; padding:5px;'>"+ quantity+   "</p>" +
                    "<p style='color: Black; font-weight: bold; font-size: 20;'>Quantity</p></div></html>");
        } else if (command.equals("decreaseQuantity")) {
            if (quantity > 1) {
                quantity--;
                f_CenterLabel[0].setText("<html><div style='text-align: top;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 15px; padding:5px;'>"+ quantity+   "</p>" +
                        "<p style='color: Black; font-weight: bold; font-size: 20;'>Quantity</p></div></html>");
            }
        } else if (command.startsWith("Menu")) {
            int index = Integer.parseInt(command.substring(5));
            cardLayout.show(cardContParent, "card" + (index + 1));
            System.out.println(command);
        }
    }

    private void selectItem(int index) {
        if (selectedIndex != -1) {
            itemCard[selectedIndex / 6][selectedIndex % 6].setBorder(defaultBorder); // Reset previously selected button border
        }
        selectedIndex = index;
        defaultBorder = itemCard[index / 6][index % 6].getBorder(); // Store the default border
        itemCard[index / 6][index % 6].setBorder(BorderFactory.createLineBorder(new Color(255, 184,14), 5,true)); // Highlight selected button
    }

/*    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.startsWith("item")) {
            int index = Integer.parseInt(command.substring(4));
            selectItem(index);
        } else if (command.equals("addToCart")) {
            if (selectedIndex != -1) {
                cartContents.append(quantity).append(" x ").append(items[selectedIndex]).append("<br>");
                totalPrice += prices[selectedIndex] * quantity;
//                itemCardButt[selectedIndex].setBorder(defaultBorder); // Reset button border
                selectedIndex = -1;
                quantity = 1; // Reset quantity
                f_CenterLabel[0].setText("<html><div style='text-align: top;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 15px; padding:5px;'>"+ quantity+"</p>" +
                "<p style='color: Black; font-weight: bold; font-size: 20;'>Quantity</p></div></html>"); // Reset quantity label
                updateCartDisplay();
            }
        } else if (command.equals("increaseQuantity")) {
            quantity++;
            f_CenterLabel[0].setText("<html><div style='text-align: top;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 15px; padding:5px;'>"+ quantity+   "</p>" +
                    "<p style='color: Black; font-weight: bold; font-size: 20;'>Quantity</p></div></html>");
//            f_CenterLabel[0].setText("Quantity: " + quantity); // Corrected concatenation
        } else if (command.equals("decreaseQuantity")) {
            if (quantity > 1) {
                quantity--;
                f_CenterLabel[0].setText("<html><div style='text-align: top;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 15px; padding:5px;'>"+ quantity+   "</p>" +
                        "<p style='color: Black; font-weight: bold; font-size: 20;'>Quantity</p></div></html>");
//                f_CenterLabel[0].setText("Quantity: " + quantity); // Corrected concatenation
            }
        }else if (command.startsWith("Menu")) {
            int index = Integer.parseInt(command.substring(5));
            cardLayout.show(cardContParent, "card" + (index + 1));
            System.out.println(command);
        }
    }

    private void selectItem(int index) {
//        if (selectedIndex != -1) {
//            itemCardButt[selectedIndex].setBorder(defaultBorder); // Reset previously selected button border
//        }
//        selectedIndex = index;
//        defaultBorder = itemCardButt[index].getBorder(); // Store the default border
//        itemCardButt[index].setBorder(BorderFactory.createLineBorder(Color.BLUE, 3)); // Highlight selected button
    }*/

    private void updateCartDisplay() {
//        f_SouthLabel.setText("Total Price: $\n" + totalPrice );
        totalCartPrice = "P " + totalPrice;
        f_SouthLabel.setText("<html><div style='text-align: center;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 15px;'>Order Total: <span style='color: Black; font-weight: bold; font-size: 20;'>" + totalCartPrice +" </span> </p></div></html>");

    }

}



