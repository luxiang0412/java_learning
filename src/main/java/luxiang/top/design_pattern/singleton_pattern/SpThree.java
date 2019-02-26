package luxiang.top.design_pattern.singleton_pattern;

import java.util.concurrent.CountDownLatch;

/**
 * 饿汉模式 线程安全
 */
public class SpThree {

    private static CountDownLatch latch = new CountDownLatch(1000);

    private static SpThree spThree = new SpThree();

    private SpThree() {
        System.out.println(this.hashCode());
    }

    public static SpThree getSpThreeInstance() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return spThree;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(SpThree::getSpThreeInstance);
            thread.start();
            latch.countDown();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }
}
