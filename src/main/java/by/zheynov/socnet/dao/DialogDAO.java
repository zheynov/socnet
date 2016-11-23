package by.zheynov.socnet.dao;

import java.util.List;

import by.zheynov.socnet.entity.DialogEntity;

/**
 * DialogDAO interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao
 */
public interface DialogDAO
{
	/**
	 * Saves.
	 *
	 * @param dialogEntity the entity
	 *
	 * @return the entity
	 */
	DialogEntity createDialog(DialogEntity dialogEntity);

	/**
	 * Finds By dialogID.
	 *
	 * @param dialogID the id
	 *
	 * @return the entity
	 */
	DialogEntity getById(Long dialogID);

	/**
	 * Retrieves a list of DialogEntity objects.
	 *
	 * @return the List<DialogEntity>
	 */
	List<DialogEntity> getAllTheDialogs();

}