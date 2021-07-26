package JavaGame;

import java.util.List;

public class View {
    public void printStartMessage(){
        System.out.printf("Загадано число от %d до %d.\nПопробуйте угадать его.%n", GlobalConstants.MIN_BOUND,
                GlobalConstants.MAX_BOUND);
    }

    public void printOnNumberIsBigger(int number){
        System.out.printf("число %d больше искомого.%n", number);
    }

    public void printBounds(int min, int max){
        System.out.printf("Введите число от %d до %d%n", min, max);
    }

    public void printOnNumberIsLess(int number){
        System.out.printf("число %d меньше искомого.%n", number);
    }

    public void printOnNumberIsFound(int number){
        System.out.printf("число %d совпадает с искомым.%n", number);
    }

    public void printUserStats(List<Integer> stats){
        System.out.println("Статистика ввода пользователя:");
        for (int i : stats){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void printErrorMessage(){
        System.out.println("Ошибка ввода\nПовторите попытку.");
    }
}
