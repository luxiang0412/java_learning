package luxiang.top.lambda;

public class User {
    private Integer id;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        User user;
        if (o.getClass() == User.class) {
            user = (User) o;
        } else {
            return false;
        }
        return user.getId().equals(this.getId());
    }
}
