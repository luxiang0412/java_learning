package luxiang.top.design_pattern.singleton_pattern;

import java.util.concurrent.CountDownLatch;

/**
 * 懒汉模式，线程不安全
 */
public class SpOne {

    private static CountDownLatch latch = new CountDownLatch(1000);

    private static SpOne spOne = null;

    private SpOne() {
        System.out.println(this.hashCode());
    }

    public static SpOne getSpOneInstance() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (spOne == null) {
            spOne = new SpOne();
        }
        return spOne;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(SpOne::getSpOneInstance);
            thread.start();
            latch.countDown();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }
}
