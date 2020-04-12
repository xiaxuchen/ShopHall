## 自动更新组件使用说明
### 自动更新组件能做什么？
1. 根据指定url下载apk
2. 在状态栏显示当前下载进度
3. 下载完成后更新状态栏，点击即可安装

### 自动更新组件如何使用？
1. 模块依赖自动更新组件
2. 启动service，通过intent传递参数
必填参数:
apkUrl: 下载安装包的链接，(提示，在没有服务器的时候可以通过utools工具测试文件下载)
appName: 应用的名称，下载时在通知栏显示，如果不给会自动去BuildConfig类中查找APP_NAME属性
```java
// android.gradle配置如下，给BuildConfig添加了APP_NAME属性，属性值写在ext.gradle文件中
buildConfigField "String", "APP_NAME", "\"${ rootProject.ext.appName}\""
```
可选参数:
filePath: 文件下载路径，会在路径前添加```Environment.getExternalStorageDirectory()```,
默认```Environment.getExternalStorageDirectory() + "/" + BuildConfig.APPLICATION_ID.replace(".","") + "/AppUpdate/base.apk";```,
也就是在内存卡的包名路径上的AppUpdate文件夹里的base.apk
icon: 通知栏的图标,不传递就是autoupdate模块下的mipmap下的logo.png
smallIcon：通知栏的小图标,不传递就是autoupdate模块下的mipmap下的logo.png
### 自动更新组件不能做的
1. 获取app的更新信息，对更新信息进行判断，决定是否自动更新
原因:不同的app的接口不一定相同，但是可以将这一逻辑封装成工具类放在自动更新组件中，后续可以进行一些尝试

