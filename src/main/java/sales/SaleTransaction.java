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
        return this.index == 3;
    }

   /* public boolean canBePurcased() {
    }*/

    public void addPurchased() {

    }
}
