public class Doctor extends Person {
    private String specialty;
    private int id;




    public Doctor(String name, int age, boolean gender, int contact_no, String address, int id, String specialty) {
        super(name, age, gender, contact_no, address);
        this.id = id;
        this.specialty = specialty;
    }



}