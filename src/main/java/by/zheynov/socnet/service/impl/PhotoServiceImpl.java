package by.zheynov.socnet.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import by.zheynov.socnet.dao.PhotoDao;
import by.zheynov.socnet.entity.PhotoEntity;
import by.zheynov.socnet.service.PhotoService;
import by.zheynov.socnet.utils.PhotoCreationOnHDD;

/**
 * PhotoServiceImpl class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.service.impl
 */
@Service("photoService")
public class PhotoServiceImpl implements PhotoService
{
	private static final Logger LOGGER = Logger.getLogger(PhotoServiceImpl.class);

	@Autowired
	private PhotoDao           photoDao;
	@Autowired
	private PhotoCreationOnHDD photoCreationOnHDD;

	/**
	 * Saves.
	 *
	 * @param photoEntity the entity
	 * @param photo       the photo
	 *
	 * @return the entity
	 */
	@Transactional
	public PhotoEntity createPhoto(final PhotoEntity photoEntity, final MultipartFile photo)
	{
		UUID namePicture = photoCreationOnHDD.createPhotoOnHDD(photo);
		photoEntity.setPhotoFileName("photo/" + namePicture + ".jpg");
		LOGGER.info("Saved photo for profileID " + photoEntity.getProfileEntity());

		return photoDao.createPhoto(photoEntity);
	}

	/**
	 * Updates.
	 *
	 * @param photoEntity the entity
	 */
	@Transactional
	public void updatePhoto(final PhotoEntity photoEntity)
	{
		LOGGER.info("Updated photo with ID " + photoEntity.getId());
		photoDao.updatePhoto(photoEntity);
	}

	/**
	 * Deletes.
	 *
	 * @param photoEntity the entity
	 */
	@Transactional
	public void deletePhoto(final PhotoEntity photoEntity)
	{
		LOGGER.info("Deleted photo with ID " + photoEntity.getId());
		photoDao.deletePhoto(photoEntity);
	}

	/**
	 * Retrieves a list of PhotoEntity objects.
	 *
	 * @param profileID the id
	 *
	 * @return the List<PhotoEntity>
	 */
	@Transactional(readOnly = true)
	public List<PhotoEntity> getAllThePhotos(final Long profileID)
	{
		LOGGER.info("Got list of photos for profileID " + profileID);
		return photoDao.getAllThePhotos(profileID);
	}

	/**
	 * Gets PhotoEntity from database.
	 *
	 * @param photoId the id
	 *
	 * @return user entity
	 */
	@Transactional(readOnly = true)
	public PhotoEntity getById(final Long photoId)
	{
		LOGGER.info("Got photo with ID " + photoId);
		return photoDao.getById(photoId);
	}

}