package com.tattoo.tattoo_app.application.tattoo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v2/tattoo")
@Slf4j //faz com que o lombok adc um objeto de log para utilizar na classe
public class TattooController {

    @PostMapping //quem for usar essa API para salvar uma imagem fara uma requisição POST para /v2/tattoo,o metodo abaixa ficara escutando a requisição e necessariamente precisara passar os parametros abaixo
    public ResponseEntity save(
         @RequestParam("file") MultipartFile file, //dessa forma o spring cria essa classe e ela represnta uma string de dados
         //utilizada para receber arquivos do lado do servidor da API, definindo qual o parametro da requisição
         @RequestParam("nome") String nome,
         @RequestParam("data") String data,
         @RequestParam("hora") String hora,
         @RequestParam("tags") List<String> tags
    ){

        log.info("Imagem recebida: name: {}, size{}", file.getName(), file.getSize());
        log.info("Nome definido para a imagem: {}", nome);
        log.info("Data do agendamento: {}", data);
        log.info("Horário do agendamento: {}", hora);
        log.info("Tags: {}", tags);
        return ResponseEntity.ok().build(); //Response Entity é classe responsavel por responder uma requisição http, retona ao codigo 200 para dizer OK
    }

}
