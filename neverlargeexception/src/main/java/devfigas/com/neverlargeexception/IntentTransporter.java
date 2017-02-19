package devfigas.com.neverlargeexception;

import android.os.Build;
import android.os.Bundle;
import android.os.TransactionTooLargeException;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

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
public class IntentTransporter {

    private static SuperIntent sSuperIntent ;
    public static void startActivityForResult(AppCompatActivity from, SuperIntent superIntent, RuntimeException runtimeException,
                                              int requestCode){
        if(runtimeException==null || runtimeException.getCause() instanceof TransactionTooLargeException){
            sSuperIntent = SuperIntent.receiveForResult(superIntent,from,requestCode);
        }
    }
    public static void startActivity(AppCompatActivity from, SuperIntent superIntent, RuntimeException runtimeException){
        if(runtimeException==null || runtimeException.getCause() instanceof TransactionTooLargeException){
            sSuperIntent = SuperIntent.receive(superIntent,from);
        }
    }
    public static void startActivity(Fragment from, SuperIntent superIntent, RuntimeException runtimeException){
        if(runtimeException==null || runtimeException.getCause() instanceof TransactionTooLargeException){
            sSuperIntent = SuperIntent.receive(superIntent,from);
        }
    }
    public static void startActivityForResult(Fragment from, SuperIntent superIntent, RuntimeException runtimeException, int requestCode){
        if(runtimeException==null || runtimeException.getCause() instanceof TransactionTooLargeException){
            sSuperIntent = SuperIntent.receiveForResult(superIntent,from,requestCode);
        }
    }
    public static void startActivity(AppCompatActivity from, SuperIntent superIntent){
        switch (superIntent.mIntentCofiguration.getTransportMode()){
            case IntentCofiguration.NEVER:
                from.startActivity(superIntent);//only transport using traditional mode
                break;
            case IntentCofiguration.EVER:
                IntentTransporter.startActivity(from,superIntent,null);//only transport using static attribute mode
                break;
            case IntentCofiguration.ACCORDING_SIZE:
                if(IntentCofiguration.sizeOf(superIntent.getBundle())<superIntent.mIntentCofiguration.getLimitSize()){
                    from.startActivity(superIntent);//only transport using static attribute mode if len is validate
                    break;
                }
                //case else, no break:go to IntentCofiguration.DEFAULT case
            case IntentCofiguration.DEFAULT:
                try{
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                        //force exception, because Android N- no call RuntimeException, but cant transport sucess
                        throw  new TransactionTooLargeException();
                    }
                    else from.startActivity(superIntent);
                }
                catch (RuntimeException e){
                    IntentTransporter.startActivity(from,superIntent,e);
                } catch (TransactionTooLargeException e) {
                    IntentTransporter.startActivity(from,superIntent,null);
                }
                break;
        }

    }
    public static void startActivity(Fragment from, SuperIntent superIntent){
        switch (superIntent.mIntentCofiguration.getTransportMode()){
            case IntentCofiguration.NEVER:
                from.startActivity(superIntent);//only transport using traditional mode
                break;
            case IntentCofiguration.EVER:
                IntentTransporter.startActivity(from,superIntent,null);//only transport using static attribute mode
                break;
            case IntentCofiguration.ACCORDING_SIZE:
                if(IntentCofiguration.sizeOf(superIntent.getBundle())<superIntent.mIntentCofiguration.getLimitSize()){
                    from.startActivity(superIntent);//only transport using static attribute mode if len is validate
                    break;
                }
                //case else, no break:go to IntentCofiguration.DEFAULT case
            case IntentCofiguration.DEFAULT:
                try{
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                        //force exception, because Android N- no call RuntimeException, but cant transport sucess
                        throw  new TransactionTooLargeException();
                    }
                    else from.startActivity(superIntent);
                }
                catch (RuntimeException e){
                    IntentTransporter.startActivity(from,superIntent,e);
                } catch (TransactionTooLargeException e) {
                    IntentTransporter.startActivity(from,superIntent,null);
                }
                break;
        }
    }
    public static void startActivityForResult(Fragment from, SuperIntent superIntent, int requestCode){
        switch (superIntent.mIntentCofiguration.getTransportMode()){
            case IntentCofiguration.NEVER:
                from.startActivityForResult(superIntent,requestCode);//only transport using traditional mode
                break;
            case IntentCofiguration.EVER:
                IntentTransporter.startActivity(from,superIntent,null);//only transport using static attribute mode
                break;
            case IntentCofiguration.ACCORDING_SIZE:
                if(IntentCofiguration.sizeOf(superIntent.getBundle())<superIntent.mIntentCofiguration.getLimitSize()){
                    from.startActivityForResult(superIntent,requestCode);//only transport using static attribute mode if len is validate
                    break;
                }
                //case else, no break:go to IntentCofiguration.DEFAULT case
            case IntentCofiguration.DEFAULT:
                try{
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                        //force exception, because Android N- no call RuntimeException, but cant transport sucess
                        throw  new TransactionTooLargeException();
                    }
                    else from.startActivityForResult(superIntent,requestCode);
                }
                catch (RuntimeException e){
                    IntentTransporter.startActivityForResult(from,superIntent,e,requestCode);
                } catch (TransactionTooLargeException e) {
                    IntentTransporter.startActivityForResult(from,superIntent,null,requestCode);
                }
                break;
        }
    }
    public static void startActivityForResult(AppCompatActivity from, SuperIntent superIntent, int requestCode){
        switch (superIntent.mIntentCofiguration.getTransportMode()){
            case IntentCofiguration.NEVER:
                from.startActivityForResult(superIntent,requestCode);//only transport using traditional mode
                break;
            case IntentCofiguration.EVER:
                IntentTransporter.startActivity(from,superIntent,null);//only transport using static attribute mode
                break;
            case IntentCofiguration.ACCORDING_SIZE:
                if(IntentCofiguration.sizeOf(superIntent.getBundle())<superIntent.mIntentCofiguration.getLimitSize()){
                    from.startActivityForResult(superIntent,requestCode);//only transport using static attribute mode if len is validate
                    break;
                }
                //case else, no break:go to IntentCofiguration.DEFAULT case
            case IntentCofiguration.DEFAULT:
                try{
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                        //force exception, because Android N- no call RuntimeException, but cant transport sucess
                        throw  new TransactionTooLargeException();
                    }
                    else from.startActivityForResult(superIntent,requestCode);
                }
                catch (RuntimeException e){
                    IntentTransporter.startActivityForResult(from,superIntent,e,requestCode);
                } catch (TransactionTooLargeException e) {
                    IntentTransporter.startActivityForResult(from,superIntent,null,requestCode);
                }
                break;
        }
    }
    public static Bundle getIntent(AppCompatActivity to){
        if(sSuperIntent!=null){
            Bundle result = (Bundle) sSuperIntent.getBundle().clone();
            sSuperIntent.getBundle().clear();
            sSuperIntent = null;
            return result;
        }else {
            return to.getIntent().getBundleExtra(SuperIntent.EXTRAS);
        }
    }
}
