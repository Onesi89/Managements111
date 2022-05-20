package customer;

public class Member { // 현재 로그인한 멤버의 정보를 담는 클래스 static ->private 로 바꿈
	private String mNum = "0";
	private String mId;
	private String mPwd;
	private String mName;
	private String mBirth;
	private String mAddress;
	private String mPhone;
	private String mEmail;
	private String mGrade;
	private String mPoint = "0";

	
	public Member(String mNum, String mId, String mPwd, String mName, String mBirth, String mAddress, String mPhone,
			String mEmail, String mGrade, String mPoint) {
		this.mNum = mNum;
		this.mId = mId ;
		this.mPwd = mPwd ;
		this.mName = mName ;
		this.mBirth = mBirth ;
		this.mAddress = mAddress ;
		this.mPhone = mPhone ;
		this.mEmail = mEmail ;
		this.mGrade = mGrade ;
		this.mPoint = mPoint ;
		
	}

	public String getmNum() {
		return mNum;
	}
	

	public String getmId() {
		return mId;
	}

	public String getmPwd() {
		return mPwd;
	}
	public void setmPwd(String mPwd) {
		this.mPwd = mPwd;
	}

	public String getmName() {
		return mName;
	}

	public String getmBirth() {
		return mBirth;
	}

	public String getmAddress() {
		return mAddress;
	}
	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	
	public String getmGrade() {
		return mGrade;
	}

	public String getmPoint() {
		return mPoint;
	}
	
	
	public void minusPoint(int usePoint) {
		this.mPoint = String.valueOf((Integer.parseInt(this.mPoint) - usePoint));
	}
	
	public void plusPoint(int plusPoint) {
		this.mPoint = String.valueOf((Integer.parseInt(this.mPoint) + plusPoint));
	}

	@Override
	public String toString() {
		return mNum + mId + mPwd + mName + mBirth + mAddress + mPhone + mEmail + mGrade + mPoint;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			if (this.getmId().equals(((Member) obj).getmId()))
				return true;
		}
		return false;
	}

	
}
