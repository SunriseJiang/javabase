package test.copy;

import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CloneTest {

    @Test
    public void testArray() {

        // test Array copy

        Student a = new Student("123", 2);
        Account aC = new Account("797897", BigDecimal.valueOf(12.7));
        a.setAccount(aC);
        Student b = new Student("456", 3);
        Account bC = new Account("423432", BigDecimal.valueOf(2.7));
        b.setAccount(bC);

        List<Student> students = new ArrayList<>();
        students.add(a);
        students.add(b);

        Student[] s = students.toArray(new Student[]{});
        Student[] clone = s.clone();

        System.out.println(s);
        for (Student t : s) {
            System.out.println(t);
        }

        b.setAge(10);

        System.out.println(clone);
        for (Student t : clone) {
            System.out.println(t);
        }
    }

    @Test
    public void testInherit() throws IOException {
        HighStudent highStudent = new HighStudent("123", 2);
        highStudent.setDegree("doctor");
        Account aC = new Account("797897", BigDecimal.valueOf(12.7));

        highStudent.setAccount(aC);

        HighStudent.rank = 12;

        System.out.println(highStudent);


        FileOutputStream fileOutputStream = new FileOutputStream("/tmp/1");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(highStudent);

        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();
//
//        HighStudent clone = highStudent.clone();
//        aC.setNumber("53254354235");
//
//        System.out.println(highStudent);
//
//
//        System.out.println(clone);
    }

    @Test
    public void read() {
        try (FileInputStream fileInputStream = new FileInputStream("/tmp/1");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        )
        {
            HighStudent highStudent = (HighStudent) objectInputStream.readObject();

            System.out.println(highStudent);
            System.out.println(HighStudent.rank);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
