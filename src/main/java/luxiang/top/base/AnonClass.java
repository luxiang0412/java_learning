package luxiang.top.base;

public class AnonClass {

    public int a = 1;

    public static void main(String[] args) {
        AnonClass.Inner a = new AnonClass().new Inner();
        AnonClass anonClass = new AnonClass();
        anonClass.innerFun();
    }

    class Inner{

    }

    static class InnerStatic{

    }

    public void innerFun(){
        final int b = 1;
        class InnerFun{
            private void fun(){
                //b的值不允许改变
                System.out.println(b);
                System.out.println(++a);
            }
        }
        InnerFun innerFun = new InnerFun();
        innerFun.fun();
    }
}
