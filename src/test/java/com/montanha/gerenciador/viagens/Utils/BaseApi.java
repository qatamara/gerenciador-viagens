package com.montanha.gerenciador.viagens.Utils;

import org.junit.BeforeClass;
import static io.restassured.RestAssured.*;

public class BaseApi {
    @BeforeClass

    public static void preCondicao(){

        baseURI ="http://localhost";
        basePath="/api";
        port =8089;

    }
}
