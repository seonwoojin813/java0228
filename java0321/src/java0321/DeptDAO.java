package java0321;

import java.util.List;

//작업을 수행할 클래스의 메소드 원형을 만들어둔 인터페이스
//클라이언트나 PM과 대화할 때 사용
public interface DeptDAO { 
        //데이터를 삽입하는 메소드
        //매개변수는 되도록이면 없거나 1개로 만드는 것이 좋습니다.
	    //이름은 어떤 작업을 수행하는지 알 수 있도록 해주는 것이 좋습니다.
	    //리턴타입은 작업의 결과를 확인할 수 있도록 해주는 것이 좋습니다.
	    //insert, delete, update 의 리턴타입은 int
	
	//public 리턴타입 insertMyDEPT(int deptno, String dname, String loc); -->이거를 세개를 하나로 묶을 수 있음
	public int insertMyDEPT(MyDEPT  myDEPT);
	
	//mydept 테이블의 데이터를 수정하는 메소드
	//수정하는 메소드는 모양이 삽입하는 메소드와 동일
	public int updateMyDEPT(MyDEPT myDEPT);
	
	
	//데이터를 삭제하는 메소드
	public int deleteMyDEPT(int deptno);
	
	//조건없이 테이블의 모든 데이터를 가져오는 메소드
	//여러개의 데이터를 조회할 때는 리턴타입이 List
	//매개변수는 where 절에 설정되는 조건
	public List <MyDEPT> listMyDEPT(); 
	
	
	//테이블에서 기본키를 가지고 하나의 데이터를 찾아오는 메소드  - 상세보기, 데이터 수정을 할 때 기본정보를 가져오는 메소드
	public MyDEPT getMyDEPT(int deptno);
	
	
	
}
