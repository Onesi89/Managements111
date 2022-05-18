package interfaceList;

import java.io.IOException;
import java.util.InputMismatchException;

public interface HumanInfoEditable {
	void listCall();
	void addToList() throws InputMismatchException, IOException, NumberFormatException;
	void delFromList()throws InputMismatchException, IOException, NumberFormatException;
	void listWrite(boolean trueOrFalse)throws InputMismatchException, IOException, NumberFormatException;
	//equals 도 오버라이딩하세요.
	

}
