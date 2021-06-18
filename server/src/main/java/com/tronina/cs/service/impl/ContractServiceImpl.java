package com.tronina.cs.service.impl;

import com.tronina.cs.model.Contract;
import com.tronina.cs.repository.ContractRepository;
import com.tronina.cs.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    public Contract findOne(int id) {
        Optional<Contract> foundPerson = contractRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(Contract person) {
        contractRepository.save(person);
    }

    @Transactional
    public void update(int id, Contract updatedContract) {
        updatedContract.setId(id);
        contractRepository.save(updatedContract);
    }

    @Transactional
    public void delete(int id) {
        contractRepository.deleteById(id);
    }
}
