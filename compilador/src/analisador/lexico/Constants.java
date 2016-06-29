package analisador.lexico;
public interface Constants extends ScannerConstants, ParserConstants
{
    int EPSILON  = 0;
    int DOLLAR   = 1;

    int t_pr = 2;
    int t_int = 3;
    int t_float = 4;
    int t_string = 5;
    int t_bool = 6;
    int t_conint = 7;
    int t_confloat = 8;
    int t_constring = 9;
    int t_c_bloco = 10;
    int t_TOKEN_11 = 11; //","
    int t_TOKEN_12 = 12; //":"
    int t_TOKEN_13 = 13; //";"
    int t_TOKEN_14 = 14; //"["
    int t_TOKEN_15 = 15; //"]"
    int t_TOKEN_16 = 16; //"("
    int t_TOKEN_17 = 17; //")"
    int t_TOKEN_18 = 18; //"{"
    int t_TOKEN_19 = 19; //"}"
    int t_TOKEN_20 = 20; //"+"
    int t_TOKEN_21 = 21; //"-"
    int t_TOKEN_22 = 22; //"*"
    int t_TOKEN_23 = 23; //"/"
    int t_TOKEN_24 = 24; //"<-"
    int t_TOKEN_25 = 25; //"="
    int t_TOKEN_26 = 26; //"!="
    int t_TOKEN_27 = 27; //"<"
    int t_TOKEN_28 = 28; //"<="
    int t_TOKEN_29 = 29; //">"
    int t_TOKEN_30 = 30; //">="
    int t_and = 31;
    int t_false = 32;
    int t_if = 33;
    int t_in = 34;
    int t_isFalseDo = 35;
    int t_isTrueDo = 36;
    int t_main = 37;
    int t_module = 38;
    int t_not = 39;
    int t_or = 40;
    int t_out = 41;
    int t_true = 42;
    int t_while = 43;
}
