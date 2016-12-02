package by.zheynov.socnet.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import by.zheynov.socnet.dto.PhotoDTO;
import by.zheynov.socnet.entity.PhotoEntity;

/**
 * PhotoDTOReverseConverter class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */
@Component
public class PhotoDTOReverseConverter implements Converter<PhotoDTO, PhotoEntity>
{

	@Override
	public PhotoEntity convert(final PhotoDTO photoDTO)
	{

		if (photoDTO == null)
		{
			return null;
		}

		PhotoEntity photoEntity = new PhotoEntity();

		photoEntity.setId(photoDTO.getId());
		photoEntity.setPhotoFileName(photoDTO.getPhoto().getName());

		return photoEntity;
	}
}