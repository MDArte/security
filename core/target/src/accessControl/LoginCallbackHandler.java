// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: LoginCallbackHandler.java.vsl in andromda-bpm4struts-cartridge-coppetec.
//
package accessControl;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;


public class LoginCallbackHandler implements CallbackHandler {
    private String username;
    private String password;

    public LoginCallbackHandler(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void handle(Callback[] callbacks)
        throws java.io.IOException, UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            if (callbacks[i] instanceof NameCallback) {
                NameCallback nc = (NameCallback) callbacks[i];
                nc.setName(username);
            } else if (callbacks[i] instanceof PasswordCallback) {
                PasswordCallback pc = (PasswordCallback) callbacks[i];
                pc.setPassword(password.toCharArray());
            } else {
                throw new UnsupportedCallbackException(callbacks[i], "Error");
            }
        }
    }
}