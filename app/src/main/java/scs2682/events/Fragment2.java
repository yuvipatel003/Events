package scs2682.events;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by yuvi0 on 2018-03-13.
 */

public class Fragment2 extends Fragment{

    public static final String NAME = Fragment2.class.getSimpleName();
    private TextView text;
    @Nullable

    @Subscribe
    public void onEventBusEvent(NotificationEvent event)
    {
        if(event.tag.equals(NAME))
        {
            text.setText(event.textValue);
        }



    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        text = (TextView) view;
        text.setOnClickListener(v ->{
            EventBus.getDefault().post(new NotificationEvent(NAME,"Fragment 2 was clicked"));
        });
    }

    public void onStart()
    {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
