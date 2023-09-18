# HealthTechApp
# Conceito:
A ideia desse projeto piloto é demonstrar protótipo de como seria a aplicação do HealthTech, onde o temos como objetivo permitir que o usuário tenha informações sobre filas de hospitais, podendo ser de hospitais privados ou públicos, dependendo da aplicabilidade no mercado.
Além disso, podendo mapear hospitais próximos e mais vazios.
O objetivo é conseguir integrar no mesmo aplicativo as informações referentes a disponibilidade de vacinas e médicos especialistas disponíveis.

# Telas da aplicação:
	Tela de Login,
	Cadastro,
	Hospitais Próximos.

![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/ec5112cf-8739-4ab8-b5c7-e57eed789eba)
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/c912514e-d212-4b1e-8e6b-22086c41123a)


# Telas de Validação:
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/220d0a1b-8492-434f-b212-4285390dc734)

Validações nulas/brancas possuem o mesmo texto, sendo requisitado o preenchimento do campo, em caso de preenchimento errado o texto é alterado.
O mesmo para a tela de login.


# Telas de Idioma:
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/01fead4c-2ad9-46be-ad56-410199e19ec9)

Com a mudança de idioma do celular, os textos do aplicativo também são alterados de acordo.
Disponivel apenas em ingles e portugues:
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/e4896a3d-7398-4178-8fd1-cf78de49d19b)

 
# Modelagem de dados do Projeto:
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/7268e8e1-8e18-4bb1-8c49-438d33a11dc5)

Também está presente na pasta: “Modelagem” do projeto.


# Swagger:
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/e1bfb0af-0752-49bd-b609-e51f27fdd88e)

O Swagger foi feito em C# para se comunicar com o banco, até o momento ainda segue em alterações, já que estamos enfrentando alguns problemas com o Oracle, mas as rotas necessárias já estão funcionais.


# Subindo a API:
![image](https://github.com/LSilvaPedroso/HealthTechApp/assets/61203222/98f562bb-26d9-4f2a-a98d-4299e24f5d47)

O dispositivo do Android Studio não compreende o Localhost estando na mesma rede, então é necessário abrir uma rota com o ngrok e atualizar RetrofitFactory para que o aplicativo funcione.
