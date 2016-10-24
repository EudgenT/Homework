package com.company;

import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        LoadImages loadImages = new LoadImages();
        loadImages.setOnLoadListener(new LoadImages.OnLoadListener(){

            @Override
            public void onLoadDone() {
                System.out.println("Load is done");
            }
        });
        new Thread(loadImages){

        }.start();
    }
}
