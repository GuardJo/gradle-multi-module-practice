package io.github.guardjo.multimodule.async.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AsyncService {
    private final NotificationService notificationService;

    /*
    Spring Bean 으로 주입받은 객체 사용 시 spring에서 정상적으로 비동기처리가 수행됨
    spring에서 asnyc 어노테이션을 사용한 비동기 처리는 해당 bean 객체를 프록시 객체로 
    래핑 한 후 처리하기에 bean으로 설정된 객체에 한해서만 비동기 처리 작업을 수행할 수 있음
     */
    public void executeWithBean() {
        log.info("Execute with Bean");

        notificationService.sendEmail();
        notificationService.sendEmailWithCustomExecutor();
    }

    /*
    인스턴스를 새로 생성 후 호출할 경우 spring에서 관리할 수 있는 객체가 아니기에 
    spring에서 제공하는 asnyc 어노테이션을 사용할 수가 없게 됨
     */
    public void executeWithNewInstance() {
        log.info("Execute with New Instance");

        NotificationService instance = new NotificationService();
        instance.sendEmail();
        instance.sendEmailWithCustomExecutor();
    }

    /*
    내부 메소드로 호출한 경우에도 비동기 처리 작업이 수행되지 않음
    이는, 현재 객체가 bean 객체이지만 이미 bean 객체로 읽어 들인 후 그 안에 내부 메소드를 호출 했기 떄문임
    앞선 주석처럼 spring에서는 asnyc 수행 시 해당 bean을 proxy bean으로 래핑 후 사용해야 하는데 이미
    해당 메소드 요청을 위해 일반 bean으로 읽은 후이기에 내부 메소드 호출 시에는 asnyc 어노테이션이 수행되지 않음
     */
    public void executeWithInnerMethod() {
        log.info("Execute with Inner Method");

        sendEmail();
    }

    @Async
    public void sendEmail() {
        log.info("Send Email!");
    }
}
