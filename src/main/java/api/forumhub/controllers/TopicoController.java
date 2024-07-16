package api.forumhub.controllers;

import api.forumhub.domain.topico.*;
import api.forumhub.domain.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastrarTopico dados, UriComponentsBuilder uriBuilder ){
        var topicos = new Topicos(dados);
        repository.save(topicos);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topicos.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topicos));

    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemTopico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topicos = repository.getReferenceById(dados.id());
        topicos.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topicos));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.getReferenceById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topicos = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topicos));
    }






}
