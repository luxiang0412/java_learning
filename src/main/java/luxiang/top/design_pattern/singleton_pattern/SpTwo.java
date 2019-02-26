package luxiang.top.design_pattern.singleton_pattern;

import java.util.concurrent.CountDownLatch;

/**
 * 懒汉模式  线程安全
 */
public class SpTwo {

    private static CountDownLatch latch = new CountDownLatch(1000);

    private static SpTwo spTwo = null;

    private SpTwo() {
        System.out.println(this.hashCode());
    }

    public static synchronized SpTwo getSpTwoInstance() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (spTwo == null) {
            spTwo = new SpTwo();
        }
        return spTwo;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(SpTwo::getSpTwoInstance);
            thread.start();
            latch.countDown();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }
}
