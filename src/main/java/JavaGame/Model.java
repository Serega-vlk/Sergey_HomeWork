package JavaGame;

import java.util.ArrayList;

public class Model {
    private int number;
    private int minBound;
    private int maxBound;
    private ArrayList<Integer> userEnters;

    public Model(){
        userEnters = new ArrayList<>();
    }

    public void generateRandInt(){
        number = (int) Math.round(Math.random() * (GlobalConstants.MAX_BOUND - 2)) + 1;
        minBound = GlobalConstants.MIN_BOUND;
        maxBound = GlobalConstants.MAX_BOUND;
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

    public int getMinBound() {
        return minBound;
    }

    public int getMaxBound() {
        return maxBound;
    }

    public void setMinBound(int minBound) {
        if ((number - minBound) < (number - this.minBound) && minBound < number)
            this.minBound = minBound;
    }

    public void setMaxBound(int maxBound) {
        if ((maxBound - number) < (this.maxBound - number) && maxBound > number)
            this.maxBound = maxBound;
    }

    public ArrayList<Integer> getUserEnters() {
        return userEnters;
    }
}
