package NeptuneWebsite.Backend.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/*

UserID: Unique identifier (Primary Key).
Name: Full name of the user.
Role: Teacher, Student, or Admin.
SchoolID: Links to the school entity.
AccountStatus: Active, Inactive.
 */
public abstract class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long userId;


    private String name;
    private Long school;
    private Boolean accountStatus;
    @OneToOne(mappedBy = "user")
    private Student student;

    public User() {
    }

    public User(Long userId, String name, Long school, Boolean accountStatus) {
        this.userId = userId;
        this.name = name;
        this.school = school;
        this.accountStatus = accountStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSchool() {
        return school;
    }

    public void setSchool(Long school) {
        this.school = school;
    }

    public Boolean getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Boolean accountStatus) {
        this.accountStatus = accountStatus;
    }
}
