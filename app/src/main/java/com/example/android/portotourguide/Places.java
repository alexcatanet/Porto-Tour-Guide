package com.example.android.portotourguide;

/**
 * {@link Places} represents a geographically place that the user wants to know about
 * It contains a mPlaceName, a image resource, and an image icon.
 */
class Places {

    /**
     * Position of a specific place
     */
    private final int mPlaceName;

    /**
     * Image resource ID for the place
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    //Constant value that represents no image was provided for this word
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Image icon resource ID for the place
     */
    private int mImageIcon = NO_IMAGE_PROVIDED_2;

    //Constant value that represents no image was provided for this word
    private static final int NO_IMAGE_PROVIDED_2 = -1;

    /**
     * Create a new Word object.
     *
     * @param placeName       represents a geographically place that the user wants to know about
     * @param imageResourceId is the drawable resource ID for the image associated with the place
     * @param imageIcon       Image icon resource ID for the place
     */
    Places(int placeName, int imageResourceId, int imageIcon) {
        mPlaceName = placeName;
        mImageResourceId = imageResourceId;
        mImageIcon = imageIcon;
    }

    /**
     * Get the place name ID
     */
    int getPlaceName() {
        return mPlaceName;
    }

    /**
     * Return the image resource ID of the place.
     */
    int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Return the image icon resource ID of the place.
     */
    int getImageIcon() {
        return mImageIcon;
    }

    /**
     * Return whether or not there is an image for this item.
     */
    boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Return whether or not there is an image icon for this item.
     */
    boolean hasImage_for_item() {
        return mImageIcon != NO_IMAGE_PROVIDED_2;
    }
}
