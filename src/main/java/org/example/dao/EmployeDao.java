package org.example.dao;

import org.example.model.Employe;

import java.util.List;

public interface EmployeDao {


        public List listAllEmploye();

        public void addEmploye(Employe Employe);

        public void updateEmploye(Employe Employe);

        public void delete(Employe Employe);

        public Employe findEmployeById(Employe Employe);

    }
