package luxiang.top.design_pattern.bridge_pattern;

public class GreenCircle implements DrawApi {
    @Override
    public void drawCircle(int r, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + r + ", x: " + x + ", " + y + "]");
    }
}
