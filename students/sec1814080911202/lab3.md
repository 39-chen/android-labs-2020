# һ��ʵ�鱨��

1. �˽�AndroidӦ���и�����Դ�ĸ�����ʹ�÷���
2. ������AndroidӦ����ʹ��ͼƬ����Դ�ķ���

# ����ʵ������

1. �ڽ�������ʾ����һ��ͼƬ�������Լ�����Ŀ��ӣ�
2. �ύres/drawable��ͼƬʹ�õĴ���
3. �ύres/values, res/layout����������
4. ��Ӧ�����н����ͼ���ŵ�ʵ�鱨����
5. ���ͼƬ����ť��ʱ������һ��Activity

# ����ʵ�鲽��

1. ��Ŀ��ͼƬ���浽����Android studio�� res/drawable·����

2. ����Ӧlayout��xml�ļ�������`ImageView`��`app:srcCompat`����ʵ�ֵ���ͼƬ����������
```xml
    <!-- ������ ����ѧԺͼ�������ͼƬ -->
    <ImageView
        android:id="@+id/imageview_hzu_library1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/hzu_library1"/>


    <!-- book1 ������ȫ���� -->
    <ImageView
        android:id="@+id/imageview_lan_sec_awd"
        android:layout_width="wrap_content"
        android:layout_height="200dp"
        android:src="@drawable/lan_sec_awd"/>

    <!-- book2 web��ȫ���� -->
    <ImageView
        android:id="@+id/imageview_web_sec_awd"
        android:layout_width="wrap_content"
        android:layout_height="200dp"
        android:src="@drawable/web_sec_awd"/>
```


# �ġ�ʵ����

![lab3](https://raw.githubusercontent.com/L1nzSec/android-labs-2020/master/students/sec1814080911202/lab3.png)

# �塢ʵ���ĵ�

����ʵ�����˽�AndroidӦ���и�����Դ�ĸ�����ʹ�÷������Լ�������AndroidӦ����ʹ��ͼƬ����Դ�ķ�����ͨ������ʵ�飬���������ͼƬ�ļ��ַ������ر���ImageView���Լ�ѧ����ͼƬ���������õȵȡ�
