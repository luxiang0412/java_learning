import luxiang.top.data_structures.sort.Bar;
import luxiang.top.data_structures.sort.BubbleSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BubbleSortTest {

    @Test
    public void test() {
        BubbleSort sort = new BubbleSort();
        Integer[] unsorted = new Integer[]{2, 23, 1, 4, 5, 8, 3};
        Integer[] sorted = sort.sort(unsorted);
        List<Bar> barList = new ArrayList<>();
        barList.add(new Bar(1));
        barList.add(new Bar(2));
        List<Bar> test = sort.sort(barList);
        for (Bar bar : test) {
            System.out.println(bar.getId());
        }
    }
}
