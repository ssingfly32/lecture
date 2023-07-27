package ksh;

public class Korean {
	// 대한민국 국민은 주민등록번호, 이름
	private String registerNo;
	private String name;
	
	public Korean(String registerNo, String name) {
		this.registerNo = registerNo;
		this.name = name;
	}
	
	public String getRegisterNo() {
		return this.registerNo;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		if(name.length() <= 4) {
			this.name = name;
		}
	}
	
	
	// 주민등록번호와 이름이 같으면 true, 나머지 경우엔 false
	@Override
	public boolean equals(Object obj) { // obj가 업캐스팅되서
		boolean result = false;
		
		// 넘겨받은 obj가 Korean 타입이라면..
		if(obj instanceof Korean) {  
			Korean tmp = (Korean) obj; // 코리안으로 다운캐스팅
			// 주민등록번호와 이름이 같을 때 같은 객체로 인식
			if((this.registerNo.equals(tmp.registerNo)) 
					&& (this.name.equals(tmp.name))) {
				result = true;
			}
		}
		return result;
	}
	
	

	@Override
	public int hashCode() {
		// 주민등록번호(문자열) + 이름(문자열)을 더해
		// 주민등록번호와 이름이 같은 경우에는 같은 주소가 반환되도록.. 했다.
		return (this.registerNo + this.name).hashCode();
	}

	@Override
	public String toString() {
		return "주민번호 : " + this.registerNo + ", 이름 : " + this.name + "(객체 주소 : " + this.hashCode() + ")"; 
	}
}
