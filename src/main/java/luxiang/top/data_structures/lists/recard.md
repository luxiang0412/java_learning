# java 集合
---
## Iterable（接口）
- default void forEach()
- iterator();//迭代
- default Spliterator<T> spliterator()//Spliterator（splitable iterator可分割迭代器）接口是Java为了并行遍历数据源中的元素而设计的迭代器

## Collection（接口）
- removeIf()//移除满足条件的元素
```
ArrayList<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);
list.add(4);
list.removeIf((e)->{
   return e==1;
});
System.out.println(list);
//[2, 3, 4]
```
- Spliterator<E> spliterator()//获取并行迭代器
- Stream<E> stream()//return StreamSupport.stream(this.spliterator(), false);
- Stream<E> parallelStream()//多管道和stream单管道都是获取流，效率更高，但是无法保证元素的顺序（使用不当导致线程安全的问题）
```
ArrayList<Integer> arr = new ArrayList<>();
for (int i = 0;i<30;i++){
    arr.add(i);
}
long time1 = System.currentTimeMillis();
arr.stream().forEach(e-> {
    try {
        TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e1) {
        e1.printStackTrace();
    }
    System.out.print(e+" ");
});
//List<Integer> collect = arr.stream().filter(e -> e % 2 == 1).collect(Collectors.toList());
System.out.println();
long time2 = System.currentTimeMillis();
//List<Integer> collect2 = arr.parallelStream().filter(e -> e % 2 == 1).collect(Collectors.toList());
arr.parallelStream().forEach(e-> {
    try {
        TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e1) {
        e1.printStackTrace();
    }
    System.out.print(e+" ");
});
long time3 = System.currentTimeMillis();
System.out.println();
System.out.println("parallelStream用时（毫秒）："+(time3-time2)+"，list：");
System.out.println("stream用时（毫秒）："+(time2-time1)+"，list：");

//输出
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 
18 9 13 3 19 14 10 4 20 11 7 5 21 12 8 6 16 26 24 1 17 27 25 2 15 0 28 22 29 23 
parallelStream用时（毫秒）：8042，list：
stream用时（毫秒）：30020，list：
```