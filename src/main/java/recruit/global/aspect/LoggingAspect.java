package recruit.global.aspect;

import recruit.global.util.HttpRequestUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Aspect
@Slf4j
@Component
@Order(10)
@RequiredArgsConstructor
public class LoggingAspect {

  @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
  public void springBeanPointcut() {
  }

  @Around("springBeanPointcut()")
  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    String requestFrom = requestFrom();
    Object endResponse;

    loggingIn(requestFrom, joinPoint);

    try {
      endResponse = joinPoint.proceed();
      loggingOut(requestFrom, joinPoint, endResponse);

      return endResponse;
    } catch (Exception e) {
      loggingError(joinPoint, e);
      throw e;
    }
  }

  private String requestFrom() {
    ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    if (servletRequestAttributes != null) {
      HttpServletRequest request = servletRequestAttributes.getRequest();
      String requestUrl = request.getMethod() + " " + request.getRequestURI();
      String remoteIp = HttpRequestUtil.getIp(request);
      return requestUrl + " (IP:" + remoteIp + ")";
    }
    return "";
  }

  private void loggingIn(String requestFrom, JoinPoint joinPoint) {
    log.info("### IN ## {} => {}.{}() ## Args: {}",
      requestFrom,
      joinPoint.getSignature().getDeclaringTypeName(),
      joinPoint.getSignature().getName(),
      Arrays.toString(joinPoint.getArgs())
    );
  }

  private void loggingOut(String requestFrom, JoinPoint joinPoint, Object endResponse) {
    if (requestFrom.contains("car/list") || requestFrom.contains("car/detail")) {
      return;
    }
    log.info("### OUT ## {} => {}.{}() ## 결과: {}",
      requestFrom,
      joinPoint.getSignature().getDeclaringTypeName(),
      joinPoint.getSignature().getName(), endResponse
    );
  }

  private void loggingError(JoinPoint joinPoint, Exception e) {
    log.error("### 예외 발생: {}.{}() ## 메세지:{} ## 원인: {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
      e.getMessage(), (e.getCause() != null) ? e.getCause().getMessage() : "알 수 없음");
  }

  private String generateExceptionMessage(JoinPoint joinPoint, Exception e) {
    String requestFrom = requestFrom();
    return "*- Point:* " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()
      + "\n*- Exception:* `" + e.getClass() + "`"
      + "\n*- Message:* " + e.getMessage()
      + "\n*- Request:* " + requestFrom
      + "\n*- Params:* " + Arrays.toString(joinPoint.getArgs());
  }
}
