package ScannedImagesController;

import java.io.File;

public class ImageScanned {

    private String imagePath;
    private String dataScanned;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(File imageFile) {
        this.imagePath = imageFile.getPath();
    }

    public void setImagePath(String imagePath) {
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
        this.imagePath = imageFile.getPath();
        this.dataScanned = dataScanned;
    }

    public ImageScanned(String imagePath, String dataScanned) {
        this.imagePath = imagePath;
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
