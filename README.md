

# 🚗 FIPE Explorer - Consulta de Preços de Veículos com Java + Spring

Este projeto é uma aplicação em **Java com Spring Boot** que permite consultar os preços atualizados de **carros**, **motos** e **caminhões** diretamente da **API da Tabela FIPE**.

É uma aplicação **console interativa**, com navegação orientada ao usuário e validações para evitar erros de digitação.

---

## ✨ Funcionalidades

- ✅ Escolha entre carros, motos ou caminhões
- ✅ Visualize as marcas disponíveis
- ✅ Selecione o modelo e o ano desejado
- ✅ Obtenha o valor atualizado do veículo
- ✅ Mensagens amigáveis em caso de entrada inválida

---

## 🧰 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Maven
- Biblioteca Jackson (para converter JSON)
- API pública da [Tabela FIPE](https://deividfortuna.github.io/fipe/)

---

## ▶️ Como Executar

1. **Clone o repositório:**

```bash

git clone https://github.com/Betinho1990/fipe-explorer.git
cd fipe-explorer

```

2. **Compile e execute com Maven:**

./mvnw spring-boot:run

## 🧪 Exemplo de uso

```yaml

Escolha o tipo de veículo:
1 - Carros
2 - Motos
3 - Caminhões

Informe o código da marca: 21
Modelos disponíveis:
4828 - Palio
...

Informe o código do modelo: 4828
Anos disponíveis:
2020-1 - 2020
2021-1 - 2021

Informe o código do ano: 2021-1

🧾 Informações do veículo:
Marca: Fiat
Modelo: Palio
Ano: 2021
Valor: R$ 35.678,00

```

## 💡 Possíveis melhorias

- Transformar em API REST com endpoints HTTP

- Interface gráfica (Swing ou JavaFX)

- Filtros por nome da marca ou modelo

- Histórico de buscas

## 🤝 Contribuições

Contribuições são bem-vindas! Se você quiser colaborar com melhorias, fique à vontade para fazer um fork e enviar um pull request.

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

## ✍️ Autor

Desenvolvido com 💻 por Roberto Filho 🚀
