package com.demoga.tests;
import org.junit.jupiter.api.*;
public class FirstJUnitTest {
    @BeforeAll
    static void beforeAll(){
        System.out.println("#### @BeforeAll");
    }

    @AfterAll
    static void AfterAll(){
        System.out.println("#### @AfterAll");
    }
    @BeforeEach
    void BeforeEach(){
        System.out.println("    #### @BeforeEach");
    }

    @AfterEach
    void AfterEach(){
        System.out.println("    #### @AfterEach");
    }

    @Test
    void firstTest() {
        Assertions.assertTrue(3 > 2);
        System.out.println("    ####@Test firstTest()");
    }

    @Test
    void secondTest() {
        Assertions.assertTrue(3 > 2);
        System.out.println("    ####@Test secondTest()");
    }
}
