package com.example.project_swing_jdbc.aspects;

import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterWindowAspect {
    final Logger LOGGER_CONTROLLER = Logger.getLogger(RegisterWindowAspect.class.getName());
    @Pointcut(value = "execution(void com.example.project_swing_jdbc.controller.WindowController.window())")
    public void loggingWindow() {}

    @Order(1)
    @Before(value = "loggingWindow()")
    public void beforeLoggingWindowAspect(JoinPoint point) {
        String nameMethode = point.getSignature().getName();
        LOGGER_CONTROLLER.info(String.format("[%s -> %s, начал работу]", "Метод", nameMethode));
    }

    @Order(2)
    @After(value = "execution(void com.example.project_swing_jdbc.controller.WindowController.window())")
    public void afterLoggingWindowAspect(JoinPoint point) {
        String nameMethode = point.getSignature().getName();
        LOGGER_CONTROLLER.info(String.format("[%s -> %s, завершил работу]", "Метод", nameMethode));
    }


}
