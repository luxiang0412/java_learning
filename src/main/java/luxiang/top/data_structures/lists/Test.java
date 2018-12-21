package luxiang.top.data_structures.lists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.removeIf((e)->{
           return e==1;
        });
        //System.out.println(list);
        //[2, 3, 4]

        /*ArrayList<Integer> arr = new ArrayList<>();
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
        System.out.println("stream用时（毫秒）："+(time2-time1)+"，list：");*/

        //深度copy
        ArrayList<ArrayList> parent = new ArrayList<ArrayList>();
        ArrayList<Integer> child1 = new ArrayList<Integer>();
        child1.add(1);
        child1.add(2);
        child1.add(3);
        ArrayList<Integer> child2 = new ArrayList<Integer>();
        child2.add(4);
        child2.add(5);
        child2.add(6);
        ArrayList<Integer> child3 = new ArrayList<Integer>();
        child3.add(7);
        child3.add(8);
        child3.add(9);
        parent.add(child1);
        parent.add(child2);
        parent.add(child3);
        //深拷贝
        List<ArrayList> arrayLists = DeepcopyList.deepCopy(parent);
        //浅拷贝
        ArrayList arrayList = (ArrayList) parent.clone();
        //引用复制
        ArrayList arrayList1 = parent;
        System.out.println(parent);
        parent.get(1).remove(1);
        parent.remove(0);
        System.out.println(arrayLists);
        System.out.println(arrayList);
        System.out.println(arrayList1);
    }
}
