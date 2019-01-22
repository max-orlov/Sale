package sales;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Sale {
    private ProductList productList;
    private SaleTransaction transaction;

    public Sale() {
        this.productList = new ProductList();
        this.transaction = new SaleTransaction(new RandomNumberGenerator(1000, 9999).random());

        productList.addProduct("name1", "first prod", 100, 2, 5);
        productList.addProduct("name2", "second prod", 150, 7, 2);
        productList.addProduct("name3", "third prod", 200, 6, 2);
        productList.addProduct("name4", "fourth prod", 320, 12, 2);
        productList.addProduct("name5", "fifth prod", 180, 10, 2);
    }

    public void start(){
        while (true) {
            for (int i = 0; i < 27; i++) {
                System.out.print("=+");
            }
            System.out.println("\nWelcome to the Simple Inventory Management System");
            for (int i = 0; i < 27; i++) {
                System.out.print("=+");
            }
            System.out.println("\n");
            System.out.println("Please select from the fallowing options: \n" +
                    "Press 1 to Register a Product for Sale \n" +
                    "Press 2 to Buy a Product to the Cart \n" +
                    "Press 3 to Remove the Product from the Cart \n" +
                    "Press 4 to View all Available Products \n" +
                    "Press 5 to Check out \n" +
                    "Press 6 to Get Help \n" +
                    "Press 7 to Exit" + "\n"
            );
            System.out.print("Please enter your choice: ");
            Scanner n = new Scanner(System.in);
            int a = n.nextInt();
            switch (a){
                case 1:
                    registerProduct(n);
                    break;
                case 2:
                    purchaseProduct(n);
                    break;
                case 3:
                    removeProduct(n);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                        break;
                    case 7:
                        return;
                default:
                    System.out.println("Bad choice");
            }
        }
    }

    private void registerProduct(Scanner s) {
        if(this.productList.isFull()){
            System.out.println("Stock is already full\n");
            return;
        }
        System.out.println("Registering new Product...");
        s.nextLine();
        System.out.println("Input product name: ");
        String name = s.nextLine();
        System.out.println("Input product description: ");
        String desc = s.nextLine();
        System.out.println("Input product price");
        double price = s.nextDouble();
        RandomNumberGenerator rnd = new RandomNumberGenerator(0, 10);
        int qtyOnHand = rnd.random();
        rnd.setValues(1, 5);
        int minOrderQty = rnd.random();
        this.productList.addProduct(name, desc, price, qtyOnHand, minOrderQty);
        //System.err.println(Arrays.toString(this.productList.getListOfProducts()));
    }

    private void purchaseProduct(Scanner s) {
        if (this.productList.isEmpty()) {
            System.out.println("There are currently no products added in the stock.");
            System.out.println("Please select Option #1 to add a products to the stock.");
            return;
        }
        if (this.transaction.isFull()){
            System.out.println("The Cart is already full");
            return;
        }
        System.out.println("Please select from the fallowing products which are available: \n");
        for (int i = 0; i < productList.countProducts() -1 ; i++){
            System.out.println("Select product " + (i +1) + ":");
            System.out.println("    Name: " + this.productList.getProduct(i).getName() );
            System.out.println("    Description: " + this.productList.getProduct(i).getDesc());
            System.out.println("    Quantity: " + this.productList.getProduct(i).getQtyOnHand());
            System.out.println("    Price: " + this.productList.getProduct(i).getPrice());
            System.out.println("    Min Order Quantity: " + this.productList.getProduct(i).getMinOrderQty());
            System.out.println();
        }
        System.out.println("Select Product " + (productList.countProducts()) +  " to exit purchase menu\n");
        System.out.println("Please enter selected product: ");
        Scanner n = new Scanner(System.in);
        int b = n.nextInt();
        if(this.productList.getProduct(b) == null || this.productList.getProduct(b).getQtyOnHand() < this.productList.getProduct(b).getMinOrderQty()) {
            System.out.println("This product can't be purchased");
            return;
        }
        transaction.addPurchased(productList.getProduct(b -1));
    }

    private void removeProduct(Scanner n) {
        if(transaction.isEmpty()) {
            System.out.println("The stock is empty.\nPlease select Option #2 to Purchase products");
            return;
        }
        System.out.println("Please select from the following products which have been added to Cart");

    }
}
