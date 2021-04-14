package org.example.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.dao.EmployeDao;
import org.example.model.Employe;


@Service
public class EmployeServiceImpl implements EmployeService {
    EmployeDao EmployeDao;

    @Autowired
    public void setEmployeDao(EmployeDao EmployeDao) {
        this.EmployeDao = EmployeDao;
    }

    public List listAllEmploye() {
        return EmployeDao.listAllEmploye();
    }

    public void addEmploye(Employe Employe) {
        EmployeDao.addEmploye(Employe);
    }

    public void updateEmploye(Employe Employe) {
        EmployeDao.updateEmploye(Employe);
    }

    public void delete(Employe Employe) {
        EmployeDao.delete(Employe);
    }

    public Employe findEmployeById(Employe Employe) {
        return EmployeDao.findEmployeById(Employe);
    }
}
