import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(transfer(sort2(list)));
        String s = "http://onestop.jxufe.edu.cn/eos/FileDown.jsp?path=ff80808166c8ea6401672f094e510189.png";
        String substring = s.substring(s.lastIndexOf(".") + 1);
        System.out.println(substring);
        List<String> strings = Arrays.asList("aa");
        Optional<String> reduce = strings.stream().reduce((a, b) -> a + "," + b);
        String s1 = reduce.orElse("error");
        System.out.println(s1);
    }

    //方法一
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        return Arrays.asList(list.toArray((T[]) new Comparable[list.size()]));
    }

    //方法二
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> T[] sort2(List<T> list) {
        return list.toArray((T[]) new Comparable[list.size()]);
    }

    public static <T> List<T> transfer(T... t) {
        Object[] objects = Objects.requireNonNull(t);
        return Stream.of(t).map(e -> (T) e).collect(Collectors.toList());
    }
}
