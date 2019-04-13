package luxiang.top.data_structures.sort;

/**
 * 冒泡排序
 * 1.开始处，每次比对相邻的两个元素
 * 2.如果比对结果左边的大于右边的，则交换元素。
 * 3.每一次都会确定一个最大的元素
 */
public class BubbleSort implements Sort {
    //实现1
    /*@Override
    public <T extends Comparable<T>> T[] sort(T[] unsortd) {
        //每次确定一个最大的元素，需要循环length-1次
        for (int i = 0; i < unsortd.length - 1; i++) {
            //第一次需要遍历length-1次 之后都是length-1-n（n是已经确定的个数）
            for (int j = 0; j < unsortd.length - 1 - i; j++) {
                if (less(unsortd[i], unsortd[i + 1])) {
                    SortUtils.swap(unsortd, j, j + 1);
                }
            }
        }
        return unsortd;
    }*/

    //实现2
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsortd) {
        int last = unsortd.length;
        boolean swap;
        do {
            swap = false;
            //判断是否需要遍历
            for (int i = 0; i < last - 1; i++) {
                if (less(unsortd[i], unsortd[i + 1])) {
                    swap = SortUtils.swap(unsortd, i, i + 1);
                }
            }
            //每次遍历之后last都会-1,因为每次会确定一个最大值
            --last;
        } while (swap);
        return unsortd;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4, 1, 5, 2, 8, 6, 7, 3, 4, 5, 6, 8, 1};
        BubbleSort sort = new BubbleSort();
        System.out.println(SortUtils.print(sort.sort(arr)));
    }
}
