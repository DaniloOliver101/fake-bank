import aiohttp
import asyncio

async def get_customers_list():
    url = 'http://localhost:8080/customer/v1'  # Substitua pela URL do seu servidor web
    async with aiohttp.ClientSession() as session:
        async with session.get(url) as response:
            if response.status == 200:
                customers = await response.json()
                return customers
            else:
                print(f"Erro na requisição: {response.status}")
                return []

async def main():
    customers_list = await get_customers_list()
    print(customers_list)

if __name__ == "__main__":
    loop = asyncio.get_event_loop()
    loop.run_until_complete(main())
