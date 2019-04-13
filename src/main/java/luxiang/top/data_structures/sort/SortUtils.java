package luxiang.top.data_structures.sort;

import java.util.Arrays;
import java.util.List;

public class SortUtils {

    /**
     * 交换数组的两个元素的值
     *
     * @param arr 数据
     * @param a   索引a
     * @param b   索引b
     * @param <T> 元素类型
     * @return true
     */
    static <T extends Comparable<T>> boolean swap(T[] arr, int a, int b) {
        T t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
        return true;
    }

    /**
     * 打印
     *
     * @param arr 数组
     */
    static <T extends Comparable<T>> String print(T[] arr) {
        return Arrays.toString(arr);
    }

    /**
     * 打印
     */
    static <T extends Comparable<T>> void print(List<T> list) {
        list.stream().map(e -> e.toString() + " ").forEach(System.out::println);
        System.out.println();
    }
}
