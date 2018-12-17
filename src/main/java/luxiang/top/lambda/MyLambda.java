package luxiang.top.lambda;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class MyLambda {
    public static void main(String[] args) {
        Integer arr [] = new Integer []{9,23,4,5,6,71,3,5324,2};
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));

        //map(Function<? super T, ? extends R> var1)
        //R apply(T var1)
        //apply接受一个参数返回一个参数
        Set<Integer> mapToSet = list.stream().map(e -> e + 1).collect(Collectors.toSet());
        System.out.println("map():"+mapToSet);


        //Stream<T> filter(Predicate<? super T> var1);
        //boolean test(T var1);
        //接受一个参数，返回一个boolean
        //配合filter  返回true的元素保留
        Set<Integer> filterToSet = list.stream()
                .filter(e -> e > 100)
                .collect(Collectors.toSet());
        System.out.println(filterToSet);

        //reduce exa1
        //实现一个累加
        //BinaryOperator<T> var1
        //BinaryOperator extend BiFunction
        //参数为两个对象，返回第三对象
        System.out.println(list.stream()
                .reduce((a, b) -> a + b).get());

        //reduce exa2
        //会将1加上累加的结果
        System.out.println(list.stream()
                .reduce(1, (a, b) -> a + b));

        //reduce exa3
        System.out.println(list.stream()
                .reduce(1, (a,b)-> a+b,(a,b) -> a));

        forEach(list,(index,e)->{
            System.out.println("index:"+index+",e:"+e);
        });


    }

    public static void forEach(List<? extends Object> list,BiConsumer<Integer,? super Object> var1) {
        Objects.requireNonNull(var1);
        for (int i =0;i<list.size();i++){
            Object u = list.get(i);
            var1.accept(i, u);
        }
    }
}
