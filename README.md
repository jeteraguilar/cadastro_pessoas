Projeto Api Cadastro de pessoas.

Esta API, é um projeto Maven, foi desenvolvida na linguagem java 1.8, utilizando os
frameworks Spring Boot, Lombok e hibernate.
Para guardar os dados, utilizei um banco em memória chamado H2.
Logo, para compilar esse projeto, será necesário ter essas ferramentas disponíveis. Algumas precisam fazer 
o download e por isso segue os links abaixo.

Para Maven -> https://maven.apache.org/
Para Lombok -> https://projectlombok.org 


Utilização do banco.

Para utilizar o banco de dados H2, digite esse endereço no browser http://localhost:8080/h2-console.
Abrirá uma janela para login que deverá ser preenchido com os seguintes dados:


Saved Settings:	    Generic H2 (Embedded)
Setting Name:       Generic H2 (Embedded)  

Driver Class:	    org.h2.Driver
JDBC URL:           jdbc:h2:mem:testdb
User Name:          sa
Password:	


Após digitar os dados no formulário de login, clique em Connect.
Irá abrir o banco de dados, onde terá as tabelas abaixo:

#####CADASTRO
#####DEPENDENTE
#####ENDERECO
#####PESSOA
#####TELEFONE.

Escolha a tabela Cadastro e acione o botão (Run) "primeiro botão na parte superior".
Abrirá a tabela com os campos ID_CADASTRO,ID_DEPENDENTE, ID_ENDERECO, ID_PESSOA, ID_TELEFONE.
Acione o botão "Edit" na parte inferior do banco.
Abrirá a opção para adicionar dados. 
Em cada um desses campos adicione o número 1 para todos e depois clique em salvar.
Pronto, agora já dá para testar a aplicação.
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
				
Postman

Para utilização do Postman, segue o passo a passo do seguinte link:
 https://atendimento.tecnospeed.com.br/hc/pt-br/articles/360017143594-Como-instalar-e-utilizar-
 o-Postman-para-enviar-requisi%C3%A7%C3%B5es-HTTP#:~:text=Crie%20a%20conta%20e%20fa%C3%A7a,
 requisi%C3%A7%C3%A3o%20apenas%20clicando%20sobre%20ela.;


Métodos CRUD.


GET:
 Para realizar uma pesquisa de todos os cadastros que há no  banco , basta selecionar o método de resposta GET 
 na caixa suspensa  à esquerda, adicionar o seguinte url (localhost:8080/cadastro) e clique em enviar/SEND.


GET com id:
Para buscar um cadastro específico, repita a ação acima, substituindo o url por este (localhost:8080/cadastro/1).
Como há somente um cadastro, adicionei o número 1 na url, mas se acrescentar mais cadastros, é só trocar o 
número 1 pelo número de id  do cadastro que tem interesse em  pesquisar.
-

UPDATE:
 Para alterar dados de algum cadastro, basta selecionar o método de resposta GET na caixa suspensa
 à esquerda, utilizando a url (localhost:8080/cadastro/?)e substituindo o ? pelo número de interesse.
O retorno será um  corpo no formato Json. Copie esse corpo e cole no campo  (Body), logo abaixo 
da caixa suspensa.  Altere os dados necessários mude o método de GET para UPDATE, mantém a mesma url e clique
 em enviar/SEND. 

OBS:
Para alterar os campos "tipoContato","tipoDependente","tipoEndereco" e "tipo",
 tem que digitar a palavra com todas as letras maiúsculas por se tratar de "enums", 
sendo as opções aceitáveis disponíveis para cada campo especificado abaixo:

*Campo "tipoContato": Opções-> CONTATO, RESIDENCIAL e COMERCIAL.
*Campo "tipoDependente": Opções-> ESPOSA, FILHO, PAI e MÃE.
*Campo "tipoEndereco": Opções-> COMERCIAL RESIDENCIAL e CONTATO.
*Campo "tipo": Opções-> RUA AVENIDA e ESTRADA.

Corpo Json exemplo.

 {
        "idCadastro": 1,
        "pessoa": {
            "idPessoa": 1,
            "dataNascimento": "15/08/1985",
            "apelido_NomeFantasia": "Fonseca",
            "nome": "André Luiz Fonseca",
            "salario": 3000.0,
            "cpf_CNPJ": "83.230.227/0001-50",
            "profissao": "Técnico"
        },
        "telefone": {
            "idTelefone": 1,
            "numero": "98745-0000",
            "ddd": "11",
            "tipoContato": "COMERCIAL",
            "codigoPais": 55
        },
        "dependente": {
            "idDependente": 1,
            "tipoDependente": "FILHO",
            "nomeCompleto": "Hugo Faria"
        },
        "endereco": {
            "idEndereco": 1,
            "tipoEndereco": "COMERCIAL",
            "tipo": "RUA",
            "logradouro": "Rua",
            "numero": 6,
            "nome": "Antoni de França",
            "complemento": "3° andar",
            "cep": "08945-415",
            "estado": "S.P",
            "pais": "Brasil",
            "cidade": "São Paulo",
            "bairro": "Centro"
        }
    }


DELETE: 
Para deletar um cadastro, basta selecionar o método de resposta DELETE na caixa suspensa
 à esquerda,  adicione a url (localhost:8080/cadastro/?), substituindo o ? pelo número de interesse e
  clique em enviar/SEND. 


POST: 
Para adicionar um cadastro, basta selecionar o método de resposta POST na caixa suspensa
 à esquerda,  copie o corpo em formato Json que está abaixo e cole no campo (Body), logo abaixo 
da caixa suspensa e clique em enviar/SEND.


 {
       
        "pessoa": {
            
            "dataNascimento": "15/08/1985",
            "apelido_NomeFantasia": "Fonseca",
            "nome": "André Luiz Fonseca",
            "salario": 3000.0,
            "cpf_CNPJ": "83.230.227/0001-50",
            "profissao": "Técnico"
        },
        "telefone": {
            
            "numero": "98745-0000",
            "ddd": "11",
            "tipoContato": "COMERCIAL",
            "codigoPais": 55
        },
        "dependente": {
            
            "tipoDependente": "FILHO",
            "nomeCompleto": "Hugo Faria"
        },
        "endereco": {
         
            "tipoEndereco": "COMERCIAL",
            "tipo": "RUA",
            "logradouro": "Rua",
            "numero": 6,
            "nome": "Antoni de França",
            "complemento": "3° andar",
            "cep": "08945-415",
            "estado": "S.P",
            "pais": "Brasil",
            "cidade": "São Paulo",
            "bairro": "Centro"
        }
    }


				