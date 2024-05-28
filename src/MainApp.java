import javax.swing.JFrame;
import java.awt.*;


class MainApp{
    public static void main(String[] args){

        WindowApp startMenu = new WindowApp(625,800,"Jolikod",true,false, new BorderLayout(), JFrame.EXIT_ON_CLOSE);
        startMenu.setVisible(true);



    }
}