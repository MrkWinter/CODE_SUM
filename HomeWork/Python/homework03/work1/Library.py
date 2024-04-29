from typing import List

from Book import Book


class Library:
    def __init__(self, name: str, books: List[Book]):
        self._name = name
        self._books = books

    def add_book(self, book: Book):
        self._books.append(book)

    def find_book(self, name: str):
        for i in self._books:
            if i.get_title() == name:
                return i.get_author(), i.get_price()
        return "Book not find"

    def sell_book(self, title: str, num: int):
        for i in self._books:
            if i.get_title() == title:
                return i.get_price() * num
        return "Book not find"

    def get_inventory(self):
        return self._books


if __name__ == '__main__':
    library = Library("图书馆1", list())
    library.add_book(Book("a", "b", 10, 2))
    books = library.get_inventory()
    for i in books:
        print(i)