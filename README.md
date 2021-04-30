# XToast
XToast是一个Toast封装组件

## how to use

1. app/build.gradle 配置如下：
   
   ```
   dependencies {
       ...
   
       implementation 'io.github.yueliangrensheng:xtoast:1.0.2'
   }
   ```

   
2. init

在Application or Activity 的 onCreate()方法调用如下方法：

```
//init
XToast.init(context);

```

2.1 init with Config (optional)

```
//
IConfig iConfig = new IConfig();
iConfig.backgroundResId = R.drawable.ic_launcher_background;//设置Toast background 
XToast.init(this, iConfig);
```

3. use
```

String message = "I'm a Toast";
XToast.show(message);


//set Gravity  (default: Gravity.Bottom)
XToast.show(message, Gravity.CENTER);


//set ResID
int msgResId = R.string.app_name;
XToast.show(msgResId);

```