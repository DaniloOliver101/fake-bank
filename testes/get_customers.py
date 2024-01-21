import requests

response = requests.get('http://localhost:8080/customer/v1')

print(response.json())