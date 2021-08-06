package com.montanha.gerenciador.viagens.Testes;

import com.montanha.gerenciador.viagens.Dados.Dados;
import com.montanha.gerenciador.viagens.Utils.BaseApi;
import com.montanha.gerenciador.viagens.Utils.Login;
import io.restassured.http.ContentType;
import org.junit.Test;



import static io.restassured.RestAssured.*;

public class ViagensTest extends BaseApi {
    String tokenAdm = new Login().autenticacaoAdm();
    String tokenUsuario = new Login().autenticacaoUsuario();
    Dados dados = new Dados();

    @Test
    public void cadastrarViagem(){

        given()  /* Estou passando o token extraido anteriormente para obter autorização de cadastro*/
                .header("Authorization",tokenAdm)
                .body("{\n" +
                        "  \"acompanhante\": \"Vinicius\",\n" +
                        "  \"dataPartida\": \"2021-08-19\",\n" +
                        "  \"dataRetorno\": \"2021-09-23\",\n" +
                        "  \"localDeDestino\": \"Gramado\",\n" +
                        "  \"regiao\": \"Sul\"\n" +
                        "}")
                .contentType(ContentType.JSON)
        .when()
                .post("/v1/viagens")/*Ação(metodo) chamando apenas o endpoint a ser testado pois a classe que contem o caminho foi extendida*/
        .then()
                .statusCode(201)
                .log().all()
                ;


    }

    @Test
    public void consultarViagens(){
        given()
                .header("Authorization",tokenUsuario)
                .contentType(ContentType.JSON)
        .when()
                .get("/v1/viagens")
        .then()
                .statusCode(200)
                .log().all()
        ;

    }
    @Test
    public void apagarUmaViagemEspecifica(){
        given()
                .header("Authorization",tokenAdm)
                .contentType(ContentType.JSON)
        .when()
                .delete("/v1/viagens/1")
        .then()
                .statusCode(204)
                .log().all()

        ;
    }

    @Test
    public void atualizarViagemEspecifica(){
        given()
                .header("Authorization",tokenAdm)
                .contentType(ContentType.JSON)
            .body("{\n" +
                        "  \"acompanhante\": \"Vanessa\",\n" +
                        "  \"dataPartida\": \"2021-08-12\",\n" +
                        "  \"dataRetorno\": \"2021-08-30\",\n" +
                        "  \"localDeDestino\": \"Caxias\",\n" +
                        "  \"regiao\": \"Sul\"\n" +
                        "}")
        .when()/*Ação(metodo)*/
                .put("/v1/viagens/5")

        .then()
                .statusCode(204)
                .log().all()

        ;
    }

    /*@Test
    public void retornarUmaViagemEspecifica(){
        given()
        .when()/*Ação(metodo)
                .get("/v1/viagens/1")
        .then()
                .statusCode(200)
                .log().all();}*/
}


