package ru.hogoshi.util;

@FunctionalInterface
public interface Easing {
    /**
     * @param value
     * @return animation formula
     */
    double ease(double value);
}