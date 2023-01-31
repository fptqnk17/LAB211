package lab211.controller;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import lab211.model.ProductModel;
import lab211.view.ProductView;

public class ProductController {

    private ProductView view;
    private ArrayList<ProductModel> products;

    public ProductController(ProductView view) {
        this.view = view;
        this.products = new ArrayList<>();
        this.loadProductsFromFile();

        this.view.addOption("Create a new Product");
        this.view.addOption("Check to exist Product");
        this.view.addOption("Search Product information by name");
        this.view.addOption("Update Product information");
        this.view.addOption("Delete Product information");
        this.view.addOption("Save to file");
        this.view.addOption("Print all lists from file");
        this.view.addOption("Exit");
    }

    private void createNewProduct() {
        while (true) {
            ProductModel newProduct = view.createNewProduct();
            products.add(newProduct);

            if (view.showAskGoBackMainMenu() == 1) {
                break;
            }
        }
    }

    private boolean checkProductExists(String ID) {
        for (ProductModel product : this.products) {
            if (product.getProductID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    private void productExists() {
        while (true) {
            String ID = view.getProductID();

            if (this.checkProductExists(ID)) {
                System.out.println("Product exists");
            } else {
                System.out.println("No Product Found!");
            }

            if (view.showAskGoBackMainMenu() == 1) {
                break;
            }
        }
    }

    private void searchProductsByName() {
        while (true) {
            ArrayList<ProductModel> suitableProducts = view.searchProductsByName(this.products);

            if (suitableProducts.isEmpty()) {
                System.out.println("Have no any Product");
            } else {
                for (ProductModel product : suitableProducts) {
                    System.out.println(product);
                }
            }

            if (view.showAskGoBackMainMenu() == 1) {
                break;
            }
        }
    }
    
    private ProductModel getProductByID(String ID) {
        for (ProductModel product : this.products) {
            if (product.getProductID().equals(ID)) {
                return product;
            }
        }
        
        return null;
    }

    private void updateProductByID() {
        while (true) {
            String ID = view.getProductID();

            if (this.checkProductExists(ID)) {
                ProductModel product = this.getProductByID(ID);
                
                view.updateProduct(product);
            } else {
                System.out.println("Product does not exist");
            }

            if (view.showAskGoBackMainMenu() == 1) {
                break;
            }
        }
    }

    private void deleteProduct(String ID) {
        for (ProductModel product : this.products) {
            if (product.getProductID().equals(ID)) {
                products.remove(product);
                break;
            }
        }
    }

    private void deleteProductByID() {
        while (true) {
            String ID = view.getProductID();

            if (this.checkProductExists(ID)) {
                if (view.comfirmDeleteProduct() == 1) {
                    this.deleteProduct(ID);

                    System.out.println("Delete successfully");
                } else {
                    System.out.println("Delete failed");
                }
            } else {
                System.out.println("Product does not exist");
            }

            if (view.showAskGoBackMainMenu() == 1) {
                break;
            }
        }
    }

    private void saveToFile() {
        while (true) {
            try ( PrintWriter pw = new PrintWriter(new FileWriter("Product.dat"))) {
                for (ProductModel product : this.products) {
                    pw.println(
                            product.getProductID() + ","
                            + product.getProductName() + ","
                            + product.getUnitPrice() + ","
                            + product.getQuantity() + ","
                            + product.getStatus()
                    );
                }

                pw.close();

                System.out.println("Save to file \'Product.dat\' successfully");
            } catch (Exception e) {
            }

            if (view.showAskGoBackMainMenu() == 1) {
                break;
            }
        }
    }

    private void loadProductsFromFile() {
        this.products.clear();

        try {
            List<String> lines = Files.readAllLines(Paths.get("Product.dat"));

            for (String line : lines) {
                String[] parts = line.split(",");

                String productID = parts[0];
                String productName = parts[1];
                double unitPrice = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                String status = parts[4];

                products.add(new ProductModel(productID, productName, unitPrice, quantity, status));
            }
        } catch (IOException e) {
        }
    }

    private void printAllListsFromFile() {
        this.loadProductsFromFile();

        ArrayList<ProductModel> sortedProducts = new ArrayList<>(products);
        sortedProducts.sort((p1, p2) -> {
            int result = Integer.compare(p2.getQuantity(), p1.getQuantity());
            if (result == 0) {
                result = Double.compare(p1.getUnitPrice(), p2.getUnitPrice());
            }
            return result;
        });

        while (true) {
            view.printAllLists(sortedProducts);

            if (view.showAskGoBackMainMenu() == 1) {
                break;
            }
        }
    }

    public void run() {

        boolean isRunning = true;

        while (isRunning) {
            int choice = view.showMainMenu();

            switch (choice) {
                case 1 -> {
                    this.createNewProduct();
                }

                case 2 -> {
                    this.productExists();
                }

                case 3 -> {
                    this.searchProductsByName();
                }

                case 4 -> {
                    this.updateProductByID();
                }

                case 5 -> {
                    this.deleteProductByID();
                }

                case 6 -> {
                    this.saveToFile();
                }

                case 7 -> {
                    this.printAllListsFromFile();
                }

                case 8 -> {
                    isRunning = false;
                }
            }
        }
    }
}
