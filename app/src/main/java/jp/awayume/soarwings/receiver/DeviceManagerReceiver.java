package jp.awayume.soarwings.receiver;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;


/**
 * The device admin receiver.
 *
 * @author Awayume <dev@awayume.jp>
 * @since 0.1
 */
public class DeviceManagerReceiver extends DeviceAdminReceiver {
    @Override
    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);
    }
}
