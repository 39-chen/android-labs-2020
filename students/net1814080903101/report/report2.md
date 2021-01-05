# 实验二 Android组件编程



## 一、实验目标

​	1.在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；

​	2.根据自选题目编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）;

​	3.将标题设置为自己的学号+对应的功能或题目；

​	4.根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容

​	1.创建安卓项目选题；

​	2.根据选题在Android Studio中创建一个或多个Activity；

​	3.实现各个Activity之间的跳转。

## 三、实验步骤

​	1.创建安卓项目选题	![选题](picture/selection.png)

​	2.根据选题创建三个Activity

![创建Activity](picture/create_Activity.png)

​	3.实现各个Activity之间的跳转

​		(1)在activity_net1814080903101.xml中创建按钮

```xml
 <Button
        android:id="@+id/game_start"
        android:layout_width="126dp"
        android:layout_height="70dp"
        android:layout_marginBottom="90dp"
        android:text="@string/game_start"
        android:textSize="60px"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />
```

​	(2)在Net1814080903101Activity.java中加入界面跳转代码

```java
Button startbtn=(Button)findViewById(R.id.game_start);
startbtn.setOnClickListener(new View.OnClickListener() {
	@Override
    public void onClick(View v) {
    	Intent intent = new Intent();
        intent.setClass(Net1814080903101Activity.this, FarmActivity.class);
        startActivity(intent);
        }
    });
```

​	(3)按照相同的方法实现FarmActivity与StoreActivity之间的跳转

```xml
 <Button
        android:id="@+id/toStore"
        android:layout_width="126dp"
        android:layout_height="70dp"
        android:layout_marginBottom="90dp"
        android:text="@string/toStore"
        android:textSize="60px"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />
```

```java
Button storebtn=(Button)findViewById(R.id.toStore);
storebtn.setOnClickListener(new View.OnClickListener() {
	@Override
    public void onClick(View v) {
    	Intent intent = new Intent();
        intent.setClass(FarmActivity.this, StoreActivity.class);
        startActivity(intent);
        }
    });
```



## 四、实验结果

![开始界面](picture/exp2_start.png)

点击后跳转农场界面

![农场界面](picture/exp2_farm.png)

点击后跳转商店界面

![商店界面](picture/exp2_store.png)

## 五、心得体会

​		这次实验有关于安卓组件编程，学习了Activity界面的组成原理和各个界面之间的跳转，难度并不高，运用java语言对按钮设置监听事件，使用intent对象实现了各个见面之间的跳转，完成了这次实验。