package be.phury.resizeme;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.eclipse.jetty.http.HttpStatus;

import spark.Response;

public class ResizeImageResponse {

	private final BufferedImage image;
	
	public ResizeImageResponse(BufferedImage image) {
		this.image = image;
	}

	public void writeTo(Response response) {
		try {
			
			response.type("image/jpeg");
			response.status(HttpStatus.OK_200);
			ImageIO.write(image, "jpg", response.raw().getOutputStream());
			
		} catch (IOException e) {
			throw new ImageResizeException(e);
		}
	}

}
