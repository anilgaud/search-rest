package com.kgate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kgate.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addEmployee(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
        //  sessionFactory.getCurrentSession().saveOrUpdate(skill);
    }

    @SuppressWarnings("unchecked")
    public List<Employee> searchEmployeesBySkill(String txt) {

        String qry = "select employee0_.name, employee0_.email, employee0_.address, employee0_.telephone  from  employee123 employee0_ cross  join join_employee_skill listskill1_, Skills skill2_  where  employee0_.id=listskill1_.id and listskill1_.skill_Id=skill2_.skill_Id  and skill2_.skill_name LIKE '" + txt + "'";
        List<Object> data = sessionFactory.getCurrentSession().createSQLQuery(qry).list();

        List<Employee> emp = new ArrayList<>();
//        Employee e = new Employee();

        for (Object d : data) {

            Object arr[] = (Object[]) d;
            String st, st1, st2, st3;
//            String s[] = null;
//            for (int i = 0; i <= arr.length; i++) {
//                s[i] = (String) arr[i];
//
//            }
            Employee e = new Employee();
            st = (String) arr[0];
            st1 = (String) arr[1];
            st2 = (String) arr[2];
            st3 = (String) arr[3];

            e.setName(st);
            e.setEmail(st1);
            e.setAddress(st2);
            e.setTelephone(st3);

            emp.add(e);

        }

        return emp;
   
    }
 

    @SuppressWarnings("unchecked")
    public List<Employee> searchEmployees(String txt) {

        String query = "from Employee u where u.name like '" + txt + "%' or u.email like '" + txt + "%' or u.address like '" + txt + "%' or u.telephone like '" + txt + "%' ";
        return sessionFactory.getCurrentSession().createQuery(query).list();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployees() {

        return sessionFactory.getCurrentSession().createQuery("from Employee")
                .list();
    }

    @Override
    public void deleteEmployee(Integer employeeId) {

        String query ="delete employee123, join_employee_skill from employee123 inner join  join_employee_skill  where    employee123.id = join_employee_skill.id and employee123.id ="+employeeId+"";
        
          SQLQuery  sqlq = sessionFactory.getCurrentSession().createSQLQuery(query);
          sqlq.executeUpdate();
          
//        Employee employee = (Employee) sessionFactory.getCurrentSession().load(
//                Employee.class,
//                employeeId);
//        if (null != employee) {
//            this.sessionFactory.getCurrentSession().delete(employee);
//        }

    }

    public Employee getEmployee(int empid) {
        return (Employee) sessionFactory.getCurrentSession().get(
                Employee.class,
                empid);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
        return employee;
    }

}
