package com.thermofisher.assignments;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDaoImpl implements EmpDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Employee selectEmployee() {

        String sql = "select * from employee where id=?";
        return (Employee) jdbcTemplate.queryForObject(sql, new Object[]{1}, new RowMapper() {

            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee e = new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setSalary(rs.getString(3));
                return e;

            }
        });
    }

    @Override
    public int insertEmployee(Employee e) {
        String sql = "insert into employee values(?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{e.getId(), e.getName(), e.getSalary()});
    }

    @Override
    public int updatetEmployee(Employee e) {
        String sql = "update employee set name=? where id =?";
        return jdbcTemplate.update(sql, new Object[]{"geek", 3});
    }

    @Override
    public int deleteEmployee(Employee e) {
        String sql = "delete from employee where id =?";
        return jdbcTemplate.update(sql, new Object[]{2});
    }
}
