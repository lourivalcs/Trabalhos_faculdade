package start;

import funcionalidades.Menu;
import objetos.Arrays;

public class App {
    public static void main(String[] args) {
        //Objeto com todos os arrays utilizado no programa
        Arrays arrays = new Arrays();
        //classe para carregar dados de testes
        new InsereDadosSoftware(arrays);
        //Instancia o menu e chama seu método
        new Menu().menu(arrays);
    }
}
