package customer;

public class Member { // 현재 로그인한 멤버의 정보를 담는 클래스
	public static String mNum = "0";
	public static String mId;
	public static String mPwd;
	public static String mName;
	public static String mBirth;
	public static String mAddress;
	public static String mPhone;
	public static String mEmail;
	public static String mGrade;
	public static String mPoint = "0";
	
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

	public static String getmNum() {
		return mNum;
	}

	public static String getmId() {
		return mId;
	}

	public static String getmPwd() {
		return mPwd;
	}

	public static String getmName() {
		return mName;
	}

	public static String getmBirth() {
		return mBirth;
	}

	public static String getmAddress() {
		return mAddress;
	}

	public static String getmPhone() {
		return mPhone;
	}

	public static String getmEmail() {
		return mEmail;
	}

	public static String getmGrade() {
		return mGrade;
	}

	public static String getmPoint() {
		return mPoint;
	}
	

	@Override
	public String toString() {
		return mNum + mId + mPwd + mName + mBirth + mAddress + mPhone + mEmail + mGrade + mPoint;
	}
	
}
