package com.codevergence.demo.masterdata.exception.employee;

public class BadRequestException extends RuntimeException
{
    public BadRequestException(String pathValue)
    {
        super("java.lang.long cannot be cast to java.lang.String. " + "\n" +
                "required value of java.lang.Long but found java.lang.String");
    }
}
