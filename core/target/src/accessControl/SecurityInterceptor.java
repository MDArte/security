package accessControl;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Responsavel por interceptar chamadas de servicos EJB3.
 *
 */
public class SecurityInterceptor extends SecurityBase {

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		interceptServiceMethod(ctx.getMethod(), ctx.getParameters(), ctx.getTarget());

		return ctx.proceed();
	}
}
