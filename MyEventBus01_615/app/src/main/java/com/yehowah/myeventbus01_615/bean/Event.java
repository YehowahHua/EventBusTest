package com.yehowah.myeventbus01_615.bean;


/**
 * 对事件封装，传入一个泛型T,表示具体的事件类
 * @param <T>
 */
public class Event<T>{
    /**
     * 标记码  判断数据来源
     */
    private int tabCode;
    private T data;

    public Event(int tabCode) {
        this.tabCode = tabCode;
    }

    public Event(int tabCode, T data) {
        this.tabCode = tabCode;
        this.data = data;
    }

    public int getTabCode() {
        return tabCode;
    }
    public void setTabCode(int tabCode) {
        this.tabCode = tabCode;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
