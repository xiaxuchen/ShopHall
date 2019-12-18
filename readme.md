# 项目基础框架

## 专业名词

- 配置文件

AndroidManifest.xml文件



## 项目结构

**ShopHall**

\------------------- **app** 项目的入口，一般只在AndroidManifest.xml中配置入口activity

\------------------- **autoupdate** 自动更新组件，可以简单的完成项目的版本更新功能

\------------------- **context** 全局的上下文管理

\------------------- **httplib** 网络请求组件

\------------------- **joint** 组件整合库，业务组件依赖此组件

\------------------- **mvpbase** mvp模式的基本封装

\------------------- **utils** 工具类集



## 各模块介绍

- context

内含BaseApplication、ContextManager两个核心组件，ContextManager将在BaseApplication获取Context并一直持有，

用户需要在配置文件配置application的name属性，如下:

```xml
	    <application
        android:name="com.cxyz.context.application.BaseApplication"></application>
```

配置以后你就可以在项目中使用ContextManager.getContext()来获取Application的上下文了



- utils

其中有一些较为实用的工具类，如GsonUtil、ImageLoaderManager、

SpUtil、ToastUtil、ExitActivityUtil，方法不多可以直接看源码

- mvpbase 有MVP模式相关的基类、接口

  - IBaseModel 

  所有Model的父类，**必须继承**，用于访问数据，如访问数据库、访问服务器、访问文件等，通过回调的方式返回数据给Presenter层

  - IBaseView

  所有View接口的父接口,**必须继承**，Activity实现自定义的子接口，主要用于视图的更新，由Presenter进行调用

  - IBasePresenter<M,V>

  所有Presenter的父类，**必须继承**,其中的**泛型**M和V分别是IBaseModel和IBaseView的子类和子接口

  - BaseActivity\<P>

  所有Activity的基类，实现了MVP模式的接口绑定和一些规范.其中泛型为IBasePresenter的子类.

  以下是较为重要的方法：

  ```java
  public abstract class BaseActivity<p extends IBasePresenter> extends AppCompatActivity implements IBaseView {
      
  
      /**
       * 获取布局，可以是View类型也可以是布局id，如果都不是则抛出异常
       */
      protected abstract Object getContentView();
      
      /**
       * 在setEvent之后调用
       */
      protected  void afterInit(){}
  
  
      /**
       * 在setContentView方法后紧接着调用
       */
      protected void afterSetContent() {
      }
      
  
   
  
      /**
       * 在此方法中进行一些初始化view的操作
       */
      public abstract void initView();
  
      /**
       * 在此方法中进行一些初始化数据的操作
       */
      public abstract void initData();
  
      /**
       * 在此方法中设置事件
       */
      public abstract  void setEvent();
  
  
  
      /**
       * 是否设置标题栏
       * 默认不显示，重写该方法来选择是否显示
       * @return
       */
      protected boolean isShowTitle() {
          return false;
      }
  
  
      /**
       * 设置是否全屏
       * 默认不全屏，重写该方法来选择是否显示
       */
      protected boolean isFullScreen() {
          return false;
      }
  
      /**
       * 设置是否竖屏
       * 默认竖屏屏，重写该方法来选择
       */
      protected boolean isScreenRotate()
      {
          return true;
      }
  
      /***
       * 设置是否使用沉浸式状态栏
       * 默认为使用，重写该方法来选择是否使用
       */
      protected boolean isStateBar()
      {
          return true;
      }
  
  
      
      /**
       * 设置你的IPresenter为返回值，生命周期方法会被自动调用
       * @return
       */
      protected abstract  p createIPresenter();
      
  
      /**
       * 当由其他组件跳转并需要根据intent带来的数据显示view时调用
       * @param intent 跳转时所用的
       */
      protected void handleIntent(Intent intent) { }
      
      
  }
  ```

  

  注意，继承BaseActivity后无需重写onCreate也尽量不要重写，因为其中有很多模板代码，一旦没有调用super.onCreate则会出现问题.你可以仔细看看上述方法注释和示例

  - BaseFragment同上

  具体示例参照app模块下的TestActivity的实现



- joint 

用于管理公共依赖，所有业务逻辑模块都要继承此组件

## 组件化

**集成模式**:业务模块为library，app入口模块依赖于业务libarary，且只有app模块可运行(也就是运行整个项目)

**单模块模式**:业务模块为application，可单独运行，调试起来比集成模式快

当业务模块需要进行单模块调试时，只需把gradle.properties文件中的isDebug修改为true即可，当前module将成为一个application，可以单独运行。

注意，集成模式和单模块模式使用的配置文件不同，单模块调试时配置文件在src/main/debug/AndroidManifest.xml，而集成模式在配置文件在src/main/release/AndroidManifest.xml中

