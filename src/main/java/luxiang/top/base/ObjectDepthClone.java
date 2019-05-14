package luxiang.top.base;

import java.io.*;

public class ObjectDepthClone {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Teacher teacher = new Teacher(1, "teacher");
        Student student = new Student(2, "student", teacher);

        System.out.println(student);
        Student clone = (Student) student.clone();
        Student depthClone = (Student) objectClone(student);
        teacher.name = "teacher____2";
        System.out.println(clone);
        System.out.println(depthClone);
    }

    static Object objectClone(Object o) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(o);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return objectInputStream.readObject();
    }
}
