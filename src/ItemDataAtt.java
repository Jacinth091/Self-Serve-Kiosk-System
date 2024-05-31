import javax.swing.*;

class ItemDataAtt {

    private String itemDesc;
    private String itemCateg;
    private double itemPrice;

    private int itemQuant;

    private double itemPriceTimesQuant;

     private int item_LROW;
     private int item_LCOL;
     private ImageIcon itemImage;

     public ItemDataAtt(){

     }
     
    public ItemDataAtt(String itemDesc, String itemCateg, double itemPrice, int itemQuant,
                                  double itemPriceTimesQuant, ImageIcon itemImage, int item_LROW, int item_LCOL) {
        this.setItemDesc(itemDesc);
        this.setItemCateg(itemCateg);
        this.setItemPrice(itemPrice);
        this.setItemQuant(itemQuant);
        this.setItemPriceTimesQuant(itemPriceTimesQuant);
        this.setItemImage(itemImage);
        this.setItem_LROW(item_LROW);
        this.setItem_LCOL(item_LCOL);
    }


    // Setters and Getters for itemDesc
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    // Setters and Getters for itemCateg
    public void setItemCateg(String itemCateg) {
        this.itemCateg = itemCateg;
    }

    public String getItemCateg() {
        return itemCateg;
    }

    // Setters and Getters for itemPrice
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    // Setters and Getters for itemQuant
    public void setItemQuant(int itemQuant) {
        this.itemQuant = itemQuant;
    }

    public int getItemQuant() {
        return itemQuant;
    }

    // Setters and Getters for itemPriceTimesQuant
    public void setItemPriceTimesQuant(double itemPriceTimesQuant) {
        this.itemPriceTimesQuant = itemPriceTimesQuant;
    }

    public double getItemPriceTimesQuant() {
        return itemPriceTimesQuant;
    }

    // Setters and Getters for item_LROW
    public void setItem_LROW(int item_LROW) {
        this.item_LROW = item_LROW;
    }

    public int getItem_LROW() {
        return item_LROW;
    }

    // Setters and Getters for item_LCOL
    public void setItem_LCOL(int item_LCOL) {
        this.item_LCOL = item_LCOL;
    }

    public int getItem_LCOL() {
        return item_LCOL;
    }

    // Setters and Getters for itemImage
    public void setItemImage(ImageIcon itemImage) {
        this.itemImage = itemImage;
    }

    public ImageIcon getItemImage() {
        return itemImage;
    }

}
