package luxiang.top.design_pattern.singleton_pattern;

import java.util.concurrent.CountDownLatch;

public class SpFour {

    private static SpFour spFour = null;

    private static CountDownLatch latch = new CountDownLatch(1000);

    private SpFour() {
        System.out.println(this.hashCode());
    }

    public static SpFour getSpFourInstance() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (spFour == null) {
            synchronized (SpFour.class) {
                if (spFour == null) {
                    spFour = new SpFour();
                }
            }
        }
        return spFour;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(SpFour::getSpFourInstance);
            thread.start();
            latch.countDown();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }
}
