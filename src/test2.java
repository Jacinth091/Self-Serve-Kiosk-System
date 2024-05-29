import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class test2 extends JLabel {
    private int cornerRadius = 15; // The radius of the corners

    public test2(String text) {
        super(text);
        setOpaque(false); // Make sure the label is not opaque so we can paint the background ourselves
    }

    public test2(String text, int cornerRadius) {
        super(text);
        this.cornerRadius = cornerRadius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Paint the background with rounded corners
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

        // Ensure the label's text is painted
        super.paintComponent(g);

        g2.dispose();
    }

    // Overriding setText method to ensure it updates the component
    @Override
    public void setText(String text) {
        super.setText(text);
        revalidate(); // Revalidate the component to ensure layout is updated
        repaint(); // Repaint the component to update the display
    }

    // Getter and setter for the corner radius
    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint(); // Repaint the label when the corner radius changes
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Rounded Label Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());

            // Creating the RoundedCorners instance
            RoundedCorners roundedLabel = new RoundedCorners("Rounded Label");
            roundedLabel.setBackground(Color.CYAN);
            roundedLabel.setForeground(Color.BLACK);
            roundedLabel.setFont(new Font("Arial", Font.BOLD, 20));
            roundedLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

            // Buttons to change and revert text
            JButton changeTextButton = new JButton("Change Text");
            JButton revertTextButton = new JButton("Revert Text");

            // Add action listeners for buttons
            ActionListener actionListener = new ActionListener() {
                private String previousText = roundedLabel.getText();

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == changeTextButton) {
                        previousText = roundedLabel.getText();
                        roundedLabel.setText("Hello, World!");
                    } else if (e.getSource() == revertTextButton) {
                        roundedLabel.setText(previousText);
                    }
                }
            };

            changeTextButton.addActionListener(actionListener);
            revertTextButton.addActionListener(actionListener);

            // Adding components to the frame
            frame.add(roundedLabel);
            frame.add(changeTextButton);
            frame.add(revertTextButton);

            // Packing the frame to fit the preferred size of the label
            frame.pack();

            // Setting the frame location to center of the screen
            frame.setLocationRelativeTo(null);

            // Making the frame visible
            frame.setVisible(true);
        });
    }
}
