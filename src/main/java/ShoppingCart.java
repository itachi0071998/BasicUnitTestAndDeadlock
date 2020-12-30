import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Product> cartList = new ArrayList<>();

    public int getProductCount(){
        return cartList.size();
    }
    public void addProduct(Product product){
        cartList.add(product);
    }
    public float totalCartPrice(){
        float total = 0;
        for(Product price: cartList) total += price.getTotalPrice();
        return total;
    }



//    public static void main(String[] args){
//        ShoppingCart cart = new ShoppingCart();
//        IOoffer offer = new BuyXGetYFree(2, 1);
//        Product product = new Product("Gatsby hair cream", 30, 5);
//        offer.applyOffer(product);
//        cart.addProduct(product);
//    }
}

