package com.geoup.springboot.configuration.template;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author: lisy
 * @version: BaseJdbcTemplate , v0.1 2021年01月28日 19:51
 * @remark：BaseJdbcTemplate
 */
public abstract class BaseJdbcTemplate<T> {

    protected JdbcTemplate jdbcTemplate;

    protected abstract JdbcTemplate jdbcTemplate();

    public void execute(String sql) {
        jdbcTemplate.execute(sql);
    }

    public T query(String sql, ResultSetExtractor<T> rse) {
        return jdbcTemplate.query(sql, rse);
    }

    public int update(String sql) {
        return jdbcTemplate.update(sql);
    }

    public void batchUpdate(String sql, final List v, final List<String> javaFields) {
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                int index = 1;
                for (int j = 0; j < javaFields.size(); ++j) {
                    try {
                        String name = javaFields.get(j);
                        Field field = v.get(i).getClass().getDeclaredField(name);
                        setPreparedStatement(field, name, preparedStatement, index, v.get(i));
                        ++index;
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                }
            }

            public int getBatchSize() {
                return v.size();
            }
        });
    }

    private void setPreparedStatement(Field field, String name, PreparedStatement preparedStatement, int index, Object obj) {
        try {
            field.setAccessible(true);
            if (field.getType().getName().equals(String.class.getName())) {
                preparedStatement.setString(index, field.get(obj) == null ? null : String.valueOf(field.get(obj)));
                return;
            }

            if (field.getType().getName().equals(Long.class.getName()) || field.getType().getName().equals(long.class.getName())) {
                preparedStatement.setLong(index, field.get(obj) == null ? null : Long.parseLong(String.valueOf(field.get(obj))));
                return;
            }
            if (field.getType().getName().equals(int.class.getName()) || field.getType().getName().equals(Integer.class.getName())) {
                preparedStatement.setLong(index, field.get(obj) == null ? null : Integer.parseInt(String.valueOf(field.get(obj))));
                return;
            }

            if (field.getType().equals(Date.class) || field.getType().equals(java.sql.Date.class)) {
                preparedStatement.setTimestamp(index, field.get(obj) == null ? null : new java.sql.Timestamp(((Timestamp) field.get(obj)).getTime()));
                return;
            }

            if (field.getType().equals(Double.class) || field.getType().equals(double.class)) {
                preparedStatement.setDouble(index, field.get(obj) == null ? null : Double.parseDouble(String.valueOf(field.get(obj))));
                return;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
