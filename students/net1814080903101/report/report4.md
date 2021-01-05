# 实验四 Android界面设计编程



## 一、实验目标

​	1.根据选题要求设计界面布局及控件使用；

​	2.布局xml及界面控制操作代码提交并截图；

​	3.将应用运行结果截图。

## 二、实验内容

​	1.使用其中一种布局方式，设计所选题目界面；

​	2.通过控件ID获取界面对象，执行相关操作；

​	3.实现界面控件的事件处理；

​	4.操作之后，切换到你的第二个界面。

## 三、实验步骤

​	1.设计开始游戏界面

​		开始游戏界面内容较少，使用了LinearLayout流式布局，并添加了背景图片，三个子控件按从上而下布局，使用android:layout_marginLeft控制子控件与屏幕左侧的距离，用android:layout_marginTop控制三个控件之间的距离，用android:background="@android:color/tansparent"将其透明化后,android:src添加素材图片实现个性化按钮设置。

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/background"
    android:orientation="vertical"
    tools:context=".Net1814080903101Activity">

    <ImageView
        android:layout_marginLeft="40dp"
        android:id="@+id/title"
        android:layout_width="345dp"
        android:layout_height="269dp"
        android:src="@drawable/title"
        />
    <ImageButton
        android:id="@+id/starting"
        android:layout_width="200dp"
        android:layout_height="100dp"
        android:layout_marginLeft="110dp"
        android:layout_marginTop="100dp"
        android:src="@drawable/starting"
        android:scaleType="centerInside"
        android:background="@android:color/transparent"/>
    <ImageButton
        android:id="@+id/exiting"
        android:layout_width="200dp"
        android:layout_height="100dp"
        android:layout_marginLeft="110dp"
        android:layout_marginTop="50dp"
        android:src="@drawable/exiting"
        android:scaleType="centerInside"
        android:background="@android:color/transparent"/>
</LinearLayout>
```

​	2.设计农场界面

​		农场界面结构较为复杂，使用了RelativeLayout相对布局，若干个大小相同的ImageButton块通过android:id进行标识，通过android:layout_below和android:layout_toRightOf将所有控件的位置与其他控件联系起来，凑成相对布局整体。

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/background"
    tools:context=".FarmActivity">
    <TextView
        android:id="@+id/rank"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:text="2"
        android:textSize="50dp"
        android:background="@drawable/rank"
        android:gravity="center"/>
    <TextView
        android:id="@+id/bar"
        android:layout_width="310dp"
        android:layout_height="50dp"
        android:layout_toRightOf="@+id/rank"
        android:background="@drawable/bar"
        android:text="200/500"
        android:textSize="25dp"
        android:gravity="center"
        android:textColor="@color/colorAccent"/>
    <ImageView
        android:id="@+id/money"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:layout_below="@+id/bar"
        android:layout_toRightOf="@+id/rank"
        android:src="@drawable/money"/>
    <TextView
        android:id="@+id/moneytext"
        android:layout_width="120dp"
        android:layout_height="50dp"
        android:layout_toRightOf="@+id/money"
        android:layout_below="@+id/bar"
        android:text="50000"
        android:textSize="25dp"
        android:gravity="center_vertical"/>
    <ImageButton
        android:id="@+id/farm1"
        android:layout_width="130dp"
        android:layout_height="130dp"
        android:background="@drawable/locked"
        android:layout_below="@+id/rank" />

    <ImageButton
        android:id="@+id/farm2"
        android:layout_width="130dp"
        android:layout_height="130dp"
        android:background="@drawable/locked"
        android:layout_below="@+id/rank"
        android:layout_toRightOf="@+id/farm1" />
    <ImageButton
        android:id="@+id/farm3"
        android:layout_width="130dp"
        android:layout_height="130dp"
        android:background="@drawable/locked"
        android:layout_below="@+id/rank"
        android:layout_toRightOf="@+id/farm2" />
    <ImageButton
        android:id="@+id/farm4"
        android:layout_width="130dp"
        android:layout_height="130dp"
        android:background="@drawable/locked"
        android:layout_below="@+id/farm1" />
    <ImageButton
        android:id="@+id/farm5"
        android:layout_width="130dp"
        android:layout_height="130dp"
        android:background="@drawable/locked"
        android:layout_below="@+id/farm1"
        android:layout_toRightOf="@+id/farm4" />
    <ImageButton
        android:id="@+id/farm6"
        android:layout_width="130dp"
        android:layout_height="130dp"
        android:background="@drawable/locked"
        android:layout_below="@+id/farm1"
        android:layout_toRightOf="@+id/farm5" />
    <ImageButton
        android:id="@+id/farm7"
        android:layout_width="130dp"
        android:layout_height="130dp"
        android:background="@drawable/unlock"
        android:layout_below="@+id/farm4" />
    <ImageButton
        android:id="@+id/farm8"
        android:layout_width="130dp"
        android:layout_height="130dp"
        android:background="@drawable/unlock"
        android:layout_below="@+id/farm4"
        android:layout_toRightOf="@+id/farm7"/>
    <ImageButton
        android:id="@+id/farm9"
        android:layout_width="130dp"
        android:layout_height="130dp"
        android:background="@drawable/unlock"
        android:layout_below="@+id/farm4"
        android:layout_toRightOf="@+id/farm8" />
    <ImageButton
        android:id="@+id/farm10"
        android:layout_width="130dp"
        android:layout_height="130dp"
        android:background="@drawable/unlock"
        android:layout_below="@+id/farm7" />
    <ImageButton
        android:id="@+id/farm11"
        android:layout_width="130dp"
        android:layout_height="130dp"
        android:background="@drawable/unlock"
        android:layout_below="@+id/farm7"
        android:layout_toRightOf="@+id/farm10" />
    <ImageButton
        android:id="@+id/farm12"
        android:layout_width="130dp"
        android:layout_height="130dp"
        android:background="@drawable/unlock"
        android:layout_below="@+id/farm7"
        android:layout_toRightOf="@+id/farm11" />
    <ImageButton
        android:id="@+id/get"
        android:src="@drawable/expansion"
        android:background="@android:color/transparent"
        android:layout_width="130dp"
        android:layout_height="130dp"
        android:layout_below="@+id/farm10"/>
    <ImageButton
        android:id="@+id/shop"
        android:src="@drawable/shop"
        android:background="@android:color/transparent"
        android:layout_width="130dp"
        android:layout_height="130dp"
        android:layout_below="@+id/farm10"
        android:layout_toRightOf="@id/get"
        android:layout_marginLeft="130dp"/>
</RelativeLayout>
```

​	3.设计商店仓库界面

​		商店仓库界面同样使用了RelativeLayout相对布局，为保证上半部分的商店与下半部分的仓库设计上相同，在该界面的相对布局中嵌套了两个小的，且完全相同的相对布局，各自作为整体进行相互参照。

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/background"
    tools:context=".StoreActivity">
    <ImageView
        android:layout_marginLeft="120dp"
        android:id="@+id/storemoney"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:src="@drawable/money"/>
    <TextView
        android:id="@+id/storemoneytext"
        android:layout_width="120dp"
        android:layout_height="50dp"
        android:layout_toRightOf="@+id/storemoney"
        android:text="50000"
        android:textSize="25dp"
        android:gravity="center_vertical"/>

    <RelativeLayout
        android:id="@+id/depositorypage"
        android:layout_marginLeft="15dp"
        android:layout_width="380dp"
        android:layout_height="250dp"
        android:layout_below="@id/storebefore"
        android:background="@drawable/storecage">

        <TextView
            android:id="@+id/depositorytitle"
            android:layout_width="150dp"
            android:layout_height="30dp"
            android:text="仓库"
            android:textSize="25dp"
            android:gravity="center"
            android:textColor="@color/colorAccent"/>
        <ImageButton
            android:id="@+id/item7"
            android:layout_width="88dp"
            android:layout_height="90dp"
            android:layout_below="@+id/depositorytitle"
            android:layout_marginLeft="17dp"
            android:layout_marginTop="17dp"
            android:background="@android:color/transparent"/>
        <ImageButton
            android:id="@+id/item8"
            android:layout_width="88dp"
            android:layout_height="90dp"
            android:layout_below="@+id/depositorytitle"
            android:layout_marginLeft="36dp"
            android:layout_marginTop="17dp"
            android:layout_toRightOf="@+id/item7"
            android:background="@android:color/transparent"/>
        <ImageButton
            android:id="@+id/item9"
            android:layout_width="88dp"
            android:layout_height="90dp"
            android:layout_below="@+id/depositorytitle"
            android:layout_marginLeft="36dp"
            android:layout_marginTop="17dp"
            android:layout_toRightOf="@+id/item8"
            android:background="@android:color/transparent"/>
        <ImageButton
            android:id="@+id/item10"
            android:layout_width="88dp"
            android:layout_height="90dp"
            android:layout_below="@+id/item7"
            android:layout_marginLeft="17dp"
            android:layout_marginTop="8dp"
            android:background="@android:color/transparent"/>
        <ImageButton
            android:id="@+id/item11"
            android:layout_width="88dp"
            android:layout_height="90dp"
            android:layout_below="@+id/item7"
            android:layout_marginLeft="36dp"
            android:layout_marginTop="8dp"
            android:layout_toRightOf="@+id/item10"
            android:background="@android:color/transparent"/>
        <ImageButton
            android:id="@+id/item12"
            android:layout_width="88dp"
            android:layout_height="90dp"
            android:layout_below="@+id/item7"
            android:layout_marginLeft="36dp"
            android:layout_marginTop="8dp"
            android:layout_toRightOf="@+id/item11"
            android:background="@android:color/transparent"/>

    </RelativeLayout>
    <ImageButton
        android:id="@+id/depositorybefore"
        android:layout_width="70dp"
        android:layout_height="70dp"
        android:layout_below="@id/depositorypage"
        android:background="@drawable/before"
        android:layout_marginLeft="80dp"/>
    <TextView
        android:id="@+id/depositorynowpage"
        android:layout_width="100dp"
        android:layout_height="70dp"
        android:layout_below="@id/depositorypage"
        android:layout_toRightOf="@id/depositorybefore"
        android:text="1/1"
        android:textSize="50dp"
        android:gravity="center"/>
    <ImageButton
        android:id="@+id/depositorynext"
        android:layout_width="70dp"
        android:layout_height="70dp"
        android:layout_below="@id/depositorypage"
        android:background="@drawable/next"
        android:layout_toRightOf="@id/depositorynowpage" />
    <RelativeLayout
        android:id="@+id/storepage"
        android:layout_marginLeft="15dp"
        android:layout_width="380dp"
        android:layout_height="250dp"
        android:layout_below="@id/storemoney"
        android:background="@drawable/storecage">

        <TextView
            android:id="@+id/storetitle"
            android:layout_width="150dp"
            android:layout_height="30dp"
            android:text="商店"
            android:textSize="25dp"
            android:gravity="center"
            android:textColor="@color/colorAccent"/>
        <ImageButton
            android:id="@+id/item1"
            android:layout_width="88dp"
            android:layout_height="90dp"
            android:layout_below="@+id/storetitle"
            android:layout_marginLeft="17dp"
            android:layout_marginTop="17dp"
            android:background="@android:color/transparent"/>
        <ImageButton
            android:id="@+id/item2"
            android:layout_width="88dp"
            android:layout_height="90dp"
            android:layout_below="@+id/storetitle"
            android:layout_marginLeft="36dp"
            android:layout_marginTop="17dp"
            android:layout_toRightOf="@+id/item1"
            android:background="@android:color/transparent"/>
        <ImageButton
            android:id="@+id/item3"
            android:layout_width="88dp"
            android:layout_height="90dp"
            android:layout_below="@+id/storetitle"
            android:layout_marginLeft="36dp"
            android:layout_marginTop="17dp"
            android:layout_toRightOf="@+id/item2"
            android:background="@android:color/transparent"/>
        <ImageButton
            android:id="@+id/item4"
            android:layout_width="88dp"
            android:layout_height="90dp"
            android:layout_below="@+id/item1"
            android:layout_marginLeft="17dp"
            android:layout_marginTop="8dp"
            android:background="@android:color/transparent"/>
        <ImageButton
            android:id="@+id/item5"
            android:layout_width="88dp"
            android:layout_height="90dp"
            android:layout_below="@+id/item1"
            android:layout_marginLeft="36dp"
            android:layout_marginTop="8dp"
            android:layout_toRightOf="@+id/item4"
            android:background="@android:color/transparent"/>
        <ImageButton
            android:id="@+id/item6"
            android:layout_width="88dp"
            android:layout_height="90dp"
            android:layout_below="@+id/item1"
            android:layout_marginLeft="36dp"
            android:layout_marginTop="8dp"
            android:layout_toRightOf="@+id/item5"
            android:background="@android:color/transparent"/>

    </RelativeLayout>
    <ImageButton
        android:id="@+id/storebefore"
        android:layout_width="70dp"
        android:layout_height="70dp"
        android:layout_below="@id/storepage"
        android:background="@drawable/before"
        android:layout_marginLeft="80dp"/>
    <TextView
        android:id="@+id/storenowpage"
        android:layout_width="100dp"
        android:layout_height="70dp"
        android:layout_below="@id/storepage"
        android:layout_toRightOf="@id/storebefore"
        android:text="1/1"
        android:textSize="50dp"
        android:gravity="center"/>
    <ImageButton
        android:id="@+id/storenext"
        android:layout_width="70dp"
        android:layout_height="70dp"
        android:layout_below="@id/storepage"
        android:background="@drawable/next"
        android:layout_toRightOf="@id/storenowpage" />

</RelativeLayout>
```

## 四、实验结果

​	1.开始游戏

![实验4开始界面](picture/exp4_start.png)

​	2.进入农场

![实验4农场界面](picture/exp4_farm.png)

​	3.进入仓库/商店

![实验4商店界面](picture/exp4_store.png)

## 五、心得体会

​		这次实验开始设计整个APP的布局，三个界面使用了流式布局以及相对布局，还有布局之间的嵌套，使用了一些素材使界面变的美观，按照预想的设计思路一步一步完成了实验。