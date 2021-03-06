import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employees")

public class Employees {

    @Id
    @Column(name = "emp_no")
    private int empNo;
    @Column(name = "birth_date")
    private String birthDate;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private char gender;
    @Column(name = "hire_date")
    private String hireDate;

    @ManyToMany(cascade = CascadeType.PERSIST)

    @JoinTable(name = "employee_projects", joinColumns = {@JoinColumn(name = "emp_no")},

            inverseJoinColumns = {@JoinColumn(name = "project_id")})

    private List<Project> projectList;

    public List<Project> getProjectList() {
        return projectList;
    }


    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Employees() {
    }

    public Employees(String firstName, String lastName, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }


    @OneToOne(mappedBy = "emp")
    private EmploeesDetales empDetales;

    public int getEmpNo() {
        return empNo;
    }

    public EmploeesDetales getEmpDetales() {
        return empDetales;
    }

    public void setEmpDetales(EmploeesDetales empDetales) {
        this.empDetales = empDetales;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return empNo == employees.empNo &&
                firstName.equals(employees.firstName) &&
                lastName.equals(employees.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, firstName, lastName);
    }
}
