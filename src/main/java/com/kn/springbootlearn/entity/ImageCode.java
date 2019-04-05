package com.kn.springbootlearn.entity;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/3 11:03
 * @ Modified By:
 */
public class ImageCode extends ValidateCode {
    private BufferedImage image;
    public ImageCode() {
    }

    public ImageCode(BufferedImage image, String code, int expireTime) {
        super(code, expireTime);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
