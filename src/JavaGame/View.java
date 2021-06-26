package JavaGame;

import java.util.List;

public class View {
    public void printStartMessage(){
        System.out.println("Загадано число от 0 до 100.\nПопробуйте угадать его.");
    }

    public void printOnNumberIsBigger(int number){
        System.out.println(String.format("число %d больше искомого.", number));
    }

    public void printBounds(int min, int max){
        System.out.println(String.format("Введите число от %d до %d", min, max));
    }

    public void printOnNumberIsLess(int number){
        System.out.println(String.format("число %d меньше искомого.", number));
    }

    public void printOnNumberIsFound(int number){
        System.out.println(String.format("число %d совпадает с искомым.", number));
    }

    public void printUserStats(List<Integer> stats){
        System.out.println("Статистика ввода пользователя:");
        for (int i : stats){
            System.out.print(i + " ");
        }
    }

    public void printErrorMessage(){
        System.out.println("Ошибка ввода\nПовторите попытку.");
    }
}
