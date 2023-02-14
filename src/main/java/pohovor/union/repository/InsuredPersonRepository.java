package pohovor.union.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pohovor.union.model.InsuredPerson;

import java.util.List;
import java.util.Optional;

@Repository
public interface InsuredPersonRepository extends CrudRepository<InsuredPerson, Long> {

    Optional<InsuredPerson> findById(Long id);

    List<InsuredPerson> findAll(Sort sort);


    InsuredPerson save(InsuredPerson entity);
}
