package luxiang.top.design_pattern.factory_pattern;

public class CarFactoryTest {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car car = carFactory.getCar("大众");
        System.out.println(car.getBrandName());//大众
    }
}
