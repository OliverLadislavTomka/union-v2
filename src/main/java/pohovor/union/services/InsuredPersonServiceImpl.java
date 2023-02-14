package pohovor.union.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pohovor.union.exceptions.BadRequestException;
import pohovor.union.exceptions.IdNotFoundException;
import pohovor.union.model.InsuredPerson;
import pohovor.union.repository.InsuredPersonRepository;

import java.util.List;

@Service
public class InsuredPersonServiceImpl implements IInsuredPersonService{

    private final InsuredPersonRepository insuredPersonRepository;

    @Autowired
    public InsuredPersonServiceImpl(InsuredPersonRepository insuredPersonRepository) {
        this.insuredPersonRepository = insuredPersonRepository;
    }

    @Override
    public Long createInsuredPerson(InsuredPerson insuredPerson) {
        try {
            InsuredPerson newEntity = insuredPersonRepository.save(insuredPerson);
            return newEntity.getId();
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }

    @Override
    public List<InsuredPerson> getAll() {
        return insuredPersonRepository.findAll(Sort.by(Sort.Direction.ASC,"lastName"));
    }

    @Override
    public InsuredPerson getInsuredPerson(Long id) {
        return insuredPersonRepository.findById(id).orElseThrow(IdNotFoundException::new);
    }
}
