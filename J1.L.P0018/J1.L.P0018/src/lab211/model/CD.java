package lab211.model;

public class CD {
    private String collectionName;
    private String type;
    private String title;
    private double unitPrice;
    private int id;
    private int publishingYear;

    public CD() {
    }

    public CD(String collectionName, String type, String title, double unitPrice, int id, int publishingYear) {
        this.collectionName = collectionName;
        this.type = type;
        this.title = title;
        this.unitPrice = unitPrice;
        this.id = id;
        this.publishingYear = publishingYear;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getID() {
        return id;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    @Override
    public String toString() {
        return this.collectionName + " | " + this.type + " | " + this.title + " | " + this.unitPrice + " | " + this.id + " | " + this.publishingYear;
    }
}