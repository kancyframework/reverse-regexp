package com.github.kancyframework.rereg;

import org.junit.Test;

import java.util.Random;

/**
 * RegexpRandomTest
 *
 * @author huangchengkang
 * @date 2022/9/15 14:27
 */
public class RegexpRandomTest {

    @Test
    public void test1() {
        RegexpRandom random = new RegexpRandom("1(3|5|7|8)\\d{9}");
        System.out.println(random.next());
        System.out.println(random.nextBatch(10));
        System.out.println(random.next("1(3|5|7|8)\\d{9}"));
        System.out.println(random.next("^1(3|5|7|8)\\d{9}$"));
        System.out.println(random.nextBatch("^1(3|5|7|8)\\d{9}$", 10));
    }

    @Test
    public void test2() {
        RegexpRandom random = new RegexpRandom();
        System.out.println(random.next("1(3|5|7|8)\\d{9}"));
        System.out.println(random.next("^1(3|5|7|8)\\d{9}$"));
        System.out.println(random.nextBatch("^1(3|5|7|8)\\d{9}$", 10));
    }

    @Test
    public void test3() {
        System.out.println(RandomUtils.next("1(3|5|7|8)\\d{9}"));
        System.out.println(RandomUtils.next("^1(3|5|7|8)\\d{9}$"));
        System.out.println(RandomUtils.nextBatch("^1(3|5|7|8)\\d{9}$", 10));
    }

    @Test
    public void test4() {
        System.out.println(RandomUtils.nextEmail(5));
        System.out.println(RandomUtils.nextZipCode(5));
        System.out.println(RandomUtils.nextIdCardNo(5));
        System.out.println(RandomUtils.nextBankCardNo(5));
        System.out.println(RandomUtils.nextBankDebitCardNo(5));
        System.out.println(RandomUtils.nextIp(5));
        System.out.println(RandomUtils.nextMobile(5));
        System.out.println(RandomUtils.nextHttp(5));
    }
}
