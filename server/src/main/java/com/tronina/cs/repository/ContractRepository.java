package com.tronina.cs.repository;

import com.tronina.cs.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Integer>{
}
