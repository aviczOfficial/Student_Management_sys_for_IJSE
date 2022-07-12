package model;

public class Teacher {
    private String teacherId;
    private String Name;
    private String nic;
    private String contact;
    private String address;

    public Teacher() {
    }


    public Teacher(String teacherId, String name, String nic, String contact, String address) {
        this.setTeacherId(teacherId);
        setName(name);
        this.setNic(nic);
        this.setContact(contact);
        this.setAddress(address);
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", Name='" + Name + '\'' +
                ", nic='" + nic + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
