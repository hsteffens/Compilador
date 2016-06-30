package analisador.lexico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import visao.actions.GerarCodigo;

public class Sintatico implements Constants{
    private Stack stack = new Stack();
    private Token currentToken;
    private Token previousToken;
    private Lexico scanner;
    private Semantico semanticAnalyser;
    
    public static String operadorRelacional = "";
    public static Stack<String> pilhaTipo = new Stack<>();
    public static List<String> listaIdentificadores = new ArrayList<>();
    public static Stack<String> pilhaEndereco = new Stack<>();
    public static int tamanho = 0;
    public static int posicao = 1;
    public static Map<String, Integer> tabelaSimbolos = new HashMap<>();

	private static final boolean isTerminal(int x){
        return x < FIRST_NON_TERMINAL;
    }

    private static final boolean isNonTerminal(int x){
        return x >= FIRST_NON_TERMINAL && x < FIRST_SEMANTIC_ACTION;
    }

    private static final boolean isSemanticAction(int x){
        return x >= FIRST_SEMANTIC_ACTION;
    }

    private boolean step() throws LexicalError, SyntaticError, SemanticError{
        if (currentToken == null) {
            int pos = 0;
            if (previousToken != null)
                pos = previousToken.getPosition()+previousToken.getLexeme().length();

            currentToken = new Token(DOLLAR, "$", pos);
        }

        int x = ((Integer)stack.pop()).intValue();
        int a = currentToken.getId();

        if (x == EPSILON){
            return false;
        }else if (isTerminal(x)){
            if (x == a) {
                if (stack.empty())
                    return true;
                else {
                    previousToken = currentToken;
                    currentToken = scanner.nextToken();
                    return false;
                }
            } else {
                throw new SyntaticError(PARSER_ERROR[x], currentToken.getPosition());
            }
        }
        else if (isNonTerminal(x)){
            if (pushProduction(x, a))
                return false;
            else
                throw new SyntaticError(PARSER_ERROR[x], currentToken.getPosition());
        } else { // isSemanticAction(x)
            GerarCodigo.codigo += semanticAnalyser.executeAction(x-FIRST_SEMANTIC_ACTION, previousToken, operadorRelacional, pilhaTipo, listaIdentificadores, pilhaEndereco, tamanho, tabelaSimbolos, posicao);
            return false;
        }
    }

    private boolean pushProduction(int topStack, int tokenInput){
        int p = PARSER_TABLE[topStack-FIRST_NON_TERMINAL][tokenInput-1];
        if (p >= 0)
        {
            int[] production = PRODUCTIONS[p];
            //empilha a produção em ordem reversa
            for (int i=production.length-1; i>=0; i--)
            {
                stack.push(new Integer(production[i]));
            }
            return true;
        }
        else
            return false;
    }

    public void parse(Lexico scanner, Semantico semanticAnalyser) throws LexicalError, SyntaticError, SemanticError{
        this.scanner = scanner;
        this.semanticAnalyser = semanticAnalyser;

        stack.clear();
        stack.push(new Integer(DOLLAR));
        stack.push(new Integer(START_SYMBOL));
        listaIdentificadores.clear();
		pilhaTipo.clear();
		pilhaEndereco.clear();
		tabelaSimbolos.clear();
		GerarCodigo.codigo = "";
		operadorRelacional = "";
		tamanho = 0;
		posicao = 1;

        currentToken = scanner.nextToken();

        while (!step());
        
        //System.out.println(GerarCodigo.codigo);
    }
    
	public static String getOperadorRelacional() {
		return operadorRelacional;
	}

	public static void setOperadorRelacional(String operadorRelacional) {
		Sintatico.operadorRelacional = operadorRelacional;
	}

	public static Stack<String> getPilhaTipo() {
		return pilhaTipo;
	}

	public static void setPilhaTipo(Stack<String> pilhaTipo) {
		Sintatico.pilhaTipo = pilhaTipo;
	}

	public static List<String> getListaIdentificadores() {
		return listaIdentificadores;
	}

	public static void setListaIdentificadores(List<String> listaIdentificadores) {
		Sintatico.listaIdentificadores = listaIdentificadores;
	}

	public static Stack<String> getPilhaEndereco() {
		return pilhaEndereco;
	}

	public static void setPilhaEndereco(Stack<String> pilhaEndereco) {
		Sintatico.pilhaEndereco = pilhaEndereco;
	}

	public static int getPosicao() {
		return posicao;
	}

	public static void setPosicao(int posicao) {
		Sintatico.posicao = posicao;
	}
}
