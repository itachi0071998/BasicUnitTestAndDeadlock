import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartAppTest {

    @Test
    public void testCreateEmotyShoppingCart(){
        ShoppingCart cart = new ShoppingCart();
        Assert.assertEquals(0, cart.getProductCount());
    }

    @Test
    public void testAddOneProductToTheCart(){
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Gatsby hair cream", 30, 1);
        cart.addProduct(product);
        Assert.assertEquals(1, cart.getProductCount());
        Assert.assertEquals(30.0, cart.totalCartPrice(), 0.0);
        Product product2 = new Product("Bvlgiri Soap", 130, 1);
        cart.addProduct(product2);
    }

    @Test
    public void testAddDifferentProductToTheCart(){
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Gatsby hair cream", 30, 1);
        Product product2 = new Product("Bvlgiri Soap", 130, 1);
        cart.addProduct(product);
        cart.addProduct(product2);
        Assert.assertEquals(2, cart.getProductCount());
        Assert.assertEquals(160, cart.totalCartPrice(), 0.0);
    }

    @Test
    public void testAddProductOnBuyXgetYFree(){
        ShoppingCart cart = new ShoppingCart();
        IOoffer offer = new BuyXGetYFree(2, 1);
        Product product = new Product("Gatsby hair cream", 30, 5);
        offer.applyOffer(product);
        cart.addProduct(product);
        Assert.assertEquals(1, cart.getProductCount());
        Assert.assertEquals(120.0, cart.totalCartPrice(),0.0);

    }

    @Test
    public void testAddProductWithDifferentPromotuon(){
        ShoppingCart cart = new ShoppingCart();
        IOoffer offer = new BuyXGetYFree(2, 1);
        IOoffer noOffer = new NoOffer();
        Product product = new Product("Gatsby hair cream", 30, 5);
        Product product2 = new Product("Bvlgiri Soap", 100, 4);
        offer.applyOffer(product);
        noOffer.applyOffer(product2);
        cart.addProduct(product);
        cart.addProduct(product2);
        Assert.assertEquals(2, cart.getProductCount());
        Assert.assertEquals(520, cart.totalCartPrice(), 0.0);
    }

    @Test
    public void testAddProductOnBuyXGetYPercentageDiscount(){
        ShoppingCart cart = new ShoppingCart();
        IOoffer offer = new BuyXItemGetYPercentageDiscount(1, 50);
        Product product = new Product("Gatsby hair cream", 30, 2);
        offer.applyOffer(product);
        cart.addProduct(product);
        Assert.assertEquals(1, cart.getProductCount());
        Assert.assertEquals(45.0, cart.totalCartPrice(),0.0);
    }
}
