<h1>Portfólio das APIs - Cauana Dias Costa</h1>

<h4>Introdução</h4>

<p align="justify">Trabalho de Graduação na modalidade Portfólio das Aprendizagens a partir de Projeto Integrador (APIs), apresentado na Faculdade de Tecnologia de São José dos Campos - curso: Banco de Dados.</p>

<h4>Sobre mim</h4>

<p align="center"><img src="https://github.com/Cauana/bertoti/assets/77700346/fa566986-fa26-4d55-9d05-57cb6117387c" width="30%"></p>

<p align="justify">Bacharel em Administração Pública pela Universidade Estadual Paulista (UNESP) e regularmente matriculada no 4º semestre do curso tecnólogo em Banco de Dados pela Faculdade de Tecnologia de São José dos Campos (FATEC).</p>

<p align="justify">Possuo experiência na área de Tecnologia, tive a oportunidade de realizar meu estágio na General Electric (GE Taubaté) por um ano, onde trabelhei com o desenvolvimento de um projeto de melhoria das traduções técnicas com termos de Engenharia. Além disso, atuei realizando tratamento de dados, dashboards para entendimento de listas de documentos e principalmente desenvolvimento de automações de processos.</p>

<p align="justify">Atualmente estou começando uma nova jornada como Assessora de Tecnologia do Banco do Brasil (BB), no qual terei a oportunidade de me desenvolver tecnicamente, trabalhando com desenvolvimento em si..</p>

<p align="center">• <a href="https://www.git.com/Cauana">LinkedIn</a> • <a href="https://www.linkedin.com/in/cauanadias/">GitHub</a> •</p>


<details><summary><b>Meus Principais Conhecimentos</b></summary>
<br>
<p align="justify">Aprendizados sobre a linguagem de programação Java, pude desenvolver a lógica da aplicação, desenvolvi a capacidade de projetar e implementar APIs RESTful para expor operações CRUD, garantindo uma comunicação eficaz entre diferentes componentes do sistema e possibilitando a integração com outras aplicações. Obtive experiência prática com bancos de dados relacionais, como PostgreSQL, aprendendo a armazenar e recuperar dados de forma eficiente e segura.</p>
<p align="justify">Aprimorei minhas habilidades em utilizar o Git para controle de versão do código-fonte e colaboração em equipe, garantindo um fluxo de trabalho suave e colaborativo durante todo o desenvolvimento do projeto. Além de conseguir adquirir conhecimentos básicos de tecnologias front-end, incluindo HTML, CSS e JavaScript, permitindo-me construir interfaces de usuário interativas e amigáveis para os usuários finais.</p></details>


<h4>Meus Projetos</h4>

<h4>Em 2023-2</h4> 
<p align="justify">O produto 2Rponto é um sistema que realiza o controle de horas excedentes de colaboradores da empresa 2RP Net. A empresa parceira é conhecida por disponibilizar soluções para análise de informações em tempo real para tomada de decisões de negócios que precisam atender requisitos de tempo extremamente rigorosos. As soluções inovadoras e customizadas a diferenciam no mercado, assim como os serviços, permitem o crescimento de negócio e de seus resultados.</p>

<p align="center"><img src="https://github.com/Cauana/bertoti/assets/77700346/2c90ccaa-860e-44a9-afa8-b276b372905e" width="70%"></p>

<p align="justify">Anteriormente, a empresa enfrentava desafios na gestão de horas, dependendo de várias planilhas, o que limitava a disponibilidade, flexibilidade e controle necessários. Em resposta, desenvolvemos uma aplicação que centraliza o controle de horas excedentes, distinguindo entre horas extras e sobreavisos. Essa aplicação também oferece recursos de aprovação ou reprovação das horas pelo gestor da equipe e pelo departamento de Recursos Humanos. Além disso, inclui painéis de controle para os colaboradores visualizarem suas horas aprovadas ou reprovadas, enquanto gestores e RH podem monitorar as pendências de aprovação de seus respectivos usuários. </p>
    
[GIT](https://github.com/oJavaLi/doisrponto?tab=readme-ov-file)

<summary><b>Tecnologias Utilizadas</b></summary>
<br>
<ul>
    <li><strong>Figma:</strong> Plataforma de design de interface do usuário.</li>
    <li><strong>Java Spring:</strong> Framework de desenvolvimento Java com gama de recursos para desenvolver aplicativos robustos e escaláveis.</li>
    <li><strong>Git:</strong> Sistema de controle de versão distribuído.</li>
    <li><strong>Slack:</strong> Plataforma de comunicação empresarial.</li>
    <li><strong>PostgreSQL:</strong> Sistema de gerenciamento de banco de dados relacional de código aberto para armazenar dados cadastrados.</li>
</ul>

<b>Contribuições Pessoais</summary></b>
<br>
<p align="justify">Desempenhei o papel de Product Owner, realizando o levantamente dos requisitos para construção do backlog do produto, garantindo uma compreensão do time sobre as necessidades do cliente e das regras de negócio. Fui responsável pela estruturação de classes, desenvolvi a aplicação cliente-servidor para apontamentos de sobreavisos e cadastro de usuários, além de realizar correções ao banco de dados. Sendo as atividades desempenhadas:</p>
  
 

<details><Summary><b>Controller de Usuário.</b></Summary>
<pre><code>
package com.ojavali.doisrponto.usuarios;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository; 

    // Criação de usuário
    @PostMapping("/cadastrarUsuario")
    public ResponseEntity<User> cadastrarUsuario(@RequestBody @Validated User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
    }

    // Obter todos os usuários
    @GetMapping("/usuarios")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }

    // Obter um usuário com base no ID
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Object> getUsuario(@PathVariable(value = "id") Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
    }

    // Atualizar dados de um usuário
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable(value = "id") Long id, @RequestBody User updatedUser) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            BeanUtils.copyProperties(updatedUser, user, "id"); 
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
    }

    // Deletar um usuário
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value = "id") Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userRepository.delete(user);
            return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
    }
}

</pre></code>
  </details>
<details><Summary><b>Formulário de Sobreavisos.</b></Summary>
<pre><code>
    
const formulario = document.querySelector("sobre-aviso-form");
const botao = document.querySelector("submit");
const entrada = document.querySelector(".entrada");
const saida = document.querySelector(".saida");
const cliente = document.querySelector(".cliente");
const projeto = document.querySelector(".projeto");
const cr = document.querySelector(".cr");
const justificativa = document.querySelector(".justificativa");
const matricula = 1;

function getQueryParameter(name) {
    const urlSearchParams = new URLSearchParams(window.location.search);
    return urlSearchParams.get(name);
}

const username = getQueryParameter('username');
const categoria = getQueryParameter('categoria');

const usernameDisplay = document.getElementById('usernameDisplay');

usernameDisplay.textContent = `Matrícula: ${username}`; // Exemplo de mensagem de boas-vindas
function cadastrar(){
    fetch("http://localhost:1234/cadastrarApontamentos",
        {
            headers: {
                'Accept':'application/json',
                'Content-Type':'application/json'
            },
            method:"POST",
            body: JSON.stringify({
                categoria: categoria,
                data_hora_inicio:  entrada.value,
                data_hora_fim: saida.value,
                justificativa: justificativa.value,
                usuarioMatricula:  username,
                centroResultadosId: cr.value

            })
        })
        .then(function (res){
            // Verifica se a resposta da requisição foi bem-sucedida
            if (res.ok) {
                // Redireciona para a outra página HTML após o cadastro bem-sucedido
                window.location.href = `listarApontamentos.html?username=${username}`;
            } else {
                console.log("Erro ao cadastrar");
            }
        })
        .catch(function(res) {console.log(res)})
}
formulario.addEventListener('submit', function(event){
    event.preventDefault();
    cadastrar();
});
document.getElementById("submit2").addEventListener("click", function () {
    // Volte para a página anterior no histórico de navegação
    window.location.href = `listarApontamentos.html?username=${username}`;
});

document.addEventListener('DOMContentLoaded', function () {
    // Execute este código após a página ser completamente carregada

    // Obtém a referência ao elemento <select> com id="cr"
    const crSelect = document.getElementById('cr');

    // Faça uma solicitação AJAX (ou fetch) para buscar os IDs da URL
    fetch('/CR')
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro na solicitação.');
            }
            return response.json();
        })
        .then(data => {
            // Preencha as opções do <select> com as propriedades "id" dos objetos
            data.forEach(obj => {
                const option = document.createElement('option');
                option.value = obj.id.toString(); // Acesse a propriedade "id" do objeto e converta para string
                option.textContent = obj.id.toString(); // Acesse a propriedade "id" do objeto e converta para string
                crSelect.appendChild(option);
            });
        })
        .catch(error => {
            console.error('Erro:', error);
        });
});

document.addEventListener('DOMContentLoaded', function () {

    function fetchApontamentosAndPopulateTable() {
        const token = sessionStorage.getItem("token");
        if (!token) {
            window.location.href = "/index.html";
        }
        // Execute este código após a página ser completamente carregada
        const crSelect = document.getElementById('cr');
        const clienteInput = document.getElementById('cliente');
        const projetoInput = document.getElementById('projeto');

        crSelect.addEventListener('change', function () {
        const crValue = this.value; 

            if (!crValue) {
                clienteInput.value = ''; // Limpa o campo "Cliente"
                projetoInput.value = ''; // Limpa o campo "Projeto"
                return;
            }

            fetch("/CR/" + crValue)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Erro na solicitação.');
                    }
                    return response.json();
                })
                .then(data => {
                    // Preencha os campos "cliente" e "projeto" com os dados do JSON
                    clienteInput.value = data.nome_cliente;
                    projetoInput.value = data.nome_projeto;
                })
                .catch(error => {
                    console.error('Erro:', error);
                });
        });
    }
    fetchApontamentosAndPopulateTable();

});

</pre></code>
</details>

<details>
  <summary><b>Conexão entre o backend e o front-end para cadastro de apontamentos</b></summary>
  <pre><code>
const formulario = document.querySelector("form");
const botao = document.querySelector("button");
const UserNome = document.querySelector(".name");
const UserMatricula = document.querySelector(".matricula");
const UserEmail = document.querySelector(".email");
const UserSenha = document.querySelector(".password");
const UserCategoria = document.querySelector(".role");

function cadastrar() {
    fetch("http://localhost:1234/cadastrarApontamento", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            nome: UserNome.value,
            matricula: UserMatricula.value,
            email: UserEmail.value,
            senha: UserSenha.value,
            categoria: UserCategoria.value
        })
    })
    .then(function (res) { console.log(res) })
    .catch(function (res) { console.log(res) })
};

formulario.addEventListener('submit', function (event) {
    event.preventDefault();
    cadastrar();
});
  </code></pre>
</details>


<details><Summary><b>Definição do backlog do produto.</b></Summary>

 | Rank|           Task             |Prioridade|Sprint|
|:---------------------------------:|:----------:|:----------:|:----------:|
|1|Como RH, eu gostaria de ter a permissão de criar e gerenciar contas de um usuário com diferentes níveis de acesso, para poder cadastrar os funcionários em segurança no meu sistema.|Média|1|
|2|Como um colaborador gostaria de ter um sistema onde consiga ser capaz de lançar todas as informações sobre horas excedentes trabalhadas, para poder ser pago.|Alta|1|
|3|Como colaborador eu quero ser capaz de diferenciar horas extra de sobreaviso para controlar melhor meu tempo de trabalho e ter pagamento adequado.|Alta|2|
|4|Como um RH, eu quero ser capaz de visualizar os apontamentos submetidos por cada funcionário, para que eu possa revisar a carga trabalhada para submeter a pagamento.|Média|2|
|5|Como RH, eu quero ser capaz de aprovar ou rejeitar as horas trabalhadas garantir não ter qualquer erro ou inconsistência no lançamento e fazer pagamento correto aos colaboradores.|Alta|2|
|6|Como um gestor, eu quero ser capaz de visualizar os apontamentos submetidos pelo meu CR, para que eu possa revisar a carga trabalhada para submeter a pagamento.|Média|3|
|7|Como gestor, eu quero ser capaz de aprovar ou rejeitar as horas trabalhadas garantir não ter qualquer erro ou inconsistência no lançamento e fazer pagamento correto aos colaboradores.|Alta|3|
|8|Como um colaborador, eu quero ser capaz de visualizar informações sobre as minhas próprias horas extras executadas no dashboard, para ter maior controle das horas aprovadas/ reprovadas e pagamento adequado.|Baixa|4|
|9|Como RH, eu quero ser capaz de acessar um dashboard em tempo real que me permita monitorar as horas extras executadas pelos colaboradores, para acompanhar horas trabalhadas de acordo com as necessidades do CR|Baixa|4|
 
</details>

<br>
  <summary><b>Hard skills</b></summary>
  <br>
  <table align="center">
    <tr>
      <td align="center"><b>Java:</b></td>
      <td>🌟🌟🌟🌟</td>
    </tr>
    <tr>
      <td align="center"><b>Java Spring Framework:</b></td>
      <td>🌟🌟🌟🌟</td>
    </tr>
    <tr>
      <td align="center"><b>Banco de Dados Relacionais, PostgreSQL:</b></td>
      <td>🌟🌟🌟🌟🌟</td>
    </tr>
    <tr>
      <td align="center"><b>Git:</b></td>
      <td>🌟🌟🌟🌟</td>
    </tr>
    <tr>
      <td align="center"><b>RESTful APIs:</b></td>
      <td>🌟🌟🌟🌟</td>
    </tr>
    <tr>
      <td align="center"><b>HTML/CSS/JavaScript:</b></td>
      <td>🌟🌟🌟</td>
    </tr>
    <tr>
      <td align="center"><b>Diagrama DER:</b></td>
      <td>🌟🌟🌟🌟🌟</td>
    </tr>
  </table>


<summary><b>Soft skills</b></summary>
<br>
  <table align="center">
    <tr>
      <td align="center"><b>Comunicação Efetiva:</b></td>
      <td>🌟🌟🌟🌟</td>
    </tr>
    <tr>
      <td align="center"><b>Trabalho em Equipe:</b></td>
      <td>🌟🌟🌟🌟🌟</td>
    </tr>
    <tr>
      <td align="center"><b>Resolução de Problemas:</b></td>
      <td>🌟🌟🌟🌟🌟</td>
    </tr>
    <tr>
      <td align="center"><b>Adaptabilidade:</b></td>
      <td>🌟🌟🌟</td>
    </tr>
    <tr>
      <td align="center"><b>Atenção aos Detalhes:</b></td>
      <td>🌟🌟🌟🌟🌟</td>
    </tr>
    <tr>
      <td align="center"><b>Gestão do Tempo:</b></td>
      <td>🌟🌟🌟🌟</td>
    </tr>
    <tr>
      <td align="center"><b>Aprendizado Contínuo:</b></td>
      <td>🌟🌟🌟🌟</td>
    </tr>
    <tr>
      <td align="center"><b>Resiliência:</b></td>
      <td>🌟🌟🌟</td>
    </tr>
  </table>

