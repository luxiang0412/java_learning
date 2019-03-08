package luxiang.top.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static Integer integer = 0;

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
        //流的连接
        System.out.println("concat:" + Stream.concat(list.stream(), list.stream()).map(User::getId).collect(Collectors.toList()));

        Optional<Integer> stream = list.stream().filter(element -> {
            System.out.println("filter() was called!");
            return element.getId() > 2;
        }).map(element -> {
            System.out.println("map() was called!");
            return element.getId() + 2;
        }).findFirst();

        System.out.println(Stream.of(1, 2, 3).map(e -> e + 2).reduce((x, y) -> x + y).get());

        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        /*list1.add(1);
        list1.add(2);
        list1.add(3);*/
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        System.out.println("reduce");
        System.out.println(lists.stream().filter(e -> e != null).reduce(new ArrayList<Integer>(), (x, y) -> {
            x.addAll(y);
            return x;
        }));

        System.out.println(lists.stream().filter(e -> null != e).reduce((x, y) -> {
            x.addAll(y);
            return x;
        }).get());

        System.out.println(lists.stream().filter(e -> e != null));

        System.out.println(new StreamTest().getSelf());
        //flatMap 每次返回一个流
        System.out.println(Stream.of("3,4,5", "2,3,4", "1,2,3").map(e -> e.split(",")).flatMap(e -> Arrays.stream(e)).collect(Collectors.toList()));

        System.out.println(Stream.of("3,4,5", "2,3,4", "1,2,3").map(e -> e.split(",")).flatMap(e -> Arrays.stream(e)).distinct().collect(Collectors.toList()));

        System.out.println(Stream.of("3,4,5", "2,3,4", "1,2,3").map(e -> e.split(",")).flatMap(e -> Arrays.stream(e)).distinct().sorted().collect(Collectors.toList()));

        System.out.println(Stream.of("3,4,5", "2,3,4", "1,2,3").map(e -> e.split(",")).flatMap(e -> Arrays.stream(e)).sorted().distinct().collect(Collectors.toList()));

        System.out.println(list.stream().map(User::getId).collect(Collectors.toList()));

        //类似懒加载  如果没有后续的操作  peek将被忽略
        //list.stream().peek(e->e.setId(e.getId()+10)).collect(Collectors.toList());

        System.out.println(list.stream().map(User::getId).collect(Collectors.toList()));
        //排序
        System.out.println(list.stream().sorted(Comparator.comparing(User::getId)).map(User::getId).collect(Collectors.toList()));
        //指定次数
        Stream.of("3,4,5", "2,3,4", "1,2,3").limit(2).forEach(e -> System.out.println(e));
        //与limit相反
        Stream.of("3,4,5", "2,3,4", "1,2,3").skip(2).forEach(e -> System.out.println(e));
        //并行读取
        "hello world".chars().parallel().forEach(e -> System.out.print((char) e));
        //保证顺序
        "hello world".chars().parallel().forEachOrdered(e -> System.out.print((char) e));

        System.out.println();
        //保证顺序
        list.parallelStream().forEachOrdered(user -> System.out.println(user.getId()));

        list.stream().parallel().forEachOrdered(user -> System.out.println(user.getId()));


        Object[] o = Stream.of("3,4,5", "2,3,4", "1,2,3").map(s -> s.split(",")).flatMap(Arrays::stream).toArray();
        for (Object o1 : o) {
            System.out.println(o1);
        }
        System.out.println(Stream.of(1, 23, 4, 25).toArray());
        System.out.println("=================toArray()");
        Integer[] integers = Stream.of(1, 23, 4, 25).toArray(Integer[]::new);
        for (Integer integer1 : integers) {
            System.out.println(integer1);
        }

        System.out.println(list.stream().map(User::getId).reduce((x, y) -> x + y));
        System.out.println(list.stream().map(User::getId).reduce(1, (x, y) -> x + y));
        System.out.println(list.stream().map(User::getId).reduce(2, (x, y) -> x + y));
    }

    public StreamTest getSelf(StreamTest this) {
        System.out.println(integer);
        return this;
    }
}
