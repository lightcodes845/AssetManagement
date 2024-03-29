package com.sprintell.assetmanagement.services;

import com.sprintell.assetmanagement.models.Department;
import com.sprintell.assetmanagement.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private LocalDate timeNw = LocalDate.now();
    private Boolean status = true;

    @Autowired
    DepartmentRepository departmentRepository;

    //Add Department data
    public Department addDepartment(Department department){
        department.setRegTime(timeNw);
        department.setStatus(status);

        return departmentRepository.saveAndFlush(department);
    }

    public List <Department> addDepartments(List<Department> departments){
        for (Department department : departments){
            department.setRegTime(timeNw);
            department.setStatus(status);
        }

        return departmentRepository.saveAll(departments);
    }

    // Get Department Data

    public Optional<Department> getDepartment(Long id){
        return departmentRepository.findById(id);
    }

    /*public List<Department> getSomeDepartments(List<Long> ids) {
        return departmentRepository.findByIdIn(ids);
    }*/

    public List<Department> getDepartments(){
        List<Department> departments = departmentRepository.findAll();

        return departments;
    }

    // Search / Delete / Check Existence of Departments Data

    public List<Department> search(int page, int size, String searchParam){

        List<Department> departments = departmentRepository.findBySearchParameter(searchParam);

        return departments;
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public void deleteAllDepartments(){
        departmentRepository.deleteAll();
    }


    public boolean checkExistence(Long id) {

        return departmentRepository.existsById(id);
    }

    public long countRecord() {
        long count = departmentRepository.count();
        return count;
    }

    public Boolean updateDepartment(Department incoming_department, Long id) {

        Optional<Department> opt_department = getDepartment(id);

        if (opt_department.isPresent()){
            Department loc = opt_department.get();
            loc.setName(incoming_department.getName());
            loc.setDescription(incoming_department.getDescription());
            loc.setStatus(true);
            loc.setRegTime(LocalDate.now());
            departmentRepository.save(loc);
            return true;
        }
        return false;
    }
}

