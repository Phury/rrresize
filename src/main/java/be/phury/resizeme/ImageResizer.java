package be.phury.resizeme;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageResizer {

	private final BufferedImage image;
	
	public ImageResizer(String url) {
		try {
			
			image = ImageIO.read(new URL(url));
			
		} catch (MalformedURLException e) {
			throw new ImageResizeException(e);
		} catch (IOException e) {
			throw new ImageResizeException(e);
		}
	}

	public BufferedImage resize(ResizeQuery query) {
		int imageWidth  = image.getWidth();
	    int imageHeight = image.getHeight();
	    
		double scaleX = query.getScaleX() == null ? (double)query.getWidth()/imageWidth : query.getScaleX();
		double scaleY = query.getScaleY() == null ? (double)query.getHeight()/imageHeight : query.getScaleY();
		
		AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
	    AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);

	    return bilinearScaleOp.filter(
	        image,
	        new BufferedImage((int)(imageWidth*scaleX), (int)(imageHeight*scaleY), image.getType()));
	}

	
}
