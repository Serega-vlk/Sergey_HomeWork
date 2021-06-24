package BasicJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    private View view;
    private Model model;

    private static final BufferedReader CONSOLE_READER = new BufferedReader(new InputStreamReader(System.in));

    public Controller(View view, Model model){
        this.model = model;
        this.view = view;
    }

    public void startProcess() throws IOException {
        view.helloMessage();
        String wordToCheck = "Hello";
        int index = 1;
        while (true){
            view.askToEnter(wordToCheck);
            String word = CONSOLE_READER.readLine();
            if (model.check(word, index)){
                model.addWord(word);
                if (index == 2) break;
                wordToCheck = "world!";
                index = 2;
            } else {
                view.askToEnterAgain();
            }
        }
        view.printResult(model.getSentences());
    }
}
