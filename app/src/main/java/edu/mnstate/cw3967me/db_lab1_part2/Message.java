package edu.mnstate.cw3967me.db_lab1_part2;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by marikonoguchi on 11/4/16.
 */
public class Message {
    public static void message(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
