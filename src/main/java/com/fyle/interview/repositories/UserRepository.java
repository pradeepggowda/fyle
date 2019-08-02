package com.fyle.interview.repositories;

import com.fyle.interview.model.BankBranchesDto;
import com.fyle.interview.model.user.UserDto;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class UserRepository {

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    public UserDto findByName(String name) throws SQLException {
        try (Connection conn = DataSourceUtils.getConnection(dataSource);
             Handle handle = DBI.open(conn)) {
            IUserRepository repository = handle.attach(IUserRepository.class);
            return repository.findByName(name);
        }
    }

    public void save(UserDto userDto) throws SQLException {
        try (Connection conn = DataSourceUtils.getConnection(dataSource);
             Handle handle = DBI.open(conn)) {
            IUserRepository repository = handle.attach(IUserRepository.class);
            repository.save(userDto);
        }
    }
}
