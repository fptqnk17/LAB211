package lab211.view;

import java.util.ArrayList;
import lab211.model.CD;
import lab211.utils.Utils;

public class CDHouseView {

    private final ArrayList<String> options;
    private int optionsCount;

    public CDHouseView() {
        this.options = new ArrayList<>();

        this.optionsCount = 0;
    }

    public void printError(String msg) {
        System.err.println(msg);
    }
    
    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void addOption(String option) {
        options.add(option);

        optionsCount++;
    }

    public int showMainMenu() {
        System.out.println("---------------    CD HOUSE    ---------------");
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

    public CD addCD() {
        System.out.println("--------------     ADD CD     ----------------");
        System.out.println("----------------------------------------------");

        String collectionName = Utils.getString("Enter Collection Name: ");
        String type = Utils.getString("Enter Type: ");
        String title = Utils.getString("Enter Title: ");
        double unitPrice = Utils.getDouble("Enter Unit Price: ", 0.0, Double.MAX_VALUE);
        int id = Utils.getInt("Enter ID: ", 0, Integer.MAX_VALUE);
        int publishingYear = Utils.getInt("Enter Publishing Year: ", 1900, Integer.MAX_VALUE);

        System.out.println("Add CD successfully");

        return new CD(collectionName, type, title, unitPrice, id, publishingYear);
    }

    public String searchCDByTitle() {
        System.out.println("------------     SEARCH CD     ---------------");
        System.out.println("----------------------------------------------");

        return Utils.getString("Enter Title: ");
    }

    public int updateCDByID() {
        System.out.println("------------     UPDATE CD     ---------------");
        System.out.println("----------------------------------------------");

        return Utils.getInt("Enter ID: ", 0, Integer.MAX_VALUE);
    }
    
    public void updateCD(CD cd) {
        String collectionName = Utils.getString("Enter Collection Name: ");
        String type = Utils.getString("Enter Type: ");
        String title = Utils.getString("Enter Title: ");
        double unitPrice = Utils.getDouble("Enter Unit Price: ", 0.0, Double.MAX_VALUE);
        int publishingYear = Utils.getInt("Enter Publishing Year: ", 1900, Integer.MAX_VALUE);
        
        cd.setCollectionName(collectionName);
        cd.setType(type);
        cd.setTitle(title);
        cd.setUnitPrice(unitPrice);
        cd.setPublishingYear(publishingYear);
    }

    public int deleteCDByID() {
        System.out.println("------------     DELETE CD     ---------------");
        System.out.println("----------------------------------------------");

        return Utils.getInt("Enter ID: ", 0, Integer.MAX_VALUE);
    }
    
    public int comfirmDeleteCD() {
        System.out.println("Delete this CD?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        return Utils.getInt("Please enter your option: ", 1, 2);
    }

    public void printACD(CD cd) {
        System.out.println(cd);
    }

    public void printAllCDs(ArrayList<CD> CDs) {
        System.out.println("Collection Name | Type | Title | Unit Price | ID | Publishing Year");

        for (CD cd : CDs) {
            this.printACD(cd);
        }
    }
}
