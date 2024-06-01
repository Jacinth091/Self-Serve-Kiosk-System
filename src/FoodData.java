/*
 * NAMES: BARRAL, JACINTH CEDRIC
 *        LAROCO, JAN LORENZ
 *        ABAIS, ALDRIE
 *        SATORRE, LANCE TIMOTHY
 * DATE: 5/31/24
 * DESCRIPTION: FINAL PROJECT IN COMPUTER PROGRAMMING BYE SIR THANKYOU
 *          
 */


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

class FoodData {
    private BufferedImage[] cateAllImg;
    private ImageIcon[] cateIcon;

    private BufferedImage[][] itemAllImg;
    private ImageIcon[][] itemPicIcons;

    private String[] foodCategory = {"Best Sellers", "Chicken Joy", "Jolly Spaghetti", "Beverages"};
    private String[] category = {"BS", "CH", "JS", "BV"};
    public String fc_PathFile = "Assets/Item_category";
    public String[] ip_PathFiles = {
            "Assets/item_pictures/BS",
            "Assets/item_pictures/CJ",
            "Assets/item_pictures/JS",
            "Assets/item_pictures/BV",
    };

    private String[][] foodDesc = {
            {"1 - pc. Chickenjoy w/ Burger Steak & Half Jolly Spaghetti Super Meal",
                    "Yumburger, Half Jolly Spaghetti & Reg. Fries Super Meal",
                    "Yumburger",
                    "Jolly Spaghetti w/ Yumburger",
                    "Jolly Spaghetti w/ Fries & Drink",
                    "1 - pc. Chickenjoy",
            },
            {"2 - pc. Chickenjoy",
                    "1 - pc. Chickenjoy w/ Burger Steak",
                    "1 - pc. Chickenjoy",
                    "1 – pc. Chickenjoy w/ Double Rice",
                    "1 - pc. Chickenjoy w/ Fries",
                    "6 - pc. Chickenjoy Bucket w/ Jolly Spaghetti Family Pan"},
            {"Jolly Spaghetti Family Pan",
                    "6 - pc. Chickenjoy Bucket w/ Jolly Spaghetti Family Pan",
                    "Yumburger, Half Jolly Spaghetti & Reg. Fries Super Meal",
                    "Jolly Spaghetti w/ Burger Steak",
                    "Jolly Spaghetti",
                    "1 - pc. Chickenjoy w/ Burger Steak & Half Jolly Spaghetti Super Meal"},
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
            {212.00, 137.00, 40.00, 122.00, 103.00, 82.00},
            {163.00, 132.00, 82.00, 148.00, 128.00, 679.00},
            {237.00, 679.00, 137.00, 108.00, 60.00, 212.00},
            {80.00, 64.00, 57.00, 53.00, 53.00, 53.00},
    };

    public FoodData() {
        initCategory();
        initItems();
    }

    private List<String> listFilesInDirectory(String path) throws URISyntaxException, IOException {
        List<String> fileNames = new ArrayList<>();
        URL url = getClass().getClassLoader().getResource(path);
        if (url == null) {
            System.out.println("Directory not found: " + path);
            return fileNames;
        }

        File directory = new File(url.toURI());
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                fileNames.add(file.getName());
            }
        } else {
            System.out.println("No files found in directory: " + path);
        }
        return fileNames;
    }

    public void initCategory() {
        cateAllImg = new BufferedImage[noOfCate];
        cateIcon = new ImageIcon[noOfCate];

        for (int i = 0; i < noOfCate; i++) {
            try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fc_PathFile + "/" + category[i] + ".png")) {
                if (inputStream == null) {
                    System.out.println("File not found: " + fc_PathFile + "/" + category[i] + ".png");
                    continue;
                }
                cateAllImg[i] = ImageIO.read(inputStream);
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
            try {
                List<String> itemFiles = listFilesInDirectory(ip_PathFiles[i]);
                for (int j = 0; j < noOfItems; j++) {
                    if (j < itemFiles.size()) {
                        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(ip_PathFiles[i] + "/" + itemFiles.get(j))) {
                            if (inputStream == null) {
                                System.out.println("File not found: " + ip_PathFiles[i] + "/" + itemFiles.get(j));
                                continue;
                            }
                            itemAllImg[i][j] = ImageIO.read(inputStream);
                            itemPicIcons[i][j] = new ImageIcon(itemAllImg[i][j]);
                            itemPicIcons[i][j] = resizeImageIcon(itemPicIcons[i][j], itemPicIcons[i][j].getIconWidth() / 3, itemPicIcons[i][j].getIconHeight() / 3);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
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
}