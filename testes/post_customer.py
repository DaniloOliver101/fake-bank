import requests

def create_customer():
    url = 'http://localhost:8080/customer/v1'
    headers = {'Content-Type': 'application/json'}
    data = {
        "name": "Novo Cliente",
        "cpf": "42545902888"
    }

    try:
        response = requests.post(url, headers=headers, json=data)

        # Verifique se a solicitação foi bem-sucedida (código de status 2XX)
        response.raise_for_status()

        print("Cliente criado com sucesso!")
    except requests.exceptions.RequestException as e:
        print(f"Erro durante a criação do cliente: {e}")

if __name__ == "__main__":
    create_customer()
