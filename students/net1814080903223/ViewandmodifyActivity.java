package edu.hzuapps.androidlabs.net1814080903223;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class ViewandmodifyActivity extends AppCompatActivity {

    private Button fanhui;
    private TextView jieguo,xx;
    String ret;
     @Override
	    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_viewandmodify);
    fanhui=(Button) findViewById(R.id.button_fanhui);
	        jieguo=(TextView)findViewById(R.id.textview_03_01);
	        xx=(TextView)findViewById(R.id.textview_03_02);
	        final Intent intent=getIntent();
	        String st=intent.getStringExtra("quan");
	        int s=Integer.parseInt(st);
	        String sp=null;
	        if(s==2){
	            sp="�� ";
	        }
	        else if(s==1){
	            sp="ʯͷ";
	        }
	        else if(s==0){
	            sp="����";
	        }
	        int x=(int)(Math.random()*3);
	        String sx=null;
	        if(x==2){
	            sx="�� ";
	        }
	        else if(x==1){
	            sx="ʯͷ";
	        }
	        else if(x==0){
	            sx="����";
	        }
	        if ((s == 0 && x == 1) ||
	                (s == 1 && x == 2) ||
	                (s == 2 && x == 0)){
	            jieguo.setText("^-^  ������  �����");
	            ret="����";
	        }
	        else if (s == x) {
	            jieguo.setText("��ԵTnTƽ��,����");
	            ret="ƽ��";
	        }
	        else {
	            jieguo.setText("(^v^) oh  ��Ӯ��  ");
	            ret="Ӯ��";
	        }
	        xx.setText("���"+sp+"�����Գ�"+sx);
	        ret=xx.getText().toString()+" ��� "+ret;
	        fanhui.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                Intent data=new Intent();
	                data.putExtra("jieguo",ret);
	                setResult(2,data);
	                finish();
	            }
	        });
	        }
}