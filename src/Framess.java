import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.*;
import javax.swing.border.Border;
public class Framess extends JFrame implements ActionListener, MouseListener {

    
    JFrame[] frames = new JFrame[2];
    JPanel[] panels = new JPanel[20];

    JLabel[] labels = new JLabel[20];

    JButton[] buttons = new JButton[20];

    ImageIcon[] image = new ImageIcon[10];

    Border border, border1, border2, border3, borderForEdit;

    //changes
    MenuApp menuApp = new MenuApp();
    // double totalCartPrice = 0.0;

    public Framess(MenuApp menuApp) {
        this.menuApp = menuApp;
        initFrame();
    }

    Framess() {
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
        borderForEdit = BorderFactory.createLineBorder(Color.black, 3);

        // ICON OR IMAGE ==============================================================================
        image[0] = new ImageIcon("C:\\Users\\Admin\\IdeaProjects\\tEST\\src\\jollibee.png"); // jollibee picture
        ImageIcon scaledIcon = new ImageIcon(image[0].getImage().getScaledInstance(170, 70, Image.SCALE_SMOOTH));

        image[1] = new ImageIcon("C:\\Users\\Admin\\IdeaProjects\\tEST\\src\\remove.png"); // CHECK LOGO sa PROCEED PAYMENT
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
        labels[2].setText("<html><div style='text-align: center;'><p style='color: Black; font-weight: bold; text-align: center; font-size: 12px;'>Order Total: <span style='color: Black; font-weight: bold; font-size: 20;'<br>" + menuApp.getTotalCartPrice() +" <br></span> </p></div></html>");
        labels[2].setBounds(55,5, 150, 50);
        labels[2].setFont(new Font("ARIAL", Font.BOLD, 16));


        labels[3] = new JLabel(); // EDIT ORDER
        labels[3].setText("EDIT ORDER");
        labels[3].setForeground(new Color(222, 187, 6, 255));
        labels[3].setBounds(220, 20, 200, 50);
        labels[3].setFont(new Font("ARIAL", Font.BOLD, 30));


        // BUTTON ====================================================================================
        buttons[0] = new JButton("PROCEED TO PAYMENT"); // PROCEED BUTTON
        buttons[0].setForeground(Color.BLACK);
        buttons[0].setFont(new Font("Arial", Font.BOLD, 11));
        buttons[0].setBackground(new Color(4, 136, 43));
        buttons[0].setBounds(428, 12, 171, 50);
        buttons[0].setIcon(scaledCheck);
        buttons[0].setBorder(border3);
        buttons[0].addActionListener(this);
        buttons[0].setFocusable(false);


        buttons[1] = new JButton("CLOSE"); // BACK BUTTON
        buttons[1].setForeground(Color.WHITE);
        buttons[1].setFont(new Font("ARIAL", Font.BOLD, 16));
        buttons[1].setBackground(new Color(99, 0, 0));
        buttons[1].setBounds(10, 10, 150, 50);
        buttons[1].addActionListener(this);
        buttons[1].setFocusable(false);
        buttons[1].setBorder(border);

        

        // PANEL =================================================================================

        panels[0] = new JPanel(); // GRAY COLOR
        panels[0].setBackground(Color.DARK_GRAY);
        panels[0].setBounds(0, 0, 610, 90);
        panels[0].setLayout(new BorderLayout());
        panels[0].setBorder(border2);

        panels[1] = new JPanel(); // RED COLOR kanang 2nd COLOR
        panels[1].setBackground(Color.RED);
        panels[1].setBounds(0, 90, 610, 80);
        panels[1].setLayout(null);
        panels[1].add(labels[3]);

        panels[2] = new JPanel(); // DARK RED kanang UBOS
        panels[2].setBackground(new Color(99, 0, 0));
        panels[2].setBounds(0, 590, 610, 80);
        panels[2].setLayout(null);
        panels[2].setBorder(border1);
        panels[2].add(buttons[0]);
        panels[2].add(buttons[1]);

        
        

        panels[3] = new JPanel(); // WHITE COLOR, kanang center dako nga white
        panels[3].setBackground(Color.WHITE);
        panels[3].setBounds(0, 170, 650, 420);
        panels[3].setLayout(null);
        // panels[3].addMouseListener(this);

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

        frames[0].setSize(625, 700);
        frames[0].setLayout(null);
        frames[0].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frames[0].setVisible(true);
        frames[0].setResizable(false);;



        panels[0].add(labels[0]);
        frames[0].add(panels[5]);
        panels[2].add(panels[4]);
        frames[0].add(panels[0]);
        frames[0].add(panels[2]);
        // frames[0].setComponentZOrder(panels[2], 100);
        frames[0].add(panels[3]);
        frames[0].add(panels[1]);
       
        int x = 700;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 16;
        frames[0].setLocation(x,y);
        
        
    }

    public static void main(String[] args) {
        new Framess();

    }


   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[1]) {
            frames[0].setVisible(false);
            menuApp.setLocationRelativeTo(null);
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
        frames[0].setVisible(false);
        menuApp.setLocationRelativeTo(null);
    }



}

