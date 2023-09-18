# HealthTechApp
# Conceito:
A ideia desse projeto piloto é demonstrar protótipo de como seria a aplicação do HealthTech, onde o temos como objetivo permitir que o usuário tenha informações sobre filas de hospitais, podendo ser de hospitais privados ou públicos, dependendo da aplicabilidade no mercado.
Além disso, podendo mapear hospitais próximos e mais vazios.
O objetivo é conseguir integrar no mesmo aplicativo as informações referentes a disponibilidade de vacinas e médicos especialistas disponíveis.

# Telas da aplicação:
	Tela de Login,
	Cadastro,
	Hospitais Próximos.

![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/8eb46fed-8302-473c-a911-2b6ced642328)
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/139932f6-5510-46f9-9646-46a227832ceb)
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/99e495da-4d34-4c89-bade-3e1cdeb5bbbe)
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/6b3cfe2c-6e68-4c1f-91f9-6bf1036b7d07)


# Telas de Validação:
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/6a729c0f-42aa-4d02-8ad9-e1ad9e6a8207)
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/5198c8d5-9b08-4008-8921-69ad61093f67)

Validações nulas/brancas possuem o mesmo texto, sendo requisitado o preenchimento do campo, em caso de preenchimento errado o texto é alterado.
O mesmo para a tela de login.


# Telas de Idioma:
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/40344407-f5d7-455a-b9f2-a1bf8e4f93cf)
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/8395d390-007c-4de0-a06a-1342b46ce488)

Com a mudança de idioma do celular, os textos do aplicativo também são alterados de acordo.
Disponivel apenas em ingles e portugues:
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/de104ed3-7adf-45d0-a16f-acb503bdb17f)

 
# Modelagem de dados do Projeto:
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/6e453ea0-1156-46af-a178-4cadad656e30)

Também está presente na pasta: “Modelagem” do projeto.


# Swagger:
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/d94f1e09-44ae-4543-bbfc-0376b0689bb2)

O Swagger foi feito em C# para se comunicar com o banco, até o momento ainda segue em alterações, já que estamos enfrentando alguns problemas com o Oracle, mas as rotas necessárias já estão funcionais.


# Subindo a API:
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/a7cf8471-9184-48a8-acb2-b598d00e8b04)

O dispositivo do Android Studio não compreende o Localhost estando na mesma rede, então é necessário abrir uma rota com o ngrok e atualizar RetrofitFactory para que o aplicativo funcione.
