package devfigas.com.neverlargeexception;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Andre on 18/02/2017.
 */

public class IntentCofiguration {

    public static final int DEFAULT = 0; //static attribute transport. exception: on android N+, try tranditional and migrate for
                                         //static attribute if catch TooLargeException

    public static final int EVER = 1; //every use stattic attribute transport;

    public static final int ACCORDING_SIZE = 2;//use static attribute transpor if objecte is more the large limit
                                                //this is discouraged because other applications can affect that.

    public static final int NEVER = 3;//never use static attribute tranport. ever use traditional transport.

    private int mLimitSize = 1000000;//limit of file. Is used only on ACCORDING_SIZE mode;

    private int mTransportMode = DEFAULT;


    public static final int sizeOf(Object object) {
        if (object == null)return -1;
        ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream =null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            objectOutputStream.close();

            byte[] byteArray = byteArrayOutputStream.toByteArray();


            return byteArray == null ? 0 : byteArray.length;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }



    }

    public int getLimitSize() {
        return mLimitSize;
    }

    public void setLimitSize(int limitSize) {
        mLimitSize = limitSize;
    }

    public int getTransportMode() {
        return mTransportMode;
    }

    public void setTransportMode(int transportMode) {
        mTransportMode = transportMode;
    }
}
