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
