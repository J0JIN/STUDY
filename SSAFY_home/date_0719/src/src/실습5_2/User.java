package src.실습5_2;

public class User {

    // 외부에서 객체 내부의 변수에 직접 접근하지 못하도록 접근 제한자 설정
    private String id;
    private String password;
    private String name;
    private String email;
    private int age;

    public User() {}

    public User(String id, String password, String name, String email, int age) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", age=" + age
                + "]";
    }

}

