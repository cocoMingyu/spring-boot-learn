package com.kn.springbootlearn.component.properties;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/3 12:22
 * @ Modified By:
 */
public class ValidateCodeProperties {
    private ImageCodeProperties image=new ImageCodeProperties();

    private SmsCodeProperties sms=new ImageCodeProperties();

    public SmsCodeProperties getSms() {
        return sms;
    }

    public void setSms(SmsCodeProperties sms) {
        this.sms = sms;
    }

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }
}
