package tools;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageTools 
{
	private BufferedImage bufferedImage;
	
	public ImageTools()
	{
		
	}
	
	public ImageIcon loadPlayerImage(int id)
	{
		String path = "/data/playerPictures/"+id+".jpeg";
		ImageIcon image = null;
		
		try 
		{
			URL url = getClass().getResource(path);
			if (url != null)
			{
				bufferedImage = ImageIO.read(url);
				image = new ImageIcon(bufferedImage);
			}	
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return image;
	}
}
