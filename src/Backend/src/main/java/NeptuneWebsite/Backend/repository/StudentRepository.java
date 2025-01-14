package NeptuneWebsite.Backend.repository;

import NeptuneWebsite.Backend.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
