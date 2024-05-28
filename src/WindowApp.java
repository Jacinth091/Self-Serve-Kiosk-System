
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.Component;
 
public class WindowApp extends JFrame {
 
    JPanel panel;

    WindowApp(){

    }

    WindowApp(int width, int height, String title,
    boolean isVisible, boolean isResizable, LayoutManager layout, int defCloseOper)
    {
        createWindow(width, height, title, isVisible, isResizable, layout, defCloseOper);
        panel = new JPanel();

        panel.setBackground(Color.red);
        panel.setVisible(true);
        panel.setSize(500,500);



        addItemsToWindow(panel);
 
    }





    public void createWindow(int width, int height, String title,
    boolean isVisible, boolean isResizable, LayoutManager layout, int defCloseOper) {
        this.setSize(width, height);
        this.setTitle(title);
        this.setDefaultCloseOperation(defCloseOper);
        this.setLayout(layout);
        this.setVisible(isVisible);
        this.setResizable(isResizable);
    }

    public void addItemsToWindow(Component component){
        this.add(component);
    }

}




