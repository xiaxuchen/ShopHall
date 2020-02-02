package com.cxyz.relative.base.ext

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.cxyz.relative.base.exception.NetException
import com.cxyz.relative.base.rx.BaseFunc
import com.cxyz.relative.base.rx.BaseFuncBoolean
import com.cxyz.relative.base.rx.BaseSubscriber
import com.cxyz.utils.ImageLoaderManager
import com.cxyz.relative.base.data.protocol.BaseResp
import com.kotlin.base.widgets.DefaultTextWatcher
import com.trello.rxlifecycle3.LifecycleProvider
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

//Kotlin通用扩展


fun ObservableEmitter<*>.error(info:String) {
    this.onError(NetException(info))
}

/*
    扩展Observable执行
 */
fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>,lifecycleProvider: LifecycleProvider<*>) {
    this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        .compose(lifecycleProvider.bindToLifecycle())
        .subscribe(subscriber)
}

/*
    扩展数据转换
 */
fun <T> Observable<BaseResp<T>>.convert():Observable<T>{
    return this.flatMap(BaseFunc())
}

/*
    扩展Boolean类型数据转换
 */
fun <T> Observable<BaseResp<T>>.convertBoolean():Observable<Boolean>{
    return this.flatMap(BaseFuncBoolean())
}

/*
    扩展点击事件
 */
fun View.onClick(listener:View.OnClickListener):View{
    setOnClickListener(listener)
    return this
}

/*
    扩展点击事件，参数为方法
 */
fun View.onClick(method:() -> Unit):View{
    setOnClickListener { method() }
    return this
}

/*
    扩展Button可用性
 */
fun Button.enable(et:EditText,method: () -> Boolean){
    val btn = this
    et.addTextChangedListener(object : DefaultTextWatcher(){
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}

/*
    ImageView加载网络图片
 */
fun ImageView.loadUrl(url: String) {
    ImageLoaderManager.getInstance().displayImage(this,url)
}


/*
    扩展视图可见性
 */
fun View.setVisible(visible:Boolean){
    this.visibility = if (visible) View.VISIBLE else View.GONE
}
