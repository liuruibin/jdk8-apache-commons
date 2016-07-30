package com.huixing.commons;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;

import java.util.*;

/**
 *
 */
public class TestCommons {
    @Test
    public void testStringUtils() {
        String str1 = "str1";
        String str2 = "str2";
        List<String> strings = Arrays.asList("111", "222", "333");

        StringUtils.isBlank(str1);
        StringUtils.isEmpty(str2);
        System.out.println("equals:" + StringUtils.equals(str1, str2));
        System.out.println("left:" + StringUtils.left(str1, 2)); // 截取左边2个字符
        System.out.println("leftPad ' ':" + StringUtils.leftPad(str1, 5)); // 左边补空格
        System.out.println("leftPad '*':" + StringUtils.leftPad(str1, 5, "*")); // 左边补*
        System.out.println("join:" + StringUtils.join(strings, "-"));

        System.out.println(StringEscapeUtils.unescapeJava("\u4E2D\u6587"));// unicode 转中文
        System.out.println(StringEscapeUtils.escapeJava("中文"));// 中文转unicode
    }

    @Test
    public void testExceptionUtils() {
        Exception e = new Exception();
        System.out.println(ExceptionUtils.getStackTrace(e));// 获取异常堆栈信息
        ExceptionUtils.getRootCauseMessage(e);
        ExceptionUtils.getMessage(e);
    }

    @Test
    public void testRandomUtils() {
        System.out.println(RandomUtils.nextInt(100000, 999999)); // 随机数生成器
        System.out.println(RandomUtils.nextLong(1, 10));
        System.out.println(RandomUtils.nextDouble(1, 10));
    }

    @Test
    public void testCollectionUtils() {
        Collection collections = new ArrayList();
        System.out.println(CollectionUtils.isEmpty(collections)); // 集合判断空值
    }

    @Test
    public void testMapUtils() {
        Map map = new HashMap();
        map.put("key", "value");
        System.out.println(MapUtils.isEmpty(map)); // map 判断空
        Object key = "key";
        System.out.println(MapUtils.getString(map, key));
    }

    @Test
    public void testDigestUtils() throws Exception {
        System.out.println(DigestUtils.md5Hex("123456"));// md5
    }

    @Test
    public void testBeanUtils() throws Exception {
        Object orig = new Object();
        Object dest = new Object();
        BeanUtils.copyProperties(dest, orig);
    }

}