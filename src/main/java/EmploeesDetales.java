import javax.persistence.*;

@Entity
@Table(name = "Emploees_detales")
public class EmploeesDetales {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int ID;
    @Column(name = "e_mail")
    private String eMail;
    @Column(name = "passport_ID")
    private String passportId;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne
    @JoinColumn (name = "emp_no")
    private Employees emp;

    public EmploeesDetales() {
    }

    public Employees getEmp() {
        return emp;
    }

    public void setEmp(Employees emp) {
        this.emp = emp;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
