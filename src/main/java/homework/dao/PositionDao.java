package homework.dao;

import homework.model.Position;

import java.util.List;

public interface PositionDao {
    Position findById(int id);
    void create(Position position);
    void update(Position position);
    void deleteById(int id);
}
