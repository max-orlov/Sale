package sales;

public class SaleTransaction {
    private int saleCode;
    private Product[] items;
    private double totalCost;
    private int index;

    public SaleTransaction(int saleCode) {
        this.index = 0;
        this.items = new Product[3];
        this.saleCode = saleCode;
    }

    public int countProducts(){
        return this.index;
    }

    public boolean isFull() {
        return this.items[2] != null;
    }

    public boolean isEmpty() {
        return this.items[0] == null;
    }

    public void addPurchased(Product product) {
        items[index++] = product;
        totalCost += this.items[index -1].getPrice();
    }

    public Product[] getItems() {
        return items;
    }
}
