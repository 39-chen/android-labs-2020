# 实验二：Android组件编程

## 一、实验要求

- 在Issues中创建自己的选题：[https://github.com/hzuapps/android-labs-2020/issues](https://github.com/hzuapps/android-labs-2020/issues) 
- 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）
- 将标题设置为自己的学号+对应的功能或题目
- 根据自己选择的题目实现Activity中导航、调用等功能（选做）

## 二、实验内容

- 根据功能创建相应的Activity
- 编写Activity对应的布局文件
- 实现各个Activity之间的跳转

## 三、实验步骤

- 创建 Net1814080903321Activity(主界面)、ShowActivity(菜单界面)、StoreActivity(商店界面)
- 在布局文件中创建 Button 组件
- 为 Button 添加点击事件处理
- 通过 startActivity(i) 实现界面跳转

```java
public class Net1814080903321Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903321);



        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Net1814080903321Activity.this, StoreActivity.class);
                startActivity(i);
            }
        });
    }
}
```

```java
public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
    }
}
```

```java
public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StoreActivity.this, ShowActivity.class);
                startActivity(i);
            }
        });
    }
} 
```

- 将创建的 Activity 注册到 AndroidManifest.xml 中；

```xml
        <activity android:name=".ShowActivity" />
        <activity android:name=".StoreActivity" />
        <activity android:name=".Net1814080903321Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```

## 四、实验结果

![应用首页](https://github.com/Classic-Z/android-labs-2020/blob/master/students/net1814080903321/2.jpg)  
首页添加按钮运行结果截图

## 五、实验心得

本次实验学习了使用 startActivity(i) 去实现界面跳转，并且使用按钮onclick方法触发跳转，实验难度也不高，上课时老师演示过后，练习好就可以顺利完成这次实验了。
