package by.gsu.epamlab;

public class PurchaseWithDiscountPresentedIf extends AbstractPurchase {
    private static int IS_DISCOUNT=5;
    private double discount;

    public PurchaseWithDiscountPresentedIf(Product product, int number, double discount) {
        super(product, number);
        this.discount = discount;
    }
    @Override
   protected Byn cost(Byn cost) {
        if (this.getNumber()>IS_DISCOUNT){
            cost=  cost.mul(1 - discount / 100,1, Byn.Rounding.FLOOR);
        }
        return cost;

    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString()+";"+discount;
    }
}
