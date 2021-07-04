package JavaGameTest;

import JavaGame.View;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class TestView {
    private ByteArrayOutputStream output;
    private static View view;

    @BeforeClass
    public static void init(){
        view = new View();
    }

    @Before
    public void resetOutput(){
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testPrintStartMessage() {
        view.printStartMessage();
        Assert.assertEquals(String.format("Загадано число от %d до %d.\nПопробуйте угадать его.%n", 0,
                100), output.toString());
    }

    @Test
    public void testPrintOnNumberIsBigger(){
        view.printOnNumberIsBigger(8);
        Assert.assertEquals(String.format("число %d больше искомого.%n", 8), output.toString());
    }

    @Test
    public void testPrintBounds(){
        view.printBounds(3, 78);
        Assert.assertEquals(String.format("Введите число от %d до %d%n", 3, 78), output.toString());
    }

    @Test
    public void testPrintOnNumberIsLess(){
        view.printOnNumberIsLess(87);
        Assert.assertEquals(String.format("число %d меньше искомого.%n", 87), output.toString());
    }

    @Test
    public void testPrintOnNumberIsFound(){
        view.printOnNumberIsFound(58);
        Assert.assertEquals(String.format("число %d совпадает с искомым.%n", 58), output.toString());
    }

    @Test
    public void testPrintUserStats(){
        List<Integer> list = Arrays.asList(4, 67, 45, 69, 57);
        view.printUserStats(list);
        Assert.assertEquals(String.format("Статистика ввода пользователя:%n" +
                "4 67 45 69 57 %n"), output.toString());
    }

    @Test
    public void testPrintErrorMessage(){
        view.printErrorMessage();
        Assert.assertEquals(String.format("Ошибка ввода\nПовторите попытку.%n"), output.toString());
    }
}
