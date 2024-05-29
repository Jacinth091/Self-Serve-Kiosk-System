
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowApp extends JFrame {
 
    private JPanel panelMain;
    private JPanel[] childPanelCont;
    private JLabel[] headLabels;
    private JLabel hLabelTitle;
    private JButton[] hLabelMenu;
    private ImageIcon jolibeeIcon;


    // Body Part
    private JPanel[] itemCardContParent;
    
    private JLayeredPane[] itemCardContainer;
    private JLabel[] itemCardLabel;
    private JButton[] itemCardButt;

    private ImageIcon[] itemCardImage;

//    private List<> componentList;

    WindowApp(){

    }
    

    WindowApp(int width, int height, String title,
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
        hLabelTitle.setText("MENU");
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
//            itemCardContParent[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            itemCardContParent[i].setLayout(new OverlayLayout(itemCardContParent[i]));

        }

        // Initialize itemCardContainer
        itemCardContainer = new JLayeredPane[6];
        for(byte i =0; i< itemCardContainer.length; i++){
            itemCardContainer[i] = new JLayeredPane();
            itemCardContainer[i].setOpaque(true);
            itemCardContainer[i].setVisible(true);
//            itemCardContainer[i].setBackground(Color.BLUE);
            itemCardContainer[i].setPreferredSize(new Dimension(300,200));
            itemCardContainer[i].setLayout(new BorderLayout());
            itemCardContainer[i].setBorder(BorderFactory.createLineBorder(Color.red,2));


        }
        // Initialize itemCardCButton
        itemCardButt = new JButton[6];

        for(byte i =0; i< itemCardButt.length; i++){
            itemCardButt[i] = new JButton();
            itemCardButt[i].setBorder(null);
            itemCardButt[i].setOpaque(true);
            itemCardButt[i].setVisible(true);
//            itemCardButt[i].setText("Button " + (i + 1));
            itemCardButt[i].setName("Card " + (i+1));
            itemCardButt[i].setLayout(new BorderLayout());

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
//            itemCardLabel[i].setBackground(Color.RED);
//            itemCardLabel[i].setBounds(itemCardContParent[i].getX(),itemCardContParent[i].getY(),itemCardContParent[i].getWidth(), itemCardContParent[i].getHeight());
//            itemCardLabel[i].setBounds(50,50,100,100);
//            itemCardLabel[i].setText("Button " + (i + 1));
            itemCardLabel[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
            itemCardLabel[i].setText("Helloooo");

        }
        // Initialize ImageIcon[]

        itemCardImage = new ImageIcon[6];
        for(byte i =0; i< itemCardImage.length; i++){
            itemCardImage[i] = new ImageIcon(getClass().getResource("Assets/item_pictures/BS-item-1.png"));
            itemCardImage[i] = resizeImageIcon(itemCardImage[i], 150, 105);

        }




        // add ImageIcon array in Jlabel
        for(byte i =0; i < itemCardImage.length; i++){
            itemCardLabel[i].setIcon(itemCardImage[i]);

        }


        // add JLayeredPane array to childPanelCont (BODY Panel - CENTER)
        for(byte i=0; i< itemCardLabel.length; i++){
            itemCardButt[i].add(itemCardLabel[i],BorderLayout.CENTER);
        }


        // add JLayeredPane array to childPanelCont (BODY Panel - CENTER)
        for(byte i=0; i< itemCardButt.length; i++){
        itemCardContainer[i].add(itemCardButt[i], BorderLayout.CENTER);
        }

        // add itemCardContainer array to itemCardContParent array
        for (byte i =0; i< itemCardContainer.length; i++) {
            itemCardContParent[i].add(itemCardContainer[i]);
        }

        // add ItemCardContParent (JPanel) array to childPanelCont (BODY Panel - CENTER)
        for (JPanel ParentContainer : itemCardContParent) {
            childPanelCont[1].add(ParentContainer);
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
        this.panelMain.add(childPanelCont[0], BorderLayout.NORTH);
        this.panelMain.add(childPanelCont[1], BorderLayout.CENTER);
        this.panelMain.add(childPanelCont[2], BorderLayout.SOUTH);


        // Add main panel to the frame
        this.add(panelMain, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        revalidate();
        repaint();
//        pack();







 
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

}




