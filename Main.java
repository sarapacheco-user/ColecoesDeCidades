import java.util.*;

public class Main {

    public static void main(String[] args) {
       
        List<Cidade> cidades = Arrays.asList(
                new Cidade("GO", "Anápolis", false),
                new Cidade("GO", "Goiânia", true),
                new Cidade("SP", "Ribeirão Preto", false),
                new Cidade("SP", "Campinas", false),
                new Cidade("MG", "Belo Horizonte", true),
                new Cidade("MG", "Uberlândia", false),
                new Cidade("MG", "Montes Claros", false),
                new Cidade("MG", "Unaí", false),
                new Cidade("TO", "Palmas", true),
                new Cidade("TO", "Araguarí", false),
                new Cidade("MT", "Cuiabá", true),
                new Cidade("MS", "Dourados", false),
                new Cidade("MS", "Campo Grande", true),
                new Cidade("MS", "Corumbá", false),
                new Cidade("MT", "Barra do Garças", false),
                new Cidade("MT", "Araguaiana", false),
                new Cidade("RO", "Porto Velho", true),
                new Cidade("RO", "Costa Marques", false)
        );

        // Estrutura 1
        TreeMap<String, List<String>> agrupadasPorUF = new TreeMap<>();
        for (Cidade cidade : cidades) {
            agrupadasPorUF.computeIfAbsent(cidade.getUf(), k -> new ArrayList<>()).add(cidade.getNome());
        }
        for (List<String> lista : agrupadasPorUF.values()) {
            lista.sort(Comparator.naturalOrder());
        }
        System.out.println("Estrutura 1: Cidades agrupadas por UF e ordenadas alfabeticamente:");
        agrupadasPorUF.forEach((uf, lista) -> System.out.println(uf + ": " + lista));

        // Estrutura 2
        List<Cidade> ordenadasCapitaisPrimeiro = new ArrayList<>(cidades);
        ordenadasCapitaisPrimeiro.sort(Comparator.comparing(Cidade::isCapital).reversed().thenComparing(Cidade::getNome));
        System.out.println("\nEstrutura 2: Capitais primeiro, depois ordem alfabética:");
        for (Cidade cidade : ordenadasCapitaisPrimeiro) {
            System.out.println(cidade.getNome() + (cidade.isCapital() ? " (Capital)" : ""));
        }

        // Estrutura 3
        TreeSet<Cidade> conjuntoDecrescente = new TreeSet<>(Comparator.comparing(Cidade::getNome).reversed());
        conjuntoDecrescente.addAll(cidades);
        System.out.println("\nEstrutura 3: Cidades em ordem alfabética decrescente:");
        conjuntoDecrescente.forEach(c -> System.out.println(c.getNome()));
    }
}
