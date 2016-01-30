package com.scp.headrecyclerview;

/**
 * Demo
 */
public class Demo {
    private Class<?> activityClass;
    private String title;

    public Demo(Class<?> activityClass, String title) {
        this.activityClass = activityClass;
        this.title = title;
    }

    public Class<?> getActivityClass() {
        return activityClass;
    }

    public void setActivityClass(Class<?> activityClass) {
        this.activityClass = activityClass;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
