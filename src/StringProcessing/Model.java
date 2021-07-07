package StringProcessing;

import java.util.ArrayList;

public class Model {
    private final ArrayList<User> people;

    public Model(){
        this.people = new ArrayList<>();
    }

    /**
     * Метод добовляет нового пользователя в список.
     * @param p пользователь которого нужно добавить
     */
    public void addPerson(User p){
        this.people.add(p);
    }

    public ArrayList<User> getPeople() {
        return people;
    }
}
