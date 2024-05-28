/*
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


//        this.setBackground(Color.CYAN);

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
    public void createLabel(){

    }

}*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Group;

public class WindowApp extends Application{

    String appTitle;
    int appWidth;
    int appHeight;

    WindowApp(){

    }
    WindowApp(String title, int appWidth, int appHeight){
        this.appTitle =title;
        this.appWidth =appWidth;
        this.appHeight =appHeight;
    }


    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root, Color.AZURE);

        setStageParameters(stage);

        stage.show();

    }

    public void setStageParameters(Stage stage){
        stage.setTitle(appTitle);
        stage.setWidth(appWidth);
        stage.setHeight(appHeight);
    }

    public void launchApp(String[] args){
        launch(args);
    }
}
