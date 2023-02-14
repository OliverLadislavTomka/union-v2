package pohovor.union.services;

import pohovor.union.model.InsuredPerson;

import java.util.List;

public interface IInsuredPersonService {
    Long createInsuredPerson(InsuredPerson insuredPerson);

    List<InsuredPerson> getAll();

    InsuredPerson getInsuredPerson(Long id);
}
