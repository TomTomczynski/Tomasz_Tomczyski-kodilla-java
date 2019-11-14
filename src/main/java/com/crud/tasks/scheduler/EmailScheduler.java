package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
public class EmailScheduler {
    @Autowired
    private SimpleEmailService simpleEmailService;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private AdminConfig adminConfig;
    private static final String SUBJECT = "Tasks: Once a day email";
    //    @Scheduled(cron = "0 0 10 * * *")
    @Scheduled(fixedDelay = 10)
    public void senInformationEmail() {
        long size = taskRepository.count();
        String message = size < 1 ? "You currently don't have any tasks in the database."
                : size == 1 ? ("Currently in database you got: " + size + " task.")
                : "Currently in database you got: " + size + " task.";
        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                message,
                null
        ));
        System.out.println(message);
    }

}
