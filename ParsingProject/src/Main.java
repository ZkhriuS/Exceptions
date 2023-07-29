import controller.FileController;
import controller.ValidationController;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        FileController fileController = new FileController();
        ValidationController validationController = new ValidationController();
        ConsoleView view = new ConsoleView(validationController, fileController);
        view.view();
    }
}
