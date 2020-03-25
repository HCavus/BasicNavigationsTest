package com.cbt.utilities;

import org.testng.Assert;

public class StringUtilityWithTestNg {
    public static void verifyEquals(String expect, String actual){
        Assert.assertEquals(expect,actual);
        }
    }

