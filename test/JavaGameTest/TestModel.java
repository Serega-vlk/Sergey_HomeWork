package JavaGameTest;

import JavaGame.Model;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class TestModel {
    private static Model model;
    
    private static Field number;
    private static Field minBound;
    private static Field maxBound;
    private static Field userEnters;

    @BeforeClass
    public static void initTest() throws NoSuchFieldException {
        model = new Model();
        
        number = Model.class.getDeclaredField("number");
        maxBound = Model.class.getDeclaredField("maxBound");
        minBound = Model.class.getDeclaredField("minBound");
        userEnters = Model.class.getDeclaredField("userEnters");
        
        number.setAccessible(true);
        maxBound.setAccessible(true);
        minBound.setAccessible(true);
        userEnters.setAccessible(true);
    }

    @Test
    public void testGenerateRandInt() throws IllegalAccessException {
        model.generateRandInt();
        int number = TestModel.number.getInt(model);
        int minBound = TestModel.minBound.getInt(model);
        int maxBound = TestModel.maxBound.getInt(model);
        Assert.assertEquals(minBound, 0);
        Assert.assertEquals(maxBound, 100);
        Assert.assertTrue(number >= 0 && number <= 100);
    }

    @Test
    public void testAddUserNumber() throws IllegalAccessException {
        userEnters.set(model, new ArrayList<>());
        ArrayList<Integer> ints = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int rand = (int) Math.round(Math.random() * 100);
            ints.add(rand);
            model.addUserNumber(rand);
        }
        ArrayList<Integer> origin = (ArrayList<Integer>) userEnters.get(model);
        for (int i = 0 ; i < origin.size(); i++){
            Assert.assertEquals(origin.get(i), ints.get(i));
        }
    }

    @Test
    public void testIsNumberFound() throws IllegalAccessException {
        int number = 67;
        TestModel.number.set(model, number);
        ArrayList<Integer> list = (ArrayList<Integer>) userEnters.get(model);
        list.add(number);
        Assert.assertTrue(model.isNumberFound());
    }

    @Test
    public void testIsBiggerThanNumber() throws IllegalAccessException {
        int number = 67;
        TestModel.number.set(model, number);
        ArrayList<Integer> list = (ArrayList<Integer>) userEnters.get(model);
        list.add(number + 20);
        Assert.assertTrue(model.isBiggerThanNumber());
    }

    @Test
    public void testGetMinBound() throws IllegalAccessException {
        minBound.set(model, 13);
        Assert.assertEquals(model.getMinBound(), 13);
    }

    @Test
    public void testGetMaxBound() throws IllegalAccessException {
        maxBound.set(model, 87);
        Assert.assertEquals(model.getMaxBound(), 87);
    }

    @Test
    public void testGetUserEnters() throws IllegalAccessException {
        ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(3, 61, 8, 67, 45, 89));
        userEnters.set(model, new ArrayList<>(ints));
        Assert.assertEquals(ints, model.getUserEnters());
    }

    @Test
    public void testSetMinBound() throws IllegalAccessException {
        number.set(model, 67);
        TestModel.minBound.set(model, 24);
        model.setMinBound(31);
        Assert.assertEquals(TestModel.minBound.get(model), 31);
        number.set(model, 87);
        TestModel.minBound.set(model, 32);
        model.setMinBound(16);
        Assert.assertEquals(TestModel.minBound.get(model), 32);
        number.set(model, 63);
        TestModel.minBound.set(model, 45);
        model.setMinBound(87);
        Assert.assertEquals(TestModel.minBound.get(model), 45);
    }

    @Test
    public void testSetMaxBound() throws IllegalAccessException {
        number.set(model, 37);
        TestModel.maxBound.set(model, 64);
        model.setMaxBound(41);
        Assert.assertEquals(TestModel.maxBound.get(model), 41);
        number.set(model, 56);
        TestModel.maxBound.set(model, 74);
        model.setMaxBound(81);
        Assert.assertEquals(TestModel.maxBound.get(model), 74);
        number.set(model, 63);
        TestModel.maxBound.set(model, 81);
        model.setMaxBound(43);
        Assert.assertEquals(TestModel.maxBound.get(model), 81);
    }
}