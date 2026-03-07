package com.ronaldo.literalura.principal;

import com.ronaldo.literalura.model.ResultadoBusca;
import com.ronaldo.literalura.service.ConverteDados;
import com.ronaldo.literalura.service.ConsumoApi;
import com.ronaldo.literalura.repository.AutorRepository;
import com.ronaldo.literalura.repository.LivroRepository;
import com.ronaldo.literalura.model.Autor;
import com.ronaldo.literalura.model.Livro;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private LivroRepository livroRepository;
    private AutorRepository autorRepository;

    public Principal(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public void exibeMenu() {

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("""
                    
                    Escolha uma opção:
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar autores
                    4 - Listar autores vivos em determinado ano
                    5 - Listar livros por idioma
                    0 - Sair
                    """);

            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {

                case 1:
                    buscarLivro();
                    break;

                case 2:
                    listarLivros();
                    break;

                case 3:
                    listarAutores();
                    break;

                case 4:
                    listarAutoresVivos();
                    break;

                case 5:
                    listarLivrosPorIdioma();
                    break;


                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarLivro() {

        System.out.println("Digite o nome do livro:");
        var nomeLivro = leitura.nextLine();

        String endereco = "https://gutendex.com/books/?search=" +
                nomeLivro.replace(" ", "%20");

        var json = consumo.obterDados(endereco);

        ResultadoBusca dados = conversor.obterDados(json, ResultadoBusca.class);

        var livroApi = dados.getResults().get(0);
        var dadosAutor = livroApi.getAuthors().get(0);

        Autor autor = autorRepository.findByNome(dadosAutor.getName())
                .orElseGet(() -> {
                    Autor novoAutor = new Autor(
                            dadosAutor.getName(),
                            dadosAutor.getBirth_year(),
                            dadosAutor.getDeath_year()
                    );
                    return autorRepository.save(novoAutor);
                });

        Livro livro = new Livro(
                livroApi.getTitle(),
                livroApi.getLanguages().get(0),
                livroApi.getDownload_count(),
                autor
        );

        livroRepository.save(livro);

        System.out.println("Livro salvo no banco!");
    }

    private void listarLivros() {

        var livros = livroRepository.findAll();

        livros.forEach(l ->
                System.out.println("Livro: " + l.getTitulo() +
                        " | Idioma: " + l.getIdioma())
        );
    }

    private void listarAutores() {

        var autores = autorRepository.findAll();

        autores.forEach(a ->
                System.out.println("Autor: " + a.getNome() +
                        " | Nascimento: " + a.getAnoNascimento())
        );
    }

    private void listarAutoresVivos() {

        System.out.println("Digite o ano para pesquisa:");
        int ano = leitura.nextInt();
        leitura.nextLine();

        var autores = autorRepository.findAll();

        autores.stream()
                .filter(a -> a.getAnoNascimento() != null && a.getAnoFalecimento() != null)
                .filter(a -> ano >= a.getAnoNascimento() && ano <= a.getAnoFalecimento())
                .forEach(a ->
                        System.out.println("Autor: " + a.getNome() +
                                " | Nascimento: " + a.getAnoNascimento() +
                                " | Falecimento: " + a.getAnoFalecimento())
                );
    }

    private void listarLivrosPorIdioma() {

        System.out.println("""
            Escolha o idioma:
            es - espanhol
            en - inglês
            fr - francês
            pt - português
            """);

        String idioma = leitura.nextLine();

        var livros = livroRepository.findAll();

        livros.stream()
                .filter(l -> l.getIdioma().equalsIgnoreCase(idioma))
                .forEach(l ->
                        System.out.println("Livro: " + l.getTitulo() +
                                " | Idioma: " + l.getIdioma())
                );
    }

}