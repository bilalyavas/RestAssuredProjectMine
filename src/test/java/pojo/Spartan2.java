package pojo;

public class Spartan2 {

    private int id;
    private String name;
    private String gender;
    private long phone;



    public Spartan2(int id, String gender,String name, long phone ) {
       this.id=id;
        this.gender = gender;
        this.name=name;
        this.phone=phone;

    }

    @Override
    public String toString() {
        return "Spartan2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
