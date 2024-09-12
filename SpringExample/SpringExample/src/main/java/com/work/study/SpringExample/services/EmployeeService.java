package com.work.study.SpringExample.services;


import com.work.study.SpringExample.dto.EmployeeDTO;
import com.work.study.SpringExample.entities.EmployeeEntity;
import com.work.study.SpringExample.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id){
        EmployeeEntity employeeEntity = employeeRepository.getById(id);

        return modelMapper.map(employeeEntity,EmployeeDTO.class);


    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {

        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO,EmployeeEntity.class);

        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> list = new ArrayList<>();
        for (EmployeeEntity EmployeeEntity : employeeRepository.findAll()) {
            EmployeeDTO map = modelMapper.map(EmployeeEntity, EmployeeDTO.class);
            list.add(map);
        }
        return list;
    }

    public boolean deleteEmployeeById(Long employeeId) {
        boolean isPresent =employeeRepository.existsById(employeeId);
        if(!isPresent){
            return false;
        }

        employeeRepository.deleteById(employeeId);
        return true;
    }

    public long getCountOfEmployees() {
        return employeeRepository.count();
    }
}
