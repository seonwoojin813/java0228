package java0308;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileInfoMain {

	public static void main(String[] args) {
		// 파일 정보 확인
		File f = new File("./");
		System.out.printf("%s\n", f.getAbsolutePath());
		//파일의 존재여부 확인
		if(f.exists()) {
			//파일정보 확인
			System.out.printf("파일 크기:%d\n", f.length());
			System.out.printf("마지막 수정 시간:%d\n", f.lastModified());
			Date date = new Date(f.lastModified());
			System.out.printf("마지막수정시간:%s\n", date);
		}else {
			try {
				//파일을 생성
				f.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
			System.out.printf("파일이 없으므로 다운로드합니다.\n");
		}
	}
}
