import org.junit.Test;

public class Test2 {
    @Test
    public void test(){
        int a = 92241;//10110100001010001
        System.out.println("000000000000000"+Integer.toBinaryString(a));
        a ^= ~(1 << 3);
        System.out.println(Integer.toBinaryString(~(1 << 3)));
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(-8));
    }
}
