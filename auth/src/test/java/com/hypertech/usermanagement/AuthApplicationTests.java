package com.hypertech.usermanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Encoder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void createBasicAuth(){
        byte[] b= new byte[0];
        try{
            b = ("hypertech"+":"+"hypertech").getBytes("utf-8");
            String basicString = new BASE64Encoder().encode(b);
            System.out.println(basicString);
        }catch (Exception e){

        }
    }

}
