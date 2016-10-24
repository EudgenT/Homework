package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadImages implements Runnable {

    interface OnLoadListener {
        void onLoadDone();
    }

    private OnLoadListener onLoadListener = null;

    public OnLoadListener getOnLoadListener() {
        return onLoadListener;
    }

    public void setOnLoadListener(OnLoadListener onLoadListener) {
        this.onLoadListener = onLoadListener;
    }

    protected BufferedImage image = null;
    protected URL url = new URL("http://minionomaniya.ru/wp-content/uploads/2016/01/minionLogo.jpg");

    public LoadImages() throws MalformedURLException {
    }

    @Override
    public void run() {
        try {
            image = ImageIO.read(url);
            if (image != null) {
                ImageIO.write(image, "jpg", new File("C:\\Users\\eudge_000\\Desktop\\image.jpg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (onLoadListener != null) {
            onLoadListener.onLoadDone();
        }
    }
}
