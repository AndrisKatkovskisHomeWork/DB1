import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;

public class Main2 {

    public static void main(String[] args) {


        Session s1 = Main.getSF().openSession();
        Transaction t1 = s1.beginTransaction();

        SalaryPK spk = new SalaryPK();
        spk.setEmpNo(10003);
        spk.setFromDate("1996-12-02");

//        Salaries sal1 = s1.find(Salaries.class, spk);
//        System.out.println("sal1  :" + sal1.getSalary() + " + " + sal1.getToDate());

        Salaries sal = makeSalaries();
        s1.persist(sal);

//        s1.delete(sal);

        t1.commit();
        s1.close();
    }


    public static Salaries makeSalaries() {
        System.out.println("makeSalaries start .. ");
        Salaries sal7 = new Salaries();

        SalaryPK spk = new SalaryPK();

        spk.setEmpNo(55);
        spk.setFromDate("2019-09-06");
        sal7.setSalaryPK(spk);
        sal7.setSalary(545454);
        sal7.setToDate("1999-05-05");

        System.out.println("makeSalaries end .. object: " + sal7.getToDate() + " " + sal7.getSalaryPK() + " " + sal7.getSalary());
        return sal7;

    }
}
