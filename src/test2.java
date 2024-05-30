import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

class test2 {
    private BufferedImage[] cateAllImg;
    private ImageIcon[] cateIcon;

    private BufferedImage[][] itemAllImg;
    private ImageIcon[][] itemPicIcons;

    private String[] foodCategory = {"Best Sellers", "Chicken Joy", "Jolly Spaghetti", "Beverages"};
    private String fc_PathFile = "Assets/Item_category"; // Updated path to match the resource structure
    private String[] ip_PathFiles = {
            "Assets/item_pictures/BS",
            "Assets/item_pictures/CJ",
            "Assets/item_pictures/JS",
            "Assets/item_pictures/BV",
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

    public test2() {
        initCategory();
        initItems();
    }

    private URL getResourceURL(String path) {
        return getClass().getClassLoader().getResource(path);
    }

    public void initCategory() {
        URL fcURL = getResourceURL(fc_PathFile);
        if (fcURL == null) {
            System.out.println("File not found: " + fc_PathFile);
            return;
        }
        else{
            System.out.println("File found: " + fc_PathFile);

        }

        File cateDir = new File(fcURL.getFile());
        File[] cateFiles = cateDir.listFiles();
        if (cateFiles == null) {
            System.out.println("Directory not found or is empty: " + fc_PathFile);
            return;
        }
        else{
            System.out.println("Directory found: " + fc_PathFile);

        }

        cateAllImg = new BufferedImage[noOfCate];
        cateIcon = new ImageIcon[noOfCate];

        for (int i = 0; i < noOfCate; i++) {
            try {
                cateAllImg[i] = ImageIO.read(cateFiles[i]);
                cateIcon[i] = new ImageIcon(cateAllImg[i]);
                cateIcon[i] = resizeImageIcon(cateIcon[i], cateIcon[i].getIconWidth() / 4, cateIcon[i].getIconHeight() / 4);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void initItems() {
        itemAllImg = new BufferedImage[noOfCate][noOfItems];
        itemPicIcons = new ImageIcon[noOfCate][noOfItems];

        for (int i = 0; i < noOfCate; i++) {
            URL ipURL = getResourceURL(ip_PathFiles[i]);
            if (ipURL == null) {
                System.out.println("Directory not found: " + ip_PathFiles[i]);
                continue;
            }

            File itemDir = new File(ipURL.getFile());
            File[] itemFiles = itemDir.listFiles();
            if (itemFiles == null) {
                System.out.println("No items found in directory: " + ip_PathFiles[i]);
                continue;
            }

            for (int j = 0; j < noOfItems; j++) {
                if (j < itemFiles.length) {
                    try {
                        itemAllImg[i][j] = ImageIO.read(itemFiles[j]);
                        itemPicIcons[i][j] = new ImageIcon(itemAllImg[i][j]);
                        itemPicIcons[i][j] = resizeImageIcon(itemPicIcons[i][j], itemPicIcons[i][j].getIconWidth() / 3, itemPicIcons[i][j].getIconHeight() / 3);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
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

    public int getNoOfCate() {
        return noOfCate;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(test2::new);
    }
}
