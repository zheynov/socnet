package by.zheynov.socnet.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * PhotoCreationOnHDD clas.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.utils
 */
@Component("photoCreationOnHDD")
public class PhotoCreationOnHDD
{
	/**
	 * Creastes photo on HDD.
	 *
	 * @param photo the MultipartFile
	 *
	 * @return the namePicture
	 */
	public UUID createPhotoOnHDD(final MultipartFile photo)
	{
		final String pathToFile = System.getProperty("user.home");
		UUID namePicture = UUID.randomUUID();

		File destination = new File(pathToFile + "/photo/" + namePicture + ".jpg");

		BufferedImage imageIO;
		try
		{
			photo.transferTo(destination);
			imageIO = ImageIO.read(destination);
			ImageIO.write(imageIO, "jpg", destination);
		}
		catch (IOException e)
		{
			System.out.println("ALERT!!!");
		}
		return namePicture;
	}
}