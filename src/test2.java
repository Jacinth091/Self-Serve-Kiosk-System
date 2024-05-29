/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Wia extends JFrame {
    private JPanel panelMain;
    private JPanel[] childPanelCont;
    private JLabel[] headLabels;
    private JLabel hLabelTitle;
    private JButton[] hLabelMenu;
    private ImageIcon jolibeeIcon;

    // Body - Center Part
    private JPanel[] itemCardContParent;
    private JLayeredPane[] itemCardContainer;
    private JLabel[] itemCardLabel;
    private JButton[] itemCardButt;
    private ImageIcon[] itemCardImage;

    // Footer - Bottom Part
    private JPanel cartPanelCont;
    private JPanel cartPanelTitle;
    private JLabel cartPanelTitleLabel;
    private JButton cartPanelTitleButton;
    private JPanel cartPanelBody;
    private JLabel cartPanelBodyLabel;
    private JButton[] cartButton;
    private JPanel checkOutPanelCont;
    private JButton[] checkOutButton;
    private JLabel checkOutLabel;

    float totalCompPrice = 0.00f;

    public WindowApp() {
    }

    public WindowApp(int width, int height, String title,
                     boolean isVisible, boolean isResizable, LayoutManager layout, int defCloseOper) {
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
        childPanelCont[0].setPreferredSize(new Dimension(100, 200));
        childPanelCont[0].setLayout(new GridLayout(2, 1));

        // Body - Center
        childPanelCont[1].setLayout(new GridLayout(2, 6, 10, 10));
        childPanelCont[1].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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
        hLabelTitle.setText("<html><p style='color: White; font-weight: bold; text-align: center; font-size: 30;'>Jolibee Menu</p></html>");
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
        for (byte i = 0; i < itemCardContParent.length; i++) {
            itemCardContParent[i] = new JPanel();
            itemCardContParent[i].setOpaque(true);
            itemCardContParent[i].setVisible(true);
            itemCardContParent[i].setToolTipText("Parent Cont");
            itemCardContParent[i].setPreferredSize(new Dimension(300, 200));
            itemCardContParent[i].setLayout(new OverlayLayout(itemCardContParent[i]));
        }

        // Initialize itemCardContainer
        itemCardContainer = new JLayeredPane[6];
        for (byte i = 0; i < itemCardContainer.length; i++) {
            itemCardContainer[i] = new JLayeredPane();
            itemCardContainer[i].setOpaque(true);
            itemCardContainer[i].setVisible(true);
            itemCardContainer[i].setPreferredSize(new Dimension(300, 200));
            itemCardContainer[i].setLayout(new BorderLayout());
        }

        // Initialize itemCardButton
        itemCardButt = new JButton[6];
        for (byte i = 0; i < itemCardButt.length; i++) {
            itemCardButt[i] = new JButton();
            itemCardButt[i].setBorder(null);
            itemCardButt[i].setOpaque(true);
            itemCardButt[i].setVisible(true);
            itemCardButt[i].setName("Card " + (i + 1));
            itemCardButt[i].setLayout(new BorderLayout());
            itemCardButt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Action to perform when the button is clicked
                    JButton source = (JButton) e.getSource();
                    System.out.print("Button clicked!\n");
                    System.out.println(source.getName());
                }
            });
        }

        // Initialize itemCardLabel
        itemCardLabel = new JLabel[6];
        for (byte i = 0; i < itemCardLabel.length; i++) {
            itemCardLabel[i] = new JLabel();
            itemCardLabel[i].setBorder(null);
            itemCardLabel[i].setOpaque(true);
            itemCardLabel[i].setVisible(true);
            itemCardLabel[i].setBackground(Color.WHITE);
            itemCardLabel[i].setText("<html><p style='color: red; font-weight: bold; text-align: center;'>P 212.00</p><br><p>Product Description</p></html>");
            itemCardLabel[i].setHorizontalTextPosition(JLabel.CENTER);
            itemCardLabel[i].setVerticalTextPosition(JLabel.BOTTOM);
            itemCardLabel[i].setHorizontalAlignment(JLabel.CENTER);
        }

        // Initialize itemCardImage
        itemCardImage = new ImageIcon[6];
        for (byte i = 0; i < itemCardImage.length; i++) {
            itemCardImage[i] = new ImageIcon(getClass().getResource("Assets/item_pictures/BS-item-1.png"));
            itemCardImage[i] = resizeImageIcon(itemCardImage[i], 100, 70);
        }

        */
/*----------------------- childPanelCont[2] FOOTER - BOTTOM PART -----------------------*//*


        // Initialize CartPanelContainer
        cartPanelCont = new JPanel();
        cartPanelCont.setOpaque(true);
        cartPanelCont.setVisible(true);
        cartPanelCont.setToolTipText("Cart Container");
        cartPanelCont.setLayout(new BorderLayout());

        // Initialize CartPanelTitle
        cartPanelTitle = new JPanel();
        cartPanelTitle.setOpaque(true);
        cartPanelTitle.setVisible(true);
        cartPanelTitle.setToolTipText("Cart Title");
        cartPanelTitle.setBackground(new Color(218, 181, 83));
        cartPanelTitle.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        cartPanelTitle.setLayout(new BorderLayout(5, 5));

        cartPanelTitleLabel = new JLabel();
        cartPanelTitleLabel.setBorder(null);
        cartPanelTitleLabel.setOpaque(true);
        cartPanelTitleLabel.setVisible(true);
        cartPanelTitleLabel.setBackground(Color.WHITE);
        cartPanelTitleLabel.setText("<html><p style='color: Black; font-weight: bold; text-align: center; font-size: 15px'>Order Options</p></html>");
        cartPanelTitleLabel.setHorizontalTextPosition(JLabel.CENTER);
        cartPanelTitleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        cartPanelTitleLabel.setHorizontalAlignment(JLabel.CENTER);

        cartPanelTitleButton = new JButton();
        cartPanelTitleButton.setText("View Cart");
        cartPanelTitleButton.setBorder(null);
        cartPanelTitleButton.setOpaque(true);
        cartPanelTitleButton.setVisible(true);
        cartPanelTitleButton.setPreferredSize(new Dimension(200, 30));

        cartPanelTitle.add(cartPanelTitleLabel, BorderLayout.CENTER);
        cartPanelTitle.add(cartPanelTitleButton, BorderLayout.EAST);

        // Initialize CartPanelBody
        cartPanelBody = new JPanel();
        cartPanelBody.setOpaque(true);
        cartPanelBody.setVisible(true);
        cartPanelBody.setToolTipText("Cart Body");
        cartPanelBody.setBackground(new Color(126, 34, 12));
        cartPanelBody.setLayout(new BorderLayout());

        cartPanelCont.add(cartPanelTitle, BorderLayout.NORTH);
        cartPanelCont.add(cartPanelBody, BorderLayout.CENTER);

        childPanelCont[2].add(cartPanelCont, BorderLayout.CENTER);

        // Initialize CheckOutPanelContainer
        checkOutPanelCont = new JPanel();
        checkOutPanelCont.setOpaque(true);
        checkOutPanelCont.setVisible(true);
        checkOutPanelCont.setBackground(Color.RED);
        checkOutPanelCont.setToolTipText("Check Out Container");
        checkOutPanelCont.setPreferredSize(new Dimension(0, 60));
        checkOutPanelCont.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        checkOutPanelCont.setLayout(new BorderLayout(5, 5));

        checkOutButton = new JButton[2];
        for (byte i = 0; i < checkOutButton.length; i++) {
            checkOutButton[i] = new JButton();
            checkOutButton[i].setOpaque(true);
            checkOutButton[i].setVisible(true);
        }

        checkOutButton[0].setPreferredSize(new Dimension(100, 30));
        checkOutButton[0].setText("<html><p style='color: white; font-weight: bold; text-align: center; font-size: 15px;'>Back</p></html>");
        checkOutButton[0].setBackground(null);
        checkOutButton[0].setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        checkOutButton[0].setFocusable(false);

        checkOutButton[1].setText("<html><p style='color: White; font-weight: bold; text-align: center; font-size: 20;'>Review And CheckOut</p></html>");
        checkOutButton[1].setBackground(new Color(51, 220, 88));

        String text = "P " + totalCompPrice;
        checkOutLabel = new JLabel();
        checkOutLabel.setBorder(null);
        checkOutLabel.setOpaque(true);
        checkOutLabel.setVisible(true);
        checkOutLabel.setBackground(new Color(246, 187, 145));
        checkOutLabel.setText("<html><div style='text-align: top;'><p style='color: White; font-weight: bold;'>OrderTotal</p><p style='color: White; font-weight: bold; font-size: 20;'>" + text + "</p></div></html>");
        checkOutLabel.setHorizontalTextPosition(JLabel.CENTER);
        checkOutLabel.setVerticalTextPosition(JLabel.TOP);
        checkOutLabel.setHorizontalAlignment(JLabel.CENTER);
        checkOutLabel.setPreferredSize(new Dimension(200, 30));

        checkOutPanelCont.add(checkOutButton[0], BorderLayout.WEST);
        checkOutPanelCont.add(checkOutButton[1], BorderLayout.CENTER);
        checkOutPanelCont.add(checkOutLabel, BorderLayout.EAST);

        childPanelCont[2].add(checkOutPanelCont, BorderLayout.SOUTH);

        // Add ImageIcon array to JLabels
        for (byte i = 0; i < itemCardImage.length; i++) {
            itemCardLabel[i].setIcon(itemCardImage[i]);
        }

        // Add itemCardLabel to itemCardButt
        for (byte i = 0; i < itemCardLabel.length; i++) {
            itemCardButt[i].add(itemCardLabel[i], BorderLayout.CENTER);
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

    public void initApp(int width, int height, String title, boolean isVisible, boolean isResizable, LayoutManager layout, int defCloseOper) {
        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(defCloseOper);
        setLayout(layout);
        setVisible(isVisible);
        setResizable(isResizable);
    }

    public static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage(); // Get the image from the ImageIcon
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Resize the image
        return new ImageIcon(resizedImage); // Create a new ImageIcon with the resized image
    }

    public void dispMessage(String mssg) {
        System.out.printf("Message: %s\n", mssg);
    }

    public void breakLine() {
        System.out.println("\n");
    }

    public static void main(String[] args) {
        new WindowApp(800, 600, "Jolibee Menu", true, true, new BorderLayout(), JFrame.EXIT_ON_CLOSE);
    }
}


*/
