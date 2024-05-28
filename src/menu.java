import javax.swing.*;

public class menu extends JFrame{
    private JPanel panelMain;
    private JPanel HeaderPanel;
    private JPanel BodyPanel;
    private JPanel FooterPanel;
    private JLabel txtLabel;
    private JLabel luh;

    public static void main(String[] args){
        menu start = new menu();

        start.setContentPane(start.panelMain);
        start.setSize(625,800);
        start.setTitle("Jolikod");
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.setVisible(true);
        start.setResizable(false);

        start.add(start.panelMain);


    }

}
