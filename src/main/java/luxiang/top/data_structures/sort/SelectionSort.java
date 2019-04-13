package luxiang.top.data_structures.sort;

/**
 * 选择排序
 */
public class SelectionSort implements Sort {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsortd) {

        int mix;
        for (int i = 0; i < unsortd.length; i++) {
            mix = i;
            for (int j = i; j < unsortd.length; j++) {
                if (less(unsortd[mix], unsortd[j])) {
                    mix = j;
                }
            }
            if (mix != i) {
                SortUtils.swap(unsortd, i, mix);
            }
        }
        return unsortd;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4, 1, 5, 2, 8, 6, 7, 3, 4, 5, 6, 8, 1};
        SelectionSort sort = new SelectionSort();
        System.out.println(SortUtils.print(sort.sort(arr)));
    }
}
