package luxiang.top.base;

import java.util.HashSet;
import java.util.Objects;

/**
 * object 的equals比较的是内存地址
 * 如果想重写equals  要重写hashcode
 * java 对equals 有五个要求
 * 1.对称性 a.equals(b) == b.equals(a)
 * 2.反射性 a.equals(b) == true
 * 3.类推性 a.equals(b)为true a.equals(c)也为true 所以b.equals(c) 也为true
 * 4.一致性 a.equals(b) 只要内容相等 就一直相等
 * 5.非空性 a.equals(null) false
 */
public class EqualsTest {
    public static void main(String[] args) {

        EqualsTest.EqualsOne one = new EqualsTest.EqualsOne(1L, "name");
        EqualsTest.EqualsOne two = new EqualsTest.EqualsOne(1L, "name");
        EqualsTest.EqualsTwo three = new EqualsTest.EqualsTwo(1L, "name");
        EqualsTest.EqualsTwo four = new EqualsTest.EqualsTwo(1L, "name");
        System.out.println(one.equals(two));
        System.out.println(three.equals(four));
        HashSet<Object> set = new HashSet<>();
        System.out.println(one.hashCode());
        set.add(one);
        System.out.println(two.hashCode());
        set.add(two);
        System.out.println(three.hashCode());
        set.add(three);
        System.out.println(four.hashCode());
        set.add(four);
        System.out.println(set);
    }

    static class EqualsOne {

        private Long id;
        private String name;

        public EqualsOne(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class EqualsTwo {

        private Long id;
        private String name;

        public EqualsTwo(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EqualsTwo equalsTwo = (EqualsTwo) o;
            return Objects.equals(this.hashCode(), equalsTwo.hashCode());
        }

        @Override
        public int hashCode() {

            return Objects.hash(id, name);
        }
    }
}
