package Java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Controller {
    private final Model model;
    private final View view;

    private static final BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void startProcess() throws IOException {
        model.initArray();
        view.printMidValue(model.findMiddleValue());
        view.printMinElement(model.findMinValue());
        view.printSumOfZero(model.findCountOfZero());
        view.printSumBiggerThanZero(model.findCountBiggerThanZero());
        int[] before = model.getArray();
        view.askToEnterInt();
        while (true) {
            try {
                model.MultiplyElementsOnNumber((Integer.parseInt(CONSOLE.readLine())));
                break;
            } catch (NumberFormatException e) {
                view.printError();
            }
        }
        int[]  after = model.getArray();
        view.printElementsAfterMultiply(before, after);
    }
}
