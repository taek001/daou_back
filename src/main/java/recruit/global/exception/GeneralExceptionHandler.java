package recruit.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import recruit.global.enumeration.CommonResCode;
import recruit.global.model.ApiRes;
import recruit.global.model.ApiResStatus;

import java.sql.SQLException;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

  protected ResponseEntity<Object> buildResponseEntity(ApiRes<Void> resultDto) {
    return ResponseEntity.ok(resultDto);
  }


  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    String message = "잘못된 요청입니다. 잠시 후 다시 이용바랍니다.";
    if (!ex.getBindingResult().getFieldErrors().isEmpty()) {
      message = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
    } else if (!ex.getBindingResult().getGlobalErrors().isEmpty()) {
      message = ex.getBindingResult().getGlobalErrors().get(0).getDefaultMessage();
    }

    return buildResponseEntity(
      ApiRes.<Void>builder()
      .result(
        ApiResStatus.builder().success(false).code("REQUEST_DATA_INVALID").message(message).build()
      )
      .build()
    );
  }


  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    String errMsg = String.format("%s URL 에서 %s 요청을 지원하지 않습니다.", ex.getRequestURL(), ex.getHttpMethod());

    return buildResponseEntity(
      ApiRes.<Void>builder()
        .result(
          ApiResStatus.builder().success(false).code("REQUEST_DATA_INVALID").message(errMsg).build()
        )
        .build()
    );
  }


  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    log.info("-- HttpMessageNotReadable Exception 발생", ex);
    ApiRes<Void> responseDto = new ApiRes<>(CommonResCode.HTTP_MESSAGE_NOT_READABLE_EXCEPTION);
    return buildResponseEntity(responseDto);
  }


  @Override
  protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    log.info("-- MissingServletRequestParameter Exception 발생", ex);
    ApiRes<Void> responseDto = new ApiRes<>(CommonResCode.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION);
    return buildResponseEntity(responseDto);
  }


  @Override
  protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    log.info("-- MissingPathVariableException 발생..!!", ex);
    ApiRes<Void> responseDto = new ApiRes<>(CommonResCode.MISSING_PATH_VARIABLE_EXCEPTION);
    return buildResponseEntity(responseDto);
  }


  @ExceptionHandler(SQLException.class)
  protected ResponseEntity<Object> handleSQLException(SQLException ex) {
    log.info("-- SQLException 발생..!!", ex);
    return buildResponseEntity(new ApiRes<>(CommonResCode.SQL_EXCEPTION));
  }

  @ExceptionHandler(NullPointerException.class)
  protected ResponseEntity<Object> handleNullPointException(NullPointerException ex) {
    log.info("-- NullPointException 발생..!!", ex);
    return buildResponseEntity(new ApiRes<>(CommonResCode.NULL_POINT_EXCEPTION));
  }

  @ExceptionHandler(BasicException.class)
  protected ResponseEntity<Object> handleBasicException(BasicException ex) {
    return buildResponseEntity(ex.toApiRes());
  }
}
