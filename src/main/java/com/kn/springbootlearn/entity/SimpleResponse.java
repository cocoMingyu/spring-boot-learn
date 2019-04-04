package com.kn.springbootlearn.entity;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/2 20:26
 * @ Modified By:
 */
public class SimpleResponse {
    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
