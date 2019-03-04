package luxiang.top.design_pattern.bridge_pattern;

public class RedCircle implements DrawApi {
    @Override
    public void drawCircle(int r, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + r + ", x: " + x + ", " + y + "]");
    }
}
