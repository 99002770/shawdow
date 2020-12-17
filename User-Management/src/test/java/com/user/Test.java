package com.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {
	@Test
	void firstname() {
	       
        form f=new form();
        int output=f.name("abcd");
        assertEquals(1,output);
        int output1=f.name("");
        assertEquals(0,output1);
        int o=f.name("0@3");
        assertEquals(0,o);
    }
    @Test
    void mobilenumber()
    {
        form f=new form();
        int output=f.phone("1234567890");
        assertEquals(1,output);
        //int o=f.name("cha1");
        //assertEquals(0,o);
        int output1=f.phone("");
        assertEquals(0,output1);
    }
    @Test
    void emailTest()
    {
        form f=new form();
        int output=f.email("abc@gmail.com");
        assertEquals(1,output);
        int o=f.name("");
        assertEquals(0,o);
        int output1=f.email("abcd");
        assertEquals(0,output1);
    }
   
    @Test
    void Password()
    {
        form f=new form();
        int output=f.password("abc@1234");
        assertEquals(1,output);
        int o=f.password("");
        assertEquals(0,o);
      
    }
    @Test
void lasttname() {
       
        form f=new form();
        int output=f.lastname("abcd");
        assertEquals(1,output);
        int output1=f.name("");
        assertEquals(0,output1);
        int o=f.lastname("0@34");
        assertEquals(0,o);
    }
    @Test   
void Pincode() {
    form f=new form();
    int output=f.pin("123456");
    assertEquals(1,output);
    int output1=f.name("abcd");
    assertEquals(0,output1);
    int o=f.pin("");
    assertEquals(0,o);
       
    }
   
   

}
