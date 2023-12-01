package aula.prestaservico.Util;

public class Validador {
    public static boolean temConteudo(String texto)
    {
        if(texto!=null && !texto.isBlank())
            return true;
        else
            return false;
    }
}
