import requests

def test_connection():
    url = 'http://localhost:8080/test'  # Substitua pela URL correta do seu endpoint

    try:
        response = requests.get(url)
        response.raise_for_status()  # Verifica se houve algum erro na resposta (status code >= 400)

        data = response.json()
        print("Conexão com o MongoDB bem-sucedida!")
        print("Dados retornados:")
        print(data)

    except requests.exceptions.RequestException as e:
        print(f"Erro na conexão com o endpoint: {e}")
        print("Certifique-se de que a aplicação Spring Boot está em execução e o endpoint /test está configurado corretamente.")

if __name__ == "__main__":
    test_connection()
