package scs2682.events;

/**
 * Created by yuvi0 on 2018-03-13.
 */

public class NotificationEvent {

    public  final String textValue;
    public final String tag;

    public NotificationEvent(String tag,String textValue)
    {
        this.tag=tag;
        this.textValue=textValue;
    }
}
