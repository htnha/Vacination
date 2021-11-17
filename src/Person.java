public class Person {
    int id;
    String name;
    String birthday;
    String qrCode;
    String securityNumber;
    String identifierNumber;
    String address;

    public Person(int id, String name, String birthday, String qrCode, String securityNumber, String identifierNumber, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.qrCode = qrCode;
        this.securityNumber = securityNumber;
        this.identifierNumber = identifierNumber;
        this.address = address;
    }
    public String toString(){
        return "Id: " + id + ", Name:" + name + ", Birthday:" + birthday + ", Address:" + address;
    }
}
