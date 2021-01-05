# ʵ�����Android������

## һ��ʵ��Ҫ��

1. ��Issues�д����Լ���ѡ�⣺[https://github.com/hzuapps/android-labs-2020/issues](https://github.com/hzuapps/android-labs-2020/issues) ��
2. ������ѡ��Ŀ����дһ������Activity�������������ѧ��ǰ׺���ŵ��Լ���Java���£���
3. ����������Ϊ�Լ���ѧ��+��Ӧ�Ĺ��ܻ���Ŀ��
4. �����Լ�ѡ�����Ŀʵ��Activity�е��������õȹ��ܣ�ѡ������

## ����ʵ������

1. ���ݹ��ܴ�����Ӧ��Activity��
2. ��дActivity��Ӧ�Ĳ����ļ���
3. ʵ�ָ���Activity֮�����ת;

## ����ʵ�鲽��


���� Net1814080903117Activity(������)��DownloadActivity(���ؽ���)��UploadActivity(�ϴ�����)��

�ڲ����ļ��д��� Button �����

Ϊ Button ��ӵ���¼�����

ͨ�� startActivity(Intent) ʵ�ֽ�����ת

```java
public class Net1814080903117Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903117);

        Button btnOpen1 = findViewById(R.id.up_btn);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,UploadActivity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

        Button btnOpen2 = findViewById(R.id.down_btn);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,DownloadActivity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });


    }
}
```

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

    }
}
```



�������� Activity ע�ᵽ AndroidManifest.xml �У�

```sssisixml
       <activity android:name=".DownloadActivity" />
        <activity android:name=".UploadActivity" />
        <activity android:name=".Net1814080903117Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```

## �ġ�ʵ��������ͼ

![ʵ���ͼƬ](https://raw.githubusercontent.com/Cloudtq/android-labs-2020/master/students/net1814080903117/lab2(1).png)


![ʵ���ͼƬ](https://raw.githubusercontent.com/Cloudtq/android-labs-2020/master/students/net1814080903117/lab2(2).png)


![ʵ���ͼƬ](https://raw.githubusercontent.com/Cloudtq/android-labs-2020/master/students/net1814080903117/lab2(3).png)

## �塢ʵ���ĵ�

����ʵ�����ʹ��android studio��ͨ����������Ŀ������Ŀ�д����������ܵ�activity������ʵ������ת�߼���ͨ��findViewById()��ð�ť��ʹ�ð�ťonclick����������ת���Ƚϼ��ܹ�������ɡ�