public class Person {
   private  String name;
    private int age;
     private boolean gender;
    private int contact_no;
    private String address;

    public Person(String name, int age, boolean gender, int contact_no, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact_no = contact_no;
        this.address = address;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isGender() {
        return gender;
    }

    public int getContact_no() {
        return contact_no;
    }

    public String getAddress() {
        return address;
    }
}