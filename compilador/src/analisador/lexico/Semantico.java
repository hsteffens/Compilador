package analisador.lexico;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants{
	public static final String int64 = "int64";
	public static final String float64 = "float64";
	public static final String string = "string";
	public static final String bool = "bool";
	
	public String executeAction(int action, Token token, String operadorRelacional, Stack<String> pilhaTipos, List<String> listaIdentificadores, Stack<String> pilhaEndereco, int tamanho, Map<String, Integer> tabelaSimbolos, int posicao)	throws SemanticError{
		String lexeme = token != null ? token.getLexeme() : null;
		String codigo = "";
		//System.out.println("Ação #"+action+", Token: "+token);

		String a;
		String b;
		
		switch (action){

			case 1:
				a = pilhaTipos.pop();
				b = pilhaTipos.pop();
				
				if	(float64.equals(a) || float64.equals(b)){
					pilhaTipos.push(float64);
				}else{
					pilhaTipos.push(int64);
				}
				codigo = "\nadd";
				toCodigo(codigo);
				break;
			case 2:
				a = pilhaTipos.pop();
				b = pilhaTipos.pop();
				
				if	(float64.equals(a) || float64.equals(b)){
					pilhaTipos.push(float64);
				}else{
					pilhaTipos.push(int64);
				}
				codigo = "\nsub";
				toCodigo(codigo);
				break;
			case 3:
				a = pilhaTipos.pop();
				b = pilhaTipos.pop();
				
				if	(float64.equals(a) || float64.equals(b)){
					pilhaTipos.push(float64);
				}else{
					pilhaTipos.push(int64);
				}
				codigo = "\nmul";
				toCodigo(codigo);
				break;	
			case 4:
				a = pilhaTipos.pop();
				b = pilhaTipos.pop();
				
				if	(a.equals(b)){
					pilhaTipos.push(a);
					codigo = "\ndiv";
				}else{
					throw new SemanticError("Operando invalido divisão", token.getPosition());
				}
				toCodigo(codigo);
				break;
			case 5:
				pilhaTipos.push(int64);
				codigo = "\nldc.i8 " + lexeme;
				toCodigo(codigo);
				break;
			case 6:
				pilhaTipos.push(float64);
				codigo = "\nldc.r8 " + lexeme;
				toCodigo(codigo);
				break;
			case 7:
				a = pilhaTipos.pop();
				if	(int64.equals(a) || float64.equals(a)){
					pilhaTipos.push(a);
				}else{
					throw new SemanticError("Operando 7", token.getPosition());
				}
				toCodigo(codigo);
				break;
			case 8:
				a = pilhaTipos.pop();
				
				if	(int64.equals(a) || float64.equals(a)){
					pilhaTipos.push(a);
					codigo = "\nldc.i8 -1"
							+ "\nmul";
				}else{
					throw new SemanticError("Acao 8", token.getPosition());
				}
				toCodigo(codigo);
				break;
			case 9:
				a = pilhaTipos.pop(); 
				b = pilhaTipos.pop();
				
				if	(a.equals(b)){
					pilhaTipos.push(bool);
					switch (operadorRelacional) {
					case "=":
						codigo = "\nceq";
						break;
					case ">":
						codigo = "\ncgt";
						break;
					case "<":
						codigo = "\nclt";
						break;	
					}
				}else{
					throw new SemanticError("Tipos imcompatíveis", token.getPosition());
				}
				toCodigo(codigo);
				break;
			case 10:
				Sintatico.setOperadorRelacional(lexeme);
				toCodigo(codigo);
				break;
			case 11:
				a = pilhaTipos.pop();
				codigo = "\ncall void [mscorlib]System.Console::Write("+a+")";
				toCodigo(codigo);
				break;
			case 12:
				codigo = "assembly extern mscorlib{}"
						+ "\n.assembly codigo_objeto{}"
						+ "\n.module codigo_objeto.exe"
						+ "\n.class public _Principal{"
						+ "\n.method static public void _principal() {"
						+ "\n.entrypoint";
				toCodigo(codigo);
				break;
			case 13:
				codigo = "\nret \n}\n}";
				toCodigo(codigo);
				break;
			case 14:
				toCodigo(codigo);
				break;
			case 15:
				toCodigo(codigo);
				break;
			case 16:
				toCodigo(codigo);
				break;
			case 17:
				toCodigo(codigo);
				break;
			case 18:
				toCodigo(codigo);
				break;
			case 19:
				pilhaTipos.push(string);
				codigo = "\nldstr " + lexeme;
				toCodigo(codigo);
				break;
			case 20:
				acao20(action, token, operadorRelacional, pilhaTipos, listaIdentificadores, pilhaEndereco, tamanho, tabelaSimbolos, codigo);
				toCodigo(codigo);
				break;
			case 21:
				acao21(action, token, operadorRelacional, pilhaTipos, listaIdentificadores, pilhaEndereco, tamanho, tabelaSimbolos, codigo);
				toCodigo(codigo);
				break;
			case 22:
				if	(!lexeme.contains("]") && !lexeme.contains("[")){
					codigo = acao22(action, token, operadorRelacional, pilhaTipos, listaIdentificadores, pilhaEndereco, tamanho, tabelaSimbolos, codigo);
					listaIdentificadores.clear();
					pilhaTipos.clear();
					toCodigo(codigo);
				}	
				break;
			case 23:
				if	(!lexeme.contains("]") && !lexeme.contains("[")){
					codigo = acao23(action, token, operadorRelacional, pilhaTipos, listaIdentificadores, pilhaEndereco, tamanho, tabelaSimbolos, codigo);
					listaIdentificadores.clear();
				}
				toCodigo(codigo);
				break;
			case 24:
				if	(!lexeme.contains("]") && !lexeme.contains("[")){
					codigo = acao24(action, token, operadorRelacional, pilhaTipos, listaIdentificadores, pilhaEndereco, tamanho, tabelaSimbolos, codigo);
					toCodigo(codigo);
				}	
				break;
			case 25:
				codigo = acao25(action, token, operadorRelacional, pilhaTipos, listaIdentificadores, pilhaEndereco, tamanho, tabelaSimbolos, codigo);
				toCodigo(codigo);
				break;
			case 26:
				codigo = acao26(action, token, operadorRelacional, pilhaTipos, listaIdentificadores, pilhaEndereco, tamanho, tabelaSimbolos, codigo);
				toCodigo(codigo);
				break;
			case 27:
				codigo = acao27(action, token, operadorRelacional, pilhaTipos, listaIdentificadores, pilhaEndereco, tamanho, tabelaSimbolos, codigo);
				toCodigo(codigo);
				break;
			case 28:
				toCodigo(codigo);
				break;
			case 29:
				toCodigo(codigo);
				break;
			case 30:
				toCodigo(codigo);
				break;
			case 31:
				codigo = acao31(action, token, operadorRelacional, pilhaTipos, listaIdentificadores, pilhaEndereco, tamanho, tabelaSimbolos, codigo, posicao);
				Sintatico.setPosicao(posicao+1);
				toCodigo(codigo);
				break;
			case 32:
				codigo = acao32(action, token, operadorRelacional, pilhaTipos, listaIdentificadores, pilhaEndereco, tamanho, tabelaSimbolos, codigo, posicao);
				toCodigo(codigo);
				break;
			case 33:
				toCodigo(codigo);
				break;
		}
		
		return codigo;
	}	
	
	private void acao20(int action, Token token, String operadorRelacional, Stack<String> pilhaTipos, List<String> listaIdentificadores, Stack<String> pilhaEndereco, int tamanho, Map<String, Integer> tabelaSimbolos, String codigo)	throws SemanticError {
		String lexeme = token != null ? token.getLexeme() : null;
		if	(lexeme.substring(0, 2).equals("f_")){
			pilhaTipos.push(float64);
		}else{
			pilhaTipos.push(int64);
		}
	}
	
	private void acao21(int action, Token token, String operadorRelacional, Stack<String> pilhaTipos, List<String> listaIdentificadores, Stack<String> pilhaEndereco, int tamanho, Map<String, Integer> tabelaSimbolos, String codigo)	throws SemanticError {
		String lexeme = token != null ? token.getLexeme() : null;
		if	(!lexeme.contains("[") && !lexeme.contains("]")){
			listaIdentificadores.add(lexeme);
			acao20(action, token, operadorRelacional, pilhaTipos, listaIdentificadores, pilhaEndereco, tamanho, tabelaSimbolos, codigo);
		}	
	}

	private String acao22(int action, Token token, String operadorRelacional, Stack<String> pilhaTipos, List<String> listaIdentificadores, Stack<String> pilhaEndereco, int tamanho, Map<String, Integer> tabelaSimbolos, String codigo)	throws SemanticError {
		String codAux = "";
		for (String umIdentificador : listaIdentificadores) {
			if	(tabelaSimbolos.get(umIdentificador) != null){
				throw new SemanticError(umIdentificador + " já foi declarado declarado", token.getPosition());
			}else{
				tabelaSimbolos.put(umIdentificador, tamanho);
				if ("".equals(codAux)){
					codAux += pilhaTipos.pop() + " " +  umIdentificador;
				}else{
					codAux += ", " + pilhaTipos.pop() + " " +  umIdentificador;
				}
			}
		}
		
		if	(!"".equals(codAux))	codigo += "\n.locals(" + codAux + ")";
		
		return codigo;
	}
	
	private String acao23(int action, Token token, String operadorRelacional, Stack<String> pilhaTipos, List<String> listaIdentificadores, Stack<String> pilhaEndereco, int tamanho, Map<String, Integer> tabelaSimbolos, String codigo)	throws SemanticError {
		String classe = "";
		if	(!listaIdentificadores.isEmpty()){
			for (String umIdentificador : listaIdentificadores) {
				if	(tabelaSimbolos.get(umIdentificador) == null){
					throw new SemanticError(umIdentificador + " não declarado", token.getPosition());
				}else{
					classe = getClasse(umIdentificador.substring(0,2)); 
				}
				codigo += "\ncall string [mscorlib]System.Console::ReadLine()"
						+ "\ncall "+classe+"::Parse(string)"
						+ "\nstloc "+umIdentificador;
			}
		}
		return codigo;
	}
	
	private String acao24(int action, Token token, String operadorRelacional, Stack<String> pilhaTipos, List<String> listaIdentificadores, Stack<String> pilhaEndereco, int tamanho, Map<String, Integer> tabelaSimbolos, String codigo)	throws SemanticError {
		String lexeme = token != null ? token.getLexeme() : null;
		String id = lexeme;
		
		if	(tabelaSimbolos.get(id) == null){
			throw new SemanticError(id + " não declarado", token.getPosition());
		}else{
			pilhaTipos.push(getTipo(id.substring(0,2)));
			codigo += "\nldloc "+id; 
		}
		
		return codigo;
	}
	
	private String acao25(int action, Token token, String operadorRelacional, Stack<String> pilhaTipos, List<String> listaIdentificadores, Stack<String> pilhaEndereco, int tamanho, Map<String, Integer> tabelaSimbolos, String codigo)	throws SemanticError {
		if	(!listaIdentificadores.isEmpty()){
			String lexeme = token != null ? token.getLexeme() : null;
			String tipoID = "";
			String tipoExp = "";
			String id = listaIdentificadores.get(0); 
			listaIdentificadores.remove(0);
			
			if	(tabelaSimbolos.get(id) == null){
				throw new SemanticError(id + " não declarado", token.getPosition());
			}else{
				tipoID = getTipo(id.substring(0,2));
				tipoExp = pilhaTipos.pop();
				
				if	(true){
					codigo += "\nstloc " + id;
				}else{
					
				}
			}
		}
		return codigo;
	}
	
	private String acao26(int action, Token token, String operadorRelacional, Stack<String> pilhaTipos, List<String> listaIdentificadores, Stack<String> pilhaEndereco, int tamanho, Map<String, Integer> tabelaSimbolos, String codigo)	throws SemanticError {
		String lexeme = token != null ? token.getLexeme() : null;
		String id = listaIdentificadores.get(listaIdentificadores.size()-1); 
		listaIdentificadores.remove(listaIdentificadores.size()-1);
		String variavel = id +"["+lexeme+"]";
		codigo += "\n// declaração de variável array: " + variavel
					+"\n.locals("+pilhaTipos.pop()+"[] "+ id +")"
					+"\nldc.i8 " + lexeme
					+"\nnewarr " + getClasseMscorlib(id.substring(0, 2))
					+"\nstloc "+id;
		
		return codigo;
	}
	
	private String acao27(int action, Token token, String operadorRelacional, Stack<String> pilhaTipos, List<String> listaIdentificadores, Stack<String> pilhaEndereco, int tamanho, Map<String, Integer> tabelaSimbolos, String codigo)	throws SemanticError {
		String lexeme = token != null ? token.getLexeme() : null;
		String id = listaIdentificadores.get(listaIdentificadores.size()-1); 
		String classe = getClasse(lexeme.substring(0,2)); 
		listaIdentificadores.remove(listaIdentificadores.size()-1);
		String variavel = lexeme +"["+id+"]";
		codigo += "\n// in (" + variavel+ ")"
					+"\nldloc " + lexeme
					+"\nldloc " + id
					+ "\ncall string [mscorlib]System.Console::ReadLine()"
					+ "\ncall "+classe+"::Parse(string)"
					+ "\nstelem "+pilhaTipos.pop();
		
		return codigo;
	}
	
	private String acao31(int action, Token token, String operadorRelacional, Stack<String> pilhaTipos, List<String> listaIdentificadores, Stack<String> pilhaEndereco, int tamanho, Map<String, Integer> tabelaSimbolos, String codigo, int posicao)	throws SemanticError {
		codigo += "\nl"+posicao+ ":";
		return codigo;
	}
	
	private String acao32(int action, Token token, String operadorRelacional, Stack<String> pilhaTipos, List<String> listaIdentificadores, Stack<String> pilhaEndereco, int tamanho, Map<String, Integer> tabelaSimbolos, String codigo, int posicao)	throws SemanticError {
		codigo += "\nbrfalsel"+posicao;
		return codigo;
	}	
	
	//----------------------------------------------------------------//-------------------------------------------------------------------//
	
	private String getClasseMscorlib(String ini){
		String classe = "";
		
		switch (ini) {
			case "i_":
				classe = "[mscorlib]System.Int64";
				break;
	
			case "f_":
				classe = "[mscorlib]System.Double";
				break;
				
			case "s_":
				classe = "[mscorlib]System.String";
				break;
				
			case "b_":
				classe = "[mscorlib]System.Boolean";
				break;	
		}
		
		return classe;
	}
	
	private String getClasse(String ini){
		String classe = "";
		
		switch (ini) {
			case "i_":
				classe = "int64 [mscorlib]System.Int64";
				break;
	
			case "f_":
				classe = "float64 [mscorlib]System.Double";
				break;
		}
		
		return classe;
	}
	
	private String getTipo(String ini){
		String tipo = "";
		
		switch (ini) {
			case "i_":
				tipo = int64;
				break;
	
			case "f_":
				tipo = float64;
				break;
		}
		
		return tipo;
	}
	
	private void toCodigo(String codigo){
		//System.out.println("Código gerado :"+codigo+"\n\n");
	}
	
}
