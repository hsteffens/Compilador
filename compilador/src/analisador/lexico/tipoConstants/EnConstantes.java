package analisador.lexico.tipoConstants;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum EnConstantes {

	PALAVRA_RESERVADA(2,"palavra reservada"), 
	INT(3, "Identificador: Int"),
	FLOAT(4, "Identificador: Float"), 
	STRING(5,"Identificador: String"), 
	BOOLEAN(6,"Identificador: Bool"),
	CONS_INT(7,"Constante Inteira"),
	CONS_FLOAT(8,"Constante Float"),
	CONS_STRING(9,"Constante String"),
	COMENTARIO(10,"Comentário de Bloco"),
	TOKEN_VIRGULA(11,"Símbolo especial: ','"),
	TOKEN_DOIS_PONTOS(12,"Símbolo especial: ':'"),
	TOKEN_PONTO_VIRGULA(13,"Símbolo especial: ';"),
	TOKEN_CONCHETE_ABR(14,"Símbolo especial: '['"),
	TOKEN_CONCHETE_FCH(15,"Símbolo especial: ']'"),
	TOKEN_PARENTESE_ABR(16,"Símbolo especial: '('"),
	TOKEN_PARENTESE_FCH(17,"Símbolo especial: ')'"),
	TOKEN_CHAVE_ABR(18,"Símbolo especial: '{'"),
	TOKEN_CHAVE_FCH(19,"Símbolo especial: '}'"),
	TOKEN_MAIS(20,"Símbolo especial: '+'"),
	TOKEN_MENOS(21,"Símbolo especial: '-'"),
	TOKEN_ASTERISTICO(22,"Símbolo especial: '*'"),
	TOKEN_BARRA(23,"Símbolo especial: '/'"),
	TOKEN_ATRIBUI(24,"Símbolo especial: '<-'"),
	TOKEN_IGUALDADE(25,"Símbolo especial: '='"),
	TOKEN_DIFERENCA(26,"Símbolo especial: '!='"),
	TOKEN_MENOR(27,"Símbolo especial: '<'"),
	TOKEN_MENOR_IGUAL(28,"Símbolo especial: '<='"),
	TOKEN_MAIOR(29,"Símbolo especial: '>'"),
	TOKEN_MAIOR_IGUAL(30,"Símbolo especial: '>='"),
	PR_AND(31,"Palavra reservada: and"),
	PR_FALSE(32,"Palavra reservada: false"),
	PR_IF(33,"Palavra reservada: if"),
	PR_IN(34,"Palavra reservada: in"),
	PR_FALSE_DO(35,"Palavra reservada: isFalseDo"),
	PR_TRUE_DO(36,"Palavra reservada: isTrueDo"),
	PR_MAIN(37,"Palavra reservada: main"),
	PR_MODULE(38,"Palavra reservada: module"),
	PR_NOT(29,"Palavra reservada: not"),
	PR_OR(40,"Palavra reservada: or"),
	PR_OUT(41,"Palavra reservada: out"),
	PR_TRUE(42,"Palavra reservada: true"),
	PR_WHILE(43,"Palavra reservada: while");

	private int codigo;
	private String descricao;
	
	 EnConstantes() {
	}
	
	EnConstantes(int codigo) {
		this.codigo = codigo;
	}
	
	EnConstantes(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	private static final Map<Integer,EnConstantes> lookup = new HashMap<Integer,EnConstantes>();

	static {
		for(EnConstantes w : EnumSet.allOf(EnConstantes.class))
			lookup.put(w.getCodigo(), w);
	}

	public static EnConstantes get(int code) { 
        return lookup.get(code); 
   }
	
}
