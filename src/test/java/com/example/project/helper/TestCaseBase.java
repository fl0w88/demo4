package com.example.project.helper;

import com.example.project.keywords.Base64App;
import org.junit.jupiter.api.AfterEach;

public class TestCaseBase {

    private final Base64App base64App = new Base64App();

    public Base64App base64App() {
        return base64App;
    }

    @AfterEach
    public void tearDown() {
        base64App.base64Keywords().close();
    }

}
