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
        view.choiceLocale();
        String locale = CONSOLE.nextLine();
        view.setLocale(locale);
        newUser:
        while (true){
            String[] user = new String[7];
            for (int i = 0; i < 7; i++) {
                while (true) {
                    aksUser(i);
                    String answer = CONSOLE.nextLine();
                    if (processUser(answer, i)) {
                        user[i] = answer;
                        break;
                    } else {
                        view.printError();
                    }
                }
            }
            try {
                model.addPerson(new User(user));
            } catch (InvalidUsernameException e){
                System.err.println(e);
                continue;
            }
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
        for (User p : model.getUsers()){
            userData.add(p.toString());
        }
        view.printAllUsers(userData);
    }

    /**
     * метод задаёт вопрос соответсвующий определённым индексам.
     * @param question номер вопроса (от 0 до 5)
     */
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
            case 6:
                view.askToBirthday();
                break;
            default:
                throw new IndexOutOfBoundsException("No questions for this index");
        }
    }

    /**
     * Метод проверяет переданное слово на соответствие шаблону регулярного выражения.
     * @param input слово которое нужно проверить
     * @param question новмер заданного вопроса для проверки на определённый шаблон
     *                 регулярного выражения
     * @return
     * true - если соответсвие найдено.
     * false - если переданное слово не соотвествует шаблону регулярного выражения.
     */
    public boolean processUser(String input, int question){
        switch (question){
            case 0:
            case 1:
            case 2:
                return input.matches(RegexContainer.ALL_NAMES_PATTERN);
            case 3:
                return input.matches(RegexContainer.TELEPHONE_PATTERN);
            case 4:
                return input.matches(RegexContainer.EMAIL_PATTERN);
            case 5:
                return input.matches(RegexContainer.NICKNAME_PATTERN);
            case 6:
                return input.matches(RegexContainer.BIRTHDAY_PATTERN);
            default:
                throw new IndexOutOfBoundsException("No questions for this index");
        }
    }
}
