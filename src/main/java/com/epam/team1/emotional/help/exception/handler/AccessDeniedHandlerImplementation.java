package com.epam.team1.emotional.help.exception.handler;

import com.epam.team1.emotional.help.exception.dto.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

@Slf4j
@Component
public class AccessDeniedHandlerImplementation implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException exception) throws IOException, ServletException {
        log.error("Exception = " + exception.getClass().getSimpleName() + " date = " + new Date() + " message = " + exception.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(403, exception.getMessage(),
                System.currentTimeMillis(),exception.getClass().getSimpleName(),httpServletRequest.getServletPath());

        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.setStatus(403);

        OutputStream out = httpServletResponse.getOutputStream();
        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, errorResponse);
        out.flush();
    }
}
