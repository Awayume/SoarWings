package jp.awayume.soarwings.service;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;


/**
 * The app install service through Android accessibility.
 *
 * @author Awayume <dev@awayume.jp>
 * @since 0.1
 */
public class ApplicationInstallAccessibilityService extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {}

    @Override
    public void onInterrupt() {}
}
