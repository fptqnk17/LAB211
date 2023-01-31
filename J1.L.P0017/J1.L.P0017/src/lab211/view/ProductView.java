package lab211.view;

import java.util.ArrayList;
import lab211.model.ProductModel;
import lab211.utils.Utils;

public class ProductView {

    private final ArrayList<String> options;
    private int optionsCount;

    public ProductView() {
        this.options = new ArrayList<>();

        this.optionsCount = 0;
    }

    public void addOption(String option) {
        options.add(option);

        optionsCount++;
    }

    public int showMainMenu() {
        System.out.println("----------    PRODUCT MANAGEMENT    ----------");
        System.out.println("----------------------------------------------");

        for (int i = 1; i <= this.optionsCount; i++) {
            System.out.println(i + ". " + this.options.get(i - 1));
        }

        System.out.println("----------------------------------------------");

        int choice = Utils.getInt("Please enter your option: ", 1, 8);

        return choice;
    }

    public int showAskGoBackMainMenu() {
        System.out.println("Go back to the main menu?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        return Utils.getInt("Please enter your option: ", 1, 2);
    }

    public ProductModel createNewProduct() {
        System.out.println("---------     ENTER NEW PRODUCT     ----------");
        System.out.println("----------------------------------------------");

        String productID = Utils.getString("Enter Product ID: ");
        String productName = Utils.getString("Enter Product Name: ", 5);
        double unitPrice = Utils.getDouble("Enter Unit Price (0 ~ 10000): ", 0.0, 10000.0);
        int quantity = Utils.getInt("Enter Quantity  (0 ~ 1000): ", 0, 1000);
        String status = Utils.getString("Enter Status (\"Available\" or \"Not Available\"): ", 0, null, "Available", "Not Available");

        return new ProductModel(productID, productName, unitPrice, quantity, status);
    }

    public String getProductID() {
        return Utils.getString("Enter Product ID: ");
    }

    public ArrayList<ProductModel> searchProductsByName(ArrayList<ProductModel> products) {
        System.out.println("-------     SEARCH PRODUCTS BY NAME     ------");
        System.out.println("----------------------------------------------");

        String productName = Utils.getString("Enter Product Name: ");

        ArrayList<ProductModel> suitableProducts = new ArrayList<>();

        for (ProductModel product : products) {
            if (product.getProductName().contains(productName)) {
                suitableProducts.add(product);
            }
        }

        return suitableProducts;
    }

    public void updateProduct(ProductModel product) {
        System.out.println("-----------     UPDATE PRODUCT     -----------");
        System.out.println("----------------------------------------------");

        String newProductName = Utils.getString("Enter Product Name: ", 5);
        double newUnitPrice = Utils.getDouble("Enter Unit Price (0 ~ 10000): ", 0.0, 10000.0);
        int newQuantity = Utils.getInt("Enter Quantity  (0 ~ 1000): ", 0, 1000);
        String newStatus = Utils.getString("Enter Status (\"Available\" or \"Not Available\"): ", 0, null, "Available", "Not Available");
                
        product.setProductName(newProductName);
        product.setUnitPrice(newUnitPrice);
        product.setQuantity(newQuantity);
        product.setStatus(newStatus);
    }

    public int comfirmDeleteProduct() {
        System.out.println("Delete this Product?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        return Utils.getInt("Please enter your option: ", 1, 2);
    }

    public void printAllLists(ArrayList<ProductModel> products) {
        System.out.println("----------     ALL LIST PRODUCTS     ---------");
        System.out.println("----------------------------------------------");

        for (ProductModel product : products) {
            System.out.println(product);
        }
    }
}
