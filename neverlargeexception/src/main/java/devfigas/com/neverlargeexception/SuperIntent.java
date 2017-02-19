package devfigas.com.neverlargeexception;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;

import java.io.Serializable;
import java.util.ArrayList;

/*Copyright 2017 Andre Figas

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/
public class SuperIntent extends Intent{


    protected static final String EXTRAS = "EXTRAS";
    private Bundle mBundle =  new Bundle();
    protected IntentCofiguration mIntentCofiguration = new IntentCofiguration();

    public SuperIntent() {
        super();
    }
    public SuperIntent(Context context, Class _class) {
        super(context,_class);
    }


    public SuperIntent build(){
        putExtra(EXTRAS,mBundle);
        return this;
    }
    protected static SuperIntent receive(SuperIntent superIntent, Activity from){
        SuperIntent plusIntent = new SuperIntent();
        plusIntent.mBundle = (Bundle) superIntent.getBundle().clone();
        try{
            superIntent.getBundleExtra(EXTRAS).clear();
        }catch (NullPointerException npe){
            throw  new NullPointerException("SuperIntent not builded: call method build() before to try start");
        }
        from.startActivity(superIntent);
        return plusIntent;
    }
    protected static SuperIntent receive(SuperIntent superIntent, Fragment from){
        SuperIntent plusIntent = new SuperIntent();
        plusIntent.mBundle = (Bundle) superIntent.getBundle().clone();
        try{
            superIntent.getBundleExtra(EXTRAS).clear();
        }catch (NullPointerException npe){
            throw  new NullPointerException("SuperIntent not builded: call method build() before to try start");
        }
        from.startActivity(superIntent);
        return plusIntent;
    }
    protected static SuperIntent receiveForResult(SuperIntent superIntent, Activity from, int requestCode){
        SuperIntent plusIntent = new SuperIntent();
        plusIntent.mBundle = (Bundle) superIntent.getBundle().clone();
        try{
            superIntent.getBundleExtra(EXTRAS).clear();
        }catch (NullPointerException npe){
            throw  new NullPointerException("SuperIntent not builded: call method build() before to try start");
        }
        from.startActivityForResult(superIntent,requestCode);
        return plusIntent;
    }
    protected static SuperIntent receiveForResult(SuperIntent superIntent, Fragment from, int requestCode){
        SuperIntent plusIntent = new SuperIntent();
        plusIntent.mBundle = (Bundle) superIntent.getBundle().clone();
        try{
            superIntent.getBundleExtra(EXTRAS).clear();
        }catch (NullPointerException npe){
            throw  new NullPointerException("SuperIntent not builded: call method build() before to try start");
        }
        from.startActivityForResult(superIntent,requestCode);
        return plusIntent;
    }
    public Bundle getBundle() {
        return mBundle;
    }
    public SuperIntent putSuperExtra(String name, String value) {
        mBundle.putString(name, value);
        return this;
    }
    public Intent putSuperExtra(String name, float value) {
        mBundle.putFloat(name, value);
        return this;
    }


    public Intent putSuperExtra(String name, double value) {
        mBundle.putDouble(name, value);
        return this;
    }

    public Intent putSuperExtra(String name, CharSequence value) {
        mBundle.putCharSequence(name, value);
        return this;
    }


    public Intent putSuperExtra(String name, Parcelable value) {
        mBundle.putParcelable(name, value);
        return this;
    }


    public Intent putSuperExtra(String name, Parcelable[] value) {
        mBundle.putParcelableArray(name, value);
        return this;
    }


    public Intent putSuperParcelableArrayListExtra(String name, ArrayList<? extends Parcelable> value) {
        mBundle.putParcelableArrayList(name, value);
        return this;
    }

    public Intent putSuperIntegerArrayListExtra(String name, ArrayList<Integer> value) {
        mBundle.putIntegerArrayList(name, value);
        return this;
    }


    public Intent putSuperStringArrayListExtra(String name, ArrayList<String> value) {
        mBundle.putStringArrayList(name, value);
        return this;
    }


    public Intent putSuperCharSequenceArrayListExtra(String name, ArrayList<CharSequence> value) {
        mBundle.putCharSequenceArrayList(name, value);
        return this;
    }


    public Intent putSuperExtra(String name, Serializable value) {
        mBundle.putSerializable(name, value);
        return this;
    }


    public Intent putSuperExtra(String name, boolean[] value) {
        mBundle.putBooleanArray(name, value);
        return this;
    }


    public Intent putSuperExtra(String name, byte[] value) {
        mBundle.putByteArray(name, value);
        return this;
    }


    public Intent putSuperExtra(String name, short[] value) {
        mBundle.putShortArray(name, value);
        return this;
    }


    public Intent putSuperExtra(String name, char[] value) {
        mBundle.putCharArray(name, value);
        return this;
    }


    public Intent putSuperExtra(String name, int[] value) {
        mBundle.putIntArray(name, value);
        return this;
    }


    public Intent putSuperExtra(String name, long[] value) {
        mBundle.putLongArray(name, value);
        return this;
    }


    public Intent putSuperExtra(String name, float[] value) {
        mBundle.putFloatArray(name, value);
        return this;
    }


    public Intent putSuperExtra(String name, double[] value) {
        mBundle.putDoubleArray(name, value);
        return this;
    }


    public Intent putSuperExtra(String name, String[] value) {
        mBundle.putStringArray(name, value);
        return this;
    }


    public Intent putSuperExtra(String name, CharSequence[] value) {
        mBundle.putCharSequenceArray(name, value);
        return this;
    }


    public Intent putSuperExtra(String name, Bundle value) {
        mBundle.putBundle(name, value);
        return this;
    }

    public SuperIntent setIntentCofiguration(IntentCofiguration intentCofiguration) {
        mIntentCofiguration = intentCofiguration;
        return this;
    }

    public IntentCofiguration getIntentCofiguration() {
        return mIntentCofiguration;
    }
}
