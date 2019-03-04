package luxiang.top.design_pattern.propotype_pattern;

public class Test {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape shape = ShapeCache.getShape(1L);
        shape.draw();
        Shape shape1 = ShapeCache.getShape(2L);
        shape1.draw();
    }
}
