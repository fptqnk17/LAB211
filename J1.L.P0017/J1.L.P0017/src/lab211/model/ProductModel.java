package lab211.model;

public class ProductModel {

    private String productID;
    private String productName;
    private double unitPrice;
    private int quantity;
    private String status;

    public ProductModel(String productID, String productName, double unitPrice, int quantity, String status) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.status = status;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName.length() >= 5 && !productName.contains(" ")) {
            this.productName = productName;
        }
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        if (unitPrice >= 0.0 && unitPrice <= 10000.0) {
            this.unitPrice = unitPrice;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0 && quantity <= 1000) {
            this.quantity = quantity;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (this.status.equals("Available") || this.status.equals("Not Available")) {
            this.status = status;
        }
    }

    @Override
    public String toString() {
        return "ProductModel{ " + "productID = " + productID + ", productName = " + productName + ", unitPrice = " + unitPrice + ", quantity = " + quantity + ", status = " + status + " }";
    }
}
