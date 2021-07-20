package Collections;

import Collections.Model.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    private final Model model;
    private final View view;

    private static final BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void startProcess(){
        while (true) {
            view.askToEnterInt();
            try {
                int number = Integer.parseInt(CONSOLE.readLine());
                model.addInt(number);
            } catch (NumberFormatException e){
                break;
            } catch (IOException e){
                view.printError();
            }
        }
        view.printResult(model.getAllElements());
    }
}
