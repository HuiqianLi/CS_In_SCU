package Linkup;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;


public class SoundThread extends Thread {
	String filePath;

	public SoundThread(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public void run() {
		 //File file = new File(filePath);
		//String urlPath = "file:/"+file.getAbsolutePath();
		AudioClip audioClip;		
		try {
			
			//audioClip = Applet.newAudioClip(new URL(urlPath));
			audioClip = Applet.newAudioClip(new URL("file", null, filePath));
			//播放一次音频
			audioClip.play();
			//循环播放音频
			//audioClip.loop();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	
	public static void main(String[] args) {
		//在图形界面具体时间中new 对象开始(指定音频文件的路径)
		new SoundThread("Music/normal.mid").stop();
		
		
	}

}