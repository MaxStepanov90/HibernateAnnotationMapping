package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstname;
    @Column(name = "LAST_NAME")
    private String lastname;
    @Column(name = "BIRTHDAY")
    private Date birthday;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name = "EMPL_PROJ",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROJECT_ID")
    )
    private Set<Project> projects;

    public Employee(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday=" + birthday +
                ", address=" + address +
                '}';
    }
}
