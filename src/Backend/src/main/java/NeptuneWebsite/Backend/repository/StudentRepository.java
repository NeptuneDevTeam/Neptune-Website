package NeptuneWebsite.Backend.repository;

import NeptuneWebsite.Backend.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
