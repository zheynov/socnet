package by.zheynov.socnet.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import by.zheynov.socnet.entity.PhotoEntity;

/**
 * PhotoService interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.service.impl
 */
public interface PhotoService
{
	/**
	 * Saves.
	 *
	 * @param photoEntity the entity
	 *
	 * @return the entity
	 */
	PhotoEntity createPhoto(PhotoEntity photoEntity, MultipartFile photo);

	/**
	 * Updates.
	 *
	 * @param photoEntity the entity
	 */
	void updatePhoto(PhotoEntity photoEntity);

	/**
	 * Deletes.
	 *
	 * @param photoEntity the entity
	 */
	void deletePhoto(PhotoEntity photoEntity);

	/**
	 * Retrieves a list of PhotoEntity objects.
	 *
	 * @return the List<PhotoEntity>
	 */
	List<PhotoEntity> getAllThePhotos();

	/**
	 * Gets PhotoEntity from database.
	 *
	 * @param photoId the id
	 *
	 * @return user entity
	 */
	PhotoEntity getById(Long photoId);
}
