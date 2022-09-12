package homework.dao.impl;

import homework.dao.PositionDao;
import homework.model.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PositionDaoImpl implements PositionDao {

    private SessionFactory sessionFactory;

    @Autowired
    public PositionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Position findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Position.class, id);
    }

    private boolean existsByPositionName(Position position) {
        Session session = sessionFactory.getCurrentSession();
        Position pos = session.get(Position.class, position.getPositionName());
        return pos != null;
    }

    @Override
    public void create(Position position) {
        Session session = sessionFactory.getCurrentSession();
        if (!existsByPositionName(position)) {
            session.persist(position);
        } else {
            session.merge(position);
        }
    }

    @Override
    public void update(Position position) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(position);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Position position = session.get(Position.class, id);
        session.remove(position);
    }

}
