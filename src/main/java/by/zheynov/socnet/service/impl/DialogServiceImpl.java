package by.zheynov.socnet.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.zheynov.socnet.dao.DialogDao;
import by.zheynov.socnet.entity.DialogEntity;
import by.zheynov.socnet.service.DialogService;

/**
 * DialogServiceImpl class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.service.impl
 */
public class DialogServiceImpl implements DialogService
{
	private DialogDao dialogDao;

	/**
	 * Saves.
	 *
	 * @param dialogEntity the entity
	 *
	 * @return the entity
	 */
	@Transactional
	public DialogEntity createDialog(final DialogEntity dialogEntity)
	{
		return dialogDao.createDialog(dialogEntity);
	}

	/**
	 * Finds By dialogID.
	 *
	 * @param dialogID the id
	 *
	 * @return the entity
	 */
	@Transactional
	public DialogEntity getById(final Long dialogID)
	{
		return dialogDao.getById(dialogID);
	}

	/**
	 * Retrieves a list of DialogEntity objects.
	 *
	 * @return the List<DialogEntity>
	 */
	@Transactional
	public List<DialogEntity> getAllTheDialogs()
	{
		return dialogDao.getAllTheDialogs();
	}

	/**
	 * Sets new dialogDao.
	 *
	 * @param dialogDao New value of dialogDao.
	 */
	public void setDialogDao(DialogDao dialogDao)
	{
		this.dialogDao = dialogDao;
	}
}