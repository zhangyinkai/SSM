package com.zyk.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class WebExceptionHandle {
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ModelAndView handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String error = "找不到服务器资源";
        log.error(error, e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("thError");
        modelAndView.addObject("e",new ServiceResponse(HttpStatus.BAD_REQUEST.value(),error));
        return modelAndView;
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ModelAndView handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String error = "不支持当前请求方法";
        log.error(error, e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("thError");
        modelAndView.addObject("e",new ServiceResponse(HttpStatus.METHOD_NOT_ALLOWED.value(),error));
        return modelAndView;
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ModelAndView handleHttpMediaTypeNotSupportedException(Exception e) {
        String error = "不支持当前媒体类型";
        log.error(error, e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("thError");
        modelAndView.addObject("e",new ServiceResponse(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(),error));
        return modelAndView;
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        String error = "服务器开小差了~";
        log.error(error, e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("thError");
        modelAndView.addObject("e",new ServiceResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),error));
        return modelAndView;
    }
}
