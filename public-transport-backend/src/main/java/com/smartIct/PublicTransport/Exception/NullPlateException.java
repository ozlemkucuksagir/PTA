package com.smartIct.PublicTransport.Exception;

public class NullPlateException extends RuntimeException{
    public NullPlateException() {
        super("License plate cannot be empty!");
    }

}
