package com.haohao.kotlintest.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Description :
 *
 * @author Wanderer
 * @date 2020/9/1
 */
public class Animal implements Parcelable {

    private String type;
    private int animalId;
    private int age;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //序列化操作
        dest.writeString(this.type);
        dest.writeInt(this.animalId);
        dest.writeInt(this.age);
    }

    public Animal() {
    }

    protected Animal(Parcel in) {
        this.type = in.readString();
        this.animalId = in.readInt();
        this.age = in.readInt();
    }

    //creator 实现反序列化 静态成员变量
    public static final Parcelable.Creator<Animal> CREATOR = new Parcelable.Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel source) {
            return new Animal(source);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };
}
