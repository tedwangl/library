package com.wl.library.enums;

/**
 * Created by peish on 2016/7/19.
 */
public enum NetState {
    NETSTATE_WIFI("0000","wifi"),
    NETSTATE_2G("0001","2G"),
    NETSTATE_3G("0002","3G"),
    NETSTATE_4G("0003","4G"),
    NETSTATE_5G("0004","4G"),
    NETSTATE_NONE("0004","NONE");

    private String code;
    private String desc;

    private NetState(String code, String desc){
        this.code=code;
        this.desc=desc;
    }

    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getDesc() {
        return desc;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }





    public static NetState getNetTypes(String value) {
        if (value != null) {
            for (NetState nameEnum : values()) {
                if (nameEnum.getCode().equals(value)) {
                    return nameEnum;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return code+desc;
    }
}
