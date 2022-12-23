package AccountOperations;
import com.databases.AccountDate;
import com.exceptions.InvalidAccNumber;
import com.exceptions.InvalidInputException;
import com.exceptions.LowBalException;

public interface AccountOperation {
	void accOpen(String accType, float amount) throws InvalidInputException;
	void deposit(int accNo,String accType, float amount) throws InvalidAccNumber;
	void withdraw(int accNo,String accType, int amount) throws InvalidAccNumber,LowBalException;
	String toString();
	void enquire(int accNo,String accType) throws InvalidAccNumber,LowBalException;
	void deleteAccount(int accNum,String accType) throws InvalidAccNumber;
	int getLastAccNum();
}
