package Collections.Model;

import java.util.Objects;

public class Element {
    private final int number;
    private int count;

    public Element(int number){
        this.number = number;
        count = 1;
    }

    public void incrementCount(){
        this.count++;
    }

    public int getNumber() {
        return number;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return number == element.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.format("%d - %d", number, count);
    }
}
