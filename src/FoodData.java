import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class FoodData {
    private BufferedImage[] cateAllImg;
    private File catePath;
    private File[] cateIconFiles;

    private ImageIcon[] cateIcon;

    private BufferedImage[][] itemAllImg;
    private File[] itemPath;
    private File[][] itemPicFiles;

    private ImageIcon[][] itemPicIcons;

//    private JFrame frame;



    private String[] foodCategory = {"Best Sellers", "Chicken Joy", "Jolly Spaghetti", "Beverages"};
    private String fc_PathFile = "src/Assets/Item_category";
    private String[] ip_PathFiles = {
            "src/Assets/item_pictures/BS",
            "src/Assets/item_pictures/CJ",
            "src/Assets/item_pictures/JS",
            "src/Assets/item_pictures/BV",
    };
    private String[][] foodDesc = {
            // Best Sellers
            {"1 - pc. Chickenjoy w/ Burger Steak & Half Jolly Spaghetti Super Meal",
                    "Yumburger, Half Jolly Spaghetti & Reg. Fries Super Meal",
                    "Yumburger",
                    "Jolly Spaghetti w/ Yumburger",
                    "Jolly Spaghetti w/ Fries & Drink",
                    "1 - pc. Chickenjoy",
            },
            // Chicken Joy
            {"2 - pc. Chickenjoy",
                    "1 - pc. Chickenjoy w/ Burger Steak",
                    "1 - pc. Chickenjoy",
                    "1 – pc. Chickenjoy w/ Double Rice",
                    "1 - pc. Chickenjoy w/ Fries",
                    "6 - pc. Chickenjoy Bucket w/ Jolly Spaghetti Family Pan"},
            // Jolly Spaghetti
            {"Jolly Spaghetti Family Pan",
                    "6 - pc. Chickenjoy Bucket w/ Jolly Spaghetti Family Pan",
                    "Yumburger, Half Jolly Spaghetti & Reg. Fries Super Meal",
                    "Jolly Spaghetti w/ Burger Steak",
                    "Jolly Spaghetti",
                    "1 - pc. Chickenjoy w/ Burger Steak & Half Jolly Spaghetti Super Meal"},
            // Beverages
            {"Iced Mocha Float",
                    "Iced Mocha",
                    "Soda Floats",
                    "Coke",
                    "Sprite",
                    "Royal"},
    };
    private int noOfCate = foodCategory.length;
    private int noOfItems = foodDesc[0].length;
    private double[][] foodPrice = {
            // Best Sellers
            {212.00, 137.00, 40.00, 122.00, 103.00, 82.00},
            // Chicken Joy
            {163.00, 132.00, 82.00, 148.00, 128.00, 679.00},
            // Jolly Spaghetti
            {237.00, 679.00, 137.00, 108.00, 60.00, 212.00},
            // Beverages
            {80.00, 64.00, 57.00, 53.00, 53.00, 53.00},
    };

    public FoodData() {
        initCategory();
        initItems();

//        frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new FlowLayout()); // Set a layout manager for the frame
//
//
//        JLabel[] label = new JLabel[noOfCate];
//
//        for (int i = 0; i < noOfCate; i++) {
//            label[i] = new JLabel(cateIcon[i]);
//            frame.add(label[i]);
//            for (int j = 0; j < noOfItems; j++) {
//                if (itemPicIcons[i][j] != null) {
//                    JLabel itemLabel = new JLabel(itemPicIcons[i][j]);
//                    frame.add(itemLabel);
//                }
//            }
//        }
//
//        frame.pack(); // Adjust the frame size based on its content
//        frame.setVisible(true); // Make the frame visible
    }
    public void initCategory(){
        catePath = new File(fc_PathFile);
        cateIconFiles = catePath.listFiles();

        if (cateIconFiles == null) {
            System.out.println("Directory not found or is empty.");
            return;
        }

        cateAllImg = new BufferedImage[noOfCate];
        cateIcon = new ImageIcon[noOfCate];

        for(int i =0; i < noOfCate; i++){
            try{
                cateAllImg[i] = ImageIO.read(cateIconFiles[i]);
                cateIcon[i] = new ImageIcon(cateAllImg[i]);
                cateIcon[i] = resizeImageIcon(cateIcon[i], cateIcon[i].getIconWidth() / 4, cateIcon[i].getIconHeight() / 4);

            }catch(IOException e){
                e.printStackTrace();

            }
        }

    }
    public void initItems(){
        itemPath = new File[noOfCate];
        itemPicFiles = new File[noOfCate][noOfItems];
        itemAllImg = new BufferedImage[noOfCate][noOfItems];
        itemPicIcons = new ImageIcon[noOfCate][noOfItems];

        for (int i = 0; i < noOfCate; i++) {
            itemPath[i] = new File(ip_PathFiles[i]);
            File[] files = itemPath[i].listFiles();
            if (files != null) {
                System.arraycopy(files, 0, itemPicFiles[i], 0, Math.min(files.length, noOfItems));
            } else {
                System.out.println("No items found in directory: " + ip_PathFiles[i]);
            }

            try{
                if (itemPicFiles[i] != null) {
                    for (int j = 0; j < itemPicFiles[i].length; j++) {
                        if (itemPicFiles[i][j] != null) {
                            itemAllImg[i][j] = ImageIO.read(itemPicFiles[i][j]);
                            itemPicIcons[i][j] = new ImageIcon(itemAllImg[i][j]);
                            itemPicIcons[i][j] = resizeImageIcon(itemPicIcons[i][j], itemPicIcons[i][j].getIconWidth() / 3, itemPicIcons[i][j].getIconHeight() / 3);
                        }
                    }
                } else {
                    System.out.println("No items found for category: " + foodCategory[i]);
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    public static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage(); // Get the image from the ImageIcon
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Resize the image
        return new ImageIcon(resizedImage); // Create a new ImageIcon with the resized image
    }

    public String[] getFoodCategory() {
        return foodCategory;
    }

    public String[][] getFoodDesc() {
        return foodDesc;
    }

    public ImageIcon[] getCateIcon() {
        return cateIcon;
    }

    public ImageIcon[][] getItemPicIcons() {
        return itemPicIcons;
    }

    public double[][] getFoodPrice() {
        return foodPrice;
    }
    public int getNoOfCate(){
        return noOfCate;
    }

    public int getNoOfItems(){
        return noOfItems;
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(FoodData::new); // Ensure the UI updates on the Event Dispatch Thread
//    }
}