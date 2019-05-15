import javax.persistence.*;

import java.util.List;

@Entity

@Table(name = "projects")

public class Project {

    public Project(){
    }
    public Project(String name){
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    private int id;
    private String name;
    @ManyToMany(mappedBy = "projectList")
    private List<Employees> employeesList;
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
    public List<Employees> getEmployeesList() {
        return employeesList;
    }
    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }
}