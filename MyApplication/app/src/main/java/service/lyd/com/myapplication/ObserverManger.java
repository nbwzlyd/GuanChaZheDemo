package service.lyd.com.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyd10892 on 2016/11/17.
 * 单例模式。观察者管理类
 */

public class ObserverManger {

    private List<ObserverManger.IListener> list = new ArrayList<>();

    /***
     * 私有化构造方法
     */
    private  ObserverManger(){}

    private static class SingleInstance{
        public static ObserverManger INSTANCE = new ObserverManger();
    }

    public static ObserverManger getInstance(){
        return  SingleInstance.INSTANCE;
    }


    /**
     * 注册观察者
     * @param listener
     */
    public void registListeners(IListener listener){
        if (!list.contains(listener)){
            list.add(listener);
        }
    }

    /**
     * 移除观察者
     * @param listener
     */

    public void unRegistListener(IListener listener) {
        if (list.contains(listener)) {
            list.remove(listener);
        }
    }

    /***
     * 通知刷新
     */
    public void notifyOthersChanged(){
        for (IListener listener : list) {
            if (listener != null) {
                listener.notifyDataSetChanged();
            }
        }
    }

    /**
     * 定义接口，通知刷新
     */
    public interface IListener{
        void notifyDataSetChanged();
    }
}
