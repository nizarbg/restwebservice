package org.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.example.model.Employe;
import org.example.service.EmployeService;

import java.util.List;

@RestController
public class EmployeController {
    @Autowired
     EmployeService EmployeService;

    @RequestMapping(value="/user/", method = RequestMethod.GET, headers="Accept=application/json")
    public ResponseEntity<List<Employe>> listAllEmploye(){
        List<Employe> list = EmployeService.listAllEmploye();

        if(list.size() == 0){
            return new ResponseEntity<List<Employe>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Employe>>(list, HttpStatus.OK);
    }

    @RequestMapping(value="/add/", method = RequestMethod.POST, headers="Accept=application/json")
    public ResponseEntity<Void> add(@RequestBody Employe Employe){
        EmployeService.addEmploye(Employe);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/update/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
    public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Employe Employe){
        Employe.setId(id);
        EmployeService.updateEmploye(Employe);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
    public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Employe Employe){
        Employe.setId(id);
        EmployeService.delete(Employe);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
}
