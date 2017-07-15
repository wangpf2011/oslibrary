package com.wf.circledialog.sample;

/**
 * Created by wangpf on 2017/7/15.
 */

public class PictureType {
    public int id;
    public String typeName;

    public PictureType() {
    }

    public PictureType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }
}
