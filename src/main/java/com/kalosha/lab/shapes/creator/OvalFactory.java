package com.kalosha.lab.shapes.creator;

import com.kalosha.lab.shapes.model.oval.Oval;

import java.util.List;

public interface OvalFactory {
    List<Oval> createOvals(int[][] sides);
}
