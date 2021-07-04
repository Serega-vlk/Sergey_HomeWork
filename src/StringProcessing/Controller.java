package StringProcessing;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private final Model model;
    private final View view;

    private static final Scanner CONSOLE = new Scanner(System.in);

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void registerUser(){
        newUser:
        while (true){
            String[] user = new String[6];
            for (int i = 0; i < 6; i++) {
                aksUser(i);
                String answer = CONSOLE.nextLine();
                if (processUser(answer, i)){
                    user[i] = answer;
                } else {
                    view.printError();
                    continue newUser;
                }
            }
            model.addPerson(new Person(user));
            view.printUserAdded();
            view.askToContinue();
            while (true){
                String continueProcess = CONSOLE.nextLine();
                if (continueProcess.equals("n")) break newUser;
                else if (continueProcess.equals("y")) continue newUser;
                else view.askToContinue();
            }
        }
        ArrayList<String> userData = new ArrayList<>();
        for (Person p : model.getPeople()){
            userData.add(p.toString());
        }
        view.printAllUsers(userData);
    }

    public void aksUser(int question){
        switch (question){
            case 0:
                view.askToName();
                break;
            case 1:
                view.askToSurname();
                break;
            case 2:
                view.askToMiddleName();
                break;
            case 3:
                view.askToTelephone();
                break;
            case 4:
                view.askToEmail();
                break;
            case 5:
                view.askToNickname();
                break;
            default:
                throw new IndexOutOfBoundsException("No questions for this index");
        }
    }

    public boolean processUser(String input, int question){
        switch (question){
            case 0:
            case 1:
            case 2:
                return input.matches("[А-ЯA-Z]\\D+");
            case 3:
                return input.matches("\\+\\d{12}") || input.matches("\\d{10}");
            case 4:
                return input.matches("\\w+@\\D+\\.\\D{2,}");
            case 5:
                return input.matches("@\\w{4,10}");
            default:
                throw new IndexOutOfBoundsException("No questions for this index");
        }
    }
}
