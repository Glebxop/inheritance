package by.gsu.epamlab;

public class PurchaseWithAdditionTransportExpenses extends AbstractPurchase {
    private Byn transportExpenses;

    public PurchaseWithAdditionTransportExpenses(Product product, int number, Byn transportExpenses) {
        super(product, number);
        this.transportExpenses = transportExpenses;
    }
 @Override
   protected Byn cost(Byn cost) {
        return cost.sub(transportExpenses);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString()+";"+transportExpenses;
    }
}
