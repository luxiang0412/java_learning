package luxiang.top.design_pattern.filter_pattern;

import java.util.List;
import java.util.stream.Collectors;

public class OrCriteria implements Criteria {

    private Criteria criteria;

    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {

        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);

        List<Person> otherCriteriaItems = otherCriteria.meetCriteria(persons);


        otherCriteriaItems.addAll(firstCriteriaPersons.stream()
                .filter(e -> !otherCriteriaItems.contains(e))
                .collect(Collectors.toList()));
        return otherCriteriaItems;
    }
}
