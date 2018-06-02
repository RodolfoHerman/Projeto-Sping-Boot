package br.com.rodolfo.lista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.rodolfo.lista.model.Convidado;
import br.com.rodolfo.lista.service.ConvidadoService;
import br.com.rodolfo.lista.service.EmailService;

/**
 * ConvidadoCOntroller
 */
@Controller
public class ConvidadoController {

    //Por padrões de projeto o Controller não acessa o 'REPOSITÓRIO' diretamente, quem faz isso é a camada de serviço. Sendo assim será retirado o objeto de repositório e inserido o de serviço.
    //A anotação 'Autowired' sinaliza que a 'bean' deve ser injetada. (Injeção de dependência)
    // @Autowired
    // private ConvidadoRepository repository;

    @Autowired
    private ConvidadoService convidadoService;
    
    @RequestMapping("/")
    public String index() {

        return "index";
    }

    //Para enviar dados para a view precisamos receber o Model, o model é passado como parâmetro
    @RequestMapping("listaconvidados")
    public String listaConvidados(Model model) {
        
        Iterable<Convidado> convidados = convidadoService.buscarTodos();

        //Utiliza o model para atribuir o valor e envia-lo para a view
        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }

    //A anotação 'RequestParam(param)' recebe o campo do formulário preenchido da VIEW
    @RequestMapping(value="salvar", method=RequestMethod.POST)
    public String salvar(Model model, 
                       @RequestParam("nome") String nome,
                       @RequestParam("email") String email,
                       @RequestParam("telefone") String telefone) {
        
        Convidado convidado = new Convidado(nome, email, telefone);

        //new EmailService().enviarEmail(nome, email);

        convidadoService.salvar(convidado);

        Iterable<Convidado> convidados = convidadoService.buscarTodos();

        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }

}