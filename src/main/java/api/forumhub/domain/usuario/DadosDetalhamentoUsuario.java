package api.forumhub.domain.usuario;

public record DadosDetalhamentoUsuario(String nome, String email) {

 public DadosDetalhamentoUsuario(Usuario usuario){
     this(usuario.getNome(),usuario.getEmail());
 }
}
