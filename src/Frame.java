import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class Frame extends JFrame implements ActionListener {
    JPanel upPanel, Frontview, downPanel, centerWHITE, EditorderPanel, PaymentTotal ;

    Frame() {

        Border border = BorderFactory.createLineBorder(Color.white,2);
        Border border1 = BorderFactory.createLineBorder(Color.black,5);

        ImageIcon originalIcon = new ImageIcon("C:\\Users\\Admin\\IdeaProjects\\tEST\\src\\jollibee.png");
        ImageIcon scaledIcon = new ImageIcon(originalIcon.getImage().getScaledInstance(250, 100, Image.SCALE_SMOOTH));

        ImageIcon originalEDIT = new ImageIcon("C:\\Users\\Admin\\IdeaProjects\\tEST\\src\\img_9.png");
        ImageIcon scaledEDIT = new ImageIcon(originalEDIT.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        ImageIcon originalCheck = new ImageIcon("C:\\Users\\Admin\\IdeaProjects\\tEST\\src\\img_11.png");
        ImageIcon scaledCheck= new ImageIcon(originalCheck.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));


        JLabel labelReview = new JLabel();
        labelReview.setText("REVIEW YOUR ORDER");
        labelReview.setHorizontalAlignment(JLabel.LEFT);
        labelReview.setForeground(Color.WHITE);
        labelReview.setIcon(scaledIcon);
        labelReview.setFont(new Font("ARIAL", Font.BOLD, 30));

        JLabel labelOrdertotal = new JLabel();
        labelOrdertotal.setText("Order Total");
        labelOrdertotal.setHorizontalAlignment(JLabel.CENTER);
        labelOrdertotal.setFont(new Font("ARIAL", Font.BOLD, 15));


        JButton buttonProceed = new JButton("PROCEED TO PAYMENT");
        buttonProceed.setForeground(Color.BLACK);
        buttonProceed.setFont(new Font("Arial",Font.BOLD,16));
        buttonProceed.setBackground(new Color(4, 136, 43));
        buttonProceed.setBounds(330, 10, 270,50);
        buttonProceed.setIcon(scaledCheck);
        buttonProceed.addActionListener(this);
        buttonProceed.setFocusable(false);

        JButton buttonBack = new JButton("BACK");
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(new Font("Arial",Font.BOLD,16));
        buttonBack.setBackground(new Color(99, 0, 0));
        buttonBack.setBounds(10, 10, 150,50);
        buttonBack.addActionListener(this);
        buttonBack.setFocusable(false);
        buttonBack.setBorder(border);

        upPanel = new JPanel();
        upPanel.setBackground(Color.DARK_GRAY);
        upPanel.setBounds(0, 0, 650, 90);
        upPanel.setLayout(new BorderLayout());

        Frontview = new JPanel();
        Frontview.setBackground(Color.RED);
        Frontview.setBounds(0, 90, 650, 500);

        downPanel = new JPanel();
        downPanel.setBackground(new Color(99, 0, 0));
        downPanel.setBounds(0, 590, 625, 100);
        downPanel.setLayout(null);
        downPanel.add(buttonProceed);
        downPanel.add(buttonBack);

        centerWHITE = new JPanel();
        centerWHITE.setBackground(Color.WHITE);
        centerWHITE.setBounds(0, 170, 650, 420);
        centerWHITE.setLayout(null);

        PaymentTotal = new JPanel();
        PaymentTotal.setBackground(new Color(222, 187, 6, 255));
        PaymentTotal.setBounds(330, 350, 270, 80);
        PaymentTotal.setBorder(border1);
        PaymentTotal.add(labelOrdertotal);

        EditorderPanel = new JPanel();
        EditorderPanel.setBackground(Color.WHITE);
        EditorderPanel.setBounds(400, 120, 150, 40);
        EditorderPanel.setLayout(new BorderLayout());// Adjusted width to match Frontview

        this.setSize(625, 700); // Adjusted height to accommodate the changed size
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        upPanel.add(labelReview);
        centerWHITE.add(PaymentTotal);
        this.add(EditorderPanel);
        this.add(upPanel);
        this.add(downPanel);
        this.add(centerWHITE);
        this.add(Frontview);
         // Added EditorderPanel to Frontview
    }

    public static void main(String[] args) {
        new Frame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
