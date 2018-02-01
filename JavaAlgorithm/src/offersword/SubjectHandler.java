package offersword;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectHandler implements InvocationHandler {
	
	private Subject subject;
	public SubjectHandler(Subject subject){
        this.subject = subject;
    }

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before rent house");
        method.invoke(subject, args);
        System.out.println("after rent house");
        return null;
	}

}
