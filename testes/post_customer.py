
import random
import requests

def gerarCpf(pontos=True):
    cpf = ''
    for i in range(11):
        cpf += str(random.randint(0,9))
    if pontos:
        cpf = cpf[:3] + '.' + cpf[3:6] + '.' + cpf[6:9] + '-' + cpf[9:]
    return cpf


def create_customer():

    url = 'http://localhost:8080/customer/v1'
    headers = {'Content-Type': 'application/json'}
    data = {
        

        "name": "Novo Cliente",
        "cpf": gerarCpf()
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
