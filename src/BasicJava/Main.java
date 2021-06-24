package BasicJava;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        controller.startProcess();
    }
}
