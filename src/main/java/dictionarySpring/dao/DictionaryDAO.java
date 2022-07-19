package dictionarySpring.dao;

import dictionarySpring.model.DictionaryLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DictionaryDAO {

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    private DictionaryDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public static List<DictionaryLine> readBD() {
        return jdbcTemplate.query("SELECT * FROM dictionaries", new BeanPropertyRowMapper<>(DictionaryLine.class));
    }
}
