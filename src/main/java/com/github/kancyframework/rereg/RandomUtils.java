package com.github.kancyframework.rereg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RandomUtils
 *
 * @author huangchengkang
 * @date 2022/9/15 14:31
 */
public class RandomUtils {

    private static final String zipCode = "^[1-9]\\d{5}$";
    private static final String mobile = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";
    private static final String idCardNo = "^[1-9]\\d{5}(19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9X]$";
    private static final String email = "^\\w{6,12}@[a-z0-9]{3}\\.(com|cn)$";
    private static final String bankCardNo = "^([1-9]{1})(\\d{11}|\\d{15}|\\d{16}|\\d{17}|\\d{18})$";
    private static final String bankDebitCardNo = "^([1-9]{1})(\\d{15}|\\d{16}|\\d{18})$";
    private static final String ipv4 = "^((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}$";
    private static final String http = "^https?://[\\w-]+(\\.[\\w-]+){1,2}(/[\\w-]{3,6}){0,2}(\\?[\\w_]{4,6}=[\\w_]{4,6}(&[\\w_]{4,6}=[\\w_]{4,6}){0,2})?$";

    private static final Map<String, RegexpRandom> regexpRandomCache = new HashMap<>();

    /**
     * 下一个
     *
     * @param expression 正则表达式
     * @return {@link String}
     */
    public static String next(String expression)  {
        RegexpRandom regexpRandom = regexpRandomCache.computeIfAbsent(expression, RegexpRandom::new);
        return regexpRandom.next();
    }

    /**
     * 下一批
     *
     * @param expression 正则表达式
     * @param batchSize  批量大小
     * @return {@link List}<{@link String}>
     */
    public static List<String> nextBatch(String expression, int batchSize) {
        RegexpRandom regexpRandom = regexpRandomCache.computeIfAbsent(expression, RegexpRandom::new);
        return regexpRandom.nextBatch(batchSize);
    }

    public static String nextMobile() {
        return next(mobile);
    }
    public static List<String> nextMobile(int batchSize) {
        return nextBatch(mobile, batchSize);
    }

    public static String nextIdCardNo() {
        return next(idCardNo);
    }
    public static List<String> nextIdCardNo(int batchSize) {
        return nextBatch(idCardNo, batchSize);
    }
    public static String nextEmail() {
        return next(email);
    }
    public static List<String> nextEmail(int batchSize) {
        return nextBatch(email, batchSize);
    }
    public static String nextZipCode() {
        return next(zipCode);
    }
    public static List<String> nextZipCode(int batchSize) {
        return nextBatch(zipCode, batchSize);
    }
    public static String nextBankCardNo() {
        return next(bankCardNo);
    }
    public static List<String> nextBankCardNo(int batchSize) {
        return nextBatch(bankCardNo, batchSize);
    }
    public static String nextBankDebitCardNo() {
        return next(bankDebitCardNo);
    }
    public static List<String> nextBankDebitCardNo(int batchSize) {
        return nextBatch(bankDebitCardNo, batchSize);
    }
    public static String nextIp() {
        return next(ipv4);
    }
    public static List<String> nextIp(int batchSize) {
        return nextBatch(ipv4, batchSize);
    }
    public static String nextHttp() {
        return next(http);
    }
    public static List<String> nextHttp(int batchSize) {
        return nextBatch(http, batchSize);
    }

}
