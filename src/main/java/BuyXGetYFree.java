public class BuyXGetYFree implements IOoffer {

    private int xItem;

    public BuyXGetYFree(int xItem, int yItem) {
        this.xItem = xItem;
        this.yItem = yItem;
    }

    private  int yItem;


    @Override
    public void applyOffer(Product product) {
        if(product.getCount() > xItem) {
            double oneItemPrice = product.getPrice();
            System.out.println("oneitemprice   " +  oneItemPrice);
            int freeItemQuantity = product.getCount()/(xItem + yItem);
            double finalPrice = product.getTotalPrice() - oneItemPrice*freeItemQuantity;
            product.setTotalPrice(finalPrice);
        }

    }
}
