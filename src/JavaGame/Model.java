package JavaGame;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.ArrayList;

public class Model {
    private int number;
    private int minRange;
    private int maxRange;
    private ArrayList<Integer> userEnters;

    public Model(){
        userEnters = new ArrayList<>();
    }

    public void generateRandInt(){
        number = (int) Math.round(Math.random() * 100);
        minRange = 0;
        maxRange = 100;
    }

    public void addUserNumber(int number){
        userEnters.add(number);
    }

    public boolean isNumberFound(){
        return number == userEnters.get(userEnters.size() - 1);
    }

    public boolean isBiggerThanNumber(){
        return number < userEnters.get(userEnters.size() - 1);
    }

    public int getMinRange() {
        return minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public void setMinRange(int minRange) {
        if ((number - minRange) < (number - this.minRange))
            this.minRange = minRange;
    }

    public void setMaxRange(int maxRange) {
        if ((maxRange - number) < (this.maxRange - number))
            this.maxRange = maxRange;
    }

    public ArrayList<Integer> getUserEnters() {
        return userEnters;
    }
}
