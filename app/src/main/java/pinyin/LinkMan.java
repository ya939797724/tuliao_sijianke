package pinyin;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class LinkMan implements MultiItemEntity {
    //联系人
    public static final int ISLINKMAN = 0;
    //字母
    public static final int ISLETTER = 1;

    private String name;
    private String phoneNum;
    //默认为联系人
    private int type = ISLINKMAN;
    private boolean isOnLine = true;

    public LinkMan(String name, String phoneNum,boolean isOnLine) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.isOnLine = isOnLine;
    }

    public LinkMan(String name,int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public boolean isOnLine() {
        return isOnLine;
    }

    public void setOnLine(boolean onLine) {
        isOnLine = onLine;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getItemType() {
        return type;
    }
}
