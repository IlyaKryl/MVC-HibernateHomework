package homework.sevice.impl;

import homework.dao.PositionDao;
import homework.model.Position;
import homework.sevice.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PositionServiceImpl implements PositionService {
    private PositionDao positionDao;

    @Autowired
    public PositionServiceImpl(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Override
    @Transactional
    public Position getPosition(int id) {
        return positionDao.findById(id);
    }

    @Override
    @Transactional
    public void createPosition(Position position) {
        positionDao.create(position);
    }

    @Override
    @Transactional
    public void updatePosition(Position position) {
        positionDao.update(position);
    }

    @Override
    @Transactional
    public void deletePosition(int id) {
        positionDao.deleteById(id);
    }
}
