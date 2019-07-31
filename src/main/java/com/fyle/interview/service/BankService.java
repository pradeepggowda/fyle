package com.fyle.interview.service;

import com.fyle.interview.model.BankBranchesDto;
import com.fyle.interview.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public List<BankBranchesDto> list(String bankName, String city, int limit, int offset) throws Exception {
        try {
            return bankRepository.list(bankName, city, limit, offset);

        } catch (Exception e) {
            String message = "Failed to list branch details for bank " + bankName + " in " + city;
            throw new Exception(message, e);
        }
    }

    public BankBranchesDto listBankDetails(String ifsc) throws Exception {
        try {
            return bankRepository.listBankDetails(ifsc);
        } catch (Exception e) {
            throw new Exception("Failed to display bank details for IFSC-" + ifsc, e);
        }
    }
}
