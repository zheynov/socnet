package by.zheynov.socnet.dao.impl;

import org.hibernate.SQLQuery;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import by.zheynov.socnet.dao.UserRoleDao;
import by.zheynov.socnet.entity.RoleEntity;

@Transactional
public class UserRoleDaoImpl extends AbstractBaseDAO implements UserRoleDao
{
	public RoleEntity createUserRole(final RoleEntity userRole)
	{
		save(userRole);
		return userRole;
	}

	public void updateUserRole(final RoleEntity userRole)
	{

		udate(userRole);
	}

	public void deleteUserRole(final RoleEntity userRole)
	{
		delete(userRole);
	}

	private void disableForeighnKeyCkeck()
	{
		String disable = "SET FOREIGN_KEY_CHECKS=0";
		SQLQuery query = getCurrentSession().createSQLQuery(disable);
		query.executeUpdate();
	}

	private void enableForeighnKeyCkeck()
	{
		String disable = "SET FOREIGN_KEY_CHECKS=1";
		SQLQuery query = getCurrentSession().createSQLQuery(disable);
		query.executeUpdate();
	}

}
