package pohovor.union.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pohovor.union.dto.InsuredPersonDTO;
import pohovor.union.model.InsuredPerson;
import pohovor.union.services.IInsuredPersonService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/insured")
public class InsuredPersonController {

    @Autowired
    private final IInsuredPersonService service;

    public InsuredPersonController(IInsuredPersonService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    public List<InsuredPersonDTO> getAllInsured() {
        return service
                .getAll()
                .stream()
                .map(k -> new InsuredPersonDTO(k,false))
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseBody
    public Long createNewInsuredPerson (@RequestBody InsuredPerson insuredPerson){
        return service.createInsuredPerson(insuredPerson);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public InsuredPersonDTO getDetails(@PathVariable("id") Long id){
        return new InsuredPersonDTO(service.getInsuredPerson(id),true);
    }
}
