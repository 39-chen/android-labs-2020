# һ��ʵ�鱨��

1. ����2-3�����Լ�ѡ���йص�Activity
2. ����Intentʵ��Activity�����ת

# ����ʵ������

1. ���ݹ��ܴ�����Ӧ��Activity
2. ��дActivity��Ӧ�Ĳ����ļ�
3. ʵ�ָ���Activity֮�����ת

# ����ʵ�鲽��

1. ��������Activityע�ᵽAndroidManifest.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs.sec1814080911202">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".BorrowActivity"></activity>
        <activity android:name=".ManageActivity" />
        <activity android:name=".Sec1814080911202Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

2. ����Button��ť������תҳ��
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".Sec1814080911202Activity">

    <!-- ����ͼ�鰴ť -->
    <Button
        android:id="@+id/button_manage"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="����ͼ��" />

    <!-- ����ͼ�鰴ť -->
    <Button
        android:id="@+id/button_borrow"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="����ͼ��" />
</LinearLayout>
```

3. ΪButton��Ť���Click����¼�ʵ����ת
```java
public class Sec1814080911202Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_1814080911202_activity);

        final Sec1814080911202Activity thisActivity = this;

        Button manageBtn = (Button) findViewById(R.id.button_manage);
        manageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ��ʽ��һ��Activity
                Intent intent = new Intent(thisActivity,ManageActivity.class);
                startActivity(intent);
            }
        });

        Button borrowBtn = (Button) findViewById(R.id.button_borrow);
        borrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,ManageActivity.class);
                startActivity(intent);
            }
        });

    }
}
```

# �ġ�ʵ����

 ![lab2](https://raw.githubusercontent.com/L1nzSec/android-labs-2020/master/students/sec1814080911202/lab2.png)

# �塢ʵ���ĵ�

����ʵ���Ǵ���2-3�����Լ�ѡ���йص�Activity��Ȼ������Intentʵ��Activity�����ת��ͨ������ʵ�飬�˽���Android��Ŀ�¸����ļ������ã�ѧ������layout�µ��ļ���Ӱ�ť���Լ���Activity�ļ���Ϊbutton��ӵ���¼���
