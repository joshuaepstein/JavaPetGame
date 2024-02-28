package uk.co.joshepstein.texture;

import java.awt.*;

public interface ITextureable {

    String getTexturePath();

    Image getTexture();

    void setTexture(Image texture);

    void setTexturePath(String texturePath);

    void loadTexture();

    Image getOrLoadTexture();

}
