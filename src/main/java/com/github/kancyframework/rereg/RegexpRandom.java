package com.github.kancyframework.rereg;

import org.laziji.commons.rereg.model.Node;
import org.laziji.commons.rereg.model.OrdinaryNode;

import java.util.*;

/**
 * 通过正则随机生成数据
 *
 * @author huangchengkang
 * @date 2022/9/15 13:55
 */
public class RegexpRandom {

    /**
     * 默认正则表达式
     */
    private String defaultExpression;

    /**
     * 数据缓存
     */
    private static final Map<String, Node> nodeCache = new HashMap<>();

    public RegexpRandom() {
    }

    public RegexpRandom(String defaultExpression) {
        this.defaultExpression = defaultExpression;
    }

    /**
     * 下一个
     *
     * @return {@link String}
     */
    public String next() {
        throwNotSetDefaultExpressionError();
        return next(this.defaultExpression);
    }

    /**
     * 下一批
     *
     * @param batchSize 批量大小
     * @return {@link List}<{@link String}>
     */
    public List<String> nextBatch(int batchSize) {
        throwNotSetDefaultExpressionError();
        return nextBatch(this.defaultExpression, batchSize);
    }

    /**
     * 下一个
     *
     * @param expression 正则表达式
     * @return {@link String}
     */
    public String next(String expression)  {
        try {
            Node node = nodeCache.computeIfAbsent(expression, this::initNode);
            return node.random();
        } catch (Exception e) {
            throw new RegexpRandomException(e);
        }
    }

    /**
     * 下一批
     *
     * @param expression 正则表达式
     * @param batchSize  批量大小
     * @return {@link List}<{@link String}>
     */
    public List<String> nextBatch(String expression, int batchSize) {
        try {
            Node node = nodeCache.computeIfAbsent(expression, this::initNode);
            LinkedList<String> linkedList = new LinkedList<>();
            for (int i = 0; i < batchSize; i++) {
                linkedList.add(node.random());
            }
            return linkedList;
        } catch (Exception e) {
            throw new RegexpRandomException(e);
        }
    }

    /**
     * 初始化节点
     *
     * @param expression 表示
     * @return {@link Node}
     */
    private Node initNode(String expression){
        try {
            return new OrdinaryNode(decodeExpression(expression));
        } catch (Exception e) {
            throw new RegexpRandomException(e);
        }
    }

    /**
     * 解码表达式
     *
     * @param expression 正则表达式
     * @return {@link String}
     */
    private String decodeExpression(String expression) {
        if (Objects.isNull(expression)){
            return null;
        }
        StringBuilder finalExpression = new StringBuilder(expression);
        if (expression.startsWith("^")){
            finalExpression.deleteCharAt(0);
        }
        if (expression.endsWith("$")){
            finalExpression.deleteCharAt(finalExpression.length()-1);
        }
        return finalExpression.toString();
    }

    /**
     * 抛出未设置默认表达式错误
     */
    private void throwNotSetDefaultExpressionError() {
        if (Objects.isNull(defaultExpression) || defaultExpression.isEmpty()) {
            throw new RegexpRandomException("Not set default expression");
        }
    }

}
