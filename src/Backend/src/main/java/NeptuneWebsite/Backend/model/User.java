package NeptuneWebsite.Backend.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
}
