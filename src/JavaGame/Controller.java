package JavaGame;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    private static final Scanner CONSOLE_READER = new Scanner(System.in);

    public Controller(View view, Model model){
        this.model = model;
        this.view = view;
    }

    public void startGame(){
        model.generateRandInt();
        view.printStartMessage();
        while (true){
            view.printBounds(model.getMinBound(), model.getMaxBound());
            int number = CONSOLE_READER.nextInt();
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
