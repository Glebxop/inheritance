package by.gsu.epamlab;

public class PurchaseWithPriceDiscount extends AbstractPurchase {
   private Byn discount;

    public PurchaseWithPriceDiscount() {
            }

    public PurchaseWithPriceDiscount(Product product, int number, Byn discount) {
        super(product, number);
        this.discount = discount;
    }

 @Override
   protected Byn cost(Byn cost) {
        return cost.sub(discount.mul(getNumber()));
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString()+";"+discount;
    }
}
