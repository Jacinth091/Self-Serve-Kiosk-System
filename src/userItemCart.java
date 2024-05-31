import java.util.ArrayList;
import java.util.List;

public class userItemCart {

    private static List<ItemDataAtt> userCartItems = new ArrayList<>();



    public void setUserCartItems(List<ItemDataAtt> userCart){
        userCartItems = userCart;
    }
}
