package by.zheynov.socnet.dao.user.impl;

import by.zheynov.socnet.dao.user.UserDao;
import by.zheynov.socnet.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    public UserEntity createUser(UserEntity user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    public void updateUser(UserEntity user) {

    }

    public void deleteUser(UserEntity user) {

    }
}
