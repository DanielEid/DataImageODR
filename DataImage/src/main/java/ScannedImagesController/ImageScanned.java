package ScannedImagesController;

import java.io.File;

public class ImageScanned {

    public String imagePath;
    public String dataScanned;

    public String getImageFile() {
        return imagePath;
    }

    public void setImageFile(File imageFile) {
        this.imagePath = imageFile.getName();
    }

    public void setImageFile(String imagePath) {
        this.imagePath = imagePath;
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
        this.imagePath = imageFile.getName();
        this.dataScanned = dataScanned;
    }

    public ImageScanned(String imageFile, String dataScanned) {
        this.imagePath = imageFile;
        this.dataScanned = dataScanned;
    }
    @Override
    public String toString() {
        return "ImageScanned{" +
                "imagePath=" + imagePath +
                ", dataScanned='" + dataScanned + '\'' +
                '}';
    }
}
