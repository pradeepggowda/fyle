package com.fyle.interview.repositories;

import com.fyle.interview.model.BankBranchesDto;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RegisterMapper(IBankRepository.BankBranchesMapper.class)
public interface IBankRepository {
    @SqlQuery("SELECT * FROM bank_branches WHERE bank_name=:bank_name AND city=:city limit :limit offset :offset")
    List<BankBranchesDto> list(@Bind("bank_name") String bankName, @Bind("city") String city,
                               @Bind("limit") int limit, @Bind("offset") int offset);

    @SqlQuery("SELECT * FROM bank_branches WHERE ifsc=:ifsc")
    BankBranchesDto listBankDetails(@Bind("ifsc") String bankName);

    class BankBranchesMapper implements ResultSetMapper<BankBranchesDto> {
        @Override
        public BankBranchesDto map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
            BankBranchesDto bank = new BankBranchesDto();
            bank.setBank_name(r.getString("bank_name"));
            bank.setAddress(r.getString("address"));
            bank.setBranch(r.getString("branch"));
            bank.setCity(r.getString("city"));
            bank.setIfsc(r.getString("ifsc"));
            bank.setState(r.getString("city"));
            bank.setDistrict(r.getString("district"));
            return bank;
        }
    }
}
