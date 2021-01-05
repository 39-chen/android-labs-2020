package edu.hzuapps.androidlabs.net1814080903223;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class PlayActivity extends AppCompatActivity {
	 {
		  @Override
		   public void onClick(View v) {
			    Intent intent=new
Intent(playActivity.this,viewandmodifyActivity.class);
intent.putExtra("quan","2");
                startActivityForResult(intent,1);
                 }
                 });
                 jiandao.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent intent=new Intent(playActivity.this,viewandmodifyActivity.class);
			intent.putExtra("quan","0");
                startActivityForResult(intent,1);
                 }
                  });
                  shitou.setOnClickListener(new View.OnClickListener() {
					  @Override
		public void onClick(View v) {
			Intent intent=new Intent(playActivity.this,viewandmodifyActivity.class);
intent.putExtra("quan","1");
                startActivityForResult(intent,1);
                 }
                  });
   }
       @Override

       protected void onActivityResult(int requestCode, int resultCode, Intent data) {
           super.onActivityResult(requestCode, resultCode, data);
           if(requestCode==1&&resultCode==2){
               String s=data.getStringExtra("jieguo");

               if(!s.isEmpty()) {
                   write(s);
               }
               refreshHistoricalRecord(s);
           }
           initHistoricalRecord();
       }
       private void refreshHistoricalRecord(String msg)  //ˢ��һ�¼�¼

       {
           if(msg==null) return;
           TextView textView = (TextView) findViewById(R.id.textview_history);
           String s = textView.getText().toString();
           Calendar c = Calendar.getInstance();
           SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           String formattedDate=df.format(c.getTime());
           textView.setText(s+"\n"+formattedDate+":"+msg);
       }

       private void initHistoricalRecord()  //��ʼ����¼
       {
           TextView textView = (TextView) findViewById(R.id.textview_history);
           String s = read();
           if(s!=null)
               refreshHistoricalRecord(s);
       }
       public String read() {   //����洢����
           try {
               FileInputStream inStream = this.openFileInput("message.txt");
               byte[] buffer = new byte[1024];
               int hasRead = 0;
               StringBuilder sb = new StringBuilder();
               while ((hasRead = inStream.read(buffer)) != -1) {
                   sb.append(new String(buffer, 0, hasRead));
               }
               inStream.close();
               return sb.toString();
           } catch (Exception e) {
               e.printStackTrace();
           }
           return null;
       }
       public void write(String msg){   //д���洢����
           // ����1����ȡ����ֵ
           if(msg == null) return;
           try {
               // ����2:����һ��FileOutputStream����,MODE_APPEND׷��ģʽ
               msg += read();  //ǰ���Ҳ������
               FileOutputStream fos = openFileOutput("storage.txt", MODE_APPEND);
               // ����3������ȡ������ֵ�����ļ�
               fos.write(msg.getBytes());
               // ����4���ر�������
               fos.close();
           } catch (Exception e) {
               e.printStackTrace();
        }
         }
          }