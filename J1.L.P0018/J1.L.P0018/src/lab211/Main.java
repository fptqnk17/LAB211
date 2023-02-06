package lab211;

import lab211.controller.CDHouseController;
import lab211.view.CDHouseView;

public class Main {
    public static void main(String[] args) {
        CDHouseView view = new CDHouseView();
        CDHouseController controller = new CDHouseController(view);
        
        controller.run();
    }
}