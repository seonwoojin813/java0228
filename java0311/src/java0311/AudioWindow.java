package java0311;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

//윈도우 클래스
public class AudioWindow extends JFrame {

	public AudioWindow() {
		setTitle("효과음 재생");
		setLocation(100,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel p = new JPanel();
		
		JTextField txt = new JTextField(30);
		p.add(txt);
		
		JButton loadUrl = new JButton("찾아보기");
		p.add(loadUrl);
		//버튼 눌렀을 때 수행할 내용
		loadUrl.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// 파일 열기 대화상자를 만들어서 출력
				JFileChooser fc = new JFileChooser();
				//확장자 선택 필터를 생성
				FileNameExtensionFilter filter = new FileNameExtensionFilter("사운드 파일", "wav", "mid");
			    fc.setFileFilter(filter);
			    //대화상자를 출력하고 누른 버튼의 값을 저장
			    int result = fc.showOpenDialog(null);
			    //확인을 눌렀다면
			    if(result == JFileChooser.APPROVE_OPTION) {
			    	//파일 경로를 가져와서 txt에 출력
			    	File f = fc.getSelectedFile();
			    	txt.setText(f.getAbsolutePath());
			    }
				
			}
		
		    });
			add(p);
			
			JButton play = new JButton("▶");
			p.add(play);
			play.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
					//파일 경로를 가지고 File 객체 생성
					File f = new File(txt.getText());
					//파일의 경로를 URL로 생성
					URL url = new URL("File:///"+ f.getAbsolutePath());
					//오디오 재생기 생성
					AudioClip audioClip =Applet.newAudioClip(url);
					audioClip.play();
					}catch(Exception e1) {	
					}
				}	
			});
			//컴포넌트 크기에 맞추어서 윈도우가 생성
			pack();
		    setVisible(true);
	}
}
