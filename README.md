# 闪屏

本例只要设置图片就行了，指示器、ViewPage页都是自动添加的。这样在以后升级版本时，如果引导页数目发生变动，只需要替换图片就行了。

Demo的流程是：闪屏->引导页->主页
 
功能简介：
 * 1、闪屏
  *    1.1、渐变的透明度；
  *    1.2、判断网络，无网络弹出对话框设置网络；
  *    1.3、判断是否第一次进入，仅第一次进入时进入引导页。
 * 2、引导页
  *    2.1、全自动的添加page页和指示器，只需要设置显示的图片即可，方便了后期维护；
  *    2.2、自动创建桌面快捷方式；到最后一页自动添加按钮。
 * 3、主页：清除配置
 
知识点：
 * 1、ViewPage适配器
 * 2、创建快捷方式的类
 * 3、主页
 * 4、闪屏
 * 5、网络管理
 * 6、配置管理
 * 7、引导页

![rotate](https://github.com/ykmeory/SplashScreen/blob/master/img_folder/slpash_rotate.jpg "rotate")
&nbsp;&nbsp;&nbsp;
![ad](https://github.com/ykmeory/SplashScreen/blob/master/img_folder/ad.jpg "ad")
&nbsp;&nbsp;&nbsp;
![guide](https://github.com/ykmeory/SplashScreen/blob/master/img_folder/guide.jpg "guide")
&nbsp;&nbsp;&nbsp;
![main](https://github.com/ykmeory/SplashScreen/blob/master/img_folder/main.jpg "main")
&nbsp;&nbsp;&nbsp;
![transparent](https://github.com/ykmeory/SplashScreen/blob/master/img_folder/slpash_alpha_transparent.jpg "transparent")
&nbsp;&nbsp;&nbsp;
![opaque](https://github.com/ykmeory/SplashScreen/blob/master/img_folder/slpash_alpha_opaque.jpg "opaque")
&nbsp;&nbsp;&nbsp;
