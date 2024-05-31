
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class FrontPage extends JFrame implements ActionListener {
    JFrame frame;
    JLabel displayField;
    ImageIcon image;
    JPanel panel;
    JButton button;

    public FrontPage() {
        Border border1 = BorderFactory.createLineBorder(Color.black,5);
        
        frame = new JFrame("JOLLIKOD");

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

        button = new JButton("START");
        button.setForeground(Color.BLACK);
        button.setFont(new Font("ARIAL", Font.BOLD, 30));
        button.setBackground(new Color(180, 6, 29, 255));
        button.setBorder(border1);
        button.addActionListener(this);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBounds(175, 520, 250, 70);
        button.setFocusable(false);

        frame.add(button);
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
        if (e.getSource() == button) {
           new MenuApp(625,800,"Jolikod",true,false, new BorderLayout(), JFrame.EXIT_ON_CLOSE);
           frame.setVisible(false);
        }
    }   

  
}
