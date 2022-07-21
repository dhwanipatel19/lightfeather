package io.lightfeather.managementstyle.apierrors;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errorMessage = ex.getBindingResult().getAllErrors().stream()
                                            .map(ObjectError::getDefaultMessage)
                                            .collect(Collectors.toList());
      return new ApiError(HttpStatus.UNPROCESSABLE_ENTITY.value(), new Date(), errorMessage.toString(), "Required Entity");              
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ApiError handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        return new ApiError(HttpStatus.METHOD_NOT_ALLOWED.value(), new Date(), ex.toString(), "Check Method Type");              
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ApiError handleMethodNotSupported(HttpMediaTypeNotSupportedException ex) {
        return new ApiError(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), new Date(), ex.toString(), "Check Media Type");              
    }
}
