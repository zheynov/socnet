package by.zheynov.socnet.dao.impl;

import by.zheynov.socnet.dao.UserDao;
import by.zheynov.socnet.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vazh on 19.10.2016.
 */

/**
 * User Dao Implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */
@Transactional
public class UserDaoImpl extends AbstractBaseDAO implements UserDao {

    public UserEntity createUser(final UserEntity user) {
        save(user);
        return user;
    }

    public void updateUser(final UserEntity user) {
    }

    public void deleteUser(final UserEntity user) {
    }

    public List<UserEntity> getAllTheUsers() {

        final Criteria criteria = getCurrentSession().createCriteria(UserEntity.class);
        final List allTheUsers = criteria.list();
        return allTheUsers;
    }


}
