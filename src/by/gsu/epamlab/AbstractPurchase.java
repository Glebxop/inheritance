package by.gsu.epamlab;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
   private Product product;
   private int number;



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public AbstractPurchase() {
    }

    public AbstractPurchase(Product product, int number) {
        this.product = product;
        this.number = number;
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return -this.getCost().compareTo(o.getCost());
    }

    public Byn getCost() {
        Byn cost = new Byn(product.getPrice());
        return cost(cost.mul(number)).round(Byn.Rounding.FLOOR,2);
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    protected String fieldsToString() {
        return product + ";" + number;
    }
   protected abstract Byn cost(Byn cost);
}
