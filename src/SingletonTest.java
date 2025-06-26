public class SingletonTest {
	
	private static volatile SingletonTest s;
	
	private SingletonTest() {
		
	}
	
	public static SingletonTest getInstance() {
		if(s==null) {
			synchronized (SingletonTest.class) {
				if(s==null) {
					s= new SingletonTest();
				}
			}
		}
		return s;
	}

}
