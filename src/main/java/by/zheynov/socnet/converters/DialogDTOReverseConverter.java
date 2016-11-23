package by.zheynov.socnet.converters;

import org.springframework.core.convert.converter.Converter;

import by.zheynov.socnet.dto.DialogDTO;
import by.zheynov.socnet.entity.DialogEntity;

/**
 * DialogDTOReverseConverter class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */
public class DialogDTOReverseConverter implements Converter<DialogDTO, DialogEntity>
{
	public DialogEntity convert(final DialogDTO source)
	{
		return null;
	}
}