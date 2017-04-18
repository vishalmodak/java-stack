package com.hotel.error;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

@ControllerAdvice
@RestController
public class BaseErrorController implements ErrorController {
 
    private static final String PATH = "/error";
 
    @Autowired
    private ErrorAttributes errorAttributes;
 
    @RequestMapping(value = PATH)
    ErrorJson error(HttpServletRequest request) {
        // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by Spring. 
        // Here we just define response body.
        return buildErrorJSON(extractErrorAttributes(request));
    }
 
    @Override
    public String getErrorPath() {
        return PATH;
    }
 
    private ErrorJson buildErrorJSON(Map<String, Object> errorAttributes) {
        return ErrorJson.newBuilder()
                        .setError((String) errorAttributes.get(ErrorFields.ERROR.getKey()))
                        .setMessage((String) errorAttributes.get(ErrorFields.MESSAGE.getKey()))
                        .setStatus((Integer) errorAttributes.get(ErrorFields.STATUS.getKey()))
                        .setTimeStamp((Date) errorAttributes.get(ErrorFields.TIMESTAMP.getKey()))
                        .setTrace((String) errorAttributes.get(ErrorFields.TRACE.getKey()))
                        .done();
    }
    
    private Map<String, Object> extractErrorAttributes(HttpServletRequest request) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        boolean showStacktrace = includeStacktrace(request);
        if (requestAttributes.getAttribute(ErrorFields.ERROR.getKey(), RequestAttributes.SCOPE_REQUEST) != null) {
            return buildErrorAttributes(requestAttributes, showStacktrace);
        }

        return errorAttributes.getErrorAttributes(requestAttributes, showStacktrace);
    }
    
    private Map<String, Object> buildErrorAttributes(RequestAttributes requestAttributes, boolean showStacktrace) {
        Map<String, Object> customErrorAttributes = new HashMap<>();
        customErrorAttributes.put(ErrorFields.ERROR.getKey(), 
                requestAttributes.getAttribute(ErrorFields.ERROR.getKey(), RequestAttributes.SCOPE_REQUEST));
        Integer status = (Integer) requestAttributes.getAttribute(
                "javax.servlet.error.status_code", RequestAttributes.SCOPE_REQUEST);
        customErrorAttributes.put(ErrorFields.STATUS.getKey(), status);
        customErrorAttributes.put(ErrorFields.PATH.getKey(), 
                requestAttributes.getAttribute("javax.servlet.error.request_uri", RequestAttributes.SCOPE_REQUEST));
        
        Throwable exception = extractException(requestAttributes);
        customErrorAttributes.put(ErrorFields.MESSAGE.getKey(), extractMessage(requestAttributes, exception));
        
        if (showStacktrace) {
            addStackTrace(exception, customErrorAttributes);
        }
        
        customErrorAttributes.put(ErrorFields.TIMESTAMP.getKey(), new Date());
        return customErrorAttributes;
    }
    
    private String extractMessage(RequestAttributes requestAttributes, Throwable exception) {
        String message = (String) requestAttributes.getAttribute(
                ErrorFields.MESSAGE.getKey(), RequestAttributes.SCOPE_REQUEST);
        if (StringUtils.isBlank(message)) {
            //if no error message has been provided, display the message from the exception.
           return exception.getMessage();
        }
        return message;
    }
    
    private Throwable extractException(RequestAttributes requestAttributes) {
        Throwable exception = (Throwable) requestAttributes.getAttribute(
                "org.springframework.boot.autoconfigure.web.DefaultErrorAttributes.ERROR", RequestAttributes.SCOPE_REQUEST);
        if (exception == null) {
            exception = (Throwable) requestAttributes.getAttribute(
                    "javax.servlet.error.exception", RequestAttributes.SCOPE_REQUEST);
        }
        return exception;
    }
    
    private void addStackTrace(Throwable exception, Map<String, Object> customErrorAttributes) {
        customErrorAttributes.put(ErrorFields.EXCEPTION.getKey(), exception.getClass().getName());
        StringWriter stackTrace = new StringWriter();
        exception.printStackTrace(new PrintWriter(stackTrace));
        stackTrace.flush();
        customErrorAttributes.put(ErrorFields.TRACE.getKey(), stackTrace.toString());
    }
    
    private boolean includeStacktrace(HttpServletRequest request) {
        String debugFlag = request.getParameter("debug");
        if (StringUtils.isNotBlank(debugFlag) && Boolean.parseBoolean(debugFlag)) {
            return true;
        }
        return false;
    }

    @ExceptionHandler(value = { MissingServletRequestParameterException.class, IllegalArgumentException.class, 
                                NumberFormatException.class })
    private void handleBadRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
    
    @ExceptionHandler(value = { TimeoutException.class })
    private void handleTimeouts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.GATEWAY_TIMEOUT.value(), "Internal gateway timeout. Please try again later.");
    }
    
    @ExceptionHandler(value = { NoResultsObtainedException.class })
    private void handleNoResults(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), "No results obtained for input criteria.");
    }

    @ExceptionHandler(value = { ArrayIndexOutOfBoundsException.class, IOException.class,
                                RestClientException.class, NullPointerException.class, 
                                HttpServerErrorException.class })
    private void handleInternalFailure(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), 
                            "Unable to continue processing due to internal failure.");
    }
}
