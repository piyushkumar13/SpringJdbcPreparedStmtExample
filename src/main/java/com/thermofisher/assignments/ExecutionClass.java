package com.thermofisher.assignments;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExecutionClass {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee employee = new Employee(10, "harsh", "100k");
        EmpDaoImpl emp = (EmpDaoImpl) applicationContext.getBean("emp1");

        int i;
        i = emp.insertEmployee(employee);
        if (i > 0) {

            System.out.println("Successfully inserted");

        }
        i = emp.updatetEmployee(employee);
        if (i > 0) {

            System.out.println("Successfully updated");
        }

        System.out.println(emp.selectEmployee());
        i = emp.deleteEmployee(employee);
        if (i > 0) {
            System.out.println("Successfully deleted");

        }
        System.out.println(emp.selectEmployee());
    }
}


