package by.gsu.epamlab;

public final class Product {
    private final String name;
    private final Byn price;


    public Product() {
        this("",null);

    }
    public Product(String name, Byn byn) {
        this.name = name;
        this.price = byn;
    }

     public String getName() {
        return name;
    }

    public Byn getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ';' +
                price;
    }
}
