import by.gsu.epamlab.*;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {


        final Product pineapple = new Product("Pineapple", new Byn(500));
        AbstractPurchase[] purchases = new AbstractPurchase[]{
                new PurchaseWithPriceDiscount(pineapple, 10, new Byn(50)), new PurchaseWithPriceDiscount(pineapple, 5, new Byn(30)),
                new PurchaseWithDiscountPresentedIf(pineapple, 12, 30), new PurchaseWithDiscountPresentedIf(pineapple, 37, 7),
                new PurchaseWithAdditionTransportExpenses(pineapple, 10, new Byn(200)), new PurchaseWithAdditionTransportExpenses(pineapple, 2, new Byn(0))
        };
        printArray(purchases);
        Arrays.sort(purchases);

        printArray(purchases);
        System.out.println("Minimum cost " + purchases[purchases.length - 1].getCost());


        int idex = Arrays.binarySearch(purchases,
                new PurchaseWithPriceDiscount(new Product("name", new Byn(500)), 1, new Byn(0)));
        System.out.println(idex >= 0 ? purchases[idex] : "Didn't find some purchase with cost equalled to 5.00 BYN");


    }

    private static void printArray(AbstractPurchase[] purchases) {
        for (AbstractPurchase purchase : purchases) {
            System.out.println(purchase);
        }
    }
}
