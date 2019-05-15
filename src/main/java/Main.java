import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        Employees e1 = new Employees();
        Employees e2 = new Employees();

        e1.setEmpNo(1);
        e2.setEmpNo(1);

        e1.setFirstName("En");
        e2.setFirstName("En");

        e1.setLastName("Las");
        e2.setLastName("Las");

        if (e1 == e2) {
            System.out.println("e1 = e2");
        } else {
            System.out.println("e1 is not = e2");
        }

        if (e1.equals(e2)) {
            System.out.println("2. e1 = e2");
        } else {
            System.out.println("2. e1 not = e2");

        }

//        selectEmployee();
        persistEmployee();
    }

    public static SessionFactory getSF() {
        // Create registry
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
// Create MetadataSources
        MetadataSources sources = new MetadataSources(registry);
// Create Metadata
        Metadata metadata = sources.getMetadataBuilder().build();
// Create SessionFactory
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        return sessionFactory;



    }

    public static void selectEmployee() {
        Session S1 = getSF().openSession();
        Transaction T1 = S1.beginTransaction();


        Employees emp = new Employees();
        emp.setFirstName("john");
        emp.setFirstName("Smith");
        emp.setGender('M');

        S1.persist(emp);
//        Employees e1 = S1.find(Employees.class, 11697);
//        System.out.println(e1.getFirstName() + " " +  e1.getLastName());
//        S1.delete(e1);


        T1.commit();
        S1.close();
//        e1.setLastName("Kollijs");


    }

    public static void persistEmployee(){

        Employees e2 = getEmployee();
        Session s1 = getSF().openSession();
        Transaction t1 = s1.beginTransaction();
//        s1.persist(e1);
//        s1.saveOrUpdate(e1);

//        s1.refresh(e1);

        Employees e1 = s1.find(Employees.class, 55);

        t1.commit();
        s1.close();

        e1.setFirstName("any ");

        Session s4 = getSF().openSession();
        Transaction t4 = s4.beginTransaction();

        Employees e4 = (Employees) s4.merge(e1);
        System.out.println("e1 " + e1.getFirstName());


        t4.commit();
        s4.close();


    }

    public static  Employees getEmployee(){

        Employees e1 = new Employees();
        e1.setGender('F');
        e1.setFirstName("Daisy999");
        e1.setLastName("Field");
        e1.setBirthDate("1992-09-27");
        e1.setEmpNo(55);
        e1.setHireDate("1999-09-22");

        return e1;
    }

}