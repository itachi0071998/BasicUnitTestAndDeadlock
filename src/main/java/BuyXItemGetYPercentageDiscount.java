public class BuyXItemGetYPercentageDiscount implements IOoffer {
    private int xItem;
    private double discount;


    public BuyXItemGetYPercentageDiscount(int xItem, double discount) {
        this.xItem = xItem;
        this.discount = discount;
    }

    @Override
    public void applyOffer(Product product) {
        if (xItem <= product.getCount()) {
            int totalItem = product.getCount();
            double discountAmount = xItem*product.getPrice()*(1 - discount/100);
            double totalPrice = product.getPrice()*(totalItem - xItem) + discountAmount;
            product.setTotalPrice(totalPrice);
        }
    }
}
