package com.amex.qr.zxing.qrCodeWithLogo;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import java.io.File;
import java.io.FileOutputStream;

public class QRCodeWithLogo {

    public static void main(String [] args) throws Exception{

        System.out.println("Writing the QR Code to file");
        QRCode.from("http://amex.ShortURLQRCodeGen").to(ImageType.PNG)
                .withSize(200, 200).
                writeTo(new FileOutputStream(new File("C:\\QRCodes\\NewQRCodeGen.png")));

        System.out.println("Writing the QR Code to file completed");
    }
}
