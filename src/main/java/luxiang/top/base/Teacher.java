package luxiang.top.base;

import java.io.Serializable;

public class Teacher implements Serializable, Cloneable {

    Integer id;
    String name;

    public Teacher(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
