package dictionarySpring.dao;

import dictionarySpring.model.DictionaryLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DictionaryMapper implements RowMapper<DictionaryLine> {

    @Autowired
    private DictionaryLine dictionaryLine;

    @Override
    public DictionaryLine mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        dictionaryLine.setKey(resultSet.getString("key"));
        dictionaryLine.setValue(resultSet.getString("value"));

        return dictionaryLine;
    }
}
