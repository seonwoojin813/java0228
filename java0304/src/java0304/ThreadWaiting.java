package java0304;

//스레드를 만들기 위해서는 Thread  클래스나 Runnable 인터페이스 이용
//run 메소드에 스레드로 수행할 내용을 작성

//Thread 클래스를 이용할 때는 인스턴스를 만들고 start()를 호출하면 스레드가 시작

//Runnable 인터페이스를 이용한 경우에는 인스턴스를 만들고
//Thread 클래스의 생성자에 인스턴스를 대입해서 Thread 인스턴스를 만들고 start()

class ThreadEx extends Thread{
	public void run() {
		try {
			for (int i=0; i<10; i=i+1) {
				Thread.sleep(500);
				System.out.printf("%d\n",  i);
			}
			
		}catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			//스레드를 종료할 수 있도록
			return;
		}
	}
}

public class ThreadWaiting {

	public static void main(String[] args) {
		ThreadEx th1 = new ThreadEx();
		th1.start();
		th1.suspend();
		//resume()을 호출 할 때 까지 일시중지
		try {
			//3초동안 스레드 중지
			//th1.join(3000);
			Thread.sleep(3000);
			//th1 스레드에 InterruptedException을 발생시킵니다.
			//th1.interrupt();
			//3초 동안 스레드를 중지
			
			//suspend 된 스레드를 다시수행
			th1.resume();
			
			
		}catch(Exception e) {
			
		}

	}

}
