package slidenerd.vivz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends Activity {

	private EditText editText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		editText=(EditText) findViewById(R.id.userNameData);
	}

	public void loadInternalCache(View view)
	{
		File folder=getCacheDir();
		File myFile=new File(folder,"mydata1.txt");
		String data=readData(myFile);
		if(data!=null)
		{
			editText.setText(data);
		}
		else
		{
			editText.setText("No data was returned");
		}
	}
	public void loadExternalCache(View view)
	{

		File folder=getExternalCacheDir();
		File myFile=new File(folder,"mydata2.txt");
		String data=readData(myFile);
		if(data!=null)
		{
			editText.setText(data);
		}
		else
		{
			editText.setText("No data was returned");
		}
	}
	public void loadPrivateExternalFile(View view)
	{

		File folder=getExternalFilesDir("Slidenerd");
		File myFile=new File(folder,"mydata3.txt");
		String data=readData(myFile);
		if(data!=null)
		{
			editText.setText(data);
		}
		else
		{
			editText.setText("No data was returned");
		}
	}
	public void loadPublicExternalFile(View view)
	{

		File folder=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
		File myFile=new File(folder,"mydata4.txt");
		String data=readData(myFile);
		if(data!=null)
		{
			editText.setText(data);
		}
		else
		{
			editText.setText("No data was returned");
		}
	}
	private String readData(File myFile)
	{
		FileInputStream fileInputStream=null;
		try {
			fileInputStream=new FileInputStream(myFile);
			int read=-1;
			StringBuffer stringBuffer=new StringBuffer();
			while((read=fileInputStream.read())!=-1)
			{
				stringBuffer.append((char)read);//65666768 ABCD
			}
			return stringBuffer.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(fileInputStream!=null)
			{
				try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public void previous(View view)
	{
		Intent intent=new Intent(this,MainActivity.class);
		startActivity(intent);
	}
	public void message(String message) {
		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	}

}
