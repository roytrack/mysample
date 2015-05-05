package com.roytrack.maven.account.email;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import com.roytrack.maven.exception.AccountEmailException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.Message;
import javax.mail.MessagingException;

/**
 * Created by roytrack on 2015/4/28.
 */
public class AccountEmailServiceTest {
    private GreenMail greenMail;

    @Before
    public void startMailServer(){
        greenMail=new GreenMail(ServerSetup.SMTP);
        greenMail.setUser("test@roytrack.com","123456");
        greenMail.start();
    }

    @After
    public void stopMailServer(){
        greenMail.stop();
    }

    @Test
    public void testSendMail() throws InterruptedException, MessagingException {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("account-email.xml");
        AccountEmailService service=(AccountEmailService)ctx.getBean("accountEmailService");
        String subject="the email title";
        String htmlText="<h3>Test</h3>";
        try {
            service.sendEmail("test@roytrack.com",subject,htmlText);
        } catch (AccountEmailException e) {
            e.printStackTrace();
        }
        greenMail.waitForIncomingEmail(2000,1);
        Message[] msgs=greenMail.getReceivedMessages();
        Assert.assertEquals(1,msgs.length);
        Assert.assertEquals(subject,msgs[0].getSubject());
        Assert.assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());
        System.out.println(msgs[0].getSubject());
    }

}
