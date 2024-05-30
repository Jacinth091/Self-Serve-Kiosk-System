import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAppDemo extends JFrame implements ActionListener {

    private JPanel panelMain;
    private CardLayout cardLayout;
    private JPanel cardContParent;
    private JPanel[] cardCont;
    private JButton[] h_MenuButt;

    public MenuAppDemo() {
        setTitle("Menu App Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel configuration
        panelMain = new JPanel();
        panelMain.setBackground(Color.GRAY);
        panelMain.setLayout(new BorderLayout());
        panelMain.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Card layout configuration
        cardContParent = new JPanel();
        cardContParent.setLayout(new CardLayout());
        cardLayout = (CardLayout) cardContParent.getLayout();

        // Create card panels
        cardCont = new JPanel[4];
        for (int i = 0; i < cardCont.length; i++) {
            cardCont[i] = new JPanel();
            cardCont[i].setBackground(getRandomColor());
            cardContParent.add(cardCont[i], "card" + (i + 1));
        }

        // Create menu buttons
        h_MenuButt = new JButton[4];
        for (int i = 0; i < h_MenuButt.length; i++) {
            h_MenuButt[i] = new JButton("Menu " + (i + 1));
            h_MenuButt[i].addActionListener(this);
            h_MenuButt[i].setActionCommand("Menu " + (i + 1));
        }

        // Add components to the main panel
        for (JButton button : h_MenuButt) {
            panelMain.add(button, BorderLayout.NORTH);
        }
        panelMain.add(cardContParent, BorderLayout.CENTER);

        // Add main panel to the frame
        add(panelMain);

        pack();
        setLocationRelativeTo(null);
    }

    private Color getRandomColor() {
        return new Color((int) (Math.random() * 0x1000000));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.startsWith("Menu")) {
            int index = Integer.parseInt(command.substring(5));
            cardLayout.show(cardContParent, "card" + (index + 1));
            System.out.println(command); // For debugging
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MenuAppDemo().setVisible(true);
        });
    }
}
