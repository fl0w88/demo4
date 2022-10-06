package com.example.project.tests.taf;

import com.example.project.helper.TestCaseBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Base64;

public class Base64Test extends TestCaseBase {

    @Test
    @DisplayName("Base64 encoding - via keywords")
    public void testBase64Conversion() {
        b64App().base64Keywords().openBase64Site();

        b64App().base64Keywords().closeCookies();

        String textToEncode = "muster";
        String actualResult = b64App().base64Keywords().encodeText(textToEncode);
        String expectedResult = Base64.getEncoder().encodeToString(textToEncode.getBytes());

        Assertions.assertEquals(expectedResult, actualResult);
    }

}
