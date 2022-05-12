package ru.hogoshi.util;

import lombok.Data;

@Data
public class V2 {

    private double x;
    private double y;

    public V2() {}

    public V2(double x, double y) {
        setX(x);
        setY(y);
    }

    public V2(int x, int y) {
        setX(x);
        setY(y);
    }

    public V2(float x, float y) {
        setX(x);
        setY(y);
    }

}