import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

class test{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Nested Layout Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Create a panel with GridLayout
            JPanel gridPanel = new JPanel(new GridLayout(3, 3));

            // Add nested panels to each cell of the grid
            for (int i = 0; i < 9; i++) {
                JPanel cellPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Use FlowLayout for each cell
                JLabel label = new JLabel("Cell " + (i + 1));
                JButton button = new JButton("Button " + (i + 1));
                cellPanel.add(label);
                cellPanel.add(button);
                gridPanel.add(cellPanel);

                System.out.printf("x: %d\n",label.getX() );
                System.out.printf("y: %d\n",label.getY() );
                System.out.printf("Width: %d\n",label.getWidth() );
                System.out.printf("Height: %d\n",label.getHeight() );

                // Add a component listener to each cell panel
                cellPanel.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentShown(ComponentEvent e) {
                        super.componentShown(e);
                        // Print location and size after the component is shown
                        System.out.println("Location: " + cellPanel.getLocation());
                        System.out.println("Size: " + cellPanel.getSize());
                    }
                });
            }

            frame.add(gridPanel);
            frame.setVisible(true);
        });
    }
}
