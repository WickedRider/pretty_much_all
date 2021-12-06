
import matplotlib.pyplot as plt
import matplotlib.image as image
import numpy as np
from scipy.io import wavfile
from math import log2

from huffmancodec import HuffmanCodec



def ocorrencias(data: np.ndarray, alfa: np.ndarray, zeros: bool = True) -> dict:
    """
    Counts how many alphabet items are in data\n
    Args:
        data: the datastream
        alfa: The alphabet (set of symbols)
        zeros: whether the array has zeros or not

    Returns:
        the occurrences of each symbol of the alphabet in the datastream
    """
    d=data.flatten()

    #if the function is called with zeros set to true the a dictionary contaioning all the items from the alfabet is created
    if zeros:
        ocorrencias = dict.fromkeys(alfa, 0)
    else:
        ocorrencias = {}

    for element in d:
        if element not in ocorrencias:
            ocorrencias[element] = 0
        ocorrencias[element] += 1

    return ocorrencias




#1- histograma,     
def anlzFt(p: np.ndarray, a: np.ndarray, filename: str):
    """Analyzes a source of information and determines the occurrence of each of the symbols
     of an alphabet.

    A bar graph showing the occurrence of each symbol is displayed.

    Args:
        p: The source of information (sound, text, image, etc.)
        a: The alphabet (set of symbols)
    """

    ocr = ocorrencias(p, a)


    #plotar o grafico
    plt.figure(1)
    plt.bar(ocr.keys(),ocr.values())
    plt.title(filename)
    plt.show()


def probability(p: np.ndarray, a: np.ndarray, zeros: bool = False) -> np.ndarray:

    ocr=ocorrencias(p, a, zeros)
    ocr= list(ocr.values())
    ocr= np.array(ocr)
    prob = ocr / p.flatten().shape[0]   #array with prob of each symbol

    return prob

def entropia(p: np.ndarray, a: np.ndarray) -> float:
    """Calculates the entropy of an information source.\n   

    Entropy: theoretical minimum limit for the average number of bits needed to encode a symbol.

    Args:
        p: The source of information (sound, text, image, etc.)
        a: The alphabet (set of symbols)

    Returns:
        The entropy of the information source.
    """

    prob = probability(p, a)

    return -np.sum(prob * np.log2(prob))



def readText(filename: str) -> np.ndarray:

    alfa = "ABCDEFGHIJKLMOPQRSTUVWXYZ"
    alfa2 = alfa.lower()

    with open(filename, "r") as f:
        text = f.read()
 
    str = []
    # to ascii conversion
    for char in text:
        if char in alfa:
            str.append(ord(char) - 65)
        if char in alfa2:
            str.append(ord(char) - 72)

    return np.array(str)







def avgBits(data: np.ndarray, alfa: np.ndarray) -> float:
    """Calculates the average of bits needed to encode a symbol in Huffman encoding.

    Args:
        data: The source of information (sound, text, image, etc.)

    Return:
        The average of bits per symbol.
    """

    #calculate the occurrences
    ocr = ocorrencias(data, alfa, False)

    #codec object
    codec=HuffmanCodec.from_frequencies(ocr)    #huffman code table

    lengths = codec.get_code_len()[1]   #list with code length per symbol

    return np.average(lengths, weights=probability(data, alfa)) #media ponderada



def variancia(data: np.ndarray) -> float:
    """
    Calculates the variance over a distribution of values\n

    Args:
        data: the datastream

    Returns:
        the variance of the distribution of values in the datastream
    """
    d = data.flatten()
    d_list = d.tolist()
    codec = HuffmanCodec.from_data(d_list)
    lengths = codec.get_code_len()[1]   #list with code length per symbol

    return np.var(lengths, dtype=np.float64)

#Less with var if symbols are grouped to create more patterns, 
# thus reducing value dispersion
#less var = more redundancy



def group(data: np.ndarray) -> np.ndarray:
    """
    Groups the items in the datastream in pairs\n

    Args:
        data: the datastream

    Returns:
        the datastream with its items grouped
    """
    d = data.flatten()

    grouped = np.zeros((int(round(d.shape[0] / 2,0)),), int)
    # o grupo de items tem de ter metade do tamanho

    index = 0
    for i in range(0,d.shape[0],2):
        grouped[index] = d[i] << 8 | d[i+1] 
        #shift 8 bits para a esquerda e depois adiciona o numero uqe queremos agrupar, ou logico
        index += 1

    if grouped.shape[0] % 2 != 0:
        grouped[-1] = d[-1]

    return grouped


def infoMutua(source1: np.ndarray, source2: np.ndarray, alfa: np.ndarray) -> float:
    """
    Calculates the mutual information between two datastreams\n

    Args:
        source1: the datastream 1
        source2: the datastream 2

    Returns:
        the mutual information between two datastreams
    """

    #calculate the joint entropy    "X+Y"
    entConj = entropia(source1[np.in1d(source1, source2)], alfa)

    #calculate the conditional entropy  X\Y  
    entCond = entConj / entropia(source2, alfa)

    #calculate the mutual information between source1 and source2
    return entropia(source1, alfa) - entCond
                # X - X\Y

def search(query: np.ndarray, target: np.ndarray, alfa: np.ndarray, step: int) -> np.ndarray:
    """
    Creates an array with the mutual information in various windows in two arrays separated by a given step\n
    Args:
        query: the array to be compared with the mutual information formula
        target: the target array to calculate the mutual information with the query in a given window
        alfa: the alphabet (Set f symbols)
        step: the distance from a window to the next

    Returns:
        an array with all the mutual informations
    """

    q = query.flatten()
    t = target.flatten()
    a = alfa.flatten()
    querySize = q.shape[0]

    #mutual information array
    infoM = np.zeros((t.shape[0] // step,), float)

    #calculate the mutual information for each window
    for i in range(infoM.shape[0]):
        infoM[i] = infoMutua(q, t[i * step:i * step + querySize], a)

    return infoM


def bits(source: np.ndarray) -> int:
    """
    Get the number of bits to store a value in the array

    Args:
        source: the datastream

    Returns:
       the number of bits to store a value in the array
    """
    b = str(source.dtype)
    c = sum(c.isdigit() for c in b) 
    # ie: b="int32", c="32"
    return int(b[-c:])



def main():
    #analizar cada uma das imagens:
    ficheiros = ["data/kid.bmp", "data/homer.bmp", "data/homerBin.bmp"]
    # b = np.arange(0, 256)
    # for i in ficheiros:
    #     file = image.imread(i)

    #     anlzFt(file, b, i)
    #     print(entropia(file, b))
    #     print(avgBits(file, b))
    #     print(variancia(file))

    # #analizar o som

    # fs, file = wavfile.read("data/guitarSolo.wav")

    # anlzFt(file, b, "data/guitarSolo.wav")
    # print(entropia(file, b))
    # print(avgBits(file, b))
    # print(variancia(file))

    # #analizar o texto
    # file = readText("data/english.txt")

    # a = np.arange(0, 52)
    # anlzFt(file, a, "data/english.txt")
    # print(entropia(file, a))
    # print(avgBits(file, a))
    # print(variancia(file))


    #exercicio 6 - shazam
    query = wavfile.read("data/guitarSolo.wav")[1]
    b = np.arange(0,2**bits(query))

    infM = []
    for i in range(1,8):
        p = search(query, wavfile.read("data/Song0%d.wav" % (i))[1], b, 5000)
        plt.plot(p)
        plt.title("informacao mutua entre guitarSolo e Song0%d.wav" % (i))
        plt.show()
        infM.append(p.max())

    print(infM)
    
    ficheiros = ["dataset/bible.txt", "dataset/finance.csv", "dataset/jquery-3.6.0.js", "dataset/random.txt"]
    file = readText(ficheiros[3])
    c = np.arange(0, 52)
    anlzFt(file, c, ficheiros[3])
    print(entropia(file, c))    
    print(avgBits(file, c))    
    print(variancia(file)) 
    
       



if __name__ == "__main__":
    main()