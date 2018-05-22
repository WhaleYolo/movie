package com.wsk.movie.tool;

import java.util.Properties;

/**
 * @Author: wsk1103
 * @Date: 18-5-22
 * @Description: 判断系统是windows还是linux.
 */
public class Os {

    public static boolean isLinux() {
        Properties prop = System.getProperties();
        String os = prop.getProperty("os.name");
        return os != null && os.toLowerCase().contains("linux");
    }

    public static void main(String[] args) {
        System.out.println(isLinux());
    }
}
