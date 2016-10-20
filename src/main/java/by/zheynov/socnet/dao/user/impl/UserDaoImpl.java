package by.zheynov.socnet.dao.user.impl;

import by.zheynov.socnet.dao.user.UserDao;
import by.zheynov.socnet.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vazh on 19.10.2016.
 */

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UserEntity createUser(final UserEntity user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    public void updateUser(final UserEntity user) {

    }

    public void deleteUser(final UserEntity user) {

    }

    public List<UserEntity> getAllTheUsers() {
        final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
        final List allTheUsers = criteria.list();
        return allTheUsers;
    }
}
