package com.kn.springbootlearn;

import com.kn.springbootlearn.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLearnApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(SpringbootLearnApplicationTests.class);
    @Value("${user.name}")
    private String name;
    @Autowired
    DataSource dataSource;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AmqpAdmin amqpAdmin;
    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void datasource() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(dataSource.getClass());
        System.out.println(connection);
    }

    /**
     * 测试rabbitmq
     */
    //1.单播,点对点
    @Test
    public void sendMessage(){
        //message需要自己构造一个,定义消息体内容,消息头
        //rabbitTemplate.send(exchange, routingKey, message);

        //object默认当成消息体,传入消息对象,自动序列化发送
        Map<String, Object> map = new HashMap<>();
        map.put("name","aaaaa");
        map.put("age",14);
        rabbitTemplate.convertAndSend("exchange.direct","user.name",roleService.findAllRole());
    }

    @Test
    public void sendByFanout(){
        rabbitTemplate.convertAndSend("exchange.fanout","",roleService.getRoleById(1));
    }

    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("user.name");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    @Test
    public void setAmqpAdmin(){
        //定义交换机
        amqpAdmin.declareExchange(new FanoutExchange("admin.exchange"));
        //定义队列
        amqpAdmin.declareQueue(new Queue("admin.queue"));
        //绑定规则
        amqpAdmin.declareBinding(new Binding("admin.queue", Binding.DestinationType.QUEUE,"admin.exchange","admin.queue",null));
    }

    /**
     * 测试发送邮件
     */
    @Test
    public void sendSimpleMail(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("邮件测试");
        simpleMailMessage.setText("测试邮件");
        simpleMailMessage.setFrom("1123542383@qq.com");
        simpleMailMessage.setTo("lvkenan@eyee.com");

        mailSender.send(simpleMailMessage);
    }

    @Test
    public void sendMineMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //multipart  可以发送图片
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("邮件测试");
        helper.setText("<b style='color:green'>测试邮件</b>",true);
        helper.setFrom("1123542383@qq.com");
        helper.setTo("lvkenan@eyee.com");

        helper.addAttachment("截图", new File("C:\\Users\\11235\\Pictures\\Saved Pictures\\企业微信截图_1535169734136.png"));
        mailSender.send(mimeMessage);
    }
}
