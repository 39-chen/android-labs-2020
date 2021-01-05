# ʵ���壺Android�洢���

## һ��ʵ��Ŀ��

1. �˽�Andoid�Ĵ洢�ֶ�
2. ����Android���ļ��洢
3. ����Android�����ݿ�洢

## ����ʵ������

1. ��Ӧ�ò��������ݱ��浽�ļ��洢�У�
2. ʹ���ļ��ⲿ�洢��ʽ
3. ���н����ͼ��

## ����ʵ�鲽��

1. Ϊactivity_upload.xml���һ��TextView��

```xml
    <TextView
        android:layout_marginLeft="100dp"
        android:layout_width="200dp"
        android:layout_height="40dp"
        android:id="@+id/uploadText"
        android:lines="1"
        android:ellipsize="end"
        android:hint="ѡ����Ҫ�ϴ����ļ�"
        />
```

2. ��AndroidManifest.xml������ⲿ�洢��дȨ�ޣ�

```xml
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

3. ��java����������Ȩ�ޣ�

```java
    //����Ȩ��
    private void permissionFile(){
        String[] permission = new String[]{
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE"
        }; //��������Ҫ��Ȩ��

        if(ActivityCompat.checkSelfPermission(this,permission[0])!= PackageManager.PERMISSION_GRANTED
                ||
                ActivityCompat.checkSelfPermission(this,permission[1])!=PackageManager.PERMISSION_GRANTED
        ){
            ActivityCompat.requestPermissions(this,permission,1);   //����Ȩ��
        }
    }
```

* ��UploadActivity.java��onCreate()�ϵ��� permissionFile();

4.ͨ�����TextView�ؼ��������ļ����������ӱ���ѡ���ļ������ϴ������ص��ⲿ�洢�ļ����С�

```java
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.main_btn:
                    intent = new Intent(UploadActivity.this, Net1814080903117Activity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.up_btn:
                    boolean b = uploadFile(path,file.getName());
                    showMessage(b?"�ϴ��ɹ�":"�ϴ�ʧ��");
                    break;
                case R.id.uploadText:
                    //���ļ�������ѡ���ļ�
                    intent = new Intent(Intent.ACTION_GET_CONTENT);
                    //������Ҫ���ļ�������
                    intent.setType("*/*");
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    startActivityForResult(intent,1);
                    break;
            }
        }
```

* ��д�ص����� onActivityResult,���ļ���������ȡ·����������ȡ�����ļ����ļ���д�ص�TiewView

```java
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();

            //���ݸ����汾��ȡ�ļ�·��
            if ("file".equalsIgnoreCase(uri.getScheme())) {   //ʹ�õ�������
                path = uri.getPath();
                file = new File(path);
                uploadfile.setText(file.getName());
                Toast.makeText(this, path, Toast.LENGTH_SHORT).show();
                return;
            }

            if (Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT) { //4.4���ϰ汾
                uri.getScheme();
                path = getPath(this,uri);
                file = new File(path);
                uploadfile.setText(file.getName());
                Toast.makeText(this, path , Toast.LENGTH_SHORT).show();
            }else{                                                  //4.4���°汾
                path = getRealPathFromURI(uri);
                file = new File(path);
                uploadfile.setText(file.getName());
                Toast.makeText(UploadActivity.this,path,Toast.LENGTH_SHORT).show();
            }
        }
    }
```

* 4.4�汾���»�ȡ·������ getRealPathFromURI( Uri )

```java
    public String getRealPathFromURI(Uri contentUri){
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri,proj,null,null,null);
        if(null!=cursor&&cursor.moveToFirst()){
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
            cursor.close();
        }
        return res;
    }
```

* 4.4���ϰ汾��ȡ·������ getPath(Context , Uri),�ж���ͨ���ļ��������� �ⲿ�洢������/ý�������/���ع������򿪵��ļ������л�ȡ·��  **@SuppressLint("NewApi")����������API����ʹ�õķ������Ĵ���**

```java
    @SuppressLint("NewApi")
    public String getPath(final Context context, final Uri uri){

        final boolean isKitKat = Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT;

        //DocumentProvider
        if(isKitKat && DocumentsContract.isDocumentUri(context,uri)){
            //ExternalStorageProvider
            if(isExternalStorageDocument(uri)){
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split =docId.split(":");
                final String type = split[0];

                if("primary".equalsIgnoreCase(type)){
                    return Environment.getExternalStorageDirectory()+"/"+split[1];
                }
            }

            //DownloadsProvider
            else if (isDownloadsDocument(uri)){

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"),Long.valueOf(id));
                return getDataColumn(context,contentUri,null,null);
            }

            //MediaProvider
            else if(isMediaDocument(uri)){

                final String docId = DocumentsContract.getDocumentId(uri);
                final String [] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if("image".equals(type)){
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                }else if("video".equals(type)){
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                }else if("audio".equals(type)){
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{split[1]};

                return getDataColumn(context,contentUri,selection,selectionArgs);
            }
        }

        //MediaStore(and general)
        else if("content".equalsIgnoreCase(uri.getScheme())){
            return getDataColumn(context,uri,null,null);
        }

        //File
        else if("file".equalsIgnoreCase(uri.getScheme())){
            return uri.getPath();
        }

        return null;

    }

    public String getDataColumn(Context context,Uri uri,String selection,String[] selectionArgs){

        Cursor cursor = null;
        final String column = "_data";
        final String [] projection = {column};

        try {
            cursor = context.getContentResolver().query(uri,projection,selection,selectionArgs,null);
            if(cursor!=null&&cursor.moveToFirst()){
                final int column_index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(column_index);
            }
        }finally {
            if(cursor!=null){
                cursor.close();
            }
        }
        return null;

    }

    public boolean isExternalStorageDocument(Uri uri){
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public boolean isDownloadsDocument(Uri uri){
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public boolean isMediaDocument(Uri uri){
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
```

5. ͨ��uploadFile(path , filename)�����ϴ�

```java
   public boolean uploadFile(String path,String filename){
        File uploadfile = new File(path);
        if(path.isEmpty()||!uploadfile.exists())
            return false;
        try {
            InputStream inputStream = new FileInputStream(uploadfile);

            if(getExternalFilesDir(null)!=null){
                String filePath = getExternalFilesDir(null).toString();
                File downloadfile = new File(getExternalFilesDir(null).toString()+"/"+filename);
                FileOutputStream outputStream = new FileOutputStream(downloadfile);
                byte[] b = new byte[1024];
                int length;
                if((length = inputStream.read(b))!=-1){
                    outputStream.write(b,0,length);
                    while( (length=inputStream.read(b)) != -1 ){
                        outputStream.write(b,0,length);
                    }
                }else{
                    file.delete();
                }

            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
```

## �ġ����н������ͼ

![ʵ����ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab5(1).png)

![ʵ����ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab5(2).png)

![ʵ����ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab5(3).png)

![ʵ����ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab5(4).png)

## �塢ʵ���ĵ�

����ʵ���ѶȽϴ��ʼ��֪�����ͨ�����ļ���������ȡ�ļ���Ȼ��ͨ���ٶ��ҷ���������һƪ����д������ε����ļ�����������μ��ݸ��汾�Լ�ѡȡ·����������䷽����Ȼ����ǲ���ʱ���ֻ���û�а취�ϴ����������Ȩ�޵����⣬ͨ����ȡ��дȨ�޺����������ʵ�飬�ջ�ϴ󣬶԰�׿�ⲿ�洢���˸������⡣