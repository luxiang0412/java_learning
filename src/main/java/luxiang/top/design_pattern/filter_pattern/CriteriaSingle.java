package luxiang.top.design_pattern.filter_pattern;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaSingle implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        return persons
                .stream()
                .filter(e -> e.getMaritalStatus().equalsIgnoreCase("SINGLE"))
                .collect(Collectors.toList());
    }
}
