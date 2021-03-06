package org.gollum.common.util;

import org.gollum.common.exception.InvalidArgumentException;

/**
 * @author wurenhai
 * @date 2017/12/28
 */
public final class Assertion {

    /**
     * 非空对象
     *
     * @param argument
     * @param format
     * @param args
     * @param <T>
     */
    public static <T> void notNull(T argument, String format, Object... args) {
        if (argument == null) {
            throw new InvalidArgumentException(String.format(format, args) + " cannot be null");
        }
    }

    /**
     * 非空字符串
     *
     * @param argument
     * @param name
     */
    public static void notNullOrEmpty(String argument, String name) {
        if (argument == null || argument.isEmpty()) {
            throw new InvalidArgumentException(name + " cannot be null or empty");
        }
    }

    /**
     * 负数
     *
     * @param number
     * @param name
     */
    public static void negative(long number, String name) {
        if (number >= 0) {
            throw new InvalidArgumentException(name + " should be negative");
        }
    }

    /**
     * 正数
     *
     * @param number
     * @param name
     */
    public static void positive(long number, String name) {
        if (number <= 0) {
            throw new InvalidArgumentException(name + " should be positive");
        }
    }

    /**
     * 非负
     *
     * @param number
     * @param name
     */
    public static void nonNegative(long number, String name) {
        if (number < 0) {
            throw new InvalidArgumentException(name + " should be non-negative");
        }
    }

    /**
     * 非正
     *
     * @param number
     * @param name
     */
    public static void nonPositive(long number, String name) {
        if (number > 0) {
            throw new InvalidArgumentException(name + " should be non-positive");
        }
    }

}
