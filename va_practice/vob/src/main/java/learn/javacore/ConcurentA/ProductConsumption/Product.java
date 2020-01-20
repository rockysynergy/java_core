package learn.javacore.ConcurentA.ProductConsumption;

class Product {
    private int idx = -1;

    public Product(int idx) {
        this.idx = idx;
    }

    @Override
    public String toString() {
        return "Product --" + idx;
    }
}