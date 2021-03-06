package by.zheynov.socnet.facade;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import by.zheynov.socnet.dto.PhotoDTO;

/**
 * PhotoFacade interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade
 */
public interface PhotoFacade
{
	/**
	 * Saves.
	 *
	 * @param photo    the photo
	 * @param photoDTO the dto
	 */
	void createPhoto(PhotoDTO photoDTO, MultipartFile photo);

	/**
	 * Updates.
	 *
	 * @param photoDTO the dto
	 */
	void updatePhoto(PhotoDTO photoDTO);

	/**
	 * Deletes.
	 *
	 * @param photoDTO the dto
	 */
	void deletePhoto(PhotoDTO photoDTO);

	/**
	 * Retrieves a list of PhotoDTO objects.
	 *
	 * @param profileID the id
	 *
	 * @return the List<PhotoDTO>
	 */
	List<PhotoDTO> getAllThePhotos(Long profileID);

	/**
	 * Gets PhotoDTO from database.
	 *
	 * @param photoId the id
	 *
	 * @return user dto
	 */
	PhotoDTO getById(Long photoId);
}