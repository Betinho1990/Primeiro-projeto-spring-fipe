package br.com.alura.fipe.service;

import br.com.alura.fipe.model.*;

import java.util.List;
import java.util.Scanner;

public class FipeApplication {

	private Scanner leitura = new Scanner(System.in);
	private ConsumoApi consumo = new ConsumoApi();
	private ConverteDados conversor = new ConverteDados();

	public void iniciar() {
		System.out.println("Escolha o tipo de veículo:");
		System.out.println("1 - Carros");
		System.out.println("2 - Motos");
		System.out.println("3 - Caminhões");

		String opcao = leitura.nextLine();
		String tipo;

		if (opcao.equals("1")) {
			tipo = "carros";
		} else if (opcao.equals("2")) {
			tipo = "motos";
		} else if (opcao.equals("3")) {
			tipo = "caminhoes";
		} else {
			System.out.println("❌ Opção inválida! Encerrando o programa.");
			return;
		}

		String urlMarcas = "https://parallelum.com.br/fipe/api/v1/" + tipo + "/marcas";
		String jsonMarcas = consumo.obterDados(urlMarcas);
		List<Veiculo> marcas = conversor.obterLista(jsonMarcas, Veiculo[].class);

		marcas.forEach(m -> System.out.println(m.codigo() + " - " + m.nome()));
		System.out.print("Informe o código da marca: ");
		String codigoMarca = leitura.nextLine();

		boolean marcaExiste = marcas.stream().anyMatch(m -> m.codigo().equals(codigoMarca));
		if (!marcaExiste) {
			System.out.println("❌ Código de marca inválido. Encerrando.");
			return;
		}

		String urlModelos = urlMarcas + "/" + codigoMarca + "/modelos";
		String jsonModelos = consumo.obterDados(urlModelos);
		ModeloResponse modeloResponse = conversor.obterDados(jsonModelos, ModeloResponse.class);

		System.out.println("\nModelos disponíveis:");
		modeloResponse.modelos().forEach(m -> System.out.println(m.codigo() + " - " + m.nome()));
		System.out.print("Informe o código do modelo: ");
		String codigoModelo = leitura.nextLine();

		boolean modeloExiste = modeloResponse.modelos().stream().anyMatch(m -> m.codigo().equals(codigoModelo));
		if (!modeloExiste) {
			System.out.println("❌ Código de modelo inválido. Encerrando.");
			return;
		}

		String urlAnos = urlMarcas + "/" + codigoMarca + "/modelos/" + codigoModelo + "/anos";
		String jsonAnos = consumo.obterDados(urlAnos);
		List<Veiculo> anos = conversor.obterLista(jsonAnos, Veiculo[].class);

		System.out.println("\nAnos disponíveis:");
		anos.forEach(a -> {
			String nomeAmigavel = a.nome().equals("32000") ? "Zero Km" : a.nome();
			System.out.println(a.codigo() + " - " + nomeAmigavel);
		});

		System.out.print("Informe o código do ano: ");
		String codigoAno = leitura.nextLine();

		boolean anoExiste = anos.stream().anyMatch(a -> a.codigo().equals(codigoAno));
		if (!anoExiste) {
			System.out.println("❌ Código de ano inválido. Encerrando.");
			return;
		}

		String urlValor = urlMarcas + "/" + codigoMarca + "/modelos/" + codigoModelo + "/anos/" + codigoAno;
		String jsonValor = consumo.obterDados(urlValor);
		VeiculoDetalhado veiculo = conversor.obterDados(jsonValor, VeiculoDetalhado.class);

		System.out.println("\n🧾 Informações do veículo:");
		System.out.println("Marca: " + veiculo.marca());
		System.out.println("Modelo: " + veiculo.modelo());
		System.out.println("Ano: " + veiculo.anoModelo());
		System.out.println("Valor: " + veiculo.valor());
	}
}
