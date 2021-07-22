package Java8;

import java.util.Arrays;

public class View {
    public void printMidValue(int mid){
        System.out.printf("Среднее значение - %d%n", mid);
    }

    public void printMinElement(int min){
        System.out.printf("Минимальное значение - %d%n", min);
    }

    public void printSumOfZero(int count){
        System.out.printf("Колтчество элементов равных 0 - %d%n", count);
    }

    public void printSumBiggerThanZero(int count){
        System.out.printf("Колтчество элементов больших 0 - %d%n", count);
    }

    public void askToEnterInt(){
        System.out.println("Введите число:");
    }

    public void printError(){
        System.out.println("Ошибка ввода, повторите попытку.");
    }

    public void printElementsAfterMultiply(int[] before, int [] after){
        System.out.println("До умножения:");
        Arrays.stream(before).forEach(x -> System.out.print(x + " "));
        System.out.println("\nПосле умножения:");
        Arrays.stream(after).forEach(x -> System.out.print(x + " "));
    }
}
