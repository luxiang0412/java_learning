package luxiang.top.design_pattern.singleton_pattern;

import java.util.concurrent.CountDownLatch;

public class SpFive {

    private static CountDownLatch latch = new CountDownLatch(1000);

    private static class SpFiveInner {
        private static SpFive spFive = new SpFive();
    }

    private SpFive() {
        System.out.println(this.hashCode());
    }

    public static SpFive getSpFiveInstance() {
        return SpFiveInner.spFive;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(SpFive::getSpFiveInstance);
            thread.start();
            latch.countDown();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }
}
