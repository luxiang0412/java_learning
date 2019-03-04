package luxiang.top.design_pattern.propotype_pattern;

import java.util.Hashtable;

public class ShapeCache {

    private static Hashtable<Long, Shape> cache = new Hashtable<>();

    public static Shape getShape(Long id) {
        Shape shape = cache.get(id);
        return (Shape) shape.clone();
    }

    public static void loadCache(){
        cache.put(1L,new Circle(1L));
        cache.put(2L,new Rectangle(2L));
    }
}
