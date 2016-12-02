package by.zheynov.socnet.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import by.zheynov.socnet.dto.PhotoDTO;
import by.zheynov.socnet.entity.PhotoEntity;

/**
 * PhotoDTOConverter class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */
@Component
public class PhotoDTOConverter implements Converter<PhotoEntity, PhotoDTO>
{
	@Override
	public PhotoDTO convert(final PhotoEntity photoEntity)
	{
		if (photoEntity == null)
		{
			return null;
		}

		PhotoDTO photoDTO = new PhotoDTO();

		photoDTO.setId(photoEntity.getId());
		photoDTO.setPhotoFileName(photoEntity.getPhotoFileName());

		return photoDTO;
	}
}