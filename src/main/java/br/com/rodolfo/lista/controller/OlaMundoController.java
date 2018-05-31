package br.com.rodolfo.lista.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * OlaMundoController
 */
//A anotação 'Controller' é usada especificar para o Spring que tal classe vai ter a função de controller na aplicação, seguindo o padrão MVC
@Controller
public class OlaMundoController {

    //A anotação 'RequestMapping' é usada para mapear uma rota para acessar algum recurso no nosso back-end
    @RequestMapping("/ola")
    //A anotação 'ResponseBody' informa que retonaremos apenas um objeto em formato texo (sem a view) que pode ser enviado via protocolo HTTP
    @ResponseBody
    public String name() {
        return "<h1>Teste de spring<h1>";
    }
    
}