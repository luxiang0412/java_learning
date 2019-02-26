package luxiang.top;

public class Test2 {
    public static void main(String[] args) {
        for (Color e :Color.values()){
            System.out.println(e);
        }
        System.out.println(Color.getName(0));
        System.out.println(Color.BLANK.getName());
        System.out.println(Color.valueOf("BLANK"));
        System.out.println(Color.valueOf("BLANK").ordinal());
        System.out.println(Color.getColorByName("（白色）"));
    }
}
