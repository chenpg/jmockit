/*
 * Sunyard.com Inc .
 * Copyright (c) 2014-2019 All Rights Reserved.
 */

import mockit.integration.junit4.JMockit;
import org.junit.runner.RunWith;

import javax.annotation.Resource;

/**
 * TODO:请描述本类的作用
 * @version 1.0
 * @update 【1】【2019/1/18 16:48】【zhej.c】【创建】
 */

public class OrderService {
    MailService mailService;
    // 用户身份校验类，用于校验某个用户是不是合法用户
    @Resource
    UserCheckService userCheckService;

    // 构造函数
    public OrderService(MailService mailService) {
        this.mailService = mailService;
    }

    /**
     * 下订单
     *
     * @param buyerId
     *            买家ID
     * @param itemId
     *            商品id
     * @return 返回 下订单是否成功
     */
    public boolean submitOrder(long buyerId, long itemId) {
        // 先校验用户身份
        if (!userCheckService.check(buyerId)) {
            // 用户身份不合法
            return false;
        }
        // 下单逻辑代码，
        // 省略...
        // 下单完成，给买家发邮件
        if (!this.mailService.sendMail(buyerId, "下单成功")) {
            // 邮件发送成功
            return false;
        }
        return true;
    }
}
