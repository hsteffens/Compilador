package analisador.lexico;

public interface ParserConstants
{
    int START_SYMBOL = 44;

    int FIRST_NON_TERMINAL    = 44;
    int FIRST_SEMANTIC_ACTION = 88;

    int[][] PARSER_TABLE =
    {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  1, -1, -1, -1, -1, -1,  2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  4,  4,  4,  4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  7,  7,  7,  7, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 10, 11, 12, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 14, 14, 14, 14, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 14, 14, -1, -1, -1, -1, -1, -1, 14, -1, 14 },
        { -1, -1, 17, 17, 17, 17, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, 18, -1, -1, -1, -1, -1, -1, 19, -1, 21 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 22, 22, 22, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 23, 23, 23, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 27, 27, 27, 27, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 30, -1, -1 },
        { -1, -1, 31, 31, 31, 31, 31, 31, 31, -1, -1, -1, -1, -1, -1, 31, -1, -1, -1, 31, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 31, -1, -1, -1, -1, -1, -1, 31, -1, -1, 31, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 39, 39, 39, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, 39, 38, -1, -1, -1, -1, -1, 39, -1, 39 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 43, 43, 43, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, 43, -1, 42, -1, -1, -1, -1, 43, -1, 43 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 45 },
        { -1, -1, 48, 48, 48, 48, 48, 48, 48, -1, -1, -1, -1, -1, -1, 48, -1, -1, -1, 48, 48, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 48, -1, -1, -1, -1, -1, -1, 48, -1, -1, 48, -1 },
        { -1, -1, 52, 52, 52, 52, 52, 52, 52, -1, -1, -1, -1, -1, -1, 52, -1, -1, -1, 52, 52, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 54, -1, -1, -1, -1, -1, -1, 55, -1, -1, 53, -1 },
        { -1, -1, 56, 56, 56, 56, 56, 56, 56, -1, -1, -1, -1, -1, -1, 56, -1, -1, -1, 56, 56, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 65, 65, 65, 65, 65, 65, 65, -1, -1, -1, -1, -1, -1, 65, -1, -1, -1, 65, 65, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 59, 60, 61, 62, 63, 64, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 69, 69, 69, 69, 69, 69, 69, -1, -1, -1, -1, -1, -1, 69, -1, -1, -1, 69, 69, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 73, 73, 73, 73, 74, 75, 76, -1, -1, -1, -1, -1, -1, 77, -1, -1, -1, 78, 79, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 80, 81, 82, 83, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 84, -1, 84, 85, 84, -1, 84, -1, -1, 84, 84, 84, 84, -1, 84, 84, 84, 84, 84, 84, 84, -1, -1, -1, -1, -1, -1, -1, -1, 84, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  5, -1,  6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  8, -1,  8,  9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 15, 15, 15, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 15, 15, -1, -1, -1, -1, -1, -1, 15, -1, 15 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 24, -1, -1, 25, -1, -1, 24, -1, -1, -1, -1, -1, -1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 28, -1, -1, -1, -1, -1, 29, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 32, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 51, -1, 51, -1, 51, -1, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 49, -1, -1, -1, -1, -1, -1, -1, -1, 50, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 68, -1, 68, -1, 68, -1, 68, -1, -1, 66, 67, -1, -1, -1, 68, 68, 68, 68, 68, 68, 68, -1, -1, -1, -1, -1, -1, -1, -1, 68, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 72, -1, 72, -1, 72, -1, 72, -1, -1, 72, 72, 70, 71, -1, 72, 72, 72, 72, 72, 72, 72, -1, -1, -1, -1, -1, -1, -1, -1, 72, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, 35, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 47, 46, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 58, -1, 58, -1, 58, -1, 58, -1, -1, -1, -1, -1, -1, -1, 57, 57, 57, 57, 57, 57, 58, -1, -1, -1, -1, -1, -1, -1, -1, 58, -1, -1, -1 }
    };

    int[][] PRODUCTIONS = 
    {
        { 37, 38, 45, 18, 50, 19 },
        { 46 },
        {  0 },
        { 12, 47, 13 },
        { 48, 76 },
        { 11, 47 },
        {  0 },
        { 49, 77 },
        {  0 },
        { 14,  7, 15 },
        {  3 },
        {  4 },
        {  5 },
        {  6 },
        { 51, 78 },
        { 50 },
        {  0 },
        { 53 },
        { 52 },
        { 56 },
        { 58 },
        { 65 },
        { 54, 24, 66, 13 },
        { 49, 79 },
        {  0 },
        { 14, 66, 15 },
        { 34, 16, 55, 17, 13 },
        { 54, 80 },
        { 11, 55 },
        {  0 },
        { 41, 16, 57, 17, 13 },
        { 66, 81 },
        { 11, 57 },
        {  0 },
        { 33, 16, 66, 17, 85 },
        { 59 },
        { 62 },
        { 36, 12, 18, 50, 19, 60 },
        { 61 },
        {  0 },
        { 35, 12, 18, 50, 19 },
        { 35, 12, 18, 50, 19, 63 },
        { 64 },
        {  0 },
        { 36, 12, 18, 50, 19 },
        { 43, 16, 66, 17, 86 },
        { 36, 12, 18, 50, 19 },
        { 35, 12, 18, 50, 19 },
        { 67, 82 },
        { 31, 67, 82 },
        { 40, 67, 82 },
        {  0 },
        { 68 },
        { 42 },
        { 32 },
        { 39, 67 },
        { 69, 87 },
        { 70, 69 },
        {  0 },
        { 25 },
        { 26 },
        { 27 },
        { 28 },
        { 29 },
        { 30 },
        { 71, 83 },
        { 20, 71, 83 },
        { 21, 71, 83 },
        {  0 },
        { 73, 84 },
        { 22, 73, 84 },
        { 23, 73, 84 },
        {  0 },
        { 74, 75 },
        {  7 },
        {  8 },
        {  9 },
        { 16, 66, 17 },
        { 20, 73 },
        { 21, 73 },
        {  3 },
        {  4 },
        {  5 },
        {  6 },
        {  0 },
        { 14, 66, 15 }
    };

//    String[] PARSER_ERROR =
//    {
//        "",
//        "Era esperado fim de programa",
//        "Era esperado pr",
//        "Era esperado int",
//        "Era esperado float",
//        "Era esperado string",
//        "Era esperado bool",
//        "Era esperado conint",
//        "Era esperado confloat",
//        "Era esperado constring",
//        "Era esperado c_bloco",
//        "Era esperado \",\"",
//        "Era esperado \":\"",
//        "Era esperado \";\"",
//        "Era esperado \"[\"",
//        "Era esperado \"]\"",
//        "Era esperado \"(\"",
//        "Era esperado \")\"",
//        "Era esperado \"{\"",
//        "Era esperado \"}\"",
//        "Era esperado \"+\"",
//        "Era esperado \"-\"",
//        "Era esperado \"*\"",
//        "Era esperado \"/\"",
//        "Era esperado \"<-\"",
//        "Era esperado \"=\"",
//        "Era esperado \"!=\"",
//        "Era esperado \"<\"",
//        "Era esperado \"<=\"",
//        "Era esperado \">\"",
//        "Era esperado \">=\"",
//        "Era esperado and",
//        "Era esperado false",
//        "Era esperado if",
//        "Era esperado in",
//        "Era esperado isFalseDo",
//        "Era esperado isTrueDo",
//        "Era esperado main",
//        "Era esperado module",
//        "Era esperado not",
//        "Era esperado or",
//        "Era esperado out",
//        "Era esperado true",
//        "Era esperado while",
//        "<programa> inv�lido",
//        "<variaveis> inv�lido",
//        "<var> inv�lido",
//        "<l_variaveis> inv�lido",
//        "<id> inv�lido",
//        "<identificador> inv�lido",
//        "<l_comando> inv�lido",
//        "<comando> inv�lido",
//        "<comando_ent_dados> inv�lido",
//        "<comando_atrb> inv�lido",
//        "<id_expressao> inv�lido",
//        "<l_identificadores> inv�lido",
//        "<comando_out_dados> inv�lido",
//        "<l_expressoes> inv�lido",
//        "<comando_selecao> inv�lido",
//        "<comando_selecao_true> inv�lido",
//        "<comando_false> inv�lido",
//        "<false> inv�lido",
//        "<comando_selecao_false> inv�lido",
//        "<comando_true> inv�lido",
//        "<true> inv�lido",
//        "<comando_repeticao> inv�lido",
//        "<expressao> inv�lido",
//        "<elemento> inv�lido",
//        "<relacional> inv�lido",
//        "<aritimetica> inv�lido",
//        "<operador_relacional> inv�lido",
//        "<termo> inv�lido",
//        "<tempo> inv�lido",
//        "<fator> inv�lido",
//        "<identificador_variavel> inv�lido",
//        "<vetor_uso> inv�lido",
//        "<l_variaveis1> inv�lido",
//        "<id1> inv�lido",
//        "<l_comando1> inv�lido",
//        "<id_expressao1> inv�lido",
//        "<l_identificadores1> inv�lido",
//        "<l_expressoes1> inv�lido",
//        "<expressao1> inv�lido",
//        "<aritimetica1> inv�lido",
//        "<termo1> inv�lido",
//        "<comando_condicao> inv�lido",
//        "<comando_repeticao1> inv�lido",
//        "<relacional1> inv�lido"
//    };
    
    String[] PARSER_ERROR =
    {
        "",
        "esperado fim de programa",
        "esperado palavra reservada",
        "esperado int",
        "esperado float",
        "esperado string",
        "esperado bool",
        "esperado constante int",
        "esperado constante float",
        "esperado constante string",
        "esperado coment�rio de bloco",
        "esperado ,",
        "esperado :",
        "esperado ;",
        "esperado [",
        "esperado ]",
        "esperado (",
        "esperado )",
        "esperado {",
        "esperado }",
        "esperado +",
        "esperado -",
        "esperado *",
        "esperado /",
        "esperado <-",
        "esperado =",
        "esperado !=",
        "esperado <",
        "esperado <=",
        "esperado >",
        "esperado >=",
        "esperado and",
        "esperado false",
        "esperado if",
        "esperado in",
        "esperado isFalseDo",
        "esperado isTrueDo",
        "esperado main",
        "esperado module",
        "esperado not",
        "esperado or",
        "esperado out",
        "esperado true",
        "esperado while",
        "esperado main",
        "esperado : { ",
        "esperado :",
        "esperado um identificador.",
        "esperado um identificador.",
        "esperado um identificador.",
        "esperado um comando.",
        "esperado um comando.",
        "esperado in",
        "esperado um identificador.",
        "esperado um identificador.",
        "esperado um identificador.",
        "esperado out",
        "esperado uma express�o.",
        "esperado if",
        "esperado isTrueDo",
        "esperado identificador } if in isFalseDo out while",
        "esperado isFalseDo",
        "esperado isFalseDo",
        "esperado identificador } if in isTrueDo out while",
        "esperado isTrueDo",
        "esperado while",
        "esperado uma express�o",
        "esperado uma express�o",
        "esperado uma express�o",
        "esperado uma express�o",
        "esperado = != < <= > >=",
        "esperado uma express�o.",
        "esperado uma express�o.",
        "esperada , ; [ ] ) operador bin�rio(aritm�tico, l�gico, relacional)",
        "esperado uma express�o.",
        "esperado uma express�o.",
        "esperado , ;",
        "esperado , ; [",
        "esperado uma express�o.",
        "esperado , [ ) <-",
        "esperado , )",
        "esperado , )",
        "esperado , ; ] ) and or",
        "esperada , ; [ ] ) operador bin�rio(aritm�tico, l�gico, relacional)",
        "esperada , ; [ ] ) operador bin�rio(aritm�tico, l�gico, relacional)",
        "esperado isTrueDo isFalseDo",
        "esperado isTrueDo isFalseDo",
        "esperada , ; [ ] ) operador bin�rio(aritm�tico, l�gico, relacional)"
    };
}
