package lab211.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lab211.model.CD;
import lab211.view.CDHouseView;

public class CDHouseController {

    private CDHouseView view;
    private ArrayList<CD> CDs;

    public CDHouseController() {
    }

    public CDHouseController(CDHouseView view) {
        this.view = view;
        this.CDs = CDHouseController.loadFromFile();

        this.view.addOption("Add CD");
        this.view.addOption("Search CD by CD title");
        this.view.addOption("Display the catalog");
        this.view.addOption("Update CD information");
        this.view.addOption("Delete CD information");
        this.view.addOption("Save to file");
        this.view.addOption("Print all list CDs from file");
        this.view.addOption("Exit");
    }
    
    private boolean checkCDExist(CD newCD) {
        for (var cd : this.CDs) {
            if (cd.getID() == newCD.getID()) {
                return true;
            }
        }
        
        return false;
    }

    private void addCD() {
        while (true) {
            CD newCD = this.view.addCD();
            
            if (!this.checkCDExist(newCD)) {
                this.CDs.add(newCD);
                
                this.view.printMessage("Add new CD successful");
            }
            else {
                this.view.printError("Add new CD failed");
            }

            if (this.view.showAskGoBackMainMenu() == 1) {
                break;
            }
        }
    }

    private void searchCDByTitle() {
        if (this.CDs.isEmpty()) {
            this.view.printError("Nothing to search!!");

            return;
        }

        String titleFromUser = this.view.searchCDByTitle();

        boolean isEmpty = true;

        for (var cd : this.CDs) {
            if (cd.getTitle().contains(titleFromUser)) {
                this.view.printACD(cd);

                isEmpty = false;
            }
        }

        if (isEmpty) {
            this.view.printError("Not found!!!");
        }
    }

    private void printAllListCDs() {
        if (this.CDs.isEmpty()) {
            this.view.printError("Nothing to print!!");
        } else {
            this.view.printAllCDs(this.CDs);
        }
    }

    private void updateCDByID() {
        if (this.CDs.isEmpty()) {
            this.view.printError("Nothing to update!!");
            this.view.printError("Update failed!!");

            return;
        }

        while (true) {
            int ID = this.view.updateCDByID();

            boolean isEmpty = true;

            for (var cd : this.CDs) {
                if (cd.getID() == ID) {

                    this.view.updateCD(cd);
                    this.view.printMessage("Update successful!!");

                    isEmpty = false;

                    break;
                }
            }

            if (isEmpty) {
                this.view.printError("Not found to update!!");
                this.view.printError("Update failed!!");
            }

            if (this.view.showAskGoBackMainMenu() == 1) {
                break;
            }
        }
    }

    private void deleteCDByID() {
        if (this.CDs.isEmpty()) {
            this.view.printError("Nothing to delete!!");
            this.view.printError("Delete failed!!");

            return;
        }

        while (true) {

            int ID = this.view.deleteCDByID();

            boolean isEmpty = true;

            for (var cd : this.CDs) {
                if (cd.getID() == ID) {
                    if (this.view.comfirmDeleteCD() == 1) {
                        this.CDs.remove(cd);

                        this.view.printMessage("Delete successful!!");
                    } else {
                        this.view.printError("Delete failed!!");
                    }

                    isEmpty = false;

                    break;
                }
            }

            if (isEmpty) {
                this.view.printError("Not found to delete!!");
                this.view.printError("Delete failed!!");
            }

            if (this.view.showAskGoBackMainMenu() == 1) {
                break;
            }
        }
    }

    private void saveToFile() {
        if (this.CDs.isEmpty()) {
            this.view.printError("Nothing to save!!");

            return;
        }

        while (true) {
            try (PrintWriter pw = new PrintWriter(new FileWriter("CDs.dat"))) {
                for (CD cd : this.CDs) {
                    pw.println(cd);
                }

                pw.close();

                System.out.println("Save to file \'CDs.dat\' successfully");
            } catch (Exception e) {
            }

            if (this.view.showAskGoBackMainMenu() == 1) {
                break;
            }
        }
    }

    private static ArrayList<CD> loadFromFile() {
        ArrayList<CD> CDsFromFile = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get("CDs.dat"));

            for (String line : lines) {
                String[] parts = line.split(" \\| ");

                String collectionName = parts[0];
                String type = parts[1];
                String title = parts[2];
                double unitPrice = Double.parseDouble(parts[3]);
                int id = Integer.parseInt(parts[4]);
                int publishingYear = Integer.parseInt(parts[5]);

                CDsFromFile.add(new CD(collectionName, type, title, unitPrice, id, publishingYear));
            }
        } catch (IOException e) {
        }

        return CDsFromFile;
    }

    private void printAllCDsFromFile() {
        ArrayList<CD> CDsFromFile = CDHouseController.loadFromFile();

        Collections.sort(CDsFromFile, (CD cd1, CD cd2) -> cd1.getTitle().compareTo(cd2.getTitle()));
        this.view.printAllCDs(CDsFromFile);
    }

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            int choice = this.view.showMainMenu();

            switch (choice) {
                case 1 -> {
                    this.addCD();
                }

                case 2 -> {
                    this.searchCDByTitle();
                }

                case 3 -> {
                    this.printAllListCDs();
                }

                case 4 -> {
                    this.updateCDByID();
                }

                case 5 -> {
                    this.deleteCDByID();
                }

                case 6 -> {
                    this.saveToFile();
                }

                case 7 -> {
                    this.printAllCDsFromFile();
                }

                case 8 -> {
                    isRunning = false;
                }
            }
        }
    }
}
