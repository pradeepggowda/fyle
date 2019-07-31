package com.fyle.interview.repositories;

import com.fyle.interview.model.BankBranchesDto;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BankRepository {
    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    public List<BankBranchesDto> list(String bankName, String city, int limit, int offset) throws SQLException {
        try (Connection conn = DataSourceUtils.getConnection(dataSource);
             Handle handle = DBI.open(conn)) {
            IBankRepository repository = handle.attach(IBankRepository.class);
            return repository.list(bankName, city, limit, offset);
        }
    }

    public BankBranchesDto listBankDetails(String ifsc) throws SQLException {
        try (Connection conn = DataSourceUtils.getConnection(dataSource);
             Handle handle = DBI.open(conn)) {
            IBankRepository repository = handle.attach(IBankRepository.class);
            return repository.listBankDetails(ifsc);
        }
    }
}
