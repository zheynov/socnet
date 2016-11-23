package by.zheynov.socnet.dao.impl;

import java.util.List;

import org.hibernate.query.Query;

import by.zheynov.socnet.dao.DialogDAO;
import by.zheynov.socnet.entity.DialogEntity;

/**
 * .
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */
public class DialogDAOImpl extends AbstractBaseDAO implements DialogDAO
{
	private static final String GET_ALL_THE_DIALOGS_QUERY = "FROM DialogEntity";

	/**
	 * Saves.
	 *
	 * @param dialogEntity the entity
	 *
	 * @return the entity
	 */
	public DialogEntity createDialog(final DialogEntity dialogEntity)
	{
		super.save(dialogEntity);
		return dialogEntity;
	}

	/**
	 * Retrieves a list of DialogEntity objects.
	 *
	 * @return the List<DialogEntity>
	 */
	public List<DialogEntity> getAllTheDialogs()
	{
		Query query = super.getCurrentSession().createQuery(GET_ALL_THE_DIALOGS_QUERY);
		return query.list();
	}

	/**
	 * Finds By dialogID.
	 *
	 * @param dialogID the id
	 *
	 * @return the entity
	 */
	public DialogEntity getById(final Long dialogID)
	{
		return super.getCurrentSession().get(DialogEntity.class, dialogID);
	}
}