package sales;

import java.util.Arrays;

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

    public boolean isFull() {
        return this.items[2] != null;
    }

    public boolean isEmpty() {
        return this.items[0] == null;
    }

    public void addPurchased(Product product) {
        items[index++] = product;
        totalCost += product.getPrice() * product.getMinOrderQty();
    }

    public void remove(int x) {
        if (x < 0 || x >= index)
            return;
        totalCost -= this.items[x].getPrice() * this.items[x].getMinOrderQty();
        items[x] = null;
        for (int i = x + 1; i < items.length; i++) {
            items[i - 1] = items[i];
        }
        items[items.length - 1] = null;
        this.index--;
    }

    public int countOfItems() {
        return this.index;
    }

    public Product getItem(int ind) {
        if (ind < 0 || ind > items.length - 1)
            return null;
        return this.items[ind];
    }

    public Product getProduct(int ind) {
        if (ind < 0 || ind > items.length - 1)
            return null;
        return this.items[ind];
    }

    public Product[] getItems() {
        return items;
    }

    public int totalQty(Product p) {
        int totalQty = 0;
        for (int i = 0; i < index; i++) {
            if (p.equals(items[i]))
                totalQty += items[i].getMinOrderQty();
        }
        return totalQty;
    }

    public double getTotalCost() {
        return totalCost;
    }
    
    public String[] getStringProducts() {
        String[] str = new String[countOfItems()];
        for (int i = 0; i < countOfItems(); i++) {
            str[i] = items[i].toString();
        }
        return str;
    }
    
    public void clear(){
        this.items = new Product[3];
        this.index = 0;
    }

    @Override
    public String toString() {
        return "SaleTransaction{" + "items: " + Arrays.toString(items) + '}';
    }
    
    
}
