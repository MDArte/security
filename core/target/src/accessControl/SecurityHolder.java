package accessControl;

import javax.security.auth.Subject;

/**
 * Guarda as informacoes de login.
 *
 */
public class SecurityHolder {
	private static ThreadLocal threadSubject;

	static {
		threadSubject = new ThreadLocal();
	}

	public static Subject getSubject() {
		Subject theSubject = (Subject) threadSubject.get();

		return theSubject;
	}

	public static void setSubject(Subject subject) {
		threadSubject.set(subject);
	}
}
