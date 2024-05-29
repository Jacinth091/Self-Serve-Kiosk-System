import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class Frame extends JFrame implements ActionListener {
    JPanel upPanel, Frontview, downPanel, centerWHITE, EditorderPanel, PaymentTotal, OrderPanel, CashPanel, NAMEORDERP,TimesPanel;
    JLabel labelReview, labelOrdertotal, labelEDIT, LabelPRICE, LabelORDER, LabelORDERText, LabelTimes;
    JButton buttonProceed,  buttonBack, buttonEDIT, buttonTRASH;
    ImageIcon originalIcon, originalCheck, originalTrash, originalORDER;
    Border border, border1, border2,border3,borderForEdit;
    Frame() {
        // BORDER =====================================================================================
        border = BorderFactory.createLineBorder(Color.white,2);
        border1 = BorderFactory.createLineBorder(Color.black,5);
        border2 = BorderFactory.createLineBorder((new Color(222, 187, 6, 255)), 5);
        border3 = BorderFactory.createLineBorder((new Color(0, 94, 32, 255)), 5);
        borderForEdit = BorderFactory.createLineBorder(Color.black,3);

        // ICON OR IMAGE ==============================================================================
        originalIcon = new ImageIcon("C:\\Users\\Admin\\IdeaProjects\\tEST\\src\\jollibee.png"); // jollibee picture
        ImageIcon scaledIcon = new ImageIcon(originalIcon.getImage().getScaledInstance(170, 70, Image.SCALE_SMOOTH));

        originalCheck = new ImageIcon("C:\\Users\\Admin\\IdeaProjects\\tEST\\src\\remove.png"); // CHECK LOGO sa PROCEED PAYMENT
        ImageIcon scaledCheck= new ImageIcon(originalCheck.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        originalTrash= new ImageIcon("C:\\Users\\Admin\\IdeaProjects\\tEST\\src\\trashcan.png"); // TRASHCAN LOGO sa TRASH ITEM BUTTON
        ImageIcon scaledTrash= new ImageIcon(originalTrash.getImage().getScaledInstance(20, 16, Image.SCALE_SMOOTH));

        originalORDER= new ImageIcon("C:\\Users\\Admin\\IdeaProjects\\tEST\\src\\img.png"); // PICTURE OF THE ITEM
        ImageIcon scaledORDER= new ImageIcon(originalORDER.getImage().getScaledInstance(150, 70, Image.SCALE_SMOOTH));


        // LABEL ======================================================================================
        labelReview = new JLabel(); // TOP / REVIEW YOUR ORDER
        labelReview.setIcon(scaledIcon);
        labelReview.setText("REVIEW YOUR ORDER");
        labelReview.setForeground(Color.WHITE);
        labelReview.setFont(new Font("ARIAL", Font.BOLD, 30));

        labelOrdertotal = new JLabel(); // ORDER TOTAL
        labelOrdertotal.setText("Order Total");
        labelOrdertotal.setHorizontalAlignment(JLabel.CENTER);
        labelOrdertotal.setFont(new Font("ARIAL", Font.BOLD, 15));

        labelEDIT = new JLabel(); // EDIT ORDER
        labelEDIT.setText("EDIT ORDER");
        labelEDIT.setForeground(new Color(222, 187, 6, 255));
        labelEDIT.setBounds(220,20,200,50);
        labelEDIT.setFont(new Font("ARIAL", Font.BOLD, 30));

        LabelPRICE = new JLabel(); // PRICE OF ITEM
        LabelPRICE.setText("P200.00");
        LabelPRICE.setBounds(12,2,200,50);
        LabelPRICE.setFont(new Font("ARIAL", Font.BOLD, 20));

        LabelORDER = new JLabel(); // PICTURE SA ITEM
        LabelORDER.setIcon(scaledORDER);
        LabelORDER.setBounds(5,10,500,70);

        LabelORDERText = new JLabel(); // NAME OF THE ITEM
        LabelORDERText.setText("<html>1 - pc. Chickenjoy w/ <br>Burger Steak & Half Jolly <br> Spaghetti Super Meal</html>");
        LabelORDERText.setBounds(170,15,500,50);
        LabelORDERText.setFont(new Font("ARIAL", Font.BOLD, 15));

        LabelTimes = new JLabel(); // TIMES OF ITEM or HOW MANY ITEMS
        LabelTimes.setText("1x");
        LabelTimes.setBounds(5,-3,300,40);
        LabelTimes.setFont(new Font("ARIAL", Font.BOLD, 15));

        // BUTTON ====================================================================================
        buttonProceed = new JButton("PROCEED TO PAYMENT"); // PROCEED BUTTON
        buttonProceed.setForeground(Color.BLACK);
        buttonProceed.setFont(new Font("Arial",Font.BOLD,16));
        buttonProceed.setBackground(new Color(4, 136, 43));
        buttonProceed.setBounds(330, 10, 270,50);
        buttonProceed.setIcon(scaledCheck);
        buttonProceed.setBorder(border3);
        buttonProceed.addActionListener(this);
        buttonProceed.setFocusable(false);

        buttonBack = new JButton("BACK"); // BACK BUTTON
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(new Font("ARIAL",Font.BOLD,16));
        buttonBack.setBackground(new Color(99, 0, 0));
        buttonBack.setBounds(10, 10, 150,50);
        buttonBack.addActionListener(this);
        buttonBack.setFocusable(false);
        buttonBack.setBorder(border);

        buttonEDIT = new JButton("EDIT"); // EDIT BUTTON of the ITEM
        buttonEDIT.setBackground(new Color(0, 164, 56));
        buttonEDIT.setBounds(450, 10, 60,20);
        buttonEDIT.setFont(new Font("ARIAL",Font.BOLD,11));
        buttonEDIT.setFocusable(false);

        buttonTRASH = new JButton(); // TRASH BUTTON of the ITEM
        buttonTRASH.setForeground(Color.white);
        buttonTRASH.setBackground(new Color(222, 0, 0));
        buttonTRASH.setBounds(520, 10, 60,20);
        buttonTRASH.setFont(new Font("ARIAL",Font.BOLD,11));
        buttonTRASH.setIcon(scaledTrash);
        buttonTRASH.setFocusable(false);

        // PANEL =================================================================================

        upPanel = new JPanel(); // GRAY COLOR
        upPanel.setBackground(Color.DARK_GRAY);
        upPanel.setBounds(0, 0, 610, 90);
        upPanel.setLayout(new BorderLayout());
        upPanel.setBorder(border2);

        Frontview = new JPanel(); // RED COLOR kanang 2nd COLOR
        Frontview.setBackground(Color.RED);
        Frontview.setBounds(0, 90, 610, 80);
        Frontview.setLayout(null);
        Frontview.add(labelEDIT);

        downPanel = new JPanel(); // DARK RED kanang UBOS
        downPanel.setBackground(new Color(99, 0, 0));
        downPanel.setBounds(0, 590, 610, 80);
        downPanel.setLayout(null);
        downPanel.setBorder(border1);
        downPanel.add(buttonProceed);
        downPanel.add(buttonBack);

        centerWHITE = new JPanel(); // WHITE COLOR, kanang center dako nga white
        centerWHITE.setBackground(Color.WHITE);
        centerWHITE.setBounds(0, 170, 650, 420);
        centerWHITE.setLayout(null);

        PaymentTotal = new JPanel(); // PANEL SA ORDER TOTAL kanang babaw  sa PROCEED button
        PaymentTotal.setBackground(new Color(222, 187, 6, 255));
        PaymentTotal.setBounds(330, 350, 270, 80);
        PaymentTotal.setBorder(border1);
        PaymentTotal.add(labelOrdertotal);

        EditorderPanel = new JPanel(); // YELLOW LINE kanang babaw sa EDIT ORDER
        EditorderPanel.setBackground(new Color(222, 187, 6, 255));
        EditorderPanel.setBounds(0, 100, 610, 10);

        OrderPanel = new JPanel();//YELLOW COLOR, BACKGROUND PANEL SA ITEM, kanang naay name sa ITEM and PICTURE
        OrderPanel.setBackground(new Color(222, 187, 6, 255));
        OrderPanel.setBounds(10, 10, 590, 100);
        OrderPanel.setLayout(null);
        OrderPanel.add(buttonEDIT); // DISPLAY THE EDIT BUTTON of the ITEM
        OrderPanel.add(buttonTRASH);// DISPLAY THE TRASH BUTTON of the ITEM

        NAMEORDERP =new JPanel(); // WHITE COLOR, BACKGROUND PANEL SA ITEM, kanang naay name sa ITEM and PICTURE
        NAMEORDERP.setBackground(new Color(232, 229, 187, 255));
        NAMEORDERP.setLayout(null);
        NAMEORDERP.setBounds(10, 10, 425, 80);
        NAMEORDERP.add(LabelORDER); // FOR DISPLAY THE PICTURE OF ITEM
        NAMEORDERP.add(LabelORDERText);// FOR DISPLAY THE NAME OF ITEM

        CashPanel = new JPanel(); // THIS PANEL IS FOR DISPLAY THE PRICE OF ITEM
        CashPanel.setBackground(new Color(232, 229, 187, 255));
        CashPanel.setBounds(463, 37, 100, 50);
        CashPanel.setLayout(null);
        CashPanel.add(LabelPRICE); // example PRICE of ITEM

        TimesPanel = new JPanel(); // Times for ITEM/ pila ka item
        TimesPanel.setBackground(Color.WHITE);
        TimesPanel.setBounds(10, 10, 30, 30);
        TimesPanel.add(LabelTimes); // Display How many item
        TimesPanel.setLayout(null);
        // FRAME ==========================================================================================
        this.setSize(625, 700);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        OrderPanel.add(TimesPanel); // Add the TimesPanel to OrderPanel
        OrderPanel.add(NAMEORDERP); // Add the NAMEORDERP to OrderPanel
        OrderPanel.add(CashPanel); // Add the CashPanel to OrderPanel
        upPanel.add(labelReview); // Add the labelReview to upPanel
        centerWHITE.add(OrderPanel); // Add the OrderPanel to centerWHITE
        centerWHITE.add(PaymentTotal); // Add the PaymentTotal to centerWHITE
        this.add(EditorderPanel);
        this.add(upPanel);
        this.add(downPanel);
        this.add(centerWHITE);
        this.add(Frontview);

    }

    public static void main(String[] args) {
        new Frame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
