package tools;

import java.awt.Color;
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
	public final static Color COLOR_T = new Color(196,173,110);
	public final static Color COLOR_CT = new Color(74,117,181);
	
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
