/*
 * Sunyard.com Inc .
 * Copyright (c) 2014-2019 All Rights Reserved.
 */

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * TODO:请描述本类的作用
 * @version 1.0
 * @update 【1】【2019/1/18 16:49】【zhej.c】【创建】
 */
//@RunWith(JMockit.class)
public class TestedAndInjectable {
    //@Tested修饰的类，表示是我们要测试对象,在这里表示，我想测试订单服务类。JMockit也会帮我们实例化这个测试对象
    @Tested
    private OrderService orderService;
    @Injectable
    private UserCheckService userCheckService;
    @Injectable
    private MailService mailService;

    //测试用户ID
    long testUserId = 123456l;
    //测试商品id
    long testItemId = 456789l;
    String aa="ddd";
    //@Mocked

    // 测试注入方式
    @Test
    public void testSubmitOrder() {
        new Expectations() {
            {
                userCheckService.check(testUserId);
                result = true;
                // 当向testUserId发邮件时，假设都发成功了
                mailService.sendMail(testUserId,anyString);
                result = true;

            }
        };
        /*Expectations只能播放一次。
        new Expectations(){
            {
                metadataService.findChildren(fatherId);
                result = metadataList;
            }
        };
        报错
        LOGGER.info( "孩子id:{}",metadataManager.findChildrenByFatherId(fatherId).getId() );
        Assert.assertEquals("testID",metadataManager.findChildrenByFatherId(fatherId).getId());*/
        // JMockit帮我们实例化了mailService了，并通过OrderService的构造函数，注入到orderService对象中。
        //JMockit帮我们实例化了userCheckService了，并通过OrderService的属性，注入到orderService对象中。
        Assert.assertTrue(orderService.submitOrder(testUserId, testItemId));
    }
}
