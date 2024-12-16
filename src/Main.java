import Pensao.Pensao;
import Pessoa.Pessoa;
public class Main {
    public static void main(String[] args) {
        var pensaoClotilde = new Pensao();

        var luciane = new  Pessoa
                .Builder()
                .nome("Luciane")
                .email("lucia@gmail.com")
                .build();
        var fernanda = new Pessoa.Builder()
                .nome("Fernanda").email("labisgoia@outlook.com").build();
        var diana = new Pessoa.Builder()
                .nome("Diana").email("diana_arte@outlook.com").build();
        var max = new Pessoa.Builder()
                .nome("Max").email("maxine_gatuna@outlook.com").build();
        var luciFernMaxDiana = new  Pessoa.Builder()
                .nome("Fernanda Luciane Diana Max").email("fernan@gmail.com")
                .build();

        pensaoClotilde.reservaQuarto(luciane,5);
        pensaoClotilde.reservaQuarto(fernanda,6);
        pensaoClotilde.reservaQuarto(diana,2);
        pensaoClotilde.reservaQuarto(max,10);
        pensaoClotilde.checkoutQuarto(6);
        pensaoClotilde.checkoutQuarto(2);
        pensaoClotilde.checkoutQuarto(10);
        pensaoClotilde.checkoutQuarto(5);
//        pensaoClotilde.reservaQuarto(luciFernMaxDiana,6);

        System.out.println(pensaoClotilde.verificaQuartosVazios());

        System.out.println(pensaoClotilde);
    }
}