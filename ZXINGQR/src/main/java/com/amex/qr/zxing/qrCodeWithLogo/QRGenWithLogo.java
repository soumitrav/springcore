package com.amex.qr.zxing.qrCodeWithLogo;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

public class QRGenWithLogo {

    private final String DIR = "C:\\QRCodes\\";
    private final String ext = ".png";
    private final String LOGO = "C:\\QRCodes\\twitter.png";
    private final String CONTENT = "Amex Shot URL";
    private final int WIDTH = 300;
    private final int HEIGHT = 300;

    public void generate() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        QRCode.from("http://amex.ShortURLQRCodeGen").to(ImageType.PNG)
                .withSize(200, 200).
                writeTo(outputStream);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        BufferedImage qrImage= getOverlyFromStream(inputStream);
        BufferedImage overly = getOverlyFromFile(LOGO);

        int deltaHeight = qrImage.getHeight() - overly.getHeight();
        int deltaWidth = qrImage.getWidth() - overly.getWidth();

        // Initialize combined image
        BufferedImage combined = new BufferedImage(qrImage.getHeight(), qrImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) combined.getGraphics();

        // Write QR code to new image at position 0/0
        g.drawImage(qrImage, 0, 0, null);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        // Write logo into combine image at position (deltaWidth / 2) and
        // (deltaHeight / 2). Background: Left/Right and Top/Bottom must be
        // the same space for the logo to be centered
        g.drawImage(overly, (int) Math.round(deltaWidth / 2), (int) Math.round(deltaHeight / 2), null);

        // Write combined image as PNG to OutputStream
        ImageIO.write(combined, "png", os);
        // Store Image
        Files.copy(new ByteArrayInputStream(os.toByteArray()), Paths.get(DIR + "QRCodewithLogo" + ext), StandardCopyOption.REPLACE_EXISTING);
    }

    private BufferedImage getOverlyFromStream(ByteArrayInputStream stream) throws IOException {
        return ImageIO.read(stream);
    }

    private BufferedImage getOverlyFromFile(String LOGO) throws IOException {
        return ImageIO.read(new File(LOGO));
    }
    private String generateRandoTitle(Random random, int length) {
        return random.ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public static void main(String []args) throws IOException {
        new QRGenWithLogo().generate();
    }
}
