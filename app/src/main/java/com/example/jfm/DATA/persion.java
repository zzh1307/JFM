package com.example.jfm.DATA;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by 吴彦祖 on 2018/9/21.
 */

public class persion extends BmobObject {
    String Name,ID,Info,Level,GatherTime;
    BmobFile IDPhoto,NowPhoto;

    public String getGatherTime() {
        return GatherTime;
    }

    public void setGatherTime(String gatherTime) {
        GatherTime = gatherTime;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public BmobFile getIDPhoto() {
        return IDPhoto;
    }

    public void setIDPhoto(BmobFile IDPhoto) {
        this.IDPhoto = IDPhoto;
    }

    public BmobFile getNowPhoto() {
        return NowPhoto;
    }

    public void setNowPhoto(BmobFile nowPhoto) {
        NowPhoto = nowPhoto;
    }
}
