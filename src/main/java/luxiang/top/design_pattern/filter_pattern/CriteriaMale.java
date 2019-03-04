package luxiang.top.design_pattern.filter_pattern;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        return persons
                .stream()
                .filter(e -> e.getGender().equalsIgnoreCase("MALE"))
                .collect(Collectors.toList());
    }
}
