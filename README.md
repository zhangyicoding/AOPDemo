感谢沪江开源的aspect框架，它在AspectJ的基础上新增了kotlin语言和jar、aar的适配。github如下：

https://github.com/HujiangTechnology/gradle_plugin_android_aspectjx


本demo有如下试验：
 - kotlin
 - multidex
 - 组件化，使用ARouter
 - 注解处理器，使用ARouter

不知道为什么，打带签名的release包在手机上安装不成功，先把这个问题记下来。

advice代码在aspect_library模块中，并附带了aspectj的匹配规则。

我注意过AOP带来的性能损耗问题，上网查得知AspectJ的原理属于静态的，编译期对class文件织入advice代码，只是引入了100k左右的微小编译器ajc（个人猜测只是IDE开发环境使用，不会装入apk），并不会使用动态代理或cglib等运行期织入方式，这样确实对性能影响很小。