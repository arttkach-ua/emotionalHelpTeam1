package com.epam.team1.emotional.help.exception;


import com.epam.team1.emotional.help.exception.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * It can be used by one of the security filters as an AuthenticationException handler,
 * because exceptions arised in filters cannot be handled in the class with @RestControllerAdvice annotation.
 *
 *  (it handles exceptions which have bean thrown after reaching to dispatcher servlet)
 * for setting this class as a handler we can use httpSecurity.exceptionHandling().authenticationEntryPoint(unauthorizedHandler) method
 * in security config class
 */
@Slf4j
@Component("restAuthenticationEntryPoint")
public class AuthenticationEntryPointImplementation implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException exception)
            throws IOException, ServletException {

        log.error("RestAuthenticationEntryPoint " + "Unauthorized error: {}", exception.getMessage() + " , exception type is " + exception.getClass().getSimpleName() );


        ErrorResponse errorResponse = new ErrorResponse(401,
                exception.getMessage(),
                System.currentTimeMillis(),
                exception.getClass().getSimpleName(),
                request.getServletPath()
        );


        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        OutputStream out = response.getOutputStream();
        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, errorResponse);
        out.flush();
    }

}
