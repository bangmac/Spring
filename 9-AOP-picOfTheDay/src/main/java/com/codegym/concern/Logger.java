package com.codegym.concern;

import com.codegym.model.Comment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;


@Aspect
public class Logger {

    public void badWordNotify() {
        System.out.println("badword");
    }

    @AfterThrowing(pointcut =
            "execution(public * com.codegym.service.CommentService.checkBadWord(..))",
            throwing = "e")
//    @AfterThrowing được thực hiện sau khi join point được kết thúc bằng một Exception
    // @AfterThrowing là một advice

// pointcut được viết ở trên mô tả rằng phương thức log được thực thi khi phương thức triển khai
// checkBadWord từ interface CustomerService tung ra ngoại lệ thực thi.
// Dấu .. ngu ý rằng poincut này áp dụng cho mọi bộ tham số của checkBadWord.
    public void log(JoinPoint joinPoint, Exception e) {
//        đối tượng Joinpoint để lấy thông tin về class, method, và bộ tham số nhằm debug dễ hơn

//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        String method = joinPoint.getSignature().getName();
//        String args = Arrays.toString(joinPoint.getArgs());
//        System.out.println(String.format("badword : %s.%s  %s: %s", className, method, args, e.getMessage()));


        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg : signatureArgs) {
            Comment comment = (Comment) signatureArg;
            String time = java.time.LocalTime.now().toString();
            System.out.println("BAD WORD DETECTED"
                    +"Feedback:" + comment.getFeedback()
                    + ". Author: " + comment.getAuthor()
                    + ". Date: " + comment.getDate()
                    +". Time: "+ time);
        }
    }
}
