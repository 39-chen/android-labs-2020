# ʵ���ģ�Android������Ʊ��

## һ��ʵ��Ŀ��

1. ����ѡ��Ҫ����ƽ��沼�ּ��ؼ�ʹ�ã�
2. ����xml��������Ʋ��������ύ����ͼ��
3. ��Ӧ�����н����ͼ��**����Ҫ����¼ע�ᣡ��**

## ����ʵ������

1. ʹ������һ�ֲ��ַ�ʽ��**�����ѡ��Ŀ�Ľ���**��������LinearLayout��

   * LinearLayout, RelativeLayout, Adapter, ConstraintLayout (��ѧ)

## ����ʵ�鲽��

��activity_net1814080903117.xml��,ѡ�� Design ���棬��Layouts��һ����ֱ��LinearLayout����Ϊһ���󲼾֣�Ȼ���ڴ󲼾��з�һ��ˮƽ��LinearLayout,��������xml���ơ�

![ʵ����ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab4(1).png)

activity_net1814080903117.xml���£�

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Net1814080903117Activity"
    android:background="@drawable/bg">

    <LinearLayout
        android:layout_width="409dp"
        android:layout_height="358dp"
        android:orientation="horizontal"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp">

        <Button
            android:id="@+id/up_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="�ϴ��ļ�"
            android:layout_marginTop="300dp"
            android:layout_marginLeft="70dp"/>

        <Button
            android:id="@+id/down_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="�����ļ�"
            android:layout_marginTop="300dp"
            android:layout_marginLeft="85dp"/>
    </LinearLayout>

</LinearLayout>
```

activity_download.xml ��

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".DownloadActivity">

    <TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/download"
        android:text="  �ļ�����"
        android:paddingLeft="160dp"
        android:paddingTop="100dp"/>

    <LinearLayout
        android:layout_width="409dp"
        android:layout_height="724dp"
        android:orientation="horizontal"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="6dp">

        <Button
            android:id="@+id/down_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="�ļ�����"
            android:layout_marginTop="100dp"
            android:layout_marginLeft="90dp"/>

        <Button
            android:id="@+id/main_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="100dp"
            android:layout_marginLeft="50dp"
            android:text="����" />
    </LinearLayout>

</LinearLayout>
```

activity_upload.xml:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".UploadActivity">

    <TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/upload"
        android:text="  �ļ��ϴ�"
        android:paddingLeft="160dp"
        android:paddingTop="100dp"/>

    <LinearLayout
        android:layout_width="409dp"
        android:layout_height="724dp"
        android:orientation="horizontal"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="6dp">

        <Button
            android:id="@+id/up_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="�ļ��ϴ�"
            android:layout_marginTop="100dp"
            android:layout_marginLeft="90dp"/>

        <Button
            android:id="@+id/main_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="100dp"
            android:layout_marginLeft="50dp"
            android:text="����" />
    </LinearLayout>


</LinearLayout>
```

## �ġ�ʵ��������ͼ

![ʵ����ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab4(2).png)

![ʵ����ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab2(1).png)

![ʵ����ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab2(2).png)

![ʵ����ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab2(3).png)