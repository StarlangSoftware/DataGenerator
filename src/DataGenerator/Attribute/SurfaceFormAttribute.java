package DataGenerator.Attribute;

import Classification.Attribute.DiscreteAttribute;

public class SurfaceFormAttribute extends DiscreteAttribute {

    /**
     * Discrete attribute for a given word. Returns the surface form.
     * @param surfaceForm Surface form of the word.
     */
    public SurfaceFormAttribute(String surfaceForm) {
        super(surfaceForm);
    }
}
