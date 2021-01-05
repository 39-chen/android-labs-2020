# 一、实验目的

1. 根据选题要求设计界面布局及控件使用  
2. 布局xml及界面控制操作代码提交并截图  
3. 将应用运行结果截图  

# 二、实验内容

1. 使用一种布局方式设计界面  
2. 通过控件ID获取界面对象，执行相关操作  
3. 实现界面控件的事件处理  
4. 操作之后，切换到第二个界面  

# 三、实验步骤

1.创建activity_collection.xml、activity_play.xml、activity_search.xml界面文件
2.用 LinearLayout线性布局设计有关界面
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/timg"
    android:orientation="vertical"
    tools:context=".Net1814080903330Activity">
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="100dp"
    android:orientation="horizontal"
    >
    <Button
         android:id="@+id/button2"
       ... />

    <Button
        android:id="@+id/button2"
       .../>

    <Button
        android:id="@+id/button3"
        ... />
</LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:orientation="vertical">

    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:orientation="horizontal">
        <Button
            android:id="@+id/button4"
            ...
            />

        <Button
            android:id="@+id/button5"
            .../>

        <Button
            android:id="@+id/button6"
           .../>


    </LinearLayout>
</LinearLayout>

```
3.调试CollectionActivity.java、SearchActivity.javad的页面按钮转跳是否正常运转

# 四、实验结果



# 五、实验心得

布局设计写的有点复杂，竖直嵌套和水平嵌套来回调换，调试了很多次才达到理想的位置，总体设计花的时间不是特别多，但是收获很大。
