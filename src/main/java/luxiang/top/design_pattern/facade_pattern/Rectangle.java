package luxiang.top.design_pattern.facade_pattern;

public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}
