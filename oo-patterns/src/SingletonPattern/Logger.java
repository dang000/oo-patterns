/**
 * 	-> Singleton Pattern
 *
 *	1. Create class with private static instance of self (set to null)
 *	2. Create default constructor as private
 *	3. Create public static getInstance function to return the current
 *     instance; create a new instance if it does not exist
 *
 */

package SingletonPattern;

public class Logger {
	private static Logger thisInstance = null;

	private Logger() {}

	public static Logger getInstance() {
		if (thisInstance == null)
			thisInstance = new Logger();

		return thisInstance;
	}

	public void log(String s) {
		System.out.println(s);
	}
}

class Test {
	public static void main(String[] args) {
		Logger logger = Logger.getInstance();
		logger.log("Test log");
	}
}