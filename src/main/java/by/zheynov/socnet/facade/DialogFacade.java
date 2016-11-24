package by.zheynov.socnet.facade;

import java.util.List;

import by.zheynov.socnet.dto.DialogDTO;
import by.zheynov.socnet.entity.DialogEntity;

/**
 * DialogFacade interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade.impl
 */
public interface DialogFacade
{
	/**
	 * Saves.
	 *
	 * @param dialogDTO the dto
	 *
	 * @return the dto
	 */
	DialogEntity createDialog(DialogDTO dialogDTO);

	/**
	 * Finds By dialogID.
	 *
	 * @param dialogID the id
	 *
	 * @return the dto
	 */
	DialogDTO getById(Long dialogID);

	/**
	 * Retrieves a list of DialogDTO objects.
	 *
	 * @return the List<DialogDTO>
	 */
	List<DialogDTO> getAllTheDialogs();


}