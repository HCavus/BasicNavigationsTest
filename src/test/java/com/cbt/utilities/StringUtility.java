package com.cbt.utilities;

public class StringUtility {
    public static void main(String[] args) {
        String actual="java";
        verifyEquals("Java",actual);
    }
    public static void verifyEquals(String expect, String actual){
        if(expect.equals(actual)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expect result: "+expect);
            System.out.println("Actual result: "+actual);
        }
    }
}
