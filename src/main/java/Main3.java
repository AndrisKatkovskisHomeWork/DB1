import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main3 {

    public static void main(String[] args) {

        Session s1 = Main.getSF().openSession();
        Transaction t1 = s1.beginTransaction();

        Employees e1 = getEmployee();
        EmploeesDetales ed1 = createEmploeesDetales();

        e1.setEmpDetales(ed1);
        ed1.setEmp(e1);

        s1.persist(e1);
        s1.persist(ed1);

        t1.commit();
        s1.close();
    }

    public static Employees getEmployee() {
        Employees e1 = new Employees();
        e1.setFirstName("Fred");
        e1.setLastName("Erro");
        e1.setEmpNo(44);
        e1.setHireDate("2018-05-07");
        e1.setBirthDate("2001-02-08");
        e1.setGender('M');
        return e1;
    }

    public static EmploeesDetales createEmploeesDetales() {
        EmploeesDetales emploeesDetales = new EmploeesDetales();
        emploeesDetales.seteMail("axy@qwr.com");
        emploeesDetales.setPassportId("axz");
        return emploeesDetales;
    }
}