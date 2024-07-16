package api.forumhub.controllers;


import api.forumhub.domain.perfil.DadosListagemPerfil;
import api.forumhub.domain.perfil.PerfilRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    PerfilRepository repository;


    public ResponseEntity<Page<DadosListagemPerfil>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.FindbyName(paginacao).map(DadosListagemPerfil::new);
        return ResponseEntity.ok(page);
    }



}
