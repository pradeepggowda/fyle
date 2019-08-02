package com.fyle.interview.repositories;

import com.fyle.interview.model.BankBranchesDto;
import com.fyle.interview.model.user.UserDto;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@RegisterMapper(IUserRepository.UserMapper.class)

public interface IUserRepository {

    @SqlUpdate("insert into users (user_name,password,email_id) values (:user_name,:password,:email_id)")
    void save(@BindBean UserDto user);

    @SqlQuery("SELECT user_name,password,email_id from users where user_name=:name")
    UserDto findByName(@Bind("name") String name);

    class UserMapper implements ResultSetMapper<UserDto> {
        @Override
        public UserDto map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
            UserDto user = new UserDto();
            user.setUser_name(r.getString("user_name"));
            user.setEmail_id(r.getString("email_id"));
            user.setPassword(r.getString("password"));
            return user;
        }
    }
}
