
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Component;
 
public class WindowApp extends JFrame {
 
    private JPanel panelMain;
    private JPanel[] headerPanels;
    private JLabel[] headLabels;
    private JLabel hLabelTitle;
    private JButton[] hLabelMenu;
    private ImageIcon jolibeeIcon;
    private BorderFactory border;

    WindowApp(){

    }
    

    WindowApp(int width, int height, String title,
    boolean isVisible, boolean isResizable, LayoutManager layout, int defCloseOper)
    {
        initApp(width, height, title, isVisible, isResizable, layout, defCloseOper);
        panelMain = new JPanel();

        panelMain.setBackground(Color.GRAY);
        panelMain.setVisible(true);
        panelMain.setLayout(new BorderLayout());

        panelMain.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));





        headerPanels = new JPanel[3];

        for(int i = 0; i < headerPanels.length; i++){
            headerPanels[i] = new JPanel();

            headerPanels[i].setOpaque(true);
            headerPanels[i].setVisible(true);
            headerPanels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            headerPanels[0].setLayout(new GridLayout());

        }

        headerPanels[0].setPreferredSize(new Dimension(100,200));
        headerPanels[0].setLayout(new GridLayout(2,1));

        headerPanels[2].setPreferredSize(new Dimension(100,200));




        headLabels = new JLabel[2];

        for(int i = 0; i < headLabels.length; i++){
            headLabels[i] = new JLabel();

            headLabels[i].setOpaque(true);
            headLabels[i].setVisible(true);
            headLabels[i].setBackground(new Color(255,24,12));
            headLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        }
        headLabels[0].setBackground(new Color(112,47,43));
        headLabels[0].setLayout(new BorderLayout());

        headLabels[1].setBackground(new Color(112,47,43));
        headLabels[1].setLayout(new GridLayout(1, 4));

        hLabelTitle = new JLabel();
        hLabelTitle.setText("MENU");
        hLabelTitle.setHorizontalAlignment(JLabel.CENTER);
//        hLabelTitle.setFont(new Font("Times New Roman"),);


        jolibeeIcon = new ImageIcon(getClass().getResource("Assets/logo/Joli-Logo.png"));
        jolibeeIcon= resizeImageIcon(jolibeeIcon, 120,90);
        hLabelTitle.setIcon(jolibeeIcon);


        hLabelMenu = new JButton[4];

        for(int i=0; i<hLabelMenu.length; i++){
            hLabelMenu[i] = new JButton();

            hLabelMenu[i].setText("Hello");
            hLabelMenu[i].setVisible(true);
            hLabelMenu[i].setOpaque(true);
        }



        this.add(panelMain, BorderLayout.CENTER);


        this.panelMain.add(headerPanels[0], BorderLayout.NORTH);
        this.panelMain.add(headerPanels[1], BorderLayout.CENTER);
        this.panelMain.add(headerPanels[2], BorderLayout.SOUTH);


        for(byte i =0; i<headLabels.length;i++){
            headerPanels[0].add(headLabels[i]);
        }

        for(byte i =0; i<hLabelMenu.length;i++){
            headLabels[1].add(hLabelMenu[i]);
        }


        headLabels[0].add(hLabelTitle, BorderLayout.CENTER);






 
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




}




