package be.phury.resizeme;

import static spark.Spark.get;
import static spark.Spark.setPort;

import java.awt.image.BufferedImage;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * A REST server to resize images on the fly.
 */
public class ResizemeServer {

	public static void main(String[] args) {
		new ResizemeServer();
	}
	
	/**
	 * Starts the server instance.
	 */
	public ResizemeServer() {
		
		/* get the port from env properties for heroku */
		setPort(Integer.parseInt(System.getenv("PORT")));
		
		get(new Route("/resize") {
			@Override
			public Object handle(Request request, Response response) {
				final String url = request.queryParams("url");
				final ResizeQuery query = new ResizeQuery()
					.setScale(request.queryParams("scale"))
					.setScaleX(request.queryParams("scaleX"))
					.setScaleY(request.queryParams("scaleY"))
					.setWidth(request.queryParams("width"))
					.setHeight(request.queryParams("height"));
				
				final BufferedImage scaledImage = new ImageResizer(url).resize(query);
				new ResizeImageResponse(scaledImage).writeTo(response);
				return null;
			}
		});
	}
}
