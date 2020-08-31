package com.amex.qr.zxing.write;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AQRGenWrite {
    public static void main(String [] args) throws Exception{

        System.out.println("Writing the QR Code to file");
        QRCode.from("http://amex.ShortURLQRCodeGen").to(ImageType.PNG)
                .withSize(200, 200).
                        writeTo(new FileOutputStream(new File("C:\\QRCodes\\NewQRCodeGen.png")));
        System.out.println("Writing the QR Code to file completed");
    }
}
