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
- Stream<E> parallelStream()//多管道和stream单管道都是获取流，效率更高，但是无法保证元素的顺序