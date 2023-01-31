package lab211;

import lab211.controller.ProductController;
import lab211.view.ProductView;

public class Main {

    public static void main(String[] args) {
        ProductView view = new ProductView();
        ProductController controller = new ProductController(view);

        controller.run();
    }
}
