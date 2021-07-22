package Java8;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Model {
    private int[] array;

    public void initArray(){
        this.array = IntStream.rangeClosed(1, (int) (Math.random() * 100))
                .map(x -> x = (int) (Math.random() * 200) - 100)
                .toArray();
    }

    public int findMiddleValue(){
        return  (int) Arrays.stream(this.array)
                .average()
                .getAsDouble();
    }

    public int findMinValue(){
        return Arrays.stream(this.array)
                .min()
                .getAsInt();
    }

    public int findCountOfZero(){
        return (int) Arrays.stream(this.array)
                .filter(x -> x == 0)
                .count();
    }

    public int findCountBiggerThanZero(){
        return (int) Arrays.stream(this.array)
                .filter(x -> x > 0)
                .count();
    }

    public void MultiplyElementsOnNumber(final int number){
        this.array = Arrays.stream(this.array)
                .map(x -> x * number)
                .toArray();
    }

    public int[] getArray() {
        return array;
    }
}
