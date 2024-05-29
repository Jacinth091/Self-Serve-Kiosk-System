import javax.swing.*;
import java.awt.*;

class test2 extends JFrame {

    private JPanel panelMain;
    private JPanel[] headerPanels;
    private JLabel[] headLabels;
    private JLabel hLabelTitle;
    private JButton[] hLabelMenu;
    private ImageIcon jolibeeIcon;

    // Default constructor
    test2() {
    }

    // Parameterized constructor
    test2(int width, int height, String title, boolean isVisible, boolean isResizable, LayoutManager layout, int defCloseOper) {
        // Initialize Window
        initApp(width, height, title, isVisible, isResizable, layout, defCloseOper);

        // Set up the initial window (you can change this to any other window method)
        MenuWindow();
    }

    // Method to initialize the application window
    public void initApp(int width, int height, String title, boolean isVisible, boolean isResizable, LayoutManager layout, int defCloseOper) {
        this.setSize(width, height);
        this.setTitle(title);
        this.setDefaultCloseOperation(defCloseOper);
        this.setLayout(layout);
        this.setVisible(isVisible);
        this.setResizable(isResizable);

        // Initialize the main panel
        panelMain = new JPanel();
        panelMain.setBackground(Color.GRAY);
        panelMain.setVisible(true);
        panelMain.setLayout(new BorderLayout());
        panelMain.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.add(panelMain, BorderLayout.CENTER);
    }

    // Method to set up the menu window
    public void MenuWindow() {
        // Clear the main panel
        panelMain.removeAll();
        panelMain.revalidate();
        panelMain.repaint();

        // Initialize header panels
        headerPanels = new JPanel[3];
        for (int i = 0; i < headerPanels.length; i++) {
            headerPanels[i] = new JPanel();
            headerPanels[i].setOpaque(true);
            headerPanels[i].setVisible(true);
            headerPanels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        }

        // Header panel layouts and sizes
        headerPanels[0].setPreferredSize(new Dimension(100, 200));
        headerPanels[0].setLayout(new GridLayout(2, 1));
        headerPanels[2].setPreferredSize(new Dimension(100, 200));

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

        // Test label to be added on a button
        JLabel test = new JLabel();
        test.setOpaque(true);
        test.setVisible(true);
        test.setBackground(Color.RED);

        // Add header panels to the main panel
        panelMain.add(headerPanels[0], BorderLayout.NORTH);
        panelMain.add(headerPanels[1], BorderLayout.CENTER);
        panelMain.add(headerPanels[2], BorderLayout.SOUTH);

        // Add head labels to the first header panel
        for (byte i = 0; i < headLabels.length; i++) {
            headerPanels[0].add(headLabels[i]);
        }

        // Add menu buttons to the second head label
        for (byte i = 0; i < hLabelMenu.length; i++) {
            headLabels[1].add(hLabelMenu[i]);
        }

        // Add test label to the first menu button
        hLabelMenu[0].setLayout(new BorderLayout());
        hLabelMenu[0].add(test, BorderLayout.CENTER);

        // Add title label to the first head label
        headLabels[0].add(hLabelTitle, BorderLayout.CENTER);

        // Refresh the main panel
        panelMain.revalidate();
        panelMain.repaint();
    }

    // Method to set up another window (e.g., Settings Window)
    public void SettingsWindow() {
        // Clear the main panel
        panelMain.removeAll();
        panelMain.revalidate();
        panelMain.repaint();

        // Create settings content
        JLabel settingsLabel = new JLabel("Settings Window", SwingConstants.CENTER);
        settingsLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panelMain.add(settingsLabel, BorderLayout.CENTER);

        // Refresh the main panel
        panelMain.revalidate();
        panelMain.repaint();
    }

    // Method to resize an ImageIcon
    public static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage(); // Get the image from the ImageIcon
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Resize the image
        return new ImageIcon(resizedImage); // Create a new ImageIcon with the resized image
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            test2 app = new test2(800, 600, "WindowApp", true, true, new BorderLayout(), JFrame.EXIT_ON_CLOSE);
            // To switch to another window, call the appropriate method, e.g., app.SettingsWindow();
            app.SettingsWindow();
        });
    }
}
