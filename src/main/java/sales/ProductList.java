package sales;

import java.util.Arrays;

public class ProductList {
    private Product[] listOfProducts;
    private static int index;

    public ProductList() {
        this.index = 0;
        this.listOfProducts = new Product[5];
    }

    public void addProduct(String name, String desc, double price, int qtyOnHand, int minOrderQty) {
        Product prd = new Product(name, desc, price, qtyOnHand, minOrderQty);
        listOfProducts[index++] = prd;
    }

    public boolean isFull() {
        return listOfProducts[4] != null;
    }

    public int countProducts() {
        return this.index;
    }

    public boolean isEmpty() {
        return countProducts() == 0;
    }

    public Product getProduct(int ind) {
        if (ind < 0 || ind > listOfProducts.length - 1)
            return null;
        return this.listOfProducts[ind];
    }

    private int searchProduct(Product pr) {
        for (int i = 0; i < listOfProducts.length; i++) {
            if (pr.equals(listOfProducts[i]))
                return i;
        }
        return -1;
    }

    public void qtyOnHandDegree(Product product) {
        int index = this.searchProduct(product);
        if (index != -1)
            listOfProducts[index].qtyOnHandDegree(listOfProducts[index].getMinOrderQty());
    }
    
    public String[] getStringProducts() {
        String[] str = new String[countProducts()];
        for (int i = 0; i < countProducts(); i++) {
            str[i] = listOfProducts[i].toString();
        }
        return str;
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "listOfProducts=" + Arrays.toString(listOfProducts) +
                '}';
    }
}
