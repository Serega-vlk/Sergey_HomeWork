package Test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class TestArithmetics {
    private static Arithmetics arithmetics;

    @Rule
    public final Timeout timeout = new Timeout(1000);

    @BeforeClass
    public static void initTest(){
        arithmetics = new Arithmetics();
    }

    @Test
    public void testAdd(){
        double res = arithmetics.add(3, 7);
        Assert.assertEquals(10, res, 0.0);
    }

    @Test
    public void testDeduct(){
        double res = arithmetics.deduct(5, 2);
        Assert.assertEquals(3, res, 0.0);
    }

    @Test
    public void testDiv(){
        double res = arithmetics.div(10, 5);
        Assert.assertEquals(2, res, 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivException(){
        arithmetics.div(10.0, 0.0);
    }

    @Test
    public void testMult(){
        double res = arithmetics.mult(5, 5);
        Assert.assertEquals(25, res, 0.0);
    }

    @Test
    public void someTest(){
        while (true){

        }
    }
}
