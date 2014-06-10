package be.phury.resizeme;

import org.apache.commons.lang.StringUtils;

public class ResizeQuery {

	private Double scaleX;
	private Double scaleY;
	private Integer width;
	private Integer height;
	
	public Double getScaleX() {
		return scaleX;
	}
	public ResizeQuery setScaleX(Double scaleX) {
		this.scaleX = scaleX;
		return this;
	}
	public Double getScaleY() {
		return scaleY;
	}
	public ResizeQuery setScaleY(Double scaleY) {
		this.scaleY = scaleY;
		return this;
	}
	public Integer getWidth() {
		return width;
	}
	public ResizeQuery setWidth(Integer width) {
		this.width = width;
		return this;
	}
	public Integer getHeight() {
		return height;
	}
	public ResizeQuery setHeight(Integer height) {
		this.height = height;
		return this;
	}
	
	public ResizeQuery setScaleX(String scaleX) {
		return StringUtils.isEmpty(scaleX) ? this : setScaleX( Double.parseDouble(scaleX) );
	}
	public ResizeQuery setScaleY(String scaleY) {
		return StringUtils.isEmpty(scaleY) ? this : setScaleY( Double.parseDouble(scaleY) );
	}
	public ResizeQuery setWidth(String width) {
		return StringUtils.isEmpty(width) ? this : setWidth( Integer.parseInt(width) );
	}
	public ResizeQuery setHeight(String height) {
		return StringUtils.isEmpty(height) ? this : setHeight( Integer.parseInt(height) );
	}
	public ResizeQuery setScale(String scale) {
		setScaleX(scale);
		return setScaleY(scale);
	}
}
