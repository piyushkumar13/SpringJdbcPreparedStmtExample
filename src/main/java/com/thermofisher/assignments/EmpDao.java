package com.thermofisher.assignments;

public interface EmpDao {
    Employee selectEmployee();

    int insertEmployee(Employee e);

    int updatetEmployee(Employee e);

    int deleteEmployee(Employee e);
}
