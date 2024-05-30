import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.BorderFactory;


class BorderButtonDemo implements ActionListener {
    private JFrame frame;
    private JPanel cardContParent;
    private JPanel[] cardCont;
    private JButton[][] buttons;
    private String imgPath = "Assets/item_pictures/BS/BS-item-1.png";
    private JButton selectedButton = null;
    private Border defaultBorder = BorderFactory.createLineBorder(Color.GRAY, 1);
    private Border selectedBorder = BorderFactory.createLineBorder(Color.BLUE, 3);

    public BorderButtonDemo() {
        cardContParent = new JPanel(new CardLayout());
        cardCont = new JPanel[4];
        buttons = new JButton[4][6];

        initUi();
    }

    private void initUi() {
        frame = new JFrame("Border Button Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        for (int i = 0; i < cardCont.length; i++) {
            cardCont[i] = new JPanel();
            cardCont[i].setLayout(new GridLayout(2, 3)); // 2 rows and 3 columns
            cardContParent.add(cardCont[i], "card" + (i + 1));

            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton("Product " + (j + 1));
                buttons[i][j].setActionCommand("item" + (i * 6 + j));
                buttons[i][j].addActionListener(this);
                buttons[i][j].setBorder(defaultBorder);
                cardCont[i].add(buttons[i][j]);
            }
        }

        // Make the first button selected initially
        buttons[0][0].setBorder(selectedBorder);
        selectedButton = buttons[0][0];

        frame.add(cardContParent);
        frame.setVisible(true);

        // Show the first card initially
        showCard(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.startsWith("item")) {
            handleButtonClick((JButton) e.getSource());
        }
    }

    private void handleButtonClick(JButton button) {
        if (selectedButton != null) {
            selectedButton.setBorder(defaultBorder); // Reset previously selected button border
        }

        button.setBorder(selectedBorder); // Highlight the current button
        selectedButton = button; // Update the selected button reference
    }

    private void showCard(int index) {
        CardLayout cl = (CardLayout) (cardContParent.getLayout());
        cl.show(cardContParent, "card" + (index + 1));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BorderButtonDemo::new);
    }
}
