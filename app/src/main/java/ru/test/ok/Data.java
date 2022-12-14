package ru.test.ok;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.Nullable;

public class Data {
    public static final int UNDEFINED_ID;

    private long _id;

    private String fn;
    private String sn;
    private String phn;
    private String age;

    static {
        UNDEFINED_ID = -1;
    }

    public Data(String fn, String sn, String phn) {
        this._id = UNDEFINED_ID;
        this.fn = fn;
        this.sn = sn;
        this.phn = phn;
        int ageLiteral = (int) (Math.random() * 900 + 100);
        this.age = String.valueOf(ageLiteral);
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(this);
    }

    public void set_id(long id) {
        this._id = id;
    }

    public long get_id() {
        return _id;
    }
    public void setFn(String fn) {
        this.fn = fn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String getFn() {
        return fn;
    }

    public String getSn() {
        return sn;
    }

    public String getPhn() {
        return phn;
    }

    public String  getAge() {
        return age;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Data guest = (Data) obj;
        return
                fn.equals(guest.getFn())
                        && sn.equals(guest.getSn())
                        && phn.equals(guest.getPhn())
                        && age.equals( guest.getAge())
                        && _id == guest.get_id();
    }
}
