package com.amex.qr.zxing.write;// Java code to generate QR code

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QRCode {

    public static void main(String[] args)
            throws WriterException,
            IOException,
            NotFoundException {

        // The data that the QR code will contain
        String data = "amex://shortURL";

        // The path where the image will get saved
        String path = "C:\\QRCodes\\qrCode.png";

        // Encoding charset
        String charset = "UTF-8";

        Map<EncodeHintType,
                ErrorCorrectionLevel>
                hintMap
                = new HashMap<EncodeHintType,
        ErrorCorrectionLevel>();

        hintMap.put(
                EncodeHintType.ERROR_CORRECTION,
                ErrorCorrectionLevel.L);

        createQR(data, path,
                charset, hintMap,
                200, 200);
        System.out.println(
                "QR Code Generated!!! ");
    }

    // Function to create the QR code
    public static void createQR(
            String data, String path,
            String charset, Map hashMap,
            int height, int width)
            throws WriterException, IOException {

        BitMatrix matrix
                = new MultiFormatWriter().encode(
                new String(
                        data.getBytes(charset),
                        charset),
                BarcodeFormat.QR_CODE, width, height);

        MatrixToImageWriter.writeToStream(matrix,"png",new FileOutputStream(new File(path)));
    }
}
