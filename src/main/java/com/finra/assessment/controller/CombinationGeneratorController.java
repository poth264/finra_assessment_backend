package com.finra.assessment.controller;

import com.finra.assessment.model.CombinationDTO;
import com.finra.assessment.service.MakeCombinations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CombinationGeneratorController {

    MakeCombinations makeCombinations;

    @Autowired
    public CombinationGeneratorController(MakeCombinations makeCombinations){
        this.makeCombinations=makeCombinations;
    }

    @GetMapping(value = "/{number}", produces = "application/json")
    public CombinationDTO getCombinations(@PathVariable(value = "number") String number){
        CombinationDTO res=makeCombinations.generateCombinations(number);
        return res;
    }
}