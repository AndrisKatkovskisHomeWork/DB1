import javax.persistence.*;

@Entity
@Table(name = "salaries")

public class Salaries {

    @EmbeddedId
    private SalaryPK salaryPK;

    @Column (name = "salary")
    private int salary;

    @Column(name = "to_date")
    private String toDate;

    public Salaries() {
    }

    public SalaryPK getSalaryPK() {
        return salaryPK;
    }

    public void setSalaryPK(SalaryPK salaryPK) {
        this.salaryPK = salaryPK;
    }




    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }




    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }


}


