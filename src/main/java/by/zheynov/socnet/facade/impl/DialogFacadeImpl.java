package by.zheynov.socnet.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import by.zheynov.socnet.dto.DialogDTO;
import by.zheynov.socnet.entity.DialogEntity;
import by.zheynov.socnet.facade.DialogFacade;
import by.zheynov.socnet.service.DialogService;

/**
 * DialogFacadeImpl class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade.impl
 */
public class DialogFacadeImpl implements DialogFacade
{
	@Autowired
	private DialogService     dialogService;
	@Autowired
	private ConversionService conversionService;

	/**
	 * Saves.
	 *
	 * @param dialogDTO the dto
	 *
	 * @return the dto
	 */
	public DialogEntity createDialog(final DialogDTO dialogDTO)
	{
		return dialogService.createDialog(conversionService.convert(dialogDTO, DialogEntity.class));
	}

	/**
	 * Finds By dialogID.
	 *
	 * @param dialogID the id
	 *
	 * @return the dto
	 */
	public DialogDTO getById(final Long dialogID)
	{
		return conversionService.convert(dialogService.getById(dialogID), DialogDTO.class);
	}

	/**
	 * Retrieves a list of DialogDTO objects.
	 *
	 * @return the List<DialogDTO>
	 */
	public List<DialogDTO> getAllTheDialogs()
	{
		List<DialogDTO> dialogDTOs = new ArrayList<DialogDTO>();

		for (DialogEntity dialogEntity : dialogService.getAllTheDialogs())
		{
			dialogDTOs.add(conversionService.convert(dialogEntity, DialogDTO.class));
		}
		return dialogDTOs;
	}
}