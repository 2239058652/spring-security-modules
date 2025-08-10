package com.dc.captcha;

import cn.hutool.captcha.generator.CodeGenerator;

public class MyCodeGenderator implements CodeGenerator {
    @Override
    public String generate() {
        int code = (int) (Math.random() * 9000 + 1000);
        return String.valueOf(code);
    }

    @Override
    public boolean verify(String code, String userInputCode) {
        return false;
    }
}
