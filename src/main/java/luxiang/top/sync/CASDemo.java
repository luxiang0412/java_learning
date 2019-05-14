package luxiang.top.sync;

public class CASDemo {
    private static Integer count1 = 0;

    private static Integer count2 = 0;

    private static Integer count3 = 0;

    private static Integer count4 = 0;

    static void add1(int add) throws InterruptedException {
        while (count1 < 2000) {
            Thread.sleep(20);
            count1 = count1 + add;
        }
    }

    synchronized static void add2(int add) throws InterruptedException {
        while (count2 < 2000) {
            Thread.sleep(20);
            count2 = count2 + add;
        }
    }

    static void add3(int add) throws InterruptedException {
        while (count3 < 2000) {
            Thread.sleep(20);
            count3 = count3 + add;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        add1(20);
        new Thread(()->{
            try {
                add2(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                add2(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                add3(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                add3(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(4000);
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
        System.out.println(count4);
    }
}
