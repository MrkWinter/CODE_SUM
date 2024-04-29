class Book:
    def __init__(self, title: str, author: str, price: float, sales=0):
        self.__title = title
        self.__author = author
        self.__price = price
        self.__sales = sales

    def get_title(self):
        return self.__title

    def get_author(self):
        return self.__author

    def get_price(self):
        return self.__price

    def sell_book(self, sales):
        return (self.__sales + sales) * self.__price

    def get_sales(self):
        return self.__sales

    def __str__(self) -> str:
        return f"title{self.__title},author{self.__author},price{self.__price},sales{self.__sales}"
