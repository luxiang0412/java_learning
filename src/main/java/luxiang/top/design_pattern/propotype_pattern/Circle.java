package luxiang.top.design_pattern.propotype_pattern;

public class Circle extends Shape {

    public Circle(Long id) {
        type = "circle";
    }

    @Override
    void draw() {
        System.out.println("circle circle circle circle");
    }
}
