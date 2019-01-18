package com.nonexistentware.igor.demoquiz.Common;

import com.nonexistentware.igor.demoquiz.Model.Category;

public class Common {
    public static Category selectedCategory = new Category();

    public enum ANSWER_TYPE {
        NO_ANSWER,
        WRONG_ANSWER,
        RIGHT_ANSWER
    }
}
