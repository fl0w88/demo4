package com.example.project.tests;

import com.example.project.taf.tests.TestCaseBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Base64Test extends TestCaseBase {

    @Test
    @DisplayName("Base64 encoding - via keywords")
    public void testBase64Conversion() {
        b64App().base64Keywords().openBase64Site();

        b64App().base64Keywords().closeCookies();

        String testResult = b64App().base64Keywords().encodeText("muster");

        Assertions.assertEquals("bXVzdGVy", testResult);
    }

}
