package org.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeDaoImpl implements EmployeDao{
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List listAllEmploye() {
        List list = new ArrayList();

        String sql = "SELECT id, firstname, lastname, address, salary, hiredate FROM Employes";

        list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new EmployeMapper());

        return list;
    }

    private SqlParameterSource getSqlParameterByModel(Employe Employe){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if(Employe != null){
            parameterSource.addValue("id", Employe.getId());
            parameterSource.addValue("firstname", Employe.getFirstname());
            parameterSource.addValue("lastname", Employe.getLastname());
            parameterSource.addValue("address", Employe.getAddress());
            parameterSource.addValue("salary", Employe.getSalary());
            parameterSource.addValue("hiredate", Employe.getHireDate());

        }
        return parameterSource;
    }

    private static final class EmployeMapper implements RowMapper{

        public Employe mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employe Employe = new Employe();
            Employe.setId(rs.getInt("id"));
            Employe.setFirstname(rs.getString("firstname"));
            Employe.setLastname(rs.getString("lastname"));
            Employe.setAddress(rs.getString("address"));
            Employe.setSalary(rs.getDouble("salary"));
            Employe.setHiredate(rs.getDate("hiredate"));

            return Employe;
        }

    }

    public void addEmploye(Employe Employe) {
        String sql = "INSERT INTO Employes(firstname, lastname, address, salary, hiredate) VALUES(:firstname, :lastname, :address, :salary, :hiredate)";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Employe));
    }

    public void updateEmploye(Employe Employe) {
        String sql = "UPDATE Employes SET firstname=:firstname, lastname=:lastname, address=:address, salary=:salary, hiredate=:hiredate WHERE id =:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Employe));
    }

    public void delete(Employe Employe) {
        String sql = "DELETE FROM Employes WHERE id=:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Employe));
    }

    public Employe findEmployeById(Employe Employe) {
        String sql = "SELECT * FROM Employes WHERE id =:id";

        return (org.example.model.Employe) namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(Employe), new EmployeMapper());
    }

}
