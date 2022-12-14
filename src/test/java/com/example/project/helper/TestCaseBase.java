package com.example.project.helper;

import com.example.project.keywords.Base64App;
import org.junit.jupiter.api.AfterEach;

public class TestCaseBase {

    private final Base64App b64 = new Base64App();

    public Base64App b64App() {
        return b64;
    }

    @AfterEach
    public void tearDown() {
        b64.base64Keywords().close();
    }

}
