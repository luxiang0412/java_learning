package luxiang.top.data_structures.sort;

import java.util.Arrays;
import java.util.List;

/**
 * 1.冒泡排序 BubbleSort.java
 * 2.选择排序 SelectionSort.java
 * 3.直接插入排序 InsertionSort.java
 * 4.快速排序 QuickSort.java
 * 5.归并排序 MergeSort.java
 * 6.堆排序 HeapSort.java
 * 7.希尔排序 ShellSort.java
 * 8.基数排序 Radix.java
 * 9.二叉数排序 BinatryTreeSort.java
 * 10.计数排序 CountingSort.java
 * 11.bogo-sort BogoSort.java
 * 12.鸡尾酒排序（定向冒泡排序） CocktailShakerSort.java
 * 13.梳排序 CombSort.java
 * 14.圈排序 CycleSort.java
 * 15.侏儒排序（愚人排序） GnomeSort.java
 * 16.煎饼排序 PancakeSort.java
 */
public interface Sort {

    /**
     * @param unsortd 未排序的数组
     * @param <T>     实现可排序的接口Comparable
     * @return 排好序的数组
     */
    <T extends Comparable<T>> T[] sort(T[] unsortd);

    /**
     * 将list列表排序
     *
     * @param unsorted 未排序的列表
     * @param <T>      列表中的元素类型
     * @return 排好序的列表
     */
    @SuppressWarnings("unchecked")
    default <T extends Comparable<T>> List<T> sort(List<T> unsorted) {
        return Arrays.asList(sort(unsorted.toArray((T[]) new Comparable[unsorted.size()])));
    }

    /**
     * 比较 a 和 b 的大小
     */
    default <T extends Comparable<T>> boolean less(T a, T b) {
        return a.compareTo(b) > 0;
    }
}
