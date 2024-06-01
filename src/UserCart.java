/*
 * NAMES: BARRAL, JACINTH CEDRIC
 *        LAROCO, JAN LORENZ
 *        ABAIS, ALDRIE
 *        SATORRE, LANCE TIMOTHY
 * DATE: 5/31/24
 * DESCRIPTION: FINAL PROJECT IN COMPUTER PROGRAMMING BYE SIR THANKYOU
 *          
 */

import java.util.ArrayList;
import java.util.List;

 class UserCart {
    private List<ItemDataAtt> cartItems;

    public UserCart() {
        cartItems = new ArrayList<>();
    }

    public void addItemToCart(ItemDataAtt item) {
        cartItems.add(item);
    }

    public List<ItemDataAtt> getCartItems() {
        return cartItems;
    }
}
