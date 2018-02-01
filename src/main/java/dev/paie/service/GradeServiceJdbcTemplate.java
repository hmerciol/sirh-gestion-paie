package dev.paie.service;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;

@Service
public class GradeServiceJdbcTemplate implements GradeService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO Grade (id,code,nbHeuresBase,tauxBase) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, nouveauGrade.getId(), nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(),
				nouveauGrade.getTauxBase());
	}

	@Override
	public void mettreAJour(Grade grade) {
		String sql = "UPDATE Grade SET code=?,nbHeuresBase=?,tauxBase=? WHERE id=?";
		jdbcTemplate.update(sql, grade.getCode(), grade.getNbHeuresBase(), grade.getTauxBase(), grade.getId());
	}

	@Override
	public List<Grade> lister() {
		String sql = "SELECT * FROM Grade";
		RowMapper<Grade> gradeMapper = (ResultSet rs, int rn) -> {
			Grade gr = new Grade();
			gr.setId(rs.getInt("id"));
			gr.setCode(rs.getString("code"));
			gr.setNbHeuresBase(rs.getBigDecimal("nbHeuresBase"));
			gr.setTauxBase(rs.getBigDecimal("tauxBase"));
			return gr;
		};
		return jdbcTemplate.query(sql, gradeMapper);
	}

}
