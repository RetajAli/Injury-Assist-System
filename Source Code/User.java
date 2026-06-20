
class User extends Person {
    private String username;
    private String password;


    public User(String name, int age, boolean gender, int contact_no, String address, Person patient) {
        super(name, age, gender, contact_no, address);

    }

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }



    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return username + "," + password;
    }
}