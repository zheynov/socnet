package by.zheynov.socnet.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.zheynov.socnet.dao.PhotoDao;
import by.zheynov.socnet.entity.PhotoEntity;

/**
 * PhotoDaoImpl class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */
@Repository("photoDao")
@Transactional
public class PhotoDaoImpl extends AbstractBaseDAO implements PhotoDao
{
	private static final String GET_ALL_PHOTOS_QUERY = "FROM PhotoEntity WHERE profileID = :profileID";

	/**
	 * Saves.
	 *
	 * @param photoEntity the entity
	 *
	 * @return the entity
	 */
	@Override
	public PhotoEntity createPhoto(final PhotoEntity photoEntity)
	{
		super.save(photoEntity);
		return photoEntity;
	}

	/**
	 * Updates.
	 *
	 * @param photoEntity the entity
	 */
	@Override
	public void updatePhoto(final PhotoEntity photoEntity)
	{
		super.udate(photoEntity);
	}

	/**
	 * Deletes.
	 *
	 * @param photoEntity the entity
	 */
	@Override
	public void deletePhoto(final PhotoEntity photoEntity)
	{
		super.delete(photoEntity);
	}

	/**
	 * Retrieves a list of PhotoEntity objects.
	 *
	 * @param profileID the id
	 *
	 * @return the List<PhotoEntity>
	 */
	@Override
	public List<PhotoEntity> getAllThePhotos(final Long profileID)
	{
		Query query = super.getCurrentSession().createQuery(GET_ALL_PHOTOS_QUERY);
		query.setParameter("profileID", profileID);
		return query.list();
	}

	/**
	 * Gets PhotoEntity from database.
	 *
	 * @param photoId the id
	 *
	 * @return user entity
	 */
	@Override
	public PhotoEntity getById(final Long photoId)
	{
		return (PhotoEntity) super.getById(PhotoEntity.class, photoId);
	}
}