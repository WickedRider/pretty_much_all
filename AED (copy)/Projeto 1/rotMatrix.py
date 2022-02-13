from sys import stdin, stdout 

class Mat:
    def __init__(self, arr1, arr2):
        self.arr1 = arr1
        self.arr2 = arr2

    def rot(self, matrix):



def readln():
    return stdin.readlines().rstrip()

def outln(n):
    stdout.write(str(n))
    stdout.write('\n')

def mountMat():
    input = readln()
    n1,n2 = input[0], input[1]
    matrix = []
    for i in range(n1):
        temp = []
        for g in range(n2):
            temp.append(input[g])
        matrix.append(temp)
    

def main():
    