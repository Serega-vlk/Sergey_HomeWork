package JavaGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    private Model model;
    private View view;

    private static final BufferedReader CONSOLE_READER = new BufferedReader(new InputStreamReader(System.in));

    public Controller(View view, Model model){
        this.model = model;
        this.view = view;
    }

    public void startGame() throws IOException {
        model.generateRandInt();
        view.printStartMessage();
        while (true){
            view.printBounds(model.getMinBound(), model.getMaxBound());
            int number;
            try {
                number = Integer.parseInt(CONSOLE_READER.readLine());
            } catch (NumberFormatException e){
                view.printErrorMessage();
                continue;
            }
            if (number > 100 || number < 0){
                view.printErrorMessage();
                continue;
            }
            model.addUserNumber(number);
            if (model.isNumberFound()){
                view.printOnNumberIsFound(number);
                view.printUserStats(model.getUserEnters());
                break;
            }
            if (model.isBiggerThanNumber()){
                view.printOnNumberIsBigger(number);
                model.setMaxBound(number);
            } else {
                view.printOnNumberIsLess(number);
                model.setMinBound(number);
            }
        }
    }
}
