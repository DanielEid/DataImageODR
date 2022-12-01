package ScannedImagesController;

import java.io.File;

public class ImageScanned {

    public File imageFile;
    public String dataScanned;

    public File getImageFile() {
        return imageFile;
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }

    public String getDataScanned() {
        return dataScanned;
    }

    public void setDataScanned(String dataScanned) {
        this.dataScanned = dataScanned;
    }

    public ImageScanned() {
    }

    public ImageScanned(File imageFile, String dataScanned) {
        this.imageFile = imageFile;
        this.dataScanned = dataScanned;
    }

    @Override
    public String toString() {
        return "ImageScanned{" +
                "imageFile=" + imageFile +
                ", dataScanned='" + dataScanned + '\'' +
                '}';
    }
}
