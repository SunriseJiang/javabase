package test.copy;

import java.io.IOException;
import java.io.Serializable;

public class HighStudent extends Student implements Cloneable, Serializable {

    private String degree;

    public static int rank = 10;

    public HighStudent(String name, int age) {
        super(name, age);
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public HighStudent clone() {
        HighStudent clone = null;
        try {
            clone = (HighStudent) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        clone.setDegree(degree);
        return clone;
    }

    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException {

        out.defaultWriteObject();
        out.write(rank);
        System.out.println("writeObject");
    }
    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        rank = in.read();
        System.out.println("readObject");

    }

    @Override
    public String toString() {
        return "HighStudent{" +
                "degree='" + degree + '\'' +
                "} " + super.toString();
    }
}
