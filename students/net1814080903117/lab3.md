# ʵ������Android��Դʹ�ñ��

## һ��ʵ��Ŀ��

1. �˽�AndroidӦ���и�����Դ�ĸ�����ʹ�÷�����
2. ������AndroidӦ����ʹ��ͼƬ����Դ�ķ�����

## ����ʵ��Ҫ��

1. �ڽ�������ʾ����һ��ͼƬ�������Լ�����Ŀ��ӣ���
2. �ύres/drawable��ͼƬʹ�õĴ��룻
3. �ύres/values, res/layout���������룻
4. ��Ӧ�����н����ͼ���ŵ�ʵ�鱨���У�
5. ���ͼƬ����ť��ʱ������һ��Activity��

## ����ʵ�鲽��

��ͼƬ�ŵ���Ŀ�е� src/main/res/drawable �С�

��activity_download.xml,���TextView�����£�

```xml
    <TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/download"
        android:text="  �ļ�����"
        android:paddingLeft="160dp"
        android:paddingTop="100dp"/>
```

�� activity_upload.xml���TextView�����£�

```xml
    <TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/upload"
        android:text="  �ļ��ϴ�"
        android:paddingLeft="160dp"
        android:paddingTop="100dp"/>
```

�� activity_net1814080903117.xml,��� background ���£�

```
android:background="@drawable/bg"
```

Ȼ������java�����е���ͼƬ��С

```java
public class DownloadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        Button btnOpen1 = findViewById(R.id.main_btn);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, Net1814080903117Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

	//����ͼƬ��С
        Drawable drawable = getResources().getDrawable(R.drawable.download);
        drawable.setBounds(0,0,200,200);
        TextView textview = findViewById(R.id.textview_01);
        textview.setCompoundDrawables(null,drawable,null,null);
    }
}
```

```java
public class UploadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        Button btnOpen = findViewById(R.id.main_btn);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, Net1814080903117Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

	//����ͼƬ��С
        Drawable drawable = getResources().getDrawable(R.drawable.upload);
        drawable.setBounds(0,0,200,200);
        TextView textview = findViewById(R.id.textview_01);
        textview.setCompoundDrawables(null,drawable,null,null);
    }
}
```

## �ġ�ʵ��������ͼ

![ʵ����ͼƬ](https://raw.githubusercontent.com/Cloudtq/android-labs-2020/master/students/net1814080903117/lab2(1).png)


![ʵ����ͼƬ](https://raw.githubusercontent.com/Cloudtq/android-labs-2020/master/students/net1814080903117/lab2(2).png)


![ʵ����ͼƬ](https://raw.githubusercontent.com/Cloudtq/android-labs-2020/master/students/net1814080903117/lab2(3).png)

## �塢ʵ���ĵ�

ͨ������ѧ���������activity�в���ͼƬ������ͨ����xml���������� padding���ñ߾࣬����ͼƬλ�ã�ͨ��java�������ͼƬ�Ĵ�С��