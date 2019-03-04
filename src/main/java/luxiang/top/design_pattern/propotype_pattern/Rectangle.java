package luxiang.top.design_pattern.propotype_pattern;

public class Rectangle extends Shape{

    public Rectangle(Long id){
        type = "rectangle";
    }

    @Override
    void draw() {
        System.out.println("rectangle rectangle rectangle rectangle");
    }
}
