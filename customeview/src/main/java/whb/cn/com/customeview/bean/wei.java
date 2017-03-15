package whb.cn.com.customeview.bean;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.RemoteViews;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.customeview.bean.wei.java
 * @author: 魏红彬
 * @e-mail: weihongbin@t-tron.com
 * @date: 2017-03-15 10:19
 */

public class wei extends weihb {
    private static final String TAG = "wei";

    static class InClass {
        public static final void show() {
            System.out.print("2323");
        }

    }

    @Override
    void mi() {

    }

    @Override
    public void requestLayout() {

    }

    @Override
    public boolean isLayoutRequested() {
        return false;
    }

    @Override
    public void requestTransparentRegion(View view) {

    }

    @Override
    public void invalidateChild(View view, Rect rect) {

    }

    @Override
    public ViewParent invalidateChildInParent(int[] ints, Rect rect) {
        return null;
    }

    @Override
    public ViewParent getParent() {
        return null;
    }

    @Override
    public void requestChildFocus(View view, View view1) {

    }

    @Override
    public void recomputeViewAttributes(View view) {

    }

    @Override
    public void clearChildFocus(View view) {

    }

    @Override
    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        return false;
    }

    @Override
    public View focusSearch(View view, int i) {
        return null;
    }

    @Override
    public void bringChildToFront(View view) {

    }

    @Override
    public void focusableViewAvailable(View view) {

    }

    @Override
    public boolean showContextMenuForChild(View view) {
        return false;
    }

    @Override
    public boolean showContextMenuForChild(View view, float v, float v1) {
        return false;
    }

    @Override
    public void createContextMenu(ContextMenu contextMenu) {

    }

    @Override
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        return null;
    }

    @Override
    public void childDrawableStateChanged(View view) {

    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean b) {

    }

    @Override
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean b) {
        return false;
    }

    @Override
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override
    public void childHasTransientStateChanged(View view, boolean b) {

    }

    @Override
    public void requestFitSystemWindows() {

    }

    @Override
    public ViewParent getParentForAccessibility() {
        return null;
    }

    @Override
    public void notifySubtreeAccessibilityStateChanged(View view, View view1, int i) {

    }

    @Override
    public boolean canResolveLayoutDirection() {
        return false;
    }

    @Override
    public boolean isLayoutDirectionResolved() {
        return false;
    }

    @Override
    public int getLayoutDirection() {
        return 0;
    }

    @Override
    public boolean canResolveTextDirection() {
        return false;
    }

    @Override
    public boolean isTextDirectionResolved() {
        return false;
    }

    @Override
    public int getTextDirection() {
        return 0;
    }

    @Override
    public boolean canResolveTextAlignment() {
        return false;
    }

    @Override
    public boolean isTextAlignmentResolved() {
        return false;
    }

    @Override
    public int getTextAlignment() {
        return 0;
    }

    @Override
    public boolean onStartNestedScroll(View view, View view1, int i) {
        return false;
    }

    @Override
    public void onNestedScrollAccepted(View view, View view1, int i) {

    }

    @Override
    public void onStopNestedScroll(View view) {

    }

    @Override
    public void onNestedScroll(View view, int i, int i1, int i2, int i3) {

    }

    @Override
    public void onNestedPreScroll(View view, int i, int i1, int[] ints) {

    }

    @Override
    public boolean onNestedFling(View view, float v, float v1, boolean b) {
        return false;
    }

    @Override
    public boolean onNestedPreFling(View view, float v, float v1) {
        return false;
    }

    @Override
    public boolean onNestedPrePerformAccessibilityAction(View view, int i, Bundle bundle) {
        return false;
    }
}