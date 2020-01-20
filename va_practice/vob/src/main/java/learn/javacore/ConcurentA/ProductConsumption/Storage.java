package learn.javacore.ConcurentA.ProductConsumption;

class Storage {
    private int top = 0;
    private Product[] products = new Product[5];

    /**
     *  push product
     */
    public synchronized void push(Product p) {
        while (top == products.length) {
            try {
                System.out.println("Producing wait...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products[top++] = p;
        System.out.println(Thread.currentThread().getName() + " produced: " + p);
        System.out.println("Now notify to all...");
        notifyAll();
    }

    /**
     * pop product
     * @return Product
     */
    public synchronized Product pop() {
        while (top == 0) {
            try {
                System.out.println("consuming is waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Product p = products[--top];
        // products[top] = null;
        System.out.println(Thread.currentThread().getName() + " consumed: " + p);
        System.out.println("consuming notify all...");
        notifyAll();
        return p;
    }
}