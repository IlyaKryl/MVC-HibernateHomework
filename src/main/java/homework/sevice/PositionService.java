package homework.sevice;

import homework.model.Position;

public interface PositionService {
    Position getPosition(int id);
    void createPosition(Position position);
    void updatePosition(Position position);
    void deletePosition(int id);
}
