import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

class RoundedCorners extends JLabel {
    private int cornerRadius = 15; // The radius of the corners

    public RoundedCorners(String text) {
        super(text);
        setOpaque(false); // Make sure the label is not opaque so we can paint the background ourselves
    }

    public RoundedCorners(String text, int cornerRadius) {
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
}