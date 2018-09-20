package com.springboot.api;

import com.springboot.api.activemq.queen.producer.ProducerClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {

	@Autowired
	ProducerClass producerClass;

	@Test
	public void contextLoads() {
		new Thread(()-> {
			for (int i = 0; i < 100; i++) {
				producerClass.sendQueue("第"+i+"次，发送信息，信息内容为： 张三丰您好！我是线程1");
			}
		}).start();

		new Thread(()-> {
			for (int i = 100; i < 200; i++) {
				producerClass.sendQueue("第"+i+"次，发送信息，信息内容为： 张三丰您好！我是线程2");
			}
		}).start();
		new Thread(()-> {
			for (int i = 200; i < 300; i++) {
				producerClass.sendQueue("第"+i+"次，发送信息，信息内容为： 张三丰您好！我是线程3");
			}
		}).start();

		new Thread(()-> {
			for (int i = 300; i < 400; i++) {
				producerClass.sendQueue("第"+i+"次，发送信息，信息内容为： 张三丰您好！我是线程4");
			}
		}).start();

		try {
			Thread.sleep(50000);
			System.out.println("主线程执行完毕");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
