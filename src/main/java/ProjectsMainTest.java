import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProjectsMainTest {
    public static void main(String arp[]) {
        linkEmpProjects();
    }

    public static void linkEmpProjects() {
        Session s1 = Main.getSF().openSession();
        Transaction t1 = s1.beginTransaction();
        // Employees
        Employees emp1 = createEmployee(new Employees("emp1", "emp1_ln", 'M'));
        Employees emp2 = createEmployee(new Employees("emp2", "emp2_ln", 'M'));
        Employees emp3 = createEmployee(new Employees("emp3", "emp3_ln", 'F'));
        Employees emp4 = createEmployee(new Employees("emp4", "emp4_ln", 'F'));
        // Projects
        Project p1 = new Project("lmt billing sys");
        Project p2 = new Project("Swidbank fintech sys");
        // Employees List
        List<Employees> empList = new ArrayList<Employees>();
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);

        empList.add(emp4);
        // Project List
        List<Project> projList = new ArrayList<Project>();
        projList.add(p1);
        projList.add(p2);
        // Add Projects list to employees
        emp1.setProjectList(projList);
        emp2.setProjectList(projList);
        emp3.setProjectList(projList);
        emp4.setProjectList(projList);
        // Add employees list to Projects
        p1.setEmployeesList(empList);
        p2.setEmployeesList(empList);
        s1.persist(emp1);
        s1.persist(emp2);
        s1.persist(emp3);
        s1.persist(emp4);
        t1.commit();
        s1.close();
    }

    /*
    public static void findEmpDept() {
        Session s1 = FactoryService.getSessionFactory().openSession();
        Transaction t1 = s1.beginTransaction();
        Employees emp = s1.find(Employees.class, 500022);
        for (EmpDept ed : emp.getEmpDept()) {
            System.out.println(ed.getEmpDeptPk().getDept().getDeptName());
        }
        t1.commit();
        s1.close();
    }
    */

    public static Employees createEmployee(Employees empNew) {
        empNew.setBirthDate("1990-01-06");
        empNew.setHireDate("2019-02-04");
        return empNew;
    }
}