package by.zheynov.socnet.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import by.zheynov.socnet.dto.PhotoDTO;
import by.zheynov.socnet.entity.PhotoEntity;
import by.zheynov.socnet.facade.PhotoFacade;
import by.zheynov.socnet.service.PhotoService;

/**
 * PhotoFacadeImpl class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade.impl
 */
@Component("photoFacade")
public class PhotoFacadeImpl implements PhotoFacade
{
	@Autowired
	private PhotoService      photoService;
	@Autowired
	private ConversionService conversionService;

	/**
	 * Saves.
	 *
	 * @param photoDTO the dto
	 * @param photo    the photo
	 */
	public void createPhoto(final PhotoDTO photoDTO, final MultipartFile photo)
	{
		photoService.createPhoto(conversionService.convert(photoDTO, PhotoEntity.class), photo);
	}

	/**
	 * Updates.
	 *
	 * @param photoDTO the dto
	 */
	public void updatePhoto(final PhotoDTO photoDTO)
	{
		photoService.updatePhoto(conversionService.convert(photoDTO, PhotoEntity.class));
	}

	/**
	 * Deletes.
	 *
	 * @param photoDTO the dto
	 */
	public void deletePhoto(final PhotoDTO photoDTO)
	{
		PhotoEntity photoEntity = conversionService.convert(photoDTO, PhotoEntity.class);
		photoService.deletePhoto(photoEntity);
	}

	/**
	 * Retrieves a list of PhotoDTO objects.
	 *
	 * @param profileID the id
	 *
	 * @return the List<PhotoDTO>
	 */
	public List<PhotoDTO> getAllThePhotos(final Long profileID)
	{
		List<PhotoDTO> allThePhotoDTOs = new ArrayList<>();

		photoService.getAllThePhotos(profileID).forEach(elem -> allThePhotoDTOs.add(conversionService.convert(elem, PhotoDTO
						.class)));

		return allThePhotoDTOs;
	}

	/**
	 * Gets PhotoDTO from database.
	 *
	 * @param photoId the id
	 *
	 * @return user dto
	 */
	public PhotoDTO getById(final Long photoId)
	{
		return conversionService.convert(photoService.getById(photoId), PhotoDTO.class);
	}
}