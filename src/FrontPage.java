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
import javax.swing.*;
import javax.swing.border.Border;

class FrontPage extends JFrame implements ActionListener {
    JFrame frame;
    JLabel displayField;
    ImageIcon image;
    JPanel panel;
    JButton button, buttonTakeOUT, buttonDineIn;

    public FrontPage() {
        Border border1 = BorderFactory.createLineBorder(Color.black,5);
        
        frame = new JFrame("JOLLIKOD by L.A.B.S");

        // Load the image
        image = new ImageIcon(getClass().getResource("Assets/pictures/wallpaper.png"));
        ImageIcon scaledIcon = new ImageIcon(image.getImage().getScaledInstance(610, 665, java.awt.Image.SCALE_SMOOTH));

        // Create a JLabel to display the image
        displayField = new JLabel(scaledIcon);
        displayField.setBounds(0, 0, scaledIcon.getIconWidth(), scaledIcon.getIconHeight());

        // Create a panel and add the JLabel to it
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 625, 700);
        panel.add(displayField); // Add the displayField JLabel to the panel

        buttonTakeOUT = new JButton("TAKE OUT");
        buttonTakeOUT.setForeground(Color.BLACK);
        buttonTakeOUT.setFont(new Font("ARIAL", Font.BOLD, 19));
        buttonTakeOUT.setBackground(new Color(180, 6, 29, 255));
        buttonTakeOUT.setBorder(border1);
        buttonTakeOUT.addActionListener(this);
        buttonTakeOUT.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonTakeOUT.setBounds(150, 520, 150, 70);
        buttonTakeOUT.setFocusable(false);

        buttonDineIn = new JButton("DINE IN");
        buttonDineIn.setForeground(Color.BLACK);
        buttonDineIn.setFont(new Font("ARIAL", Font.BOLD, 19));
        buttonDineIn.setBackground(new Color(4, 136, 43));
        buttonDineIn.setBorder(border1);
        buttonDineIn.addActionListener(this);
        buttonDineIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonDineIn.setBounds(310, 520, 150, 70);
        buttonDineIn.setFocusable(false);

        frame.add(buttonDineIn);
        frame.add(buttonTakeOUT);
        frame.add(panel); // Add the panel to the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(625, 700);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new FrontPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonDineIn || e.getSource() == buttonTakeOUT) {
           new MenuApp(625,800,"JOLLIKOD by L.A.B.S",true,false, new BorderLayout(), JFrame.EXIT_ON_CLOSE);
           frame.setVisible(false);
        }
    }   

  
}
