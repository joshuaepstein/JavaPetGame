package uk.co.joshepstein.ui.components.animated;

public class LogoAnimation {

	private static final String LOGO_PATH = "src/resources/logo.png";
	private float opacity;
	private float scale;

	public LogoAnimation() {
		this.opacity = 0;
		this.scale = 0.2f;
	}

	public void setOpacity(float newValue) {
		this.opacity = newValue;
	}

	public void setScale(float newValue) {
		this.scale = newValue;
	}

	public float getOpacity() {
		return this.opacity;
	}

	public float getScale() {
		return this.scale;
	}

}
