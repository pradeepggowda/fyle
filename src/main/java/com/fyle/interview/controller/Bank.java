package com.fyle.interview.controller;

import com.fyle.interview.controller.viewmode.BankDetailsModel;
import com.fyle.interview.model.BankBranchesDto;
import com.fyle.interview.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class Bank {
    @Autowired
    private BankService bankService;

    @RequestMapping("/")
    public String hello() {
        return "Hello there, please use the curl scripts with JWT token to try out the APIs";
    }

    @RequestMapping("/api/bank/{name}/{city}")
    public List<BankDetailsModel> bank(@PathVariable String name,
                                       @PathVariable String city,
                                       @RequestParam int limit,
                                       @RequestParam int offset) throws Exception {
        return bankService.list(name, city, limit, offset)
                .stream()
                .map(BankDetailsModel::new).collect(toList());
    }

    @RequestMapping("/api/bank/{ifsc}")
    public BankBranchesDto bankDetails(@PathVariable String ifsc) throws Exception {
        return bankService.listBankDetails(ifsc);
    }
}
