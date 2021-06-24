package BasicJava;

public class View {
    public void helloMessage(){
        System.out.println("Здраствуйте, введите в консоль слово 'hello'\nа потом 'world'.");
    }

    public void printResult(String result){
        System.out.println(result);
    }

    public void askToEnter(String text){
        System.out.println(String.format("Введите %s:", text));
    }

    public void askToEnterAgain(){
        System.out.println("Вы ввели не то слово.\nПовторите ввод!");
    }
}
