package Collections;

import java.util.List;

public class View {
    public void askToEnterInt(){
        System.out.println("Введите число или любой другой символ для завершения ввода:");
    }

    public void printError(){
        System.out.println("Произожла неизвестная ошибка,\nповторите ввод.");
    }

    public void printResult(List<String> list){
        System.out.println("Количество всех введённых елементов:");
        for (String element : list){
            System.out.println(element);
        }
    }
}
