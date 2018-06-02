package br.com.rodolfo.lista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.rodolfo.lista.model.Convidado;
import br.com.rodolfo.lista.repository.ConvidadoRepository;

/**
 * ConvidadoCOntroller
 */
@Controller
public class ConvidadoController {

    //A anotação 'Autowired' sinaliza que a 'bean' deve ser injetada. (Injeção de dependência)
    @Autowired
    private ConvidadoRepository repository;
    
    @RequestMapping("/")
    public String index() {

        return "index";
    }

    //Para enviar dados para a view precisamos receber o Model, o model é passado como parâmetro
    @RequestMapping("listaconvidados")
    public String listaConvidados(Model model) {
        
        Iterable<Convidado> convidados = repository.findAll();

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
        repository.save(convidado);

        Iterable<Convidado> convidados = repository.findAll();

        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }

}