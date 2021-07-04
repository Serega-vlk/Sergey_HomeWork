package StringProcessing;

import java.util.ArrayList;

public class Model {
    private final ArrayList<Person> people;

    public Model(){
        this.people = new ArrayList<>();
    }

    public void addPerson(Person p){
        this.people.add(p);
    }

    public ArrayList<Person> getPeople() {
        return people;
    }
}
