#quero criar uma função que retorna o cpf gerado com um parametro boolean que indica se o cpf sera apenas numeros ou com pontos e traços

import random
import requests

def gerarCpf(pontos=True):
    cpf = ''
    for i in range(11):
        cpf += str(random.randint(0,9))
    if pontos:
        cpf = cpf[:3] + '.' + cpf[3:6] + '.' + cpf[6:9] + '-' + cpf[9:]
    return cpf