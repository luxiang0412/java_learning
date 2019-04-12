package luxiang.top.data_structures.sort;

import java.util.Arrays;
import java.util.List;

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
}
