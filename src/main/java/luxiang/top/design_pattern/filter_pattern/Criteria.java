package luxiang.top.design_pattern.filter_pattern;

import java.util.List;

public interface Criteria {

    public List<Person> meetCriteria(List<Person> persons);

}
