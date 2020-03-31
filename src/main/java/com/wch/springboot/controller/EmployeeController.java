package com.wch.springboot.controller;

import com.wch.springboot.dao.DepartmentDao;
import com.wch.springboot.dao.EmployeeDao;
import com.wch.springboot.entities.Department;
import com.wch.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps",emps);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String addPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String add(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String editPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps",departments);

        return "emp/add";
    }

    @PutMapping("/emp")
    public String edit(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }
    @InitBinder
    public void InitBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            public void setAsText(String value) {
                try {
                    setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
                } catch(ParseException e) {
                    setValue(null);
                }
            }

            public String getAsText() {
                return new SimpleDateFormat("yyyy-MM-dd").format((Date) getValue());
            }

        });
    }


}
