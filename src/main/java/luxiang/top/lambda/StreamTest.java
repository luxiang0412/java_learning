package luxiang.top.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {

        //Stream  的创建1 空
        Stream<Integer> foo1 = Stream.empty();
        //Stream  的创建2 集合
        Collection<Integer> col1 = Arrays.asList(1, 2, 3);
        Stream<Integer> foo2 = col1.stream();
        //Stream  的创建3 of
        Stream<Integer> foo3 = Stream.of(1, 1, 1, 1);
        //Stream  的创建3 Builder 构建
        Stream<Integer> foo4 = Stream.<Integer>builder().add(1).add(1).add(1).add(1).build();
        //一定得指定limit
        Stream<Integer> foo5 = Stream.generate(() -> 2).limit(10);
        foo5.forEach(e -> System.out.print(e + " "));
        System.out.println();
        //一定得指定limit
        Stream<Integer> foo6 = Stream.iterate(2, e -> e + 2).limit(10);
        foo6.forEach(e -> System.out.print(e + " "));
        System.out.println();

        //基元流


        //字符流

        //文件流

        List<User> list = new ArrayList<>();
        list.add(new User(13));
        list.add(new User(3));
        list.add(new User(2));
        list.add(new User(5));
        list.add(new User(12));
        list.add(new User(7));
        list.add(new User(8));
        //allMatch 所有元素是否与提供的谓词匹配。
        System.out.println("allMath:" + list.stream().allMatch(e -> e.getId() > 1));//true
        System.out.println("allMath:" + list.stream().allMatch(e -> e.getId() > 2));//false

        //任何元素是否与提供的谓词匹配
        System.out.println("anyMatch:" + list.stream().anyMatch(e -> e.getId() > 12));
        System.out.println("anyMatch:" + list.stream().anyMatch(e -> e.getId() > 20));

        Stream.Builder<Object> builder = Stream.builder();
        Stream<Object> build = builder.build();


        //排序了。。
        System.out.println("collect:" + list.stream().map(User::getId).collect(Collectors.toSet()));

        System.out.println("concat:" + Stream.concat(list.stream(), list.stream()).map(User::getId).collect(Collectors.toList()));

    }
}
