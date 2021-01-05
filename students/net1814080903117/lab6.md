# ʵ������Android������

## һ��ʵ��Ŀ��

1. ����Android������ʷ�����
2. ���XML��JSON��ʾ���ݵķ�����

```
ע�⣺ѡ��ʵ�ֵĹ��ܣ�һ��Ҫ�����ѡ����أ�
```

## ����ʵ������

1. ����������һ���ļ���ͼƬ��MP3��MP4����
2. ���浽�ֻ�����Ӧ����ʹ���ļ���
3. ��Ӧ�����н����ͼ��

## ����ʵ�鲽��

1. �� build.gradle �ϵ�������
2. �� AndroidManifest.xml ���������Ȩ��

```xml
    <uses-permission android:name="android.permission.INTERNET"/>
```

3. ����һ��ʵ����� UploadActivity.java �е�`uploadFile`���������޸�

```java
 public boolean uploadFile(String path,String filename){
        final OkHttpClient okHttpClient = new OkHttpClient();
        File file = new File(path);
        if(path.isEmpty()||!file.exists())
            return false;
        final RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file",filename,RequestBody.create(new File(path), MediaType.parse("multipart/form-data")))
                .addFormDataPart("filename",filename)
                .build();
        FutureTask<Boolean> task = new FutureTask<>(()->{
            try {
                ResponseBody responseBody = okHttpClient.newCall(
                        new Request.Builder().post(body).url("http://10.0.2.2:8080/upload").build()
                ).execute().body();

                if(responseBody!=null){
                    return Boolean.parseBoolean(responseBody.string());
                }
                return false;
            }catch (IOException e){
                e.printStackTrace();
                return false;
            }
        });
        try {
            new Thread(task).start();
            return task.get();
        }catch (Exception e) {
            return false;
        }
    }
```

4. �� DownloadActivity.java �����һ�� EditText �����ڵ��ʱ����������������������п������ļ���չʾ��EditText

getFilesName : ���ڷ��������ȡ�ļ��б�

```java
    public void getFilesName(){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://10.0.2.2:8080/getFilesName").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()){
                    String str = response.body().string();
                    List<String> list = JSONObject.parseArray(str,String.class);
                    Message msg = new Message();
                    msg.obj = list;
                    handler.sendMessage(msg);
                }
            }
        });

        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                filenameList = (List<String>) msg.obj;
                showListPopulWindow();

            }
        };

    }
```

showListPopulWindow : ���ڽ��ļ��б�ͨ����������ʽչʾ��EidtText

```java
    private void showListPopulWindow() {
        String[] list = filenameList.toArray(new String[filenameList.size()]);
        final ListPopupWindow listPopupWindow;
        listPopupWindow = new ListPopupWindow(this);
        listPopupWindow.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list));//��android���ò��֣�������Լ�����ʽ
        listPopupWindow.setAnchorView(downText);//���ĸ��ؼ�Ϊ��׼���ڸô���mEditTextΪ��׼
        listPopupWindow.setModal(true);

        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {//������������
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                downText.setText(list[i]);//��ѡ���ѡ������չʾ��EditText��
                listPopupWindow.dismiss();//����Ѿ�ѡ���ˣ���������
            }
        });
        listPopupWindow.show();//��ListPopWindowչʾ����
    }
```

5. `downloadFile` ����ͨ��EidtText ��ȡ���ļ�����������ӷ�������ȡ�ļ���������

```java
 public File downloadFile(String filename){

        OkHttpClient okHttpClient = new OkHttpClient();

        if(filename==null||filename.isEmpty()){
            return null;
        }

        RequestBody body = new MultipartBody.Builder().addFormDataPart("filename",filename).build();

        FutureTask<File> task = new FutureTask<File>(()->{
            ResponseBody responseBody = okHttpClient.newCall(
                    new Request.Builder().post(body).url("http://10.0.2.2:8080/download").build()).execute().body();
            if(responseBody != null){
                if(getExternalFilesDir(null)!=null){
                    String filePath = getExternalFilesDir(null).toString();
                    File file = new File(getExternalFilesDir(null).toString()+"/"+filename);
                    try (
                            InputStream inputStream = responseBody.byteStream();
                            FileOutputStream outputStream = new FileOutputStream(file)
                    ){
                        byte[] b = new byte[1024];
                        int length;
                        if((length = inputStream.read(b))!=-1){
                            outputStream.write(b,0,length);
                            while( (length=inputStream.read(b)) != -1 ){
                                outputStream.write(b,0,length);
                            }
                            return file;
                        }else{
                            file.delete();
                            return null;
                        }
                    }
                }

            }
            return null;
        });
        try {
            new Thread(task).start();
            return task.get();
        }catch (Exception e) {
            return null;
        }
    }
```

## �ġ�ʵ��������ͼ

![ʵ��6ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(1).png)

![ʵ��6ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(2).png)

![ʵ��6ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(3).png)

![ʵ��6ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(4).png)

![ʵ��6ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(5).png)

![ʵ��6ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(6).png)

![ʵ��6ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(7).png)

![ʵ��6ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(8).png)

![ʵ��6ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(9).png)

![ʵ��6ͼƬ](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(10).png)

## �塢ʵ���ĵ�

ͨ������ʵ��ѧϰ������ڰ�׿�����������󣬱Ƚ�Ҫע��ĵ�����Ҫ���������ļ�����������Ȩ�ޣ������Ͳ�������Ȼ����ǿ���ͨ��ʹ�õ��������okhttp���������з��ͣ�����ԭ����������������˷�װ��ʹ�������ȽϷ��㣬���������ʹ�õ��ǰ�׿ģ����ģ�ⷢ�͸����ص�������Ӧ��ʹ�õ�ַ10.0.2.2���ip���ܹ����󵽡�