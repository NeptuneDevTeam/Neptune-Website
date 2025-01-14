package NeptuneWebsite.Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

@Entity
public class Student {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private int gradeLevel;
private boolean iepStatus;
private boolean adhdStatus;
private String customSettings;

private Student() {}

private Student(Long id,
                int gradeLevel,
                boolean iepStatus,
                boolean adhdStatus,
                String customSettings){
    this.id = id;
    this.gradeLevel = gradeLevel;
    this.iepStatus = iepStatus;
    this.adhdStatus = adhdStatus;
    this.customSettings = customSettings;

}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public boolean isIepStatus() {
        return iepStatus;
    }

    public void setIepStatus(boolean iepStatus) {
        this.iepStatus = iepStatus;
    }

    public boolean isAdhdStatus() {
        return adhdStatus;
    }

    public void setAdhdStatus(boolean adhdStatus) {
        this.adhdStatus = adhdStatus;
    }

    public String getCustomSettings() {
        return customSettings;
    }

    public void setCustomSettings(String customSettings) {
        this.customSettings = customSettings;
    }
}
