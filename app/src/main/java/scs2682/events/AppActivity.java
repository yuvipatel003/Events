package scs2682.events;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class AppActivity extends AppCompatActivity {

    public static final String NAME = AppActivity.class.getSimpleName();
    private TextView text;

    @Subscribe
    public void onEventBusEvent(NotificationEvent event)
    {
        text.setText(event.textValue);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appactivity);

        text= findViewById(R.id.text);
        text.setOnClickListener(v->{
            EventBus.getDefault().post(new NotificationEvent(NAME,"Activity was clicked"));
        });

        if(savedInstanceState==null)
        {
            //add fragment when activity just created
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container,new Fragment1())
                    .add(R.id.container,new Fragment2())
                    .add(R.id.container,new Fragment3())
                    .add(R.id.container,new Fragment4())
                    .commit();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
