package StringProcessing;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class View {
    private ResourceBundle messages;

    public View(){
        messages = ResourceBundle.getBundle("\\StringProcessing\\message", new Locale("en"));
    }

    public void setLocale(String locale){
        messages = ResourceBundle.getBundle("\\StringProcessing\\message", new Locale(locale));
    }

    public void choiceLocale(){
        System.out.println("Choice Locale (ru, en, ...):");
    }

    public void askToName(){
        System.out.println(messages.getString("input.name"));
    }

    public void askToSurname(){
        System.out.println(messages.getString("input.surname"));
    }

    public void askToMiddleName(){
        System.out.println(messages.getString("input.middle.name"));
    }

    public void askToTelephone(){
        System.out.println(messages.getString("input.telephone"));
    }

    public void askToEmail(){
        System.out.println(messages.getString("input.email"));
    }

    public void askToNickname(){
        System.out.println(messages.getString("input.nickname"));
    }

    public void askToBirthday(){
        System.out.println(messages.getString("input.birthday"));
    }

    public void printAllUsers(ArrayList<String> usersData){
        System.out.println(messages.getString("output.all.users"));
        for (String user : usersData){
            System.out.println(user);
        }
    }

    public void askToContinue(){
        System.out.println(messages.getString("output.ask.to.continue"));
    }

    public void printError(){
        System.out.println(messages.getString("output.error"));
    }

    public void printUserAdded() {
        System.out.println(messages.getString("output.user.added"));
    }
}
