public class StudentInfo {

    private Long id;
    private String name;
    private String studentId;

    public StudentInfo(){
        System.out.println("create outer class");
    }

    private StudentInfo(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setStudentId(builder.studentId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String studentId;

        public Builder() {
            System.out.println("create inner class");
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder studentId(String val) {
            studentId = val;
            return this;
        }

        public StudentInfo build() {
            return new StudentInfo(this);
        }
    }
}
