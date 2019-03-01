package luxiang.top.design_pattern.builder_pattern;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public Double price() {
        return items.stream().mapToDouble(e -> e.getPrice()).sum();
    }

    public void showItem() {
        items.forEach(e -> {
            System.out.println(e.name());
        });
    }
}
