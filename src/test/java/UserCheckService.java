/*
 * Sunyard.com Inc .
 * Copyright (c) 2014-2019 All Rights Reserved.
 */

/**
 * TODO:请描述本类的作用
 * @version 1.0
 * @update 【1】【2019/1/18 16:48】【zhej.c】【创建】
 */
public interface UserCheckService {
    /**
     * 校验某个用户是否是合法用户
     *
     * @param userId
     *            用户ID
     * @return 合法的就返回true,否则返回false
     */
    public boolean check(long userId);
}
