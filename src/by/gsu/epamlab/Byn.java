package by.gsu.epamlab;

public final class Byn implements Comparable<Byn> {
     enum Rounding {
        FLOOR {
            @Override
            double round(double value) {
                return Math.floor(value);
            }
        }, CEIL {
            @Override
            double round(double value) {
                return Math.ceil(value);
            }
        }, ROUND {
            @Override
            double round(double value) {
                return Math.round(value);
            }
        };

        abstract double round(double value);
    }

    private final int value;

    public Byn(int value) {

        this.value = value;
    }

    public Byn(int rubs, int coins) {

        this(100 * rubs + coins);
    }

    public Byn(Byn byn) {

        this(byn.value);
    }

    @Override
    public String toString() {
        return  value / 100 + "." + (value / 10 % 10) + value % 10;
    }

    public int getRubs() {
        return value / 100;
    }

    public int getCoins() {
        return value % 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return value == byn.value;
    }

    public int compareTo(Byn byn) {
        return Integer.compare(value, byn.value);
    }

    public Byn add(Byn byn) {
        return new Byn(this.value + byn.value);

    }

    public Byn mul(int k) {

        return new Byn(this.value * k);
    }

    public Byn sub(Byn byn) {
        return new Byn(this.value - byn.value);
    }

    public Byn mul(double multiplier, int toScale, Rounding mode) {
        int scale = scale(toScale);
        return new Byn((int) Rounding.valueOf(mode.name()).round((value * multiplier / scale) * scale));
    }

    public Byn round(Rounding roundMethod, int scale) {
        int tenPow = scale(scale);
        return new Byn((int) roundMethod.round((double) value / tenPow) * tenPow);
    }
    private static int scale(int toScale){
        int[] scale = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000,100000000};
        return scale[toScale];

    }


}
