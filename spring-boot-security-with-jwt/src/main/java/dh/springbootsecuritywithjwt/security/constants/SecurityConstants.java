package dh.springbootsecuritywithjwt.security.constants;

public final class SecurityConstants {
    // the path which need to be authenticated
    public static final String AUTH_LOGIN_URL = "/api/authenticate";

    // the secret which used for create token
    public static final String TOKEN_SECRET = "n2r5u8x/A%D*G-KaPdSgVkYp3s6v9y$B&E(H+MbQeThWmZq4t7w!z%C*F-J@NcRf";

    public static final String TOKEN_HEADER = "Authentication";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "secure-api: dh";
    public static final String TOKEN_AUDIENCE = "secure-app: white-cat";

    private SecurityConstants() {
        throw new IllegalStateException("can not create the instance of the class");
    }
}
