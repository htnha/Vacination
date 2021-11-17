import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Program {
    public static void main(String[]args) throws IOException {
        while(true){
            System.out.println("1. Đăng ký tiêm vacine");
            System.out.println("2. Tìm kiếm");
            System.out.println("3. Cập nhật mũi tiêm");
            System.out.println("4. Xoá người tiêm");
            System.out.println("0. Thoát");
            int option;
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine
            String optionLine = reader.readLine();
            option = Integer.parseInt(optionLine);
            switch (option){
                case 1:
                    System.out.println("Bạn đã chọn đăng ký tiêm");
                    vaccineRegister();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    try {
                        updateVaccine();
                    } catch (PersonNotFoundException e) {
                        System.out.println("Khong tim thay id");
                    }
                    break;
                case 4:
                    deletePerson();
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void deletePerson() {

    }

    private static void updateVaccine() throws PersonNotFoundException{
        ///Search person
        //not found person id
        throw new PersonNotFoundException("Khong tim thay nguoi co id nhu vay");

        //Person id exists

    }

    public static void vaccineRegister() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Họ và tên");
        String name = reader.readLine();
        System.out.println("Ngày sinh:");
        String birthday = reader.readLine();
        System.out.println("Địa chỉ:");
        String address = reader.readLine();
        Person person = new Person(0,name,birthday,"","","",address);
        SqliteConnect.insertPerson(person);
    }
    public static void search() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Nhap thong tin can tim kiem:");
        String searchItem = reader.readLine();
        ArrayList<Person> personList = SqliteConnect.search(searchItem);
        System.out.println("Ket qua co " + personList.size() + " nguoi");
        for (Person person: personList
             ) {
            System.out.println(person);
        }
    }
}
