package by.zheynov.socnet.dao;

import java.util.List;

import by.zheynov.socnet.entity.PhotoEntity;

/**
 * PhotoDao interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */
public interface PhotoDao
{
	/**
	 * Saves.
	 *
	 * @param photoEntity the entity
	 *
	 * @return the entity
	 */
	PhotoEntity createPhoto(PhotoEntity photoEntity);

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
	 * @param profileID the id
	 *
	 * @return the List<PhotoEntity>
	 */
	List<PhotoEntity> getAllThePhotos(Long profileID);

	/**
	 * Gets PhotoEntity from database.
	 *
	 * @param photoId the id
	 *
	 * @return user entity
	 */
	PhotoEntity getById(Long photoId);
}