
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class WindowApp extends JFrame implements ActionListener{

    // main panel container
    private JPanel panelMain;

    // Wrapper for the top, center, bottom panels
    private JPanel[] childPanelCont;

    // childPanelCont[0] Header - Top PART
    private JLabel[] headLabels; // Array of labels used in the header section
    private JLabel hLabelTitle; // Label representing the title in the header
    private JButton[] hLabelMenu; // Array of buttons used as menu items in the header
    private ImageIcon jolibeeIcon; // Icon representing the Jollibee logo


    // childPanelCont[1] BODY - CENTER PART
    private JPanel[] itemCardContParent; // Array of parent panels for items in the center part of the interface
    private JLayeredPane[] itemCardContainer; // Array of layered panes containing item cards
    private JLabel[] itemCardLabel; // Array of labels for displaying item images
    private JButton[] itemCardButt; // Array of buttons associated with item cards
    private ImageIcon[] itemCardImage; // Array of image icons representing item images



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


    WindowApp(){

    }
    

    WindowApp (int width, int height, String title,
    boolean isVisible, boolean isResizable, LayoutManager layout, int defCloseOper)
    {
        // Initialize Window
        initApp(width, height, title, isVisible, isResizable, layout, defCloseOper);

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
            childPanelCont[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        }

        // Header panel layouts and sizes
        // Header
        childPanelCont[0].setPreferredSize(new Dimension(100, 200));
        childPanelCont[0].setLayout(new GridLayout(2, 1));

        // Body - Center
        childPanelCont[1].setLayout(new GridLayout(2,6, 10,10));
//        childPanelCont[1].setLayout(new FlowLayout());
        childPanelCont[1].setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // Footer - Bottom
        childPanelCont[2].setPreferredSize(new Dimension(100, 200));
        childPanelCont[2].setLayout(new BorderLayout());

        // Initialize head labels
        headLabels = new JLabel[2];
        for (int i = 0; i < headLabels.length; i++) {
            headLabels[i] = new JLabel();
            headLabels[i].setOpaque(true);
            headLabels[i].setVisible(true);
            headLabels[i].setBackground(new Color(255, 24, 12));
            headLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        }

        // Specific head label configurations
        headLabels[0].setBackground(new Color(112, 47, 43));
        headLabels[0].setLayout(new BorderLayout());
        headLabels[1].setBackground(new Color(112, 47, 43));
        headLabels[1].setLayout(new GridLayout(1, 4));

        // Title label configuration
        hLabelTitle = new JLabel();
        hLabelTitle.setText("<html><p style='color: White; font-weight: bold; " +
                "text-align: center;" + "font-size: 30;" +
                "'>Jolibee Menu" +
                "</p></html>");;
        hLabelTitle.setHorizontalAlignment(JLabel.CENTER);

        // Load and resize icon for the title label
        jolibeeIcon = new ImageIcon(getClass().getResource("Assets/logo/Joli-Logo.png"));
        jolibeeIcon = resizeImageIcon(jolibeeIcon, 120, 90);
        hLabelTitle.setIcon(jolibeeIcon);

        // Initialize menu buttons
        hLabelMenu = new JButton[4];
        for (int i = 0; i < hLabelMenu.length; i++) {
            hLabelMenu[i] = new JButton();
            hLabelMenu[i].setText("Hello");
            hLabelMenu[i].setVisible(true);
            hLabelMenu[i].setOpaque(true);
        }


        // Initialize itemCardContParent
        itemCardContParent = new JPanel[6];

        for(byte i =0; i< itemCardContParent.length; i++) {
            itemCardContParent[i] = new JPanel();
            itemCardContParent[i].setOpaque(true);
            itemCardContParent[i].setVisible(true);
            itemCardContParent[i].setToolTipText("Parent Cont");
            itemCardContParent[i].setPreferredSize(new Dimension(300, 200));
//            itemCardContParent[i].setBackground(Color.WHITE);
            itemCardContParent[i].setLayout(new OverlayLayout(itemCardContParent[i]));

        }

        // Initialize itemCardContainer
        itemCardContainer = new JLayeredPane[6];
        for(byte i =0; i< itemCardContainer.length; i++){
            itemCardContainer[i] = new JLayeredPane();
            itemCardContainer[i].setOpaque(true);
            itemCardContainer[i].setVisible(true);
            itemCardContainer[i].setPreferredSize(new Dimension(300,200));
            itemCardContainer[i].setLayout(new BorderLayout());
//            itemCardContainer[i].setBorder(BorderFactory.createLineBorder(Color.red,2));


        }
        // Initialize itemCardCButton
        itemCardButt = new JButton[6];

        for(byte i =0; i< itemCardButt.length; i++){
            itemCardButt[i] = new JButton();
            itemCardButt[i].setBorder(null);
            itemCardButt[i].setOpaque(true);
            itemCardButt[i].setVisible(true);
            itemCardButt[i].setName("Card " + (i+1));
            itemCardButt[i].setLayout(new BorderLayout());
            itemCardButt[i].addActionListener(this);
            itemCardButt[i].setActionCommand("item" + i);
  

            itemCardButt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Action to perform when the button is clicked
                    JButton source = (JButton)e.getSource();
                    System.out.print("Button clicked!\n");
                    System.out.println(source.getName());
                }
            });


        }

        // Initialize itemCardLabel

        itemCardLabel = new JLabel[6];

        for(byte i =0; i< itemCardLabel.length; i++){
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
        //     itemCardButt[i].addActionListener(this);
        //     itemCardButt[i].setActionCommand("item" + i);
  

        }
        // Initialize ImageIcon[]

        itemCardImage = new ImageIcon[6];
        for(byte i =0; i< itemCardImage.length; i++) {
            itemCardImage[i] = new ImageIcon(getClass().getResource("Assets/item_pictures/BS-item-1.png"));
            itemCardImage[i] = resizeImageIcon(itemCardImage[i], 100, 70);

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

// Initialize and Configure Header Button
        f_NorthButt = new JButton("View Cart");
        f_NorthButt.setBorder(null);
        f_NorthButt.setOpaque(true);
        f_NorthButt.setVisible(true);
        f_NorthButt.setFocusable(false);
        f_NorthButt.setBackground(Color.WHITE);
        f_NorthButt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        f_NorthButt.setPreferredSize(new Dimension(200, 30));

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

        int quantity = 1;

        f_CenterLabel[0].setBackground(new Color(255, 255, 255));
        f_CenterLabel[0].setText("<html><div style='text-align: top;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 15px; padding:5px;'>   </p>" +
                "<p style='color: Black; font-weight: bold; font-size: 20;'>  </p></div></html>");
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
        f_SouthButt[1].setText("<html><p style='color: White; font-weight: bold; text-align: center; font-size: 20;'>Review And CheckOut</p></html>");
        f_SouthButt[1].setBackground(new Color(51, 220, 88));

// Initialize and Configure CheckOut Label
        String text = "P " + totalCompPrice;
        f_SouthLabel = new JLabel();
        f_SouthLabel.setBorder(null);
        f_SouthLabel.setOpaque(true);
        f_SouthLabel.setVisible(true);
        f_SouthLabel.setBackground(new Color(246, 187, 145));
        f_SouthLabel.setText("<html><div style='text-align: top;'><p style='color: White; font-weight: bold;'>OrderTotal</p><p style='color: White; font-weight: bold; font-size: 20;'>" + text + "</p></div></html>");
        f_SouthLabel.setHorizontalTextPosition(JLabel.CENTER);
        f_SouthLabel.setVerticalTextPosition(JLabel.TOP);
        f_SouthLabel.setHorizontalAlignment(JLabel.CENTER);
        f_SouthLabel.setPreferredSize(new Dimension(200, 30));

        /*----------------------- Add Components to Panels -----------------------*/

// Add Components to Footer Header
        f_ContParent[0].add(f_NorthLabel, BorderLayout.CENTER);
        f_ContParent[0].add(f_NorthButt, BorderLayout.EAST);
        

// Add Components to Footer Body
        f_CenterLabel[1].add(f_CenterButt[0]);
        f_CenterLabel[1].add(f_CenterButt[1]);

        f_ContParent[1].add(f_CenterLabel[0], BorderLayout.WEST);
        f_ContParent[1].add(f_CenterLabel[1], BorderLayout.CENTER);
        f_ContParent[1].add(f_CenterButt[2], BorderLayout.EAST);

// Add Components to Footer CheckOut
        f_ContParent[2].add(f_SouthButt[0], BorderLayout.WEST);
        f_ContParent[2].add(f_SouthButt[1], BorderLayout.CENTER);
        f_ContParent[2].add(f_SouthLabel, BorderLayout.EAST);

// Add Footer Containers to childPanelCont[2]
        childPanelCont[2].add(f_ContParent[0], BorderLayout.NORTH);
        childPanelCont[2].add(f_ContParent[1], BorderLayout.CENTER);
        childPanelCont[2].add(f_ContParent[2], BorderLayout.SOUTH);

// Add ImageIcon array to JLabels
        for (byte i = 0; i < itemCardImage.length; i++) {
            itemCardLabel[i].setIcon(itemCardImage[i]);
        }

// Add itemCardLabel to itemCardButt
        for (byte i = 0; i < itemCardLabel.length; i++) {
            itemCardButt[i].add(itemCardLabel[i], BorderLayout.CENTER);
        //     itemCardButt[i].addActionListener(this);
        //     itemCardButt[i].setActionCommand("item" + i);
        }

// Add itemCardButt to itemCardContainer
        for (byte i = 0; i < itemCardButt.length; i++) {
            itemCardContainer[i].add(itemCardButt[i], BorderLayout.CENTER);
        }

// Add itemCardContainer to itemCardContParent
        for (byte i = 0; i < itemCardContainer.length; i++) {
            itemCardContParent[i].add(itemCardContainer[i]);
        }

// Add itemCardContParent to childPanelCont (Body - Center)
        for (JPanel parentContainer : itemCardContParent) {
            childPanelCont[1].add(parentContainer);
        }

// Add title label to the first head label
        headLabels[0].add(hLabelTitle, BorderLayout.CENTER);

// Add menu buttons to the second head label
        for (JButton labelMenu : hLabelMenu) {
            headLabels[1].add(labelMenu);
        }

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
    public void dispMessage(String mssg){
        System.out.printf("Message: %s\n", mssg);
    }
    public void breakLine(){
        System.out.println("\n");
    }

    public static void main(String[] args){

        WindowApp startMenu = new WindowApp(625,800,"Jolikod",true,true, new BorderLayout(), JFrame.EXIT_ON_CLOSE);
        startMenu.setVisible(true);

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
                itemCardButt[selectedIndex].setBorder(defaultBorder); // Reset button border
                selectedIndex = -1;
                quantity = 1; // Reset quantity
                f_CenterLabel[0].setText("Quantity: 1"); // Reset quantity label
                updateCartDisplay();
            }
        } else if (command.equals("increaseQuantity")) {
            quantity++;
            f_CenterLabel[0].setText("Quantity: " + quantity); // Corrected concatenation
        } else if (command.equals("decreaseQuantity")) {
            if (quantity > 1) {
                quantity--;
                f_CenterLabel[0].setText("Quantity: " + quantity); // Corrected concatenation
            }
        }
    }

    private void selectItem(int index) {
        if (selectedIndex != -1) {
            itemCardButt[selectedIndex].setBorder(defaultBorder); // Reset previously selected button border
        }
        selectedIndex = index;
        defaultBorder = itemCardButt[index].getBorder(); // Store the default border
        itemCardButt[index].setBorder(BorderFactory.createLineBorder(Color.BLUE, 3)); // Highlight selected button
    }

    public void updateCartDisplay() {
        f_SouthLabel.setText("Total Price: $\n" + totalPrice );
    }
    
}




