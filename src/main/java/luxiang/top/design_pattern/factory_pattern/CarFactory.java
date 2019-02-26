package luxiang.top.design_pattern.factory_pattern;

public class CarFactory {
    public Car getCar(String carName) {
        if ("大众".equals(carName)) {
            return new DaZhong();
        } else if ("奔驰".equals(carName)) {
            return new BenChi();
        } else {
            return null;
        }
    }
}
