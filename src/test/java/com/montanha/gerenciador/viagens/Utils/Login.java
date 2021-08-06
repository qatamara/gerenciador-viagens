package com.montanha.gerenciador.viagens.Utils;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Login {
    public String autenticacaoAdm() {

        String tokenAdm =
                given()/*conteudo da requisição*/
                        .body("{\n" +
                                "  \"email\": \"admin@email.com\",\n" +
                                "  \"senha\": \"654321\"\n" +
                                "}")
                        .contentType(ContentType.JSON)
                        .when()/*ação(metodo)*/
                        .post("/v1/auth")
                        .then()/*então*/
                        .extract()/*extração do token para posterior utilização*/
                        .path("data.token");


        return tokenAdm;


    }

    public String autenticacaoUsuario() {

        String tokenUsuario =
                given()/*conteudo da requisição*/
                        .body("{\n" +
                                "  \"email\": \"usuario@email.com\",\n" +
                                "  \"senha\": \"123456\"\n" +
                                "}")
                        .contentType(ContentType.JSON)
                        .when()/*ação(metodo)*/
                        .post("/v1/auth")
                        .then()/*então*/
                        .extract()/*extração do token para posterior utilização*/
                        .path("data.token");


        return tokenUsuario;
    }
}