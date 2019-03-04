package luxiang.top.design_pattern.bridge_pattern;

public class Circle extends Shape {

    private int r, x, y;

    public Circle(int r, int x, int y, DrawApi drawApi) {
        super(drawApi);
        this.r = r;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawApi.drawCircle(r, x, y);
    }
}
