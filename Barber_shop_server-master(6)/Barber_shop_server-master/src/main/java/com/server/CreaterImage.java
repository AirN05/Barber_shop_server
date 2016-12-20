package com.server;


import java.io.*;

public class CreaterImage {
    public CreaterImage(){
    }

    public static byte[] getImageByte(String image, String path) throws IOException{

        //image=image+".jpg";
        //String path="images/home/"+searchName;
        String workDir = System.getProperty("user.dir");

        File file1 = new File(workDir, path);
        String fullFilename = file1.getAbsolutePath();
        //String fullFilename="C:/Program Files/Apache Software Foundation/Tomcat 7.0/bin/images/home/";
        System.out.println("Полный путь к файлу: " + fullFilename);

        File file=new File(fullFilename);
        ByteArrayOutputStream ous = null;
        InputStream ios = null;
        try {
            byte[] buffer = new byte[4096];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream(file);
            int read = 0;
            while ((read = ios.read(buffer)) != -1) {
                ous.write(buffer, 0, read);
            }
        }finally {
            try {
                if (ous != null)
                    ous.close();
            } catch (IOException e) {
            }

            try {
                if (ios != null)
                    ios.close();
            } catch (IOException e) {
            }
        }

        byte[] photo=ous.toByteArray();
        return photo;
        //response.setContentLength((int) photo.length);
        //ServletOutputStream outStream = response.getOutputStream();
        //outStream.write(photo);
        //outStream.close();
    }
}
