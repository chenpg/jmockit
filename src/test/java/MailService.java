/*
 * Sunyard.com Inc .
 * Copyright (c) 2014-2019 All Rights Reserved.
 */

/**
 * TODO:请描述本类的作用
 * @version 1.0
 * @update 【1】【2019/1/18 16:47】【zhej.c】【创建】
 */
public interface MailService {
    /**
     * 发送邮件
     *
     * @param userId
     *            邮件接受人id
     * @param content
     *            邮件内容
     * @return 发送成功了，就返回true,否则返回false
     */
    public boolean sendMail(long userId, String content);
}
