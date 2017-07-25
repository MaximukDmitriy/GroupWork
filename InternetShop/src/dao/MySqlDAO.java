package dao;

import java.util.List;

public class MySqlDAO implements DAO {

    @Override
    public <T> Long create(T entity) {
        return null;
    }

    @Override
    public <T> Boolean update(T entity) {
        return null;
    }

    @Override
    public <T> Boolean delete(T entity) {
        return null;
    }

    @Override
    public <T> T read(Long id) {
        return null;
    }

    @Override
    public <T> List<T> readByQuery(String query, Parameters params) {
        return null;
    }
}
