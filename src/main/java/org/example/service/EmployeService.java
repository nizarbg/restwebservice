package org.example.service;

import org.example.model.Employe;

import java.util.List;

public interface EmployeService {

    public List listAllEmploye();

    public void addEmploye(Employe employe);

    public void updateEmploye(Employe employe);

    public void delete(Employe employe);

    public Employe findEmployeById(Employe employe);
}
