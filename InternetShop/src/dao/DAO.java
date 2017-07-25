package dao;

import java.util.List;

/**
 * Created by Julia on 24.07.2017.
 */
public interface DAO {

    <T> Long create(T entity);

    <T> Boolean update(T entity);

    <T> Boolean delete(T entity);

    <T> T read(Long id);

    <T> List<T> readByQuery(String query, Parameters params);
}

