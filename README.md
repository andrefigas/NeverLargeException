# NeverLargeException

Android always had limit for transactions via intent. But on version 7.0.0+, there is an RunTime Exception that the transaction is overloaded and crashed application: [TransactionTooLargeException]

### Install

        compile 'waiting sonatype release'

### Sending data

        public static final String INTENT_KEY = "INTENT_KEY";

        SuperIntent superIntent =  new SuperIntent(this, Main2Activity.class);
        IntentTransporter.startActivity(this,
                superIntent.putSuperExtra(INTENT_KEY,myObject)
                        //.putSuperExtra(String,value)
                        //.putSuperExtra(Serializable,value)
                        //.putSuperExtra(Percelable,value)
                        //.putSuperExtra(...,value)
                        .build()
        );

###Receiving Data

         IntentTransporter.getIntent(this).getString(MainActivity.INTENT_KEY);


### Features

  - startActivity (from Activity or Fragment)

         IntentTransporter.startActivity...
  
  - startActivityForResult (from Activity or Fragment)
  
         IntentTransporter.startActivityForResult...
  - configuration

        superIntent.getIntentCofiguration().setTransportMode(...);
        
###Configuration Options

- IntentCofiguration.DEFAULT : Try use traditional mode on android N+, if cauth exception use library implementation
- IntentCofiguration.EVER : Ever use library implementation for transport data
- IntentCofiguration.NEVER :  Use native implementation
- IntentCofiguration.ACCORDING_SIZE : Use library accordin lenth of object

###Prevent error
- Is requiered call once a getIntent after startActivity/startActivityForResult . Aflter called, bundle cleaned is automatically. 

   [TransactionTooLargeException]: <https://developer.android.com/reference/android/os/TransactionTooLargeException.html>
   
   
  
