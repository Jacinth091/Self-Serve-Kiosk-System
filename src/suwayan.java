import javax.swing.*;
import java.awt.*;

class suwayan {
    public static void main(String[] args) {
        new Frames();
    }
}

class Frames extends JFrame {
    Frames() {

        ImageIcon jollibee = new ImageIcon("jollibee.png");
        this.setIconImage(jollibee.getImage());
        this.getContentPane().setBackground(Color.DARK_GRAY);

        JLabel label = new JLabel();
        label.setIcon(jollibee);

        this.setSize(625, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(label);
        this.setVisible(true);
    }
}