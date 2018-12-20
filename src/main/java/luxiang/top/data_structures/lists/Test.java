package luxiang.top.data_structures.lists;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
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
    }
}
