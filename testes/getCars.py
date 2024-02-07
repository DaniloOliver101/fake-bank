import requests

url = "http://localhost:8081/cars"
#url = "http://localhost:8081/cars?model=Golf"


response = requests.get(url)
print(response.status_code)
print(response.json())



