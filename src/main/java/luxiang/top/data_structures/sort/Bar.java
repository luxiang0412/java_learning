package luxiang.top.data_structures.sort;

public class Bar implements Comparable<Bar> {

    private int id;

    public Bar() {
    }

    public Bar(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "id=" + id +
                '}';
    }

    @Override
    public int compareTo(Bar bar) {
        return Integer.compare(this.id, bar.getId());
    }
}
