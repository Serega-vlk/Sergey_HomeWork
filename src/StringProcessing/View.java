package StringProcessing;

import java.util.ArrayList;

public class View {
    public static final String ENTER = "введите";
    public static final String SPACE = " ";
    public static final String DOUBLE_POINT = ":";
    public static final String TELEPHONE = "телефон";
    public static final String SURNAME = "фамилию";
    public static final String NAME = "имя";
    public static final String NICKNAME = "никнейм (начиная с @)";
    public static final String MIDDLE_NAME = "отчество";
    public static final String EMAIL = "електронную почту";
    public static final String ALL_USERS = "все пользователи";
    public static final String CONTINUE = "желаете продолжить?(y или n)";
    public static final String ERROR = "данные введены некоректно, повторите попытку";
    public static final String USER_ADDED = "пользователь успешно добавлен";

    public void askToName(){
        System.out.println(ENTER + SPACE + NAME + DOUBLE_POINT);
    }

    public void askToSurname(){
        System.out.println(ENTER + SPACE + SURNAME + DOUBLE_POINT);
    }

    public void askToMiddleName(){
        System.out.println(ENTER + SPACE + MIDDLE_NAME + DOUBLE_POINT);
    }

    public void askToTelephone(){
        System.out.println(ENTER + SPACE + TELEPHONE + DOUBLE_POINT);
    }

    public void askToEmail(){
        System.out.println(ENTER + SPACE + EMAIL + DOUBLE_POINT);
    }

    public void askToNickname(){
        System.out.println(ENTER + SPACE + NICKNAME + DOUBLE_POINT);
    }

    public void printAllUsers(ArrayList<String> usersData){
        System.out.println(ALL_USERS + DOUBLE_POINT);
        for (String user : usersData){
            System.out.println(user);
        }
    }

    public void askToContinue(){
        System.out.println(CONTINUE + DOUBLE_POINT);
    }

    public void printError(){
        System.out.println(ERROR);
    }

    public void printUserAdded(){
        System.out.println(USER_ADDED);
    }
}
