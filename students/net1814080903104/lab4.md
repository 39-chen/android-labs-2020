# 实验四
## 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

## 二、实验内容
1. 使用一种布局方式设计界面；
2. 通过控件ID获取界面对象，执行相关操作：
3. 实现界面控件的事件处理;
4. 操作之后，切换到第二个界面。

## 三、实验步骤
1. 主界面采用LinearLayout，设置了2个button，分别为领取奖励和查询信息，并使用OnClickListener事件监听器以及Intent方法实现向领取奖励界面和查询信息界面的跳转
```java
     final Net1814080903104Activity thisActivity = this;

        Button button = (Button) findViewById(R.id.button_open);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(thisActivity,GetReward.class);
                thisActivity.startActivity(intent);
            }
        });


        Button button1 = (Button) findViewById(R.id.button_search);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(thisActivity,SearchMess.class);
                thisActivity.startActivity(intent);
            }
        });
```
2. 领取奖励界面也采用LinearLayout，设置了2个button，分别为领取和返回，并使用OnClickListener事件监听器以及Intent方法实现返回主界面的跳转
```java
      Button button = (Button) findViewById(R.id.button_return);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(GetReward.this,Net1814080903104Activity.class);
                GetReward.this.startActivity(intent);
            }
        });
```
3. 查询信息界面采用RelativeLayout，设置了2个button，分别为查询和返回，以及2个Spinner和一个edittext，并使用OnClickListener事件监听器以及Intent方法实现返回主界面的跳转
```java
        Button button = (Button) findViewById(R.id.button_return);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(SearchMess.this,Net1814080903104Activity.class);
                SearchMess.this.startActivity(intent);}
        });
```

## 四、实验结果
![主界面](https://github.com/3ho-y/android-labs-2020/blob/master/students/net1814080903104/lab3(1).png)
![领取奖励界面](https://github.com/3ho-y/android-labs-2020/blob/master/students/net1814080903104/lab3(2).png)
![查询信息界面](https://github.com/3ho-y/android-labs-2020/blob/master/students/net1814080903104/lab4(1).png)

## 五、实验心得
本次实验主要是实现了界面布局的设计，根据实际设计需要灵活使用布局，才能达到自己想要实验的效果。
