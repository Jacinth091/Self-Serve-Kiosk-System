import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
// import javax.swing.BorderLayout;
class Front extends JFrame implements ActionListener {
    JFrame frame;
    JLabel displayField;
    ImageIcon image;
    JPanel panel;
    JButton button;
    

    Front() {
        frame = new JFrame("Display Test");

        // Load the image
        image = new ImageIcon(getClass().getResource("front.png"));
        ImageIcon scaledIcon = new ImageIcon(image.getImage().getScaledInstance(625, 600, java.awt.Image.SCALE_SMOOTH));

        // Create a JLabel to display the image
        displayField = new JLabel(image);
        displayField.setBounds(10, 20, image.getIconWidth(), image.getIconHeight());
        displayField.setIcon(scaledIcon);

        // Create a panel and add the JLabel to it
        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, -10, 625, 600);
        panel.add(displayField); // Add the displayField JLabel to the panel

        button = new JButton("Tap to Start");
        button.setBackground(Color.BLACK);
        button.addActionListener(this);
        button.setBounds(175, 610, 250, 40);
        button.setFocusable(false);

        frame.add(button);
        frame.add(panel); // Add the panel to the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(625, 700);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Front();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
          frame.remove(button);
        frame.remove(panel);
          WindowApp startMenu = new WindowApp(625,800,"Jolikod",true,true, new BorderLayout(), JFrame.EXIT_ON_CLOSE);
           // Repaint the frame
        frame.revalidate();
        frame.repaint();
        }
    }

    // private void openNewFrame() {
    //     panel.removeAll();
    //     JLabel newContentLabel = new JLabel("New Content");
    //     newContentLabel.setForeground(Color.WHITE);
    //     newContentLabel.setHorizontalAlignment(SwingConstants.CENTER);
    //     newContentLabel.setBounds(50, 50, 525, 40);
    //     panel.add(newContentLabel);

    //     // Repaint the panel
    //     panel.revalidate();
    //     // panel.repaint();
    // }
}
