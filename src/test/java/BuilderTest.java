import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BuilderTest {

    @Test
    public void build() {
        /*
        1.外部类初次加载，会初始化静态变量、静态代码块、静态方法，但不会加载内部类和静态内部类。
        2.实例化外部类，调用外部类的静态方法、静态变量，则外部类必须先进行加载，但只加载一次。
        3.直接调用静态内部类时，外部类不会加载。
        */
        /*StudentInfo stu = new StudentInfo();
        System.out.println(stu);*/
        System.out.println("======================");
        StudentInfo stu2 = new StudentInfo.Builder()
                .id(1L)
                .name("luxiang")
                .studentId("1111")
                .build();
        System.out.println(stu2);
    }

    @Test
    public void test(){
        List<Long> ids = new ArrayList<>();
        ids.add(2018L);
        ids.add(2016L);
        ids.add(2015L);
        ids.add(2017L);
        List<Long> collect = ids.stream().sorted().skip(1).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test2(){
        System.out.println(expTest());
    }

    public static int expTest(){
        int i =0;
        try {
            System.out.println("try:"+(++i));
            return i;
        }catch (Exception e){
            System.out.println("catch:"+(++i));
            return i;
        }finally {
            System.out.println("finally:"+(++i));
        }
    }

    @Test
    public void test3(){
        Long.valueOf("");
    }
}
