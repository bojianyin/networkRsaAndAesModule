package com.network;

import rx.Observer;

public abstract class CommonObserver<T> implements Observer<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        onFail(e);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    public abstract void onSuccess(T response);
    public abstract void onFail(Throwable t);
}
