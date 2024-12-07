package com.tattoo.tattoo_app.application.tattoo;

import com.tattoo.tattoo_app.domain.entity.Image;
import com.tattoo.tattoo_app.domain.enums.ImageExtension;
import com.tattoo.tattoo_app.domain.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static java.nio.file.Files.size;

@RestController
@RequestMapping("/v2/tattoo")
@Slf4j //faz com que o lombok adc um objeto de log para utilizar na classe
@RequiredArgsConstructor
public class TattooController {

    private final ImageService service;

    @PostMapping //quem for usar essa API para salvar uma imagem fara uma requisição POST para /v2/tattoo,o metodo abaixa ficara escutando a requisição e necessariamente precisara passar os parametros abaixo
    public ResponseEntity save(
         @RequestParam("file") MultipartFile file, //dessa forma o spring cria essa classe e ela represnta uma string de dados
         //utilizada para receber arquivos do lado do servidor da API, definindo qual o parametro da requisição
         @RequestParam("nome") String nome,
         @RequestParam("data") String data,
         @RequestParam("hora") String hora,
         @RequestParam("tags") List<String> tags
    ) throws IOException {

        log.info("Imagem recebida: name: {}, size{}", file.getName(), file.getSize());
        log.info("Content Type: {}",file.getContentType()); //adicionando log do content type
        log.info("Media Type: {}" ,file.getContentType()); //adicionando log do Media type, obtendo para depois transforma-lo em extensão

        MediaType.valueOf(file.getContentType());     //Enum do Spring com o metodo valueOf



        Image image = Image.builder()
                .name(nome)
                .data(data)
                .hora(hora)
                .tags(String.join(",",tags)) //array de strings separado por virgula, por isso é uma definição do separador
        .size(file.getSize())
                .extension(ImageExtension.valueOf(MediaType.valueOf(file.getContentType())))
                .file(file.getBytes())
                .build(); //

        service.save(image);


        return ResponseEntity.ok().build(); //Response Entity é classe responsavel por responder uma requisição http, retona ao codigo 200 para dizer OK
    }

}
