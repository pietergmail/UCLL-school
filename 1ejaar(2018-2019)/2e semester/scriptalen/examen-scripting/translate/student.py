'''
    Vertaal de code in LinkedList.java naar Python.

    We vragen niet om een letterlijke vertaling:
    de Python code moet idiomatisch zijn en gebruik
    maken van properties, operator overloading, etc.


    === ENGLISH ===

    Translate the code in LinkedList.java into Python.

    We are not interested in a literal translation,
    but instead want idiomatic Python code.
    This means you will need to make use of properties,
    operator overloading, etc.

'''


class linkedlist(object):
    def __init__(self, value=None, next=None):
        self.__value = value
        self.__next = next

    @property #get value
    def value(self):
        return self.__value

    @value.setter#set value
    def value(self, value):
        self.__value = value

    @property#get next
    def next(self):
        return self.__next

    @value.setter
    def next(self, next):
        self.__next = next

    def __len__(self):#get lenght
        if self.__next == None:
            return 1
        else:
            return 1 + len(self.__next)

    def __add__(self, lst):#add extra object
        if self.next == none:
            return LinkedList(self.__value, lst)
        else:
            return LinkedList(self.__value)

    def __contains__(self, item):#return current value
        return self.__value == value or (self.__next != None and value in self.__next)
