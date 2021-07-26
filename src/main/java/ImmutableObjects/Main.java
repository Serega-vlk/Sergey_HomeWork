package ImmutableObjects;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Faculty f1 = new Faculty("FIT", 1200);
        Student s1 = new Student("Sergey", "IPZ", 20, f1);
        // должно быть 1200
        System.out.println(s1.getFaculty().getStudentsCount());
        f1.incrementStudentsCount();
        /*
        По скольку в конструкторе класса Student оьъект класса Faculty был клонирован,
        то и ссылка f1 уже не являеться ссылкой на поле объекта s1. А значит вывод должен быть
        по прежнему 1200
         */
        System.out.println(s1.getFaculty().getStudentsCount());
        s1.getFaculty().incrementStudentsCount();
        /*
        Точно также как и в конструкторе класса Student так и в геттере к полю faculty объект
        класса Faculty был клонирован. А значит вывод по прежнемк должен быть 1200
         */
        System.out.println(s1.getFaculty().getStudentsCount());
        Field f = Student.class.getDeclaredField("faculty");
        f.setAccessible(true);
        f.set(s1, f1);
        /*
        Но поскольку в Java существует механизм рефлекции то ничего нельзя сделать безопасным так как вы того хотите.
        По-этому мы просто берём и в наглую устанавливаем в поле объекта s1 ссылку на объект f1. А по скольку мы
        уже изменили значения его поля (строка 11) то и вывод будет 1201 :D
         */
        System.out.println(s1.getFaculty().getStudentsCount());
        // Проверяем работу метода equals
        Faculty f2 = new Faculty("FIT", 1200);
        Student s2 = new Student("Sergey", "IPZ", 20, f2);
        // будет false потому что поле studentsCount объекта поля faculty объекта s1 равно 1201 (мы его увеличили)
        System.out.println(s1.equals(s2));
        Faculty f3 = new Faculty("FIT", 1201);
        Student s3 = new Student("Sergey", "IPZ", 20, f3);
        // вот теперь точно будет true
        System.out.println(s1.equals(s3));
    }
}
