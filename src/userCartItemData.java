/*
 * NAMES: BARRAL, JACINTH CEDRIC
 *        LAROCO, JAN LORENZ
 *        ABAIS, ALDRIE
 *        SATORRE, LANCE TIMOTHY
 * DATE: 5/31/24
 * DESCRIPTION: FINAL PROJECT IN COMPUTER PROGRAMMING BYE SIR THANKYOU
 *          
 */

import java.util.List;

public interface userCartItemData {
    public String getItemDesc();
    public String getItemCateg();
    public double getItemPrice();
    public int getItemQuant();
    public double getItemPriceTimesQuantity();
    public int getItem_LROW();
    public int getItem_LCOL();

    public List<ItemDataAtt> getCartData();

}

