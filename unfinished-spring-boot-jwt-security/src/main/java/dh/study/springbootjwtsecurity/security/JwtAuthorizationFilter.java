package dh.study.springbootjwtsecurity.security;

import dh.study.springbootjwtsecurity.constants.SecurityConstants;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * this filter handles all HTTP requests and checks if there is an Authorization header with the correct token.
 * For example, if the token is not expired or if the signature key is correct.
 *
 * If the token is valid then the filter will add authentication data into Spring’s security context.
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private static final Logger log = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

    }
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
        var token = request.getHeader(SecurityConstants.TOKEN_HEADER);
        if(StringUtils.isNotEmpty(token) && token.startsWith(SecurityConstants.TOKEN_PREFIX)){
            try{
                var signingKey = SecurityConstants.JWT_SECRET.getBytes();

                var parsedToken = Jwts.parser()
                        .setSigningKey(signingKey)
                        .parseClaimsJws(token.replace("Bearer", ""));

                var username = parsedToken
                        .getBody()
                        .getSubject();

                var authorities = ((List<?>)parsedToken.getBody()
                        .get("rol")).stream()
                        .map(authority -> new SimpleGrantedAuthority((String)authority))
                        .collect(Collectors.toList());

                if(StringUtils.isNotEmpty(username)){
                    return new UsernamePasswordAuthenticationToken(username, null, authorities);
                }
            }catch (ExpiredJwtException e){
                log.warn("Request to parse expired JWT : {} failed : {}", token, e.getMessage());
            } catch (UnsupportedJwtException exception) {
                log.warn("Request to parse unsupported JWT : {} failed : {}", token, exception.getMessage());
            } catch (MalformedJwtException exception) {
                log.warn("Request to parse invalid JWT : {} failed : {}", token, exception.getMessage());
            } catch (SignatureException exception) {
                log.warn("Request to parse JWT with invalid signature : {} failed : {}", token, exception.getMessage());
            } catch (IllegalArgumentException exception) {
                log.warn("Request to parse empty or null JWT : {} failed : {}", token, exception.getMessage());
            }
        }
        return null;
    }
}
