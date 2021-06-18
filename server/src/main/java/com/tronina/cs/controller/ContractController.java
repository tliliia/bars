package com.tronina.cs.controller;
import com.tronina.cs.service.impl.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;

@RestController
@RequestMapping(value = "/contracts/")
public class ContractController {
    private final ContractServiceImpl contractService;

    @Autowired
    public ContractController(ContractServiceImpl contractService) {
        this.contractService = contractService;
    }

    @GetMapping()
    public ResponseEntity index(Model model) {
        if(model == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        model.addAttribute("contract", contractService.findAll());
        var result =  contractService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
