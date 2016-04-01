package analisador.lexico.tipoConstants;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum EnConstantes {

	PALAVRA_RESERVADA(2,"palavra reservada"), 
	INT(3, "Inteiro"),
	FLOAT(4, "Float"), 
	STRING(5,"String"), 
	BOOLEAN(6,"Bool"),
	CONS_INT(7,"Constante Inteira"),
	CONS_FLOAT(8,"Constante Float"),
	CONS_STRING(9,"Constante String"),
	COMENTARIO(10,"Comentário de Bloco"),
	PR_AND(11,"Palavra reservada: and"),
	PR_FALSE(12,"Palavra reservada: false"),
	PR_IF(13,"Palavra reservada: if"),
	PR_IN(14,"Palavra reservada: in"),
	PR_FALSE_DO(15,"Palavra reservada: isFalseDo"),
	PR_TRUE_DO(16,"Palavra reservada: isTrueDo"),
	PR_MAIN(17,"Palavra reservada: main"),
	PR_MODULE(18,"Palavra reservada: module"),
	PR_NOT(19,"Palavra reservada: not"),
	PR_OR(20,"Palavra reservada: or"),
	PR_OUT(21,"Palavra reservada: out"),
	PR_TRUE(22,"Palavra reservada: true"),
	PR_WHILE(23,"Palavra reservada: while");
	
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
